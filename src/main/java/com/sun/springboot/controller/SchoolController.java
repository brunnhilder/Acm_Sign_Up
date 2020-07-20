package com.sun.springboot.controller;

import com.sun.springboot.bean.School;
import com.sun.springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    @RequestMapping("/xiaohui")
    public String test() {
        return "teacher/xiaohui";
    }

    @RequestMapping("uploadxiaohui")
    public String upload(@RequestParam("file") MultipartFile file, Model model,HttpSession session) {
//        String filename = file.getOriginalFilename();
        String me= (String) session.getAttribute("loginUser");
        String schoolname=schoolService.getSchool(me);
        String filename = schoolname+".png";
        int users1 =schoolService.schooleditxiaohui(schoolname,filename);
        // 获取上传文件名

        // 定义上传文件保存路径
        String path = filePath+"xiaohui/";
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
        // 将src路径发送至html页面
        model.addAttribute("filename", "/images/xiaohui/"+filename);
        return "teacher/xiaohui";
    }
    @RequestMapping("/schoolinfo")
    public String school(Model model, Map<String,Object> map, HttpSession session)
    {
        String me= (String) session.getAttribute("loginUser");
        String schoolname=schoolService.getSchool(me);
        School school=schoolService.get(schoolname);
        String filename=schoolService.getxiaohui(schoolname);
        if(school!=null)
        {
            model.addAttribute("school",school);
            model.addAttribute("filename", "/images/xiaohui/"+filename);
            return "teacher/schoollist";
        }
        else
        {
            model.addAttribute("schoolname",schoolname);
            return "teacher/schooladd";
        }
    }

    @RequestMapping("/schooladd")
    public String schooladd(@RequestParam("school") String school, @RequestParam("schoolen") String schoolen,
                              @RequestParam("tel") String tel, @RequestParam("address") String address, Map<String,Object> map, HttpSession session)
    {
        String status="待缴费";
        int minge=0;
        int users1 =schoolService.schooladd(school,schoolen,minge,tel,address,status);
        return "redirect:/schoolinfo";
    }

    @RequestMapping("/schooledit")
    public String schooledit(HttpSession session,Model model)
    {   String me= (String) session.getAttribute("loginUser");
        String schoolname=schoolService.getSchool(me);
        School schools=schoolService.get(schoolname);
        model.addAttribute("schools",schools);
        return "teacher/schooledit";
    }

    @RequestMapping("/schooledit2")
    public String schooledit2(@RequestParam("school") String school, @RequestParam("schoolen") String schoolen,
                            @RequestParam("minge") int minge,  @RequestParam("tel") String tel, @RequestParam("address") String address, Map<String,Object> map, HttpSession session,Model model)
    {

        int users1 =schoolService.schooledit(school,schoolen,minge,tel,address);
        return "redirect:/schoolinfo";
    }
}
