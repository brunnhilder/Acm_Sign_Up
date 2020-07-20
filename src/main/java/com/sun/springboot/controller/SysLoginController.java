package com.sun.springboot.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sun.springboot.bean.Users;
import com.sun.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;

@Controller
public class SysLoginController {

    @Autowired
    UsersService service;

    public void setService(UsersService service) {
        this.service = service;
    }

    @Autowired
    private DefaultKaptcha captchaProducer;

//    @RequestMapping("/defaultKaptcha")
//    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
//        byte[] captchaChallengeAsJpeg = null;
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//        try {
//            //生产验证码字符串并保存到session中
//            String createText = captchaProducer.createText();
//            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
//            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
//            BufferedImage challenge = captchaProducer.createImage(createText);
//            ImageIO.write(challenge, "jpg", jpegOutputStream);
//        } catch (IllegalArgumentException e) {
//            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
//
//        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
//        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//        httpServletResponse.setHeader("Cache-Control", "no-store");
//        httpServletResponse.setHeader("Pragma", "no-cache");
//        httpServletResponse.setDateHeader("Expires", 0);
//        httpServletResponse.setContentType("image/jpeg");
//        ServletOutputStream responseOutputStream =
//                httpServletResponse.getOutputStream();
//        responseOutputStream.write(captchaChallengeAsJpeg);
//        responseOutputStream.flush();
//        responseOutputStream.close();
//    }

    @RequestMapping(value="/goSysLogin")
    public String login(@RequestParam("vrifyCode") String vrifyCode,@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        Users users=service.syslogin(username,password);
        ModelAndView andView = new ModelAndView();
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        if (!captchaId.equals(vrifyCode)) {
            map.put("msg","验证码错误");
            return "syslogin";
        } else {
            if(users!=null)
            {
                session.setAttribute("loginUserSys",username);
                return "dashboard3";
            }else
            {
                map.put("msg","用户名密码错误");
                return "syslogin";
            }
        }


    }

}
