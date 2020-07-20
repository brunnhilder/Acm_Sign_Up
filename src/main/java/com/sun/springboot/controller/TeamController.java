package com.sun.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Team;
import com.sun.springboot.bean.Ticket;
import com.sun.springboot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.*;
import java.util.Collection;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;

    @Value("${file.upload.path}")
    private String filePath;

    @RequestMapping("/teaminfo")
    public String list(@RequestParam(value="pn",defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "10") int pageSize,Model model, Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=teamService.getSchool(username);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(teamService.getAll(school));
        model.addAttribute("pageInfo",pageInfo);
        return "team/teamlist";


    }
    @RequestMapping("/teamadd")
    public String teamadd()
    {

        return "team/teamadd";
    }

    @RequestMapping("/teamadd2")
    public String addTicket(@RequestParam("teamcn") String teamcn, @RequestParam("teamen") String teamen,@RequestParam("teacher") String teacher,
                            Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String school=teamService.getSchool(username);
        String jindu="待参赛";
        String huojiang="否";
        String jieshu="2020";
        int users1 = teamService.teamadd(teamcn,teamen,teacher,jieshu,jindu,huojiang,school);
        return "redirect:/teaminfo";
    }
    @RequestMapping("/teamedit/{id}")
    public String toEditPage(@PathVariable("id") int id,Model model,HttpSession session)
    {
        Team team=teamService.get(id);
        session.setAttribute("teamid",id);
        model.addAttribute("team",team);
        return "team/teamedit";
    }
    @RequestMapping("/goteamedit")
    public String editTeam(@RequestParam("teamcn") String teamcn,@RequestParam("teamen") String teamen,@RequestParam("teacher") String teacher,
                             HttpSession session, Map<String,Object> map)
    {
        int id= (int) session.getAttribute("teamid");
        int users1 = teamService.teamedit(teamcn,teamen,teacher,id);
        return "redirect:/teaminfo";
    }
    @RequestMapping("/teamdelete/{id}")
    public String deleteTeam(@PathVariable("id") int id, Model model, HttpSession session)
    {
        int users1 = teamService.ticketdelete(id);
        int users2 = teamService.studelAll(id);
        return "redirect:/teaminfo";
    }
    @RequestMapping("/teammemberadd/{id}")
    public String TeamMember(@PathVariable("id") int id, Model model, HttpSession session)
    {
        session.setAttribute("teamid",id);
        String username= (String) session.getAttribute("loginUser");
        String school=teamService.getSchool(username);
        Collection<Student> students=teamService.getAllStu(id,school);
        Collection<Student> students2=teamService.getAllStu2(id,school);
        model.addAttribute("students2",students2);
        model.addAttribute("students",students);
        return "team/stulist";
    }
    @RequestMapping("/teammemberadd2")
    public String TeamMember2(Model model, HttpSession session)
    {
        int id= (int) session.getAttribute("teamid");
        String username= (String) session.getAttribute("loginUser");
        String school=teamService.getSchool(username);
        Collection<Student> students=teamService.getAllStu(id,school);
        Collection<Student> students2=teamService.getAllStu2(id,school);
        model.addAttribute("students2",students2);
        model.addAttribute("students",students);
        return "team/stulist";
    }
    @RequestMapping("/stuaddteam/{username}")
    public String TeamMemberAdd(@PathVariable("username") String username, Model model, HttpSession session)
    {

        int id= (int) session.getAttribute("teamid");
        String username2= (String) session.getAttribute("loginUser");
        String school=teamService.getSchool(username2);
        int stumember=teamService.getstunumber(id);

        String stu=teamService.getStu(username);

        int schoolmember=teamService.getschoolnumber();
        int schoolminge=teamService.getschoolminge(school);
        if(stu==null)
        {
            if(stumember<3&&schoolmember<schoolminge)
            {

                String teamcn=teamService.getTeamCn(id);
                int users1 = teamService.stuadd(id,username,teamcn);
                return "redirect:/teammemberadd2";

            }
            else
            {
                return "team/error";
            }
        }
        else
        {
            if(stumember<3&&schoolmember<=schoolminge)
            {

                String teamcn=teamService.getTeamCn(id);
                int users1 = teamService.stuadd(id,username,teamcn);
                return "redirect:/teammemberadd2";

            }
            else
            {
                return "team/error";
            }
        }


    }
    @RequestMapping("/studdelteam/{username}")
    public String TeamMemberDel(@PathVariable("username") String username, Model model, HttpSession session)
    {
        int id= (int) session.getAttribute("teamid");
        String teamcn=teamService.getTeamCn(id);
        int users1 = teamService.studel(id,username,teamcn);
        return "redirect:/teammemberadd2";
    }
    @RequestMapping("/zhengshudownload/{id}")
    public String download(@PathVariable("id") int id, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response)
    {
        String filename = teamService.getfilename(id);
        String path = filePath+"rotPhoto/";

        if (filename != null) {
            //设置文件路径
            File file = new File(path, filename);
             if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
             try {
             fis = new FileInputStream(file);
             bis = new BufferedInputStream(fis);
             OutputStream os = response.getOutputStream();
             int i = bis.read(buffer);
             while (i != -1) {
             os.write(buffer, 0, i);
             i = bis.read(buffer);
            }
             System.out.println("success");
             } catch (Exception e) {
             e.printStackTrace();
             } finally {
             if (bis != null) {
             try {
             bis.close();
             } catch (IOException e) {
             e.printStackTrace();
             }
             }
             if (fis != null) {
             try {
             fis.close();
             } catch (IOException e) {
            e.printStackTrace();
            }
            }
            }
            }
             }
        String a=teamService.huojiang(id);
        if(a.equals("是"))
        {
            return null;
        }
        else
        {
            return "redirect:/teaminfo";
        }




    }
}
