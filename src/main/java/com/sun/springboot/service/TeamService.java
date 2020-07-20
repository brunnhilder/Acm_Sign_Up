package com.sun.springboot.service;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Team;

import java.util.Collection;
import java.util.List;


public interface TeamService {
    String getSchool(String username);



    int ticketdelete(int id);

    int teamadd(String teamcn, String teamen, String teacher, String jieshu, String jindu, String huojiang, String school);

    Team get(int id);


    int teamedit(String teamcn, String teamen, String teacher, int id);
    
    Collection<Student> getAllStu2(int id, String school);

    Collection<Student> getAllStu(int id, String school);

    int stuadd(int id, String username,String teamcn);

    String getTeamCn(int id);

    int studel(int id, String username, String teamcn);

    int getstunumber(int id);

    int getschoolminge(String school);

    int getschoolnumber();

    String getStu(String username);

    int studelAll(int id);

    int zhengshuadd(int id, String filename);

    String getfilename(int id);

    String huojiang(int id);

    List getAll(String school);
}
