package com.sun.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.springboot.bean.Quato;
import com.sun.springboot.bean.Teacher;
import com.sun.springboot.service.QuatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class QuatoController {
    @Autowired
    QuatoService quatoService;

    @RequestMapping("/quatoinfo")
    public String list(@RequestParam(value="pn",defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "10") int pageSize,Model model, Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=quatoService.getSchool(username);

        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(quatoService.getAll(school));
        model.addAttribute("pageInfo",pageInfo);
        return "quato/quatolist";


    }

    @RequestMapping("/quatoadd")
    public String addQuato(Model model, Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=quatoService.getSchool(username);
        Quato status= quatoService.getStatus(school);
        Quato status2=quatoService.getStatus2(school);
        map.put("msg2","没有错误");
        if(status!=null)
        {
            map.put("msg2","您的申请列表中有审核已经通过的申请，无法继续发送申请。");
            return "quato/error";
        }
        else if(status2!=null)
        {
            map.put("msg2","您的申请列表中有未审核的申请，无法继续发送申请。");
            return "quato/error";
        }
        else
        {
            return "quato/quatoadd";
        }


    }

    @RequestMapping("/quatoadd2")
    public String addTeacher(@RequestParam("minge") int minge, @RequestParam("tel") String tel,@RequestParam("per") String per,@RequestParam("email") String email,@RequestParam("msg") String msg,
                             @RequestParam("checkbox1") String checkbox1,@RequestParam("checkbox2") String checkbox2,@RequestParam("checkbox3") String checkbox3,@RequestParam("checkbox4") String checkbox4,@RequestParam("checkbox5") String checkbox5,Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=quatoService.getSchool(username);
        String status="等待审核";
        int users1 = quatoService.quatoadd(school,minge,status,tel,per,email,msg,checkbox1,checkbox2,checkbox3,checkbox4,checkbox5);
        return "redirect:/quatoinfo";
    }

    @RequestMapping("/quatodelete/{id}")
    public String deleteStudentTea(@PathVariable("id") int id, Model model, HttpSession session,Map<String,Object> map)
    {

        String username= (String) session.getAttribute("loginUser");
        String school=quatoService.getSchool(username);
        Quato status= quatoService.getStatus(school);
        if(status!=null)
        {
            map.put("msg2","无法删除已经审核通过的申请，如果想取消已经审核通过的申请，请与我们联系，我们将为您重置已审批的参赛名额。");
            return "quato/error";
        }
        else
        {
            int users1 = quatoService.quatodelete(id);
            return "redirect:/quatoinfo";
        }

    }
    @RequestMapping("/sysquatoinfo")
    public String syslist(Model model, Map<String,Object> map, HttpSession session,@RequestParam(value="pn",defaultValue = "1") int pageNum,
    @RequestParam(defaultValue = "10") int pageSize)
    {
        String username= (String) session.getAttribute("loginUser");
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(quatoService.getAllSys());
        model.addAttribute("pageInfo",pageInfo);
        return "quato/sysquatolist";
    }
    @RequestMapping("/sysquatoupdate/{id}")
    public String sysdeleteStudentTea(@PathVariable("id") int id, Model model, HttpSession session)
    {
        int users1 = quatoService.quatoupdate(id);
        String school=quatoService.selectschool(id);
        int schoolminge=quatoService.selectschoolminge(id);
        int minge=quatoService.selectmingebefore(school)+schoolminge;
        int u=quatoService.update(school,minge);

        return "redirect:/sysquatoinfo";
    }
    @RequestMapping("/sysquatoupdate2/{id}")
    public String sysdeleteStudentTea2(@PathVariable("id") int id, Model model, HttpSession session)
    {
        int users1 = quatoService.quatoupdate2(id);
        return "redirect:/sysquatoinfo";
    }
}
