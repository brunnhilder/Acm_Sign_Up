package com.sun.springboot.service;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Teacher;
import java.util.Collection;
import java.util.List;

public interface TeacherService {
    public Collection<Teacher> getAll(String me);
    public Teacher get(String username);
    public int teacheradd(String me,String name,String nameen,String sex, String size,String school,String tel,String email);
    public int teacherdelete(String username);
    public int teacheredit(String name, String sex, String size, String school,  String oldname,String email,String nameen,String tel);
    String getSchool(String me);

    Student getStuinfo(String username);
    public int studentedit(String name, String sex, String size, String school, String oldname, String email, String nameen);
    public int studentdelete(String username);

    List getStuAll(String school);


    List getStuAll2(String school, String selectname);

    Collection<Teacher> getSchoolName();
}
