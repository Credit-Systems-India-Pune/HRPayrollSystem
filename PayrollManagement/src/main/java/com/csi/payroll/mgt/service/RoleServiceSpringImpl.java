package com.csi.payroll.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csi.payroll.mgt.dao.RoleDAOInt;
import com.csi.payroll.mgt.dto.RoleDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;



/**
 * Role Service Implementation
 * 
 * @author Navigable Set
 * @copywrite Navigable Set
 *
 */

@Service
public class RoleServiceSpringImpl implements RoleServiceInt {

	@Autowired
	RoleDAOInt dao;

	private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(RoleDTO dto) throws DuplicateRecordException {

		log.debug("Role spring add start");

		RoleDTO existdto = dao.findByName(dto.getRoleName());

		if (existdto != null) {
			throw new DuplicateRecordException("role is already exits");
		}

		log.debug("Role spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(RoleDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(RoleDTO dto) throws DuplicateRecordException {
		log.debug("Role spring add start");

		RoleDTO existdto = dao.findByName(dto.getRoleName());
System.out.println("dto.getRoleName()************"+dto.getRoleName());
System.out.println("exist dto in role service "+existdto.getRoleName());
		if (existdto != null && existdto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("role is already exits");
		}

		log.debug("Role spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public RoleDTO findByPK(long pk) {
		
		
		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public RoleDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	public Map<Long, RoleDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}

	
	

}
