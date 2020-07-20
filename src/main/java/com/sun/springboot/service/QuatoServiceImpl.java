package com.sun.springboot.service;

import com.sun.springboot.bean.Quato;
import com.sun.springboot.mapper.QuatoMapper;
import com.sun.springboot.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class QuatoServiceImpl implements QuatoService {

    @Autowired
    private QuatoMapper mapper;



    @Override
    public String getSchool(String username) {
        return mapper.getSchool(username);
    }

    @Override
    public int quatodelete(int id) {
        return mapper.quatodelete(id);
    }

    @Override
    public int quatoadd(String school, int minge, String status, String tel, String per, String email, String msg, String checkbox1, String checkbox2, String checkbox3, String checkbox4, String checkbox5) {
        return mapper.quatoadd(school, minge, status, tel, per, email, msg, checkbox1, checkbox2, checkbox3, checkbox4, checkbox5);
    }

    @Override
    public int quatoupdate(int id) {
        return mapper.quatoupdate(id);
    }

    @Override
    public int quatoupdate2(int id) {
        return mapper.quatoupdate2(id);
    }

    @Override
    public String selectschool(int id) {
        return mapper.getSchool1(id);
    }

    @Override
    public int selectschoolminge(int id) {
        return mapper.getSchool2(id);
    }

    @Override
    public int selectmingebefore(String school) {
        return mapper.getSchool3(school);
    }

    @Override
    public int update(String school, int minge) {
        return mapper.update(minge, school);
    }

    @Override
    public Quato getStatus(String school) {
        return mapper.getStatus(school);
    }

    @Override
    public Quato getStatus2(String school) {
        return mapper.getStatus2(school);
    }

    @Override
    public List getAllSys() {
        return mapper.getAllSys();
    }

    @Override
    public List getAll(String school) {
        return mapper.getAll(school);
    }


}
