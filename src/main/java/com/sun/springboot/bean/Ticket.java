package com.sun.springboot.bean;

public class Ticket {
    private int id;
    private String school;
    private String url;
    private String address;
    private String pernum;
    private String bank;
    private String status;
    private String per;
    private String tel;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", url='" + url + '\'' +
                ", address='" + address + '\'' +
                ", pernum='" + pernum + '\'' +
                ", bank='" + bank + '\'' +
                ", status='" + status + '\'' +
                ", per='" + per + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPernum() {
        return pernum;
    }

    public void setPernum(String pernum) {
        this.pernum = pernum;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
