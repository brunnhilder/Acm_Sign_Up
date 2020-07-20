package com.sun.springboot.service;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Team;

import java.util.Collection;


public interface StudentService {
    public Collection<Student> getAll(String me);
    public Student get(String username);
    public Collection<Student> getTeamName(String teacher);
    public int studentadd(String me,String name,String nameen,String sex, String size,String school,String email);
    public int studentedit(String name, String sex, String size, String school,  String oldname,String email,String nameen);
    public int studentdelete(String username);

    int getteamid(String username);

    Collection<Team> getMyTeam(int id);

    String getteamname(String username);

    Collection<Student> getSchoolName();
}
