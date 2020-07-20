package com.sun.springboot.mapper;

import com.sun.springboot.bean.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {
    @Select("select username,password from account_info where perlevel=#{perlevel} and username=#{username} and password=#{password}")
    public Users login(@Param("username") String username, @Param("password") String password, @Param("perlevel") String perlevel);
    @Select("select username from account_info where username=#{username}")
    public Users registered(@Param("username") String username);
    @Insert("insert into account_info(username,password,perlevel) values(#{username},#{password},#{perlevel})")
    public int goRegistered(@Param("username") String username, @Param("password") String password,@Param("perlevel") String perlevel);
    @Select("select username,password from sys_account_info where username=#{username} and password=#{password}")
    public Users syslogin(@Param("username") String username, @Param("password") String password);
}
