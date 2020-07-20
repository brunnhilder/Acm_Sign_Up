package com.sun.springboot.mapper;

import com.sun.springboot.bean.Quato;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface QuatoMapper {
    @Select("select school from teacher_info where username=#{username}")
    public String getSchool(@Param("username") String username);

    @Select("select id,school,msg,status,minge,tel,per,email,checkbox1,checkbox2,checkbox3,checkbox4,checkbox5 from minge_info where school=#{school}")
    public List<Quato> getAll(@Param("school") String school);

    @Select("select id,school,msg,status,minge,tel,per,email,checkbox1,checkbox2,checkbox3,checkbox4,checkbox5 from minge_info where status='等待审核' order by id asc")
    public List<Quato> getAllSys();

    @Delete("delete from minge_info where id=#{id}")
    public int quatodelete(@Param("id") int id);

    @Insert("insert into minge_info(school,minge,status,tel,per,email,msg,checkbox1,checkbox2,checkbox3,checkbox4,checkbox5) values(#{school},#{minge},#{status},#{tel},#{per},#{email},#{msg},#{checkbox1},#{checkbox2},#{checkbox3},#{checkbox4},#{checkbox5})")
    public int quatoadd(@Param("school") String school, @Param("minge") int minge, @Param("status") String status,@Param("tel") String tel,@Param("per") String per,@Param("email") String email, @Param("msg") String msg,@Param("checkbox1") String checkbox1,@Param("checkbox2") String checkbox2,@Param("checkbox3") String checkbox3,@Param("checkbox4") String checkbox4,@Param("checkbox5") String checkbox5);

    @Update("update minge_info set status='审核通过'where id=#{id}")
    public int quatoupdate(@Param("id") int id);

    @Update("update minge_info set status='审核未通过' where id=#{id}")
    public int quatoupdate2(@Param("id") int id);

    @Select("select school from minge_info where id=#{id}")
    public String getSchool1(@Param("id") int id);

    @Select("select minge from minge_info where id=#{id}")
    public int getSchool2(@Param("id") int id);

    @Select("select minge from school_info where school=#{school}")
    public int getSchool3(@Param("school") String school);

    @Update("update school_info set minge=#{minge} where school=#{school}")
    public int update(@Param("minge") int minge,@Param("school") String school);

    @Select("select * from minge_info where status='审核通过' and school=#{school}")
    public Quato getStatus(@Param("school") String school);

    @Select("select * from minge_info where status='等待审核' and school=#{school}")
    public Quato getStatus2(@Param("school") String school);


}
