package com.sun.springboot.service;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Team;
import com.sun.springboot.bean.Ticket;
import com.sun.springboot.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper mapper;
    @Override
    public String getSchool(String username) {
        return mapper.getSchool(username);
    }



    @Override
    public int ticketdelete(int id) {
        return mapper.teamDelete(id);
    }

    @Override
    public int teamadd(String teamcn, String teamen, String teacher, String jieshu, String jindu, String huojiang, String school) {
        return mapper.teamadd(teamcn, teamen, teacher, jieshu, jindu, huojiang, school);
    }

    @Override
    public Team get(int id) {
        return mapper.get(id);
    }

    @Override
    public int teamedit(String teamcn, String teamen, String teacher, int id) {
        return mapper.teamedit(teamcn, teamen, teacher, id);
    }



    @Override
    public Collection<Student> getAllStu2(int id, String school) {
        return mapper.getAllStu2(id, school);
    }

    @Override
    public Collection<Student> getAllStu(int id, String school) {
        return mapper.getAllStu(id, school);
    }

    @Override
    public int stuadd(int id, String username, String teamcn) {
        return mapper.stuadd(id, username, teamcn);
    }

    @Override
    public String getTeamCn(int id) {
        return mapper.getTeamCn(id);
    }

    @Override
    public int studel(int id, String username, String teamcn) {
        return mapper.studel(id, username, teamcn);
    }

    @Override
    public int getstunumber(int id) {
        return mapper.getstunum(id);
    }

    @Override
    public int getschoolminge(String school) {
        return mapper.getschoolminge(school);
    }

    @Override
    public int getschoolnumber() {
        return mapper.getschoolnum();
    }

    @Override
    public String getStu(String username) {
        return mapper.getstuteam(username);
    }

    @Override
    public int studelAll(int id) {
        return mapper.studel2(id);
    }

    @Override
    public int zhengshuadd(int id, String filename) {
        return mapper.zhengshuadd(id,filename);
    }

    @Override
    public String getfilename(int id) {
        return mapper.getfilename(id);
    }

    @Override
    public String huojiang(int id) {
        return mapper.huojiang(id);
    }

    @Override
    public List getAll(String school) {
        return mapper.getAll(school);
    }


}
