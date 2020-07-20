package com.sun.springboot.controller;

import com.sun.springboot.bean.Student;

import com.sun.springboot.bean.Team;
import com.sun.springboot.bean.Users;
import com.sun.springboot.service.StudentService;
import com.sun.springboot.service.UsersService;
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
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/studentselect")
    public String list(Model model,Map<String,Object> map,HttpSession session)
    {
        String teacher= (String) session.getAttribute("loginUser");//teacher==me
        String username=teacher;
        Student student=studentService.get(username);
        String me= (String) session.getAttribute("loginUser");
        if(student!=null)
        {
            Collection<Student> students=studentService.getAll(me);
            model.addAttribute("students",students);

            return "student/list";
        }
        else
        {
            Collection<Student> schools=studentService.getSchoolName();
            model.addAttribute("schools",schools);
            return "student/add";
        }


    }
//添加按钮
//    @RequestMapping("/studentadd")
//    public String toAddPage(Model model, HttpSession session,Map<String,Object> map)
//    {
//        String teacher= (String) session.getAttribute("loginUser");//teacher==me
//        String username=teacher;
//        Student student=studentService.get(username);
//        if(student!=null)
//        {
////            map.put("msgstuadd","error");
////            System.out.print("<script>alert('success')");
//            return "dashboard";
//        }else{
//            Collection<Student> team=studentService.getTeamName(teacher);
//            model.addAttribute("teams",team);
//            return "student/add";
//        }
//
//    }

    @RequestMapping("/studentadd2")
    public String addStudent(@RequestParam("name") String name,@RequestParam("nameen") String nameen,
                            @RequestParam("size") String size,@RequestParam("school") String school,@RequestParam("email") String email, @RequestParam("sex") String sex, Map<String,Object> map,HttpSession session)
    {
        String me= (String) session.getAttribute("loginUser");
        int users1 = studentService.studentadd(me,name,nameen,sex,size,school,email);
        return "redirect:/studentselect";
    }

    @RequestMapping("/studentedit/{username}")
    public String toEditPage(@PathVariable("username") String username,Model model,HttpSession session)
    {
        Student student=studentService.get(username);
        model.addAttribute("student",student);
        session.setAttribute("oldusername",username);
        String teacher= (String) session.getAttribute("loginUser");
//        Collection<Student> team=studentService.getTeamName(teacher);
//        model.addAttribute("teams",team);
        return "student/edit";
    }
    @RequestMapping("/studentedit2")
    public String editStudent(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("nameen") String nameen,
                              @RequestParam("sex") String sex, @RequestParam("size") String size, @RequestParam("school") String school
                                , HttpSession session, Map<String,Object> map)
    {
        String oldname=(String) session.getAttribute("oldusername");
        int users1 = studentService.studentedit(name,sex,size,school,oldname,email,nameen);
        return "redirect:/studentselect";
    }

    @RequestMapping("/studentdelete/{username}")
    public String deleteStudent(@PathVariable("username") String username,Model model,HttpSession session)
    {
        int users1 = studentService.studentdelete(username);
        return "redirect:/studentselect";
    }

    @RequestMapping("/stuteaminfo")
    public String listteam(Model model, Map<String,Object> map, HttpSession session)
    {
        String username= (String) session.getAttribute("loginUser");
        String teamname=studentService.getteamname(username);
        if(teamname!=null)
        {
            int id=studentService.getteamid(username);
            Collection<Team> teams=studentService.getMyTeam(id);
            model.addAttribute("teams",teams);
        }
        else{

        }

        return "student/stuteamlist";


    }


}

