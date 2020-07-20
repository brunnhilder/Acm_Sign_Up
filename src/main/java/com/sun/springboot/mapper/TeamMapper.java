package com.sun.springboot.mapper;

import com.sun.springboot.bean.School;
import com.sun.springboot.bean.Student;
import com.sun.springboot.bean.Team;
import com.sun.springboot.bean.Ticket;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface TeamMapper {
    @Select("select school from teacher_info where username=#{username}")
    public String getSchool(@Param("username") String username);

    @Select("select teamcn from team_info where id=#{id}")
    public String getTeamCn(@Param("id") int id);

    @Select("select id,school,url,teamcn,teamen,jieshu,jindu,huojiang,teacher,schoolid from team_info where school=#{school}")
    public List<Team> getAll(@Param("school") String school);

    @Select("select * from team_info where id=#{id}")
    public Team get(@Param("id") int id);

    @Delete("delete from team_info where id=#{id}")
    public int teamDelete(@Param("id") int id);

    @Insert("insert into team_info(teamcn,teamen,teacher,jieshu,jindu,huojiang,school) values(#{teamcn},#{teamen},#{teacher},#{jieshu},#{jindu},#{huojiang},#{school})")
    public int teamadd(@Param("teamcn") String teamcn, @Param("teamen") String teamen, @Param("teacher") String teacher, @Param("jieshu") String jieshu, @Param("jindu") String jindu,@Param("huojiang") String huojiang,@Param("school") String school);

    @Update("update team_info set teamcn=#{teamcn},teamen=#{teamen},teacher=#{teacher} where id=#{id}")
    public int teamedit(@Param("teamcn") String teamcn, @Param("teamen") String teamen, @Param("teacher") String teacher,@Param("id") int id);

    @Select("select a.username,a.name,a.sex,a.size,a.school,b.teamcn,a.nameen,a.email from student_info a,team_info b where a.school=#{school} and b.id!=#{id} and b.id=a.teamid union\n" +
            "select distinct a.username,a.name,a.sex,a.size,a.school,a.team,a.nameen,a.email from student_info a,team_info b where a.school=#{school} and a.teamid is null ")
    public Collection<Student> getAllStu(@Param("id") int id,@Param("school") String school);

    @Select("select a.username,a.name,a.sex,a.size,a.school,b.teamcn,a.nameen,a.email from student_info a,team_info b where a.school=#{school} and b.id=#{id} and b.id=a.teamid ")
    public Collection<Student> getAllStu2(@Param("id") int id,@Param("school") String school);

    @Update("update student_info set teamid=#{id},team=#{teamcn} where username=#{username}")
    public int stuadd(@Param("id") int id, @Param("username") String username,@Param("teamcn") String teamcn);

    @Update("update student_info set teamid=null,team=null where username=#{username}")
    public int studel(@Param("id") int id, @Param("username") String username,@Param("teamcn") String teamcn);

    @Update("update student_info set teamid=null,team=null where teamid=#{id}")
    public int studel2(@Param("id") int id);

    @Select("select count(*) from student_info where teamid=#{id}")
    public int getstunum(@Param("id") int id);

    @Select("select count(*) from student_info where teamid is not null")
    public int getschoolnum();

    @Select("select minge from school_info where school=#{school}")
    public int getschoolminge(@Param("school") String school);

    @Select("select username from student_info where username=#{username} and teamid is not null")
    public String getstuteam(@Param("username") String username);

    @Update("update team_info set url=#{filename},huojiang='是' where id=#{id}")
    public int zhengshuadd(@Param("id") int id,@Param("filename") String filename);

    @Select("select url from team_info where id=#{id}")
    public String getfilename(@Param("id") int id);

    @Select("select huojiang from team_info where id=#{id}")
    public String huojiang(@Param("id") int id);
}
