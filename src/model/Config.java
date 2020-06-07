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
public class Config {
    int id;
    int age;
    double quyenLoiDungTuyen1;
    double quyenLoiDungTuyen2;
    double quyenLoiDungTuyen3;
    double traiTuyenTuyenHuyen;
    double traiTuyenTuyenTinh;
    double traiTuyenTuyenTrungUong;
    Date ngayApDung;

    public Config() {
    }

    public Config(int age, double quyenLoiDungTuyen1, double quyenLoiDungTuyen2, double quyenLoiDungTuyen3, double traiTuyenTuyenHuyen, double traiTuyenTuyenTinh, double traiTuyenTuyenTrungUong, Date ngayApDung) {
        this.age = age;
        this.quyenLoiDungTuyen1 = quyenLoiDungTuyen1;
        this.quyenLoiDungTuyen2 = quyenLoiDungTuyen2;
        this.quyenLoiDungTuyen3 = quyenLoiDungTuyen3;
        this.traiTuyenTuyenHuyen = traiTuyenTuyenHuyen;
        this.traiTuyenTuyenTinh = traiTuyenTuyenTinh;
        this.traiTuyenTuyenTrungUong = traiTuyenTuyenTrungUong;
        this.ngayApDung = ngayApDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getQuyenLoiDungTuyen1() {
        return quyenLoiDungTuyen1;
    }

    public void setQuyenLoiDungTuyen1(double quyenLoiDungTuyen1) {
        this.quyenLoiDungTuyen1 = quyenLoiDungTuyen1;
    }

    public double getQuyenLoiDungTuyen2() {
        return quyenLoiDungTuyen2;
    }

    public void setQuyenLoiDungTuyen2(double quyenLoiDungTuyen2) {
        this.quyenLoiDungTuyen2 = quyenLoiDungTuyen2;
    }

    public double getQuyenLoiDungTuyen3() {
        return quyenLoiDungTuyen3;
    }

    public void setQuyenLoiDungTuyen3(double quyenLoiDungTuyen3) {
        this.quyenLoiDungTuyen3 = quyenLoiDungTuyen3;
    }

    public double getTraiTuyenTuyenHuyen() {
        return traiTuyenTuyenHuyen;
    }

    public void setTraiTuyenTuyenHuyen(double traiTuyenTuyenHuyen) {
        this.traiTuyenTuyenHuyen = traiTuyenTuyenHuyen;
    }

    public double getTraiTuyenTuyenTinh() {
        return traiTuyenTuyenTinh;
    }

    public void setTraiTuyenTuyenTinh(double traiTuyenTuyenTinh) {
        this.traiTuyenTuyenTinh = traiTuyenTuyenTinh;
    }

    public double getTraiTuyenTuyenTrungUong() {
        return traiTuyenTuyenTrungUong;
    }

    public void setTraiTuyenTuyenTrungUong(double traiTuyenTuyenTrungUong) {
        this.traiTuyenTuyenTrungUong = traiTuyenTuyenTrungUong;
    }

    public Date getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(Date ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    @Override
    public String toString() {
        return "Config{" + "age=" + age + ", quyenLoiDungTuyen1=" + quyenLoiDungTuyen1 + ", quyenLoiDungTuyen2=" + quyenLoiDungTuyen2 + ", quyenLoiDungTuyen3=" + quyenLoiDungTuyen3 + ", traiTuyenTuyenHuyen=" + traiTuyenTuyenHuyen + ", traiTuyenTuyenTinh=" + traiTuyenTuyenTinh + ", traiTuyenTuyenTrungUong=" + traiTuyenTuyenTrungUong + '}';
    }
    
    
}
