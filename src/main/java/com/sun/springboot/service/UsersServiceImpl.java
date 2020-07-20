package com.sun.springboot.service;

import com.sun.springboot.bean.Users;
import com.sun.springboot.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersMapper mapper;

    public void setMapper(UsersMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Users login(String username,String password,String perlevel)
    {
        return mapper.login(username, password,perlevel);
    }

    @Override
    public Users registered(String username)
    {
        return mapper.registered(username);
    }

    @Override
    public int goRegistered(String username, String password,String perlevel)
    { return mapper.goRegistered(username, password,perlevel); }

    @Override
    public Users syslogin(String username, String password) {
        return mapper.syslogin(username, password);
    }
}
