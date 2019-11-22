package com.csi.payroll.mgt.form;

import java.util.Date;

import javax.validation.constraints.Min;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.csi.payroll.mgt.dto.BaseDTO;
import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.util.DataUtility;



public class UserForm extends BaseForm {

	@NotEmpty
	@Pattern(regexp = "(^[A-Za-z ]*)*$")
	private String firstName;
	
	
	@NotEmpty
	@Pattern(regexp = "(^[A-Za-z ]*)*$")
	private String lastName;

	@NotEmpty
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
	private String login;

	@NotEmpty
	@Pattern(regexp = "(^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12})*$")
	private String password;

	@NotEmpty
	private String confirmPassword;

	@NotEmpty
	private String dob;

	@NotEmpty
	@Pattern(regexp = "(^[7-9][0-9]{9})*$")
	private String mobileNo;

	@NotEmpty
	private String gender;
	
	@NotEmpty
	 private String fatherName;
	 
	@NotEmpty
	 private String motherName;
	 
	@NotEmpty
	 private String designation;
	 
	@NotEmpty
	 private String department;
	 
	@NotEmpty
	 private String doj;
	 
	@NotEmpty
	 private String currentAddress;
	 
	@NotEmpty
	 private String permanentAddress;
	 
	@NotEmpty
	 private String emailId;
	@NotEmpty
	private String education;
	@NotEmpty
	 private String language;
	@NotEmpty
	 private String pSkill;
	@NotEmpty
	 private String sSkill;

	@Min(value = 1)
	private long roleId;
	
	
	

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

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);

		dto.setFirstName(firstName);
		dto.setLastName(lastName);

		dto.setDob(DataUtility.getDate(dob));

		dto.setLogin(login);
		dto.setPassword(password);
		dto.setMobileNo(mobileNo);
		dto.setGender(gender);
		dto.setRoleId(roleId);
		dto.setFatherName(fatherName);
		dto.setMotherName(motherName);
		dto.setEducation(education);
		dto.setDoj(DataUtility.getDate(doj));
		dto.setEmailId(emailId);
		dto.setLanguage(language);
		dto.setDepartment(department);
		dto.setDesignation(designation);
		dto.setPermanentAddress(permanentAddress);
		dto.setCurrentAddress(currentAddress);
		dto.setsSkill(sSkill);
		dto.setpSkill(pSkill);
		
		return dto;
	}

	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();

		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		dob = DataUtility.getStringDate(dto.getDob());
		login = dto.getLogin();
		password = dto.getPassword();
		confirmPassword = dto.getPassword();
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();
		roleId = dto.getRoleId();
		education=dto.getEducation();
		doj=DataUtility.getStringDate(dto.getDoj());
		emailId=dto.getEmailId();
		language=dto.getLanguage();
		department=dto.getDepartment();
		fatherName=dto.getFatherName();
		motherName=dto.getMotherName();
		designation=dto.getDesignation();
		permanentAddress=dto.getPermanentAddress();
		currentAddress=dto.getCurrentAddress();
		sSkill=dto.getsSkill();
		pSkill=dto.getsSkill();
		

	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
