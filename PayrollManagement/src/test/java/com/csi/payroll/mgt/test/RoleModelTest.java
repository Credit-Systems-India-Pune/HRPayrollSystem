package com.csi.payroll.mgt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csi.payroll.mgt.dao.RoleDAOInt;
import com.csi.payroll.mgt.dto.RoleDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;
import com.csi.payroll.mgt.service.RoleServiceInt;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")

public class RoleModelTest {

	@Autowired
	RoleServiceInt model;
	
	@Test
	public void add() throws DuplicateRecordException{
		
		RoleDTO dto = new RoleDTO();
		
		dto.setRoleName("Employee");
		dto.setRoleDescription("Employee");
		
		long i=model.add(dto);
		if(i>0) {
			System.out.println("Data Is Successfully Save");
		}else {
			System.out.println("Data Not Save");
		}
	}
}
