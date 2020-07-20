package com.sun.springboot.service;

import com.sun.springboot.bean.Users;

public interface UsersService {
    public Users login(String username,String password,String perlevel);
    public Users registered(String username);
    public int goRegistered(String username, String password,String perlevel);
    Users syslogin(String username, String password);
}
