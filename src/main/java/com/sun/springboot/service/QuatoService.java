package com.sun.springboot.service;

import com.sun.springboot.bean.Quato;
import com.sun.springboot.bean.Teacher;

import java.util.Collection;
import java.util.List;

public interface QuatoService {
   

    public String getSchool(String username);

    public int quatodelete(int id);

    int quatoadd(String school, int minge, String status, String tel, String per, String email, String msg, String checkbox1, String checkbox2, String checkbox3, String checkbox4, String checkbox5);

    int quatoupdate(int id);

    int quatoupdate2(int id);

    String selectschool(int id);


    int selectschoolminge(int id);

    int selectmingebefore(String school);


    int update(String school, int minge);


    Quato getStatus(String school);

    Quato getStatus2(String school);

    List getAllSys();

    List getAll(String school);
}
