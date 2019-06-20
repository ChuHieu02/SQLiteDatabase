package com.chuhieu.sqlite_database.model;

public class Nguoidung {
    private String UserName, PassWords, Phone , hoten;

    public Nguoidung(){}

    public Nguoidung(String userName, String passWords, String phone, String hoten) {
        UserName = userName;
        PassWords = passWords;
        Phone = phone;
        this.hoten = hoten;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWords() {
        return PassWords;
    }

    public void setPassWords(String passWords) {
        PassWords = passWords;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Override
    public String toString() {
        return "Nguoidung{" +
                "UserName='" + UserName + '\'' +
                ", PassWords='" + PassWords + '\'' +
                ", Phone='" + Phone + '\'' +
                ", hoten='" + hoten + '\'' +
                '}';
    }
}
