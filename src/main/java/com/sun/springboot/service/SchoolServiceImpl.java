package com.sun.springboot.service;

import com.sun.springboot.bean.School;
import com.sun.springboot.mapper.SchoolMapper;
import com.sun.springboot.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper mapper;

    @Override
    public String getSchool(String me) {
        return mapper.getSchool(me);
    }

    @Override
    public School get(String schoolname) {
        return mapper.get(schoolname);
    }

    @Override
    public int schooladd(String school, String schoolen, int minge,  String tel, String address,String status) {
        return mapper.schooladd(school, schoolen, minge, tel, address,status);
    }

    @Override
    public int schooledit(String school, String schoolen, int minge,  String tel, String address) {
        return mapper.schooledit(school, schoolen, minge,  tel, address);
    }


    @Override
    public String getxiaohui(String schoolname) {
        return mapper.getXiaohui2(schoolname);
    }

    @Override
    public int schooleditxiaohui(String schoolname, String filename) {
        return mapper.schooledit2(schoolname,filename);
    }
}
