package com.csi.payroll.mgt.dto;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User POJO class. It is persistent object.
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 */

@Entity
@Table(name = "EM_USER")
public class UserDTO extends BaseDTO implements DropdownList {
    
   
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;
    
    @Column(name = "FATHER_NAME", length = 50)
    private String fatherName;
    
    @Column(name = "MOTHER_NAME", length = 50)
    private String motherName;
    /**
     * Last Name of User
     */
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
    /**
     * Login of User
     */
    @Column(name = "LOGIN", length = 50)
    private String login;
    /**
     * Password of User
     */
    @Column(name = "PASSWORD", length = 50)
    private String password;
    /**
     * Date of Birth of User
     */
    @Column(name = "DOB")
    private Date dob;
    /**
     * MobielNo of User
     */
    @Column(name = "MOBILE_NO", length = 15)
    private String mobileNo;
    /**
     * Role of User
     */
    @Column(name = "ROLE_ID")
    private long roleId;
    /**
     * Number of unsuccessful login attempt
     */
   
    /**
     * Gender of User
     */
    @Column(name = "GENDER", length = 10)
    private String gender;
    /**
     * Last login timestamp
     */
   
   @Column(name = "DESIGNATION", length = 50)
   private String designation;

   @Column(name = "DEPARTMENT", length = 50)
   private String department;
   
   @Column(name = "DOJ" )
   private Date doj;
   
   @Column(name = "CURRENT_ADDRESS", length = 50)
   private String currentAddress;
   
   @Column(name = "PERMANENT_ADDRESS", length = 50)
   private String permanentAddress;
   
   @Column(name = "EMAIL_ID", length = 50)
   private String emailId;
   
   
   private String fullName;
   
    
   public String getFullName() {
	return firstName+" "+lastName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

public String getMotherName() {
	return motherName;
}

public void setMotherName(String motherName) {
	this.motherName = motherName;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public Date getDoj() {
	return doj;
}

public void setDoj(Date doj) {
	this.doj = doj;
}

public String getCurrentAddress() {
	return currentAddress;
}

public void setCurrentAddress(String currentAddress) {
	this.currentAddress = currentAddress;
}

public String getPermanentAddress() {
	return permanentAddress;
}

public void setPermanentAddress(String permanentAddress) {
	this.permanentAddress = permanentAddress;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getEducation() {
	return education;
}

public void setEducation(String education) {
	this.education = education;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public String getpSkill() {
	return pSkill;
}

public void setpSkill(String pSkill) {
	this.pSkill = pSkill;
}

public String getsSkill() {
	return sSkill;
}

public void setsSkill(String sSkill) {
	this.sSkill = sSkill;
}



@Column(name = "EDUCATION", length = 50)
   private String education;
   
   @Column(name = "LANGUAGE", length = 50)
   private String language;
   
   @Column(name = "P_SKILL", length = 50)
   private String pSkill;
    
   @Column(name = "S_SKILL", length = 50)
   private String sSkill;
   
  

    /**
     * accessor
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

   

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    


    public String getKey() {
        return id + "";
    }

    public String getValue() {
        return firstName + " " + lastName;
    }

}