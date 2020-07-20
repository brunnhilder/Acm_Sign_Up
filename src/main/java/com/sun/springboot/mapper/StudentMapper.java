package com.sun.springboot.mapper;

import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Teacher;
import com.sun.springboot.bean.Team;
import com.sun.springboot.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface StudentMapper {
    @Select("select username,name,sex,school,size,team,nameen,email from student_info where username=#{username}")
    public Student get(@Param("username") String username);
    @Select("select username,name,sex,size,school,team,nameen,email from student_info where username=#{me}")
    public Collection<Student> getAll(@Param("me") String me);
    @Select("select team from team where teacher=#{teacher}")
    public Collection<Student> getTeamName(@Param("teacher") String teacher);
    @Insert("insert into student_info(username,name,sex,size,school,nameen,email) values(#{me},#{name},#{sex},#{size},#{school},#{nameen},#{email})")
    public int studentadd(@Param("me") String me, @Param("name") String name,@Param("nameen") String namenen,@Param("sex") String sex,@Param("size") String size,@Param("school") String school,@Param("email") String email);
    @Update("update student_info set name=#{name},sex=#{sex},size=#{size},school=#{school},nameen=#{nameen},email=#{email} where username=#{oldname}")
    public int studentedit(@Param("name") String name,@Param("sex") String sex,@Param("size") String size,@Param("school") String school,@Param("oldname") String oldname,@Param("email") String email,@Param("nameen") String nameen);
    @Delete("delete from student_info where username=#{username}")
    public int studentdelete(@Param("username") String username);
    @Select("select team from student_info where username=#{username}")
    public String getTeamName2(@Param("username") String username);
    @Select("select teamid from student_info where username=#{username}")
    public int getTeamId(@Param("username") String username);
    @Select("select * from team_info where id=#{id}")
    public Collection<Team> getMyTeam(@Param("id") int id);

    @Select("select * from school_code")
    public Collection<Student> getAllSchool();



}
