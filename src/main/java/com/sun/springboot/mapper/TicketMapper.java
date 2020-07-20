package com.sun.springboot.mapper;

import com.sun.springboot.bean.Quato;
import com.sun.springboot.bean.Ticket;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface TicketMapper {
    @Select("select school from teacher_info where username=#{username}")
    public String getSchool(@Param("username") String username);

    @Select("select id,school,url,address,pernum,bank,status,per,tel from ticket_info where school=#{school}")
    public List<Ticket> getAll(@Param("school") String school);

    @Select("select id,school,url,address,pernum,bank,status,per,tel from ticket_info where status='等待审核' order by id asc")
    public List<Ticket> getAll2();

    @Delete("delete from ticket_info where id=#{id}")
    public int ticketdelete(@Param("id") int id);

    @Insert("insert into ticket_info(school,url,address,pernum,bank,status,per,tel) values(#{school},#{url},#{address},#{pernum},#{bank},#{status},#{per},#{tel})")
    public int ticketadd(@Param("school") String school, @Param("url") String url, @Param("address") String address, @Param("pernum") String pernum, @Param("bank") String bank,@Param("status") String status,@Param("per") String per,@Param("tel") String tel);

    @Update("update ticket_info set status='审核通过'where id=#{id}")
    public int ticketupdate(@Param("id") int id);

    @Update("update ticket_info set status='审核未通过' where id=#{id}")
    public int ticketupdate2(@Param("id") int id);

    @Update("update school_info set status='已缴费' where school=#{school}")
    public int ticketupdate3(@Param("school") String school);

    @Select("select school from ticket_info where id=#{id}")
    public String getSchool1(@Param("id") int id);

    @Select("select * from ticket_info where status='审核通过' and school=#{school}")
    public Ticket getStatus(@Param("school") String school);

    @Select("select * from ticket_info where status='等待审核' and school=#{school}")
    public Ticket getStatus2(@Param("school") String school);

    @Select("select id,school,url,address,pernum,bank,status,per,tel from ticket_info  order by id asc")
    public List<Ticket> getAll3();
}
