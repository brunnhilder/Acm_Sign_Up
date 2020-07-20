package com.sun.springboot.service;

import com.sun.springboot.bean.Ticket;

import java.util.Collection;
import java.util.List;

public interface TicketService {
    String getSchool(String username);

    

    int ticketdelete(int id);

    int ticketadd(String school, String url, String address, String pernum, String bank, String status, String per, String tel);

    

    int ticketupdate(int id);

    int ticketupdate2(int id);

    String selectschool(int id);

    int ticketupdate3(String school);

    Ticket getStatus(String school);

    Ticket getStatus2(String school);

    List getAll3();

    List getAll2();

    List getAll(String school);
}
