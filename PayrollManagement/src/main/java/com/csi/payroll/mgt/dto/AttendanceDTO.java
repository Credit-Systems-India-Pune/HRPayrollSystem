package com.csi.payroll.mgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EM_ATTENDANCE")
public class AttendanceDTO extends BaseDTO implements DropdownList {
	
	@Column(name = "USER_NAME", length = 50)
	private String name;
	@Column(name = "EMAIL_ID", length = 50)
	private String emailId;
	@Column(name = "STATUS", length = 50)
	private String status;
	@Column(name = "ADATE", length = 50)
	private Date aDate;
	
	
	
	

	public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
