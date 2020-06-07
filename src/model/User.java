/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author hoanganhtuan
 */
public class User {
    private String id;
    private String name;
    private int age;
    private String job;
    private String address;
    private String hometown; // que quan
    private Date dob;
    private String nation; // dan toc
    private boolean isRelativeMartyrs; // Co la than nhan liet si
    private boolean isPoorFamily;
    private String bhytRegisterPlace;
    private String bhytID;
    private String username;
    private String password;
    private int tuyenDK;
    private int role; // 0: Admin; 1: user

    public User() {
    }

    public User(String id, String name, int age, String job, String address, String hometown, Date dob, String nation, boolean isRelativeMartyrs, boolean isPoorFamily, String bhytRegisterPlace, String bhytID, String username, String password, int tuyenDK, int role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
        this.hometown = hometown;
        this.dob = dob;
        this.nation = nation;
        this.isRelativeMartyrs = isRelativeMartyrs;
        this.isPoorFamily = isPoorFamily;
        this.bhytRegisterPlace = bhytRegisterPlace;
        this.bhytID = bhytID;
        this.username = username;
        this.password = password;
        this.tuyenDK = tuyenDK;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getTuyenDK() {
        return tuyenDK;
    }

    public void setTuyenDK(int tuyenDK) {
        this.tuyenDK = tuyenDK;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public boolean isIsRelativeMartyrs() {
        return isRelativeMartyrs;
    }

    public void setIsRelativeMartyrs(boolean isRelativeMartyrs) {
        this.isRelativeMartyrs = isRelativeMartyrs;
    }

    public boolean isIsPoorFamily() {
        return isPoorFamily;
    }

    public void setIsPoorFamily(boolean isPoorFamily) {
        this.isPoorFamily = isPoorFamily;
    }

    public String getBhytRegisterPlace() {
        return bhytRegisterPlace;
    }

    public void setBhytRegisterPlace(String bhytRegisterPlace) {
        this.bhytRegisterPlace = bhytRegisterPlace;
    }

    public String getBhytID() {
        return bhytID;
    }

    public void setBhytID(String bhytID) {
        this.bhytID = bhytID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", role=" + role + '}';
    }

    
    
    
}
