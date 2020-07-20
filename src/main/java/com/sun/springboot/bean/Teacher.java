package com.sun.springboot.bean;

public class Teacher {
    private String username;
    private String name;
    private String sex;
    private String size;
    private String school;
    private String team;
    private String password;
    private String teacher;
    private String nameen;
    private String email;
    private String tel;
    private String schoolurl;
    private String id;

    @Override
    public String toString() {
        return "Teacher{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                ", school='" + school + '\'' +
                ", team='" + team + '\'' +
                ", password='" + password + '\'' +
                ", teacher='" + teacher + '\'' +
                ", nameen='" + nameen + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", schoolurl='" + schoolurl + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getNameen() {
        return nameen;
    }

    public void setNameen(String nameen) {
        this.nameen = nameen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchoolurl() {
        return schoolurl;
    }

    public void setSchoolurl(String schoolurl) {
        this.schoolurl = schoolurl;
    }
}
