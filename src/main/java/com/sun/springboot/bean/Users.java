package com.sun.springboot.bean;

import java.math.BigInteger;

public class Users {
    private BigInteger id;
    private String username;
    private String password;
    private  String password1;
    private String perlevel;

    public String getPerlevel() {
        return perlevel;
    }

    public void setPerlevel(String perlevel) {
        this.perlevel = perlevel;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
