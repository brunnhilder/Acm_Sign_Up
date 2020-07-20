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
public class LoginController {

    @Autowired
    UsersService service;

    @Autowired
    private DefaultKaptcha captchaProducer;

    public void setService(UsersService service) {
        this.service = service;
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping(value="/goLogin")
    public String login(@RequestParam("vrifyCode") String vrifyCode,@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("perlevel") String perlevel,
                        Map<String,Object> map, HttpSession session,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        Users users=service.login(username,password,perlevel);
        int per=Integer.parseInt(perlevel);
        ModelAndView andView = new ModelAndView();
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        if (!captchaId.equals(vrifyCode)) {
            map.put("msg","验证码错误");
            return "login";
        } else {
            if(users!=null)
            {
                if(per==1)
                {
                    session.setAttribute("loginUser",username);
                    return "dashboard";
                }
                else
                {
                    session.setAttribute("loginUser",username);
                    return "dashboard2";
                }

            }else
            {
                map.put("msg","用户名密码错误");
                return "login";
            }
        }



    }

    @RequestMapping(value="/registered")
    public String goRegistered(Map<String,Object> map)
    {
        map.put("msg","请注册");
        return "registered";

    }

    @RequestMapping(value="/goRegistered")
    public String registered(@RequestParam("username") String username, @RequestParam("password") String password,
                             @RequestParam("password1") String password1,@RequestParam("perlevel") String perlevel,
                        Map<String,Object> map, HttpSession session)
    {
        Users users=service.registered(username);
        String regex="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";

        if(users!=null)
        {

            map.put("msg","用户已存在");
            return "registered";
        }
        else
        {
            if(username.matches(regex)){
                if(password.matches(regex)){
                    if (password.equals(password1) )
                    {
                        int users1 = service.goRegistered(username, password,perlevel);
                        map.put("msg", "注册成功");
                        return "login";
                    }
                    else
                    {
                        map.put("msg", "两次密码输入不一致");

                        return "registered";
                    }
                }
                else{
                    map.put("msg", "密码格式错误");
                    return "registered";
                }
        }
            else{
                map.put("msg", "账号格式错误");
                return "registered";
            }



        }

    }
}
