package com.sun.springboot.service;

import com.sun.springboot.bean.School;

public interface SchoolService {
    public String getSchool(String me);

    public School get(String schoolname);

    public int schooladd(String school, String schoolen, int minge, String tel, String address,String status);

    public int schooledit(String school, String schoolen, int minge, String tel, String address);

    

    String getxiaohui(String schoolname);

    int schooleditxiaohui(String schoolname, String filename);
}
