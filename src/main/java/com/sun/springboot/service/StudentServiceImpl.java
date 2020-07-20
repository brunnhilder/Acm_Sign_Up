package com.sun.springboot.service;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Team;
import com.sun.springboot.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    public void setMapper(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Collection<Student> getAll(String me){return mapper.getAll(me);}

    @Override
    public Student get(String username) {
        return mapper.get(username);
    }

    @Override
    public Collection<Student> getTeamName(String teacher) {
        return mapper.getTeamName(teacher);
    }

    @Override
    public int studentadd(String me,String name,String nameen,String sex, String size,String school,String email) {
        return mapper.studentadd(me, name, nameen,sex, size, school,email);
    }

    @Override
    public int studentedit( String name, String sex, String size, String school, String oldname,String email,String nameen) {
        return mapper.studentedit( name, sex, size, school,  oldname,email,nameen);
    }

    @Override
    public int studentdelete(String username) {
        return mapper.studentdelete(username);
    }

    @Override
    public int getteamid(String username) {
        return mapper.getTeamId(username);
    }

    @Override
    public Collection<Team> getMyTeam(int id) {
        return mapper.getMyTeam(id);
    }

    @Override
    public String getteamname(String username) {
        return mapper.getTeamName2(username);
    }

    @Override
    public Collection<Student> getSchoolName() {
        return mapper.getAllSchool();
    }
}
