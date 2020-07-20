package com.sun.springboot.bean;

public class Quato {
    private int id;
    private String school;
    private int minge;
    private String status;
    private String msg;
    private String username;
    private String tel;
    private String email;
    private String per;
    private String checkbox1;
    private String checkbox2;
    private String checkbox3;
    private String checkbox4;
    private String checkbox5;
    private String schoolminge;

    @Override
    public String toString() {
        return "Quato{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", minge=" + minge +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", per='" + per + '\'' +
                ", checkbox1='" + checkbox1 + '\'' +
                ", checkbox2='" + checkbox2 + '\'' +
                ", checkbox3='" + checkbox3 + '\'' +
                ", checkbox4='" + checkbox4 + '\'' +
                ", checkbox5='" + checkbox5 + '\'' +
                ", schoolminge='" + schoolminge + '\'' +
                '}';
    }

    public void setMinge(int minge) {
        this.minge = minge;
    }

    public String getSchoolminge() {
        return schoolminge;
    }

    public void setSchoolminge(String schoolminge) {
        this.schoolminge = schoolminge;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(String checkbox1) {
        this.checkbox1 = checkbox1;
    }

    public String getCheckbox2() {
        return checkbox2;
    }

    public void setCheckbox2(String checkbox2) {
        this.checkbox2 = checkbox2;
    }

    public String getCheckbox3() {
        return checkbox3;
    }

    public void setCheckbox3(String checkbox3) {
        this.checkbox3 = checkbox3;
    }

    public String getCheckbox4() {
        return checkbox4;
    }

    public void setCheckbox4(String checkbox4) {
        this.checkbox4 = checkbox4;
    }

    public String getCheckbox5() {
        return checkbox5;
    }

    public void setCheckbox5(String checkbox5) {
        this.checkbox5 = checkbox5;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getMinge() {
        return minge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
