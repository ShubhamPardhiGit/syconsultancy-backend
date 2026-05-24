package com.syconsultancy.sy_backend.DTO;
public class UserDto {

    private Long id;
    private String fullName;
    private String mobileNo;
    private String passportNo;
    private String designation;

    public UserDto(Long id, String fullName,
                       String mobileNo,
                       String passportNo, String designation) {
        this.id = id;
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.passportNo = passportNo;
        this.designation = designation ;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation){
        this.designation = designation ;
    }
}
