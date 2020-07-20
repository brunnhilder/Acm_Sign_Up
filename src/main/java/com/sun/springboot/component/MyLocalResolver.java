package com.sun.springboot.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import sun.invoke.empty.Empty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l =request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l))
        {
            String[] spilt = l.split("_");
            locale = new Locale(spilt[0],spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
