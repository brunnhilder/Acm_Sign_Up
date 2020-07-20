package com.sun.springboot.bean;

public class School {
    private String username;
    private String school;
    private String schoolen;
    private int minge;
    private String xiaohui;
    private String tel;
    private String address;
    private String status;

    @Override
    public String toString() {
        return "School{" +
                "username='" + username + '\'' +
                ", school='" + school + '\'' +
                ", schoolen='" + schoolen + '\'' +
                ", minge=" + minge +
                ", xiaohui='" + xiaohui + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMinge(int minge) {
        this.minge = minge;
    }

    public int getMinge() {
        return minge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolen() {
        return schoolen;
    }

    public void setSchoolen(String schoolen) {
        this.schoolen = schoolen;
    }

    public String getXiaohui() {
        return xiaohui;
    }

    public void setXiaohui(String xiaohui) {
        this.xiaohui = xiaohui;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
