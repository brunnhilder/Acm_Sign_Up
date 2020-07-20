package com.sun.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.springboot.bean.Quato;
import com.sun.springboot.bean.Ticket;
import com.sun.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Controller
public class TicketController {
    @Autowired
    TicketService ticketService;

    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    @RequestMapping("/ticketinfo")
    public String list(@RequestParam(value="pn",defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "10") int pageSize,Model model, Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=ticketService.getSchool(username);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(ticketService.getAll(school));
        model.addAttribute("pageInfo",pageInfo);
        String filename=school+".png";
        model.addAttribute("filename", "/images/tickets/"+filename);
        return "ticket/ticketlist";


    }

    @RequestMapping("/ticketadd")
    public String addTicket(Model model, Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=ticketService.getSchool(username);
        Ticket status= ticketService.getStatus(school);
        Ticket status2=ticketService.getStatus2(school);
        map.put("msg2","没有错误");
        if(status!=null)
        {
            map.put("msg3","您的申请列表中有审核已经通过的申请，无法继续发送申请。");
            return "ticket/error";
        }
        else if(status2!=null)
        {
            map.put("msg3","您的申请列表中有未审核的申请，无法继续发送申请。");
            return "ticket/error";
        }
        else
        {
            return "ticket/ticketadd";
        }

    }

    @RequestMapping("/ticketadd2")
    public String addTicket(Model model,@RequestParam("file") MultipartFile file, @RequestParam("tel") String tel, @RequestParam("per") String per, @RequestParam("address") String address, @RequestParam("pernum") String pernum, @RequestParam("bank") String bank,
                            Map<String,Object> map, HttpSession session)
    {
        String filename = file.getOriginalFilename();
        String username= (String) session.getAttribute("loginUser");
        String school=ticketService.getSchool(username);
        filename=school+".png";
        String url=filename;
        String status="等待审核";
        int users1 = ticketService.ticketadd(school,url,address,pernum,bank,status,per,tel);
        // 定义上传文件保存路径
        String path = filePath+"tickets/";
        // 新建文件
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("filename", "/images/tickets/"+filename);
        return "redirect:/ticketinfo";
    }

    @RequestMapping("/ticketdelete/{id}")
    public String deleteTicket(@PathVariable("id") int id, Model model, Map<String,Object> map,HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=ticketService.getSchool(username);
        Ticket status=ticketService.getStatus(school);
        if(status!=null)
        {
            map.put("msg3","无法删除已经审核通过的申请，如果想取消已经审核通过的申请，请与我们联系，我们将为您重置已审批的参赛名额。");
            return "ticket/error";
        }
        else
        {
            int users1 = ticketService.ticketdelete(id);
            return "redirect:/ticketinfo";
        }
        }

    @RequestMapping("/systicketinfo")
    public String syslist(Model model, Map<String,Object> map, HttpSession session,@RequestParam(value="pn",defaultValue = "1") int pageNum,
                          @RequestParam(defaultValue = "10") int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(ticketService.getAll2());
        model.addAttribute("pageInfo",pageInfo);
        return "ticket/systicketlist";
    }
    @RequestMapping("/ticketupdate/{id}")
    public String updateTicket(@PathVariable("id") int id, Model model, HttpSession session)
    {
        int users1 = ticketService.ticketupdate(id);
        String school=ticketService.selectschool(id);
        int users2 = ticketService.ticketupdate3(school);
        return "redirect:/systicketinfo";
    }
    @RequestMapping("/ticketupdate2/{id}")
    public String updateTicket2(@PathVariable("id") int id, Model model, HttpSession session)
    {
        int users1 = ticketService.ticketupdate2(id);
        return "redirect:/systicketinfo";
    }
    @RequestMapping("/ticketcheck/{id}")
    public String checkTicket(@PathVariable("id") int id, Model model, HttpSession session)
    {
        String school=ticketService.selectschool(id);
        String filename=school+".png";
        model.addAttribute("filename", "/images/tickets/"+filename);
        return "ticket/systicketcheck";
    }
    /**
     * 会员管理
     */
    @RequestMapping("/manageMember")
    public String manageMember(@RequestParam(value="pn",defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize,
                               Model model){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(ticketService.getAll3());
        model.addAttribute("pageInfo",pageInfo);
        return "ticket/test";
    }

}
