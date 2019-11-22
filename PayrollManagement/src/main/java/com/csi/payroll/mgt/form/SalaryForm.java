package com.csi.payroll.mgt.form;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.csi.payroll.mgt.dto.BaseDTO;
import com.csi.payroll.mgt.dto.SalaryDTO;
import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.util.DataUtility;

public class SalaryForm extends BaseForm {
	
	@Min(value = 1)
	private long userId;

	@NotEmpty
	private String sDate;

	@NotEmpty
	private String amount;
	
	@NotEmpty
	private String month;
	

	private String name;
	
	
	
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public BaseDTO getDto() {
		SalaryDTO dto=new SalaryDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setUserId(userId);
		dto.setsDate(DataUtility.getDate(sDate));
		dto.setAmount(amount);
		dto.setMonth(month);
		dto.setUserName(name);
		return dto;
		
	}

	@Override
	public void populate(BaseDTO bDto) {

		SalaryDTO dto= (SalaryDTO) bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		userId=dto.getUserId();
		sDate=DataUtility.getStringDate(dto.getsDate());
		amount=dto.getAmount();
		month=dto.getMonth();
		name=dto.getUserName();
	}

}
