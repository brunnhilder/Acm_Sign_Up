package com.sun.springboot.service;

import com.sun.springboot.bean.Ticket;
import com.sun.springboot.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketMapper mapper;
    @Override
    public String getSchool(String username) {
        return mapper.getSchool(username);
    }



    @Override
    public int ticketdelete(int id) {
        return mapper.ticketdelete(id);
    }

    @Override
    public int ticketadd(String school, String url, String address, String pernum, String bank, String status, String per, String tel) {
        return mapper.ticketadd(school, url, address, pernum, bank, status,per,tel);
    }


    @Override
    public int ticketupdate(int id) {
        return mapper.ticketupdate(id);
    }

    @Override
    public int ticketupdate2(int id) {
        return mapper.ticketupdate2(id);
    }

    @Override
    public String selectschool(int id) {
        return mapper.getSchool1(id);
    }

    @Override
    public int ticketupdate3(String school) {
        return mapper.ticketupdate3(school);
    }

    @Override
    public Ticket getStatus(String school) {
        return mapper.getStatus(school);
    }

    @Override
    public Ticket getStatus2(String school) {
        return mapper.getStatus2(school);
    }

    @Override
    public List getAll3() {
        return mapper.getAll3();
    }

    @Override
    public List getAll2() {
        return mapper.getAll2();
    }

    @Override
    public List getAll(String school) {
        return mapper.getAll(school);
    }
}
