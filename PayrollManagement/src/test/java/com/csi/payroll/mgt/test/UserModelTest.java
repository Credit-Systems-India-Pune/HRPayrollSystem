package com.csi.payroll.mgt.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;
import com.csi.payroll.mgt.service.UserServiceInt;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class UserModelTest {

	@Autowired
	UserServiceInt model;

	@Ignore
	public void add() throws ParseException, DuplicateRecordException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserDTO dto = new UserDTO();
		// dto.setId(8L);
		dto.setFirstName("rrr");
		dto.setLastName("sha");
		dto.setLogin("m@gmail.com");
		dto.setPassword("1234");

		dto.setDob(sdf.parse("03/05/1990"));

		dto.setRoleId(1L);
	
		dto.setGender("Male");
		
		dto.setMobileNo("9876543234");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		long pk = model.add(dto);

		System.out.println("pk :---" + pk);

	}

	@Ignore
	public void update() throws ParseException, DuplicateRecordException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("titu");
		dto.setLastName("ch");
		dto.setMobileNo("953656565");
		dto.setLogin("m@gmail.com");
		dto.setDob(sdf.parse("31/12/1990"));

		model.update(dto);
	}

	@Ignore
	public void delete() {

		UserDTO dto = new UserDTO();

		dto.setId(3);
		model.delete(dto);
	}

	@Ignore
	public void findbylogin() {
		UserDTO dto = new UserDTO();

		dto = model.findByLogin("man@gmail.com");

		System.out.println("kwhdgchjwevcv" + dto.getFirstName());

	}

	@Ignore
	public void findbypk() {

		UserDTO dto = new UserDTO();

		dto = model.findByPK(2);

		System.out.println(dto.getFirstName());

	}

	@Test
	public void search() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("m");
		
	List< UserDTO> list	=model.search(dto, 0, 10);
	
	
	Iterator<UserDTO> it =list.iterator();
	
	while(it.hasNext()){
		dto=it.next();
		
		System.out.println(dto.getFirstName());
	}
	}

}
