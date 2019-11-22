package com.csi.payroll.mgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EM_TIMESHEET")
public class TimeSheetDTO extends BaseDTO implements DropdownList {
	
	@Column(name = "USER_NAME", length = 50)
	private String name;
	
	@Column(name = "EMAIL_ID", length = 50)
	private String emailId;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	
	@Column(name = "HOURS", length = 50)
	private String hours;
	
	@Column(name = "tDATE")
	private Date tDate;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+" ";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

}
