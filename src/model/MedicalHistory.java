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
public class MedicalHistory {
    String id;
    String patientName;
    String doctorName;
    String hospitalName;
    String hospitalAddress;
    Date date; // ngay kham
    String diseaseName; //ten benh
    Boolean isDungTuyen;
    double totalMoney;
    double payMoney;

    public MedicalHistory() {
    }

    public MedicalHistory(String id, String patientName, String doctorName, String hospitalName, String hospitalAddress, Date date, String diseaseName, Boolean isDungTuyen, double totalMoney, double payMoney) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.date = date;
        this.diseaseName = diseaseName;
        this.isDungTuyen = isDungTuyen;
        this.totalMoney = totalMoney;
        this.payMoney = payMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Boolean getIsDungTuyen() {
        return isDungTuyen;
    }

    public void setIsDungTuyen(Boolean isDungTuyen) {
        this.isDungTuyen = isDungTuyen;
    }

    

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }
}
