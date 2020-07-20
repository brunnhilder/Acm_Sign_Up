package com.sun.springboot.mapper;


import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select username,name,sex,school,size,team,nameen,email,tel from teacher_info where username=#{username}")
    public Teacher get(@Param("username") String username);

    @Select("select username,name,sex,size,school,team,nameen,email,tel from teacher_info where username=#{me}")
    public Collection<Teacher> getAll(@Param("me") String me);

    @Insert("insert into teacher_info(username,name,sex,size,school,nameen,email,tel) values(#{me},#{name},#{sex},#{size},#{school},#{nameen},#{email},#{tel})")
    public int teacheradd(@Param("me") String me, @Param("name") String name, @Param("nameen") String namenen, @Param("sex") String sex, @Param("size") String size, @Param("school") String school, @Param("tel") String tel, @Param("email") String email);

    @Delete("delete from teacher_info where username=#{username}")
    public int teacherdelete(@Param("username") String username);

    @Update("update teacher_info set name=#{name},sex=#{sex},size=#{size},school=#{school},nameen=#{nameen},email=#{email},tel=#{tel} where username=#{oldname}")
    public int teacheredit(@Param("name") String name, @Param("sex") String sex, @Param("size") String size, @Param("school") String school, @Param("oldname") String oldname, @Param("email") String email, @Param("nameen") String nameen, @Param("tel") String tel);

    @Select("select school from teacher_info where username=#{me}")
    public String getSchool(@Param("me") String me);

    @Select("select username,name,sex,size,school,team,nameen,email from student_info where school=#{school} ")
    public List<Student> getStuAll(@Param("school") String school);

    @Select("select username,name,sex,size,school,team,nameen,email from student_info where school=#{school} and name=#{selectname}")
    public List<Student> getStuAll2(@Param("school") String school,@Param("selectname") String selectname);

    @Select("select username,name,sex,school,size,team,nameen,email from student_info where username=#{username}")
    public Student getStuinfo(@Param("username") String username);

    @Update("update student_info set name=#{name},sex=#{sex},size=#{size},school=#{school},nameen=#{nameen},email=#{email} where username=#{oldname}")
    public int studentedit(@Param("name") String name, @Param("sex") String sex, @Param("size") String size, @Param("school") String school, @Param("oldname") String oldname, @Param("email") String email, @Param("nameen") String nameen);

    @Delete("delete from student_info where username=#{username}")
    public int studentdelete(@Param("username") String username);

    @Select("select * from school_code")
    public Collection<Teacher> getAllSchool();

}