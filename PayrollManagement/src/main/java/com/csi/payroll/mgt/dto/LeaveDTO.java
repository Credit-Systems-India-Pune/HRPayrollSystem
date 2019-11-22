package com.csi.payroll.mgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EM_LEAVE")
public class LeaveDTO extends BaseDTO implements DropdownList {
	
	
	
	@Column(name = "USER_NAME", length = 50)
	private String name;
	
	@Column(name = "TO_DATE")
	private Date toDate;
	
	@Column(name = "FROM_DATE")
	private Date fromDate;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String Description;
	
	@Column(name = "Email_ID", length = 50)
	private String emailId;
	
	
	
	
	
	
	



	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
