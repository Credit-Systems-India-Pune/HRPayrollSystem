package com.csi.payroll.mgt.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.csi.payroll.mgt.dto.BaseDTO;
import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.util.DataUtility;

public class LeaveForm extends BaseForm {
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String toDate;
	@NotEmpty
	private String fromDate;
	@NotEmpty
	private String description;
	@NotEmpty
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
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

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {
		
		LeaveDTO dto=new LeaveDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setName(name);
		dto.setToDate(DataUtility.getDate(toDate));
		dto.setFromDate(DataUtility.getDate(fromDate));
		dto.setDescription(description);
		dto.setEmailId(emailId);
		
		return dto;
		
	}

	@Override
	public void populate(BaseDTO bDto) {
		LeaveDTO dto=(LeaveDTO) bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		name=dto.getName();
		toDate=DataUtility.getStringDate(dto.getToDate());
		fromDate=DataUtility.getStringDate(dto.getFromDate());
		description=dto.getDescription();
		emailId=dto.getEmailId();
		
	}

}
