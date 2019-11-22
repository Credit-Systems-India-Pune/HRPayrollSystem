package com.csi.payroll.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csi.payroll.mgt.dao.LeaveDAOInt;
import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;

@Service
public class LeaveServiceSpringImpl implements LeaveServiceInt {
	
	@Autowired
	LeaveDAOInt dao;

	private static Logger log = Logger.getLogger(LeaveServiceSpringImpl.class);
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(LeaveDTO dto) throws DuplicateRecordException {

		log.debug("Leave spring add start");

		LeaveDTO existdto = dao.findByName(dto.getName());

		if (existdto != null) {
			throw new DuplicateRecordException("Leave is already exits");
		}

		log.debug("Leave spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(LeaveDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(LeaveDTO dto) throws DuplicateRecordException {
		log.debug("Leave spring add start");

		LeaveDTO existdto = dao.findByName(dto.getName());
		if (existdto != null && existdto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("Leave is already exits");
		}

		log.debug("Leave spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public LeaveDTO findByPK(long pk) {
		
		
		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public LeaveDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<LeaveDTO> search(LeaveDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(LeaveDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	public Map<Long, LeaveDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}


}
