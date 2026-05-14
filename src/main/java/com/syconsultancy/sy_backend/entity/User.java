package com.syconsultancy.sy_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String passportNo;

    private LocalDate dob;

    private String designation;

    private String ppType;

    private String mobileNo;

    private String address;

    private String remark;

    @Column(name = "photo", columnDefinition = "bytea")
    private byte[] photo;

    @Column(name = "cv", columnDefinition = "bytea")
    private byte[] cv;

    private LocalDateTime createdDate;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(Long id,
                String fullName,
                String passportNo,
                LocalDate dob,
                String designation,
                String ppType,
                String mobileNo,
                String address,
                String remark,
                byte[] photo,
                byte[] cv,
                LocalDateTime createdDate) {

        this.id = id;
        this.fullName = fullName;
        this.passportNo = passportNo;
        this.dob = dob;
        this.designation = designation;
        this.ppType = ppType;
        this.mobileNo = mobileNo;
        this.address = address;
        this.remark = remark;
        this.photo = photo;
        this.cv = cv;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPpType() {
        return ppType;
    }

    public void setPpType(String ppType) {
        this.ppType = ppType;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}