package com.sun.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Teacher;
import com.sun.springboot.service.TeacherService;
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
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/teacherselect")
    public String list(Model model, Map<String,Object> map, HttpSession session)
    {
        String me= (String) session.getAttribute("loginUser");
        String username=me;
        Teacher teacher=teacherService.get(username);
        if(teacher!=null)
        {
            Collection<Teacher> teachers=teacherService.getAll(me);
            model.addAttribute("teachers",teachers);
            return "teacher/teacherlist";
        }
        else
        {
            Collection<Teacher> schools=teacherService.getSchoolName();
            model.addAttribute("schools",schools);
        return "teacher/teacheradd";
        }
    }
    @RequestMapping("/teacheradd2")
    public String addTeacher(@RequestParam("name") String name, @RequestParam("nameen") String nameen,
                             @RequestParam("size") String size, @RequestParam("school") String school, @RequestParam("email") String email, @RequestParam("tel") String tel,@RequestParam("sex") String sex, Map<String,Object> map, HttpSession session)
    {
        String me= (String) session.getAttribute("loginUser");
        int users1 = teacherService.teacheradd(me,name,nameen,sex,size,school,tel,email);
        return "redirect:/teacherselect";
    }
    @RequestMapping("/teacherdelete/{username}")
    public String deleteTeacher(@PathVariable("username") String username, Model model, HttpSession session)
    {
        int users1 = teacherService.teacherdelete(username);
        return "redirect:/teacherselect";
    }

    @RequestMapping("/teacheredit/{username}")
    public String toEditPage(@PathVariable("username") String username,Model model,HttpSession session)
    {
        Teacher teacher=teacherService.get(username);
        model.addAttribute("teacher",teacher);
        session.setAttribute("oldusername",username);
//        String teacher= (String) session.getAttribute("loginUser");
//        Collection<Teacher> team=teacherService.getTeamName(teacher);
//        model.addAttribute("teams",team);
        return "teacher/teacheredit";
    }
    @RequestMapping("/teacheredit2")
    public String editTeacher(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("tel") String tel,@RequestParam("nameen") String nameen,
                              @RequestParam("sex") String sex, @RequestParam("size") String size, @RequestParam("school") String school
            , HttpSession session, Map<String,Object> map)
    {
        String oldname=(String) session.getAttribute("oldusername");
        int users1 =teacherService.teacheredit(name,sex,size,school,oldname,email,nameen,tel);
        return "redirect:/teacherselect";
    }
//    @RequestMapping("/studentinfo")
//    public String studentInfo(@RequestParam(value="pn",defaultValue = "1") int pageNum,
//                              @RequestParam(defaultValue = "10") int pageSize,Model model,Map<String,Object> map,HttpSession session)
//    {
//        String me= (String) session.getAttribute("loginUser");
//        String school=teacherService.getSchool(me);
//        String selectname=null;
//        PageHelper.startPage(pageNum,pageSize);
//        PageInfo pageInfo=new PageInfo(teacherService.getStuAll(school));
//        model.addAttribute("pageInfo",pageInfo);
//        return "teacher/studentlist";
//    }
    @RequestMapping("/studentinfo2")
    public String studentInfo2(@RequestParam(value="pn",defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize,Model model,Map<String,Object> map,HttpSession session,@RequestParam(value="selectname",required = false) String selectname)
    {
        String me= (String) session.getAttribute("loginUser");
        String school=teacherService.getSchool(me);
        if(selectname!=""&&selectname!=null)
        {
            PageHelper.startPage(pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(teacherService.getStuAll2(school,selectname));
            model.addAttribute("pageInfo",pageInfo);
        }
        else
        {
            PageHelper.startPage(pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(teacherService.getStuAll(school));
            model.addAttribute("pageInfo",pageInfo);
        }

        return "teacher/studentlist";

//        else
//        {
//            Collection<Student> team=studentService.getTeamName(teacher);
//            model.addAttribute("teams",team);
//            return "student/add";
//        }
    }
    @RequestMapping("/teastudentedit/{username}")
    public String toEditStudent(@PathVariable("username") String username,Model model,HttpSession session)
    {
        Student student=teacherService.getStuinfo(username);
        model.addAttribute("student",student);
        session.setAttribute("oldusername",username);
        String teacher= (String) session.getAttribute("loginUser");
//        Collection<Student> team=studentService.getTeamName(teacher);
//        model.addAttribute("teams",team);
        return "teacher/studentedit";
    }

    @RequestMapping("/studentedit3")
    public String editStudentTea(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("nameen") String nameen,
                              @RequestParam("sex") String sex, @RequestParam("size") String size, @RequestParam("school") String school
            , HttpSession session, Map<String,Object> map)
    {
        String oldname=(String) session.getAttribute("oldusername");
        int users1 = teacherService.studentedit(name,sex,size,school,oldname,email,nameen);
        return "redirect:/studentinfo2";
    }

    @RequestMapping("/teastudentdelete/{username}")
    public String deleteStudentTea(@PathVariable("username") String username,Model model,HttpSession session)
    {
        int users1 = teacherService.studentdelete(username);
        return "redirect:/studentinfo2";
    }
}
