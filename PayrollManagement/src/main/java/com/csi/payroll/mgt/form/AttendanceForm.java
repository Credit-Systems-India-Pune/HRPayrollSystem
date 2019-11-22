package com.csi.payroll.mgt.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.csi.payroll.mgt.dto.AttendanceDTO;
import com.csi.payroll.mgt.dto.BaseDTO;
import com.csi.payroll.mgt.util.DataUtility;

public class AttendanceForm  extends BaseForm{

	@NotEmpty
	private String name;
	
	@NotEmpty
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
	private String emailId;
	
	@NotEmpty
	private String status;
	
	@NotEmpty
	private String aDate;
	
	
	
	
	
	public String getaDate() {
		return aDate;
	}

	public void setaDate(String aDate) {
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

	@Override
	public BaseDTO getDto() {
		AttendanceDTO dto=new AttendanceDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setName(name);
		dto.setEmailId(emailId);
		dto.setStatus(status);
		dto.setaDate(DataUtility.getDate(aDate));
		return dto;
		
	}

	@Override
	public void populate(BaseDTO bDto) {
		AttendanceDTO dto=(AttendanceDTO) bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		
		name=dto.getName();
		emailId=dto.getEmailId();
		status=dto.getStatus();
		aDate=DataUtility.getStringDate(dto.getaDate());
		
	}

}
