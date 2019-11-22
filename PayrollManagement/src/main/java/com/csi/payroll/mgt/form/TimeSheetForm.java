package com.csi.payroll.mgt.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.csi.payroll.mgt.dto.BaseDTO;
import com.csi.payroll.mgt.dto.TimeSheetDTO;
import com.csi.payroll.mgt.util.DataUtility;

public class TimeSheetForm extends BaseForm {
	
	@NotEmpty
	private String name;
	@NotEmpty
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
	private String emailId;
	@NotEmpty
	private String tDate;
	@NotEmpty
	private String hours;
	@NotEmpty
	private String description;
	
	
	

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

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {
		TimeSheetDTO dto=new TimeSheetDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setName(name);
		dto.setEmailId(emailId);
		dto.settDate(DataUtility.getDate(tDate));
		dto.setHours(hours);
		dto.setDescription(description);
		
		return dto;
		
	}

	@Override
	public void populate(BaseDTO bDto) {
		TimeSheetDTO dto=(TimeSheetDTO) bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		
		name=dto.getName();
		emailId=dto.getEmailId();
		tDate=DataUtility.getStringDate(dto.gettDate());
		hours=dto.getHours();
		description=dto.getDescription();
	
	}
 
}
