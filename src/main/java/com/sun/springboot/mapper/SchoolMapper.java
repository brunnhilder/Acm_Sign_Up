package com.sun.springboot.mapper;

import com.sun.springboot.bean.School;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SchoolMapper {
    @Select("select school from teacher_info where username=#{me}")
    public String getSchool(@Param("me") String me);
    @Select("select xiaohui from school_info where school=#{schoolname}")
    public String getXiaohui2(@Param("schoolname") String schoolname);
    @Select("select school,schoolen,minge,xiaohui,tel,address,status from school_info where school=#{schoolname}")
    public School get(@Param("schoolname") String schoolname);
    @Insert("insert into school_info(school,schoolen,minge,tel,address,status) values(#{school},#{schoolen},#{minge},#{tel},#{address},#{status})")
    public int schooladd(@Param("school") String school, @Param("schoolen") String schoolen, @Param("minge") int minge, @Param("tel") String tel, @Param("address") String address,@Param("status") String status);
    @Update("update school_info set schoolen=#{schoolen},minge=#{minge},tel=#{tel},address=#{address}where school=#{school}")
    public int schooledit(@Param("school") String school, @Param("schoolen") String schoolen, @Param("minge") int minge, @Param("tel") String tel, @Param("address") String address);
    @Update("update school_info set xiaohui=#{filename} where school=#{schoolname}")
    public int schooledit2( @Param("schoolname") String schoolname,@Param("filename") String filename);
}
