/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hoanganhtuan
 */
public class Hospital {
    String id;
    String ten;
    String diaChi;
    String soDienThoai;
    int tuyen; // 1: TU, 2: Tinh, 3: Huyen, 4: Xa
    String hotline;
    double mienGiam;

    public Hospital() {
    }

    public Hospital(String id, String ten, String diaChi, String soDienThoai, int tuyen, String hotline) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tuyen = tuyen;
        this.hotline = hotline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getTuyen() {
        return tuyen;
    }

    public void setTuyen(int tuyen) {
        this.tuyen = tuyen;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public double getMienGiam() {
        return mienGiam;
    }

    public void setMienGiam(double mienGiam) {
        this.mienGiam = mienGiam;
    }

    
    
    
}
