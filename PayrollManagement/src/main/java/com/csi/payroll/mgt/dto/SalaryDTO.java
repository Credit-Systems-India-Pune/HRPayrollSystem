package com.csi.payroll.mgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EM_SALARY")
public class SalaryDTO extends BaseDTO implements DropdownList {
	

	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "USER_NAME", length = 50)
	private String userName;
	
	@Column(name = "SDATE")
	private Date sDate;
	
	@Column(name = "MONTH", length = 50)
	private String month;
	
	@Column(name = "AMOUNT", length = 50)
	private String amount;
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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
