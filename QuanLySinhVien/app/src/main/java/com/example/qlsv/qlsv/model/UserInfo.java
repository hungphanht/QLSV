package com.example.qlsv.qlsv.model;

import java.util.ArrayList;

/**
 * Created by phong on 5/22/2017.
 */

public class UserInfo {

    private int id_sv;
    private String lastname;
    private String fistname;
    private String mssv;
    private String phone;
    private String birthday;
    private String placeofbirth;
    private String gender;
    private String nation;
    private String classroom;
    private ArrayList<String> photo;

    public UserInfo(int id_sv, String lastname, String fistname, String mssv, String phone, String birthday, String placeofbirth, String gender, String nation, String classroom, ArrayList<String> photo) {
        this.id_sv = id_sv;
        this.lastname = lastname;
        this.fistname = fistname;
        this.mssv = mssv;
        this.phone = phone;
        this.birthday = birthday;
        this.placeofbirth = placeofbirth;
        this.gender = gender;
        this.nation = nation;
        this.classroom = classroom;
        this.photo = photo;
    }

    public UserInfo() {
        this.id_sv = 1;
        this.lastname = "unknow";
        this.fistname = "unknow";
        this.mssv = null;
        this.phone = "unknow";
        this.birthday = "unknow";
        this.placeofbirth = "unknow";
        this.gender = "unknow";
        this.nation = "unknow";
        this.classroom = null;
        this.photo = null;
    }

    public int getId_sv() {
        return id_sv;
    }

    public void setId_sv(int id_sv) {
        this.id_sv = id_sv;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public ArrayList<String> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<String> photo) {
        this.photo = photo;
    }
}
