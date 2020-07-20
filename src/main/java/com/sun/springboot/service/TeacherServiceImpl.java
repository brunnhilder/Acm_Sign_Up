package com.sun.springboot.service;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Teacher;
import com.sun.springboot.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService  {

    @Autowired
    private TeacherMapper mapper;

    public void setMapper(TeacherMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Collection<Teacher> getAll(String me) {
        return mapper.getAll(me);
    }

    @Override
    public Teacher get(String username) {
        return mapper.get(username);
    }

    @Override
    public int teacheradd(String me,String name,String nameen,String sex, String size,String school,String tel,String email) {
        return mapper.teacheradd(me, name, nameen,sex, size, school,tel,email);
    }

    @Override
    public int teacherdelete(String username) {
        return mapper.teacherdelete(username);
    }

    @Override
    public int teacheredit( String name, String sex, String size, String school, String oldname,String email,String nameen,String tel) {
        return mapper.teacheredit( name, sex, size, school,  oldname,email,nameen,tel);
    }

    @Override
    public String getSchool(String me) {
        return mapper.getSchool(me);
    }



    @Override
    public Student getStuinfo(String username) {
        return mapper.getStuinfo(username);
    }

    @Override
    public int studentedit(String name, String sex, String size, String school, String oldname, String email, String nameen) {
        return mapper.studentedit(name,sex,size,school,oldname,email,nameen);
    }

    @Override
    public int studentdelete(String username) {
        return mapper.studentdelete(username);
    }

    @Override
    public List getStuAll(String school) {
        return mapper.getStuAll(school);
    }

    @Override
    public List getStuAll2(String school,String selectname) {
        return mapper.getStuAll2(school, selectname);
    }

    @Override
    public Collection<Teacher> getSchoolName() {
        return mapper.getAllSchool();
    }
}
