package com.sun.springboot.bean;

public class Team {
    private String id;
    private String schoolid;
    private String teacher;
    private String teamcn;
    private String teamen;
    private String jieshu;
    private String jindu;
    private String url;
    private String huojiang;
    private String school;
    private String username;
    private String name;
    private String sex;
    private String size;
    private String team;
    private String password;
    private String nameen;
    private String email;

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", schoolid='" + schoolid + '\'' +
                ", teacher='" + teacher + '\'' +
                ", teamcn='" + teamcn + '\'' +
                ", teamen='" + teamen + '\'' +
                ", jieshu='" + jieshu + '\'' +
                ", jindu='" + jindu + '\'' +
                ", url='" + url + '\'' +
                ", huojiang='" + huojiang + '\'' +
                ", school='" + school + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                ", team='" + team + '\'' +
                ", password='" + password + '\'' +
                ", nameen='" + nameen + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeamcn() {
        return teamcn;
    }

    public void setTeamcn(String teamcn) {
        this.teamcn = teamcn;
    }

    public String getTeamen() {
        return teamen;
    }

    public void setTeamen(String teamen) {
        this.teamen = teamen;
    }

    public String getJieshu() {
        return jieshu;
    }

    public void setJieshu(String jieshu) {
        this.jieshu = jieshu;
    }

    public String getJindu() {
        return jindu;
    }

    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHuojiang() {
        return huojiang;
    }

    public void setHuojiang(String huojiang) {
        this.huojiang = huojiang;
    }
}
