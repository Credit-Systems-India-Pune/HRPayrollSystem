package com.csi.payroll.mgt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csi.payroll.mgt.dto.AttendanceDTO;

@Repository
public class AttendanceDAOHibImpl implements AttendanceDAOInt {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public long add(AttendanceDTO dto) {
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(AttendanceDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);
		
	}

	public void delete(AttendanceDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);
		
	}

	public AttendanceDTO findByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(AttendanceDTO.class);

		criteria.add(Restrictions.eq("name", name));

		return (AttendanceDTO) criteria.uniqueResult();
	}

	public AttendanceDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		AttendanceDTO dto = (AttendanceDTO) session.get(AttendanceDTO.class, id);
		return dto;
	}

	public List<AttendanceDTO> search(AttendanceDTO dto, long pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AttendanceDTO.class);

		if (dto != null) {
		
			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
				criteria.add(Restrictions.like("emailId", dto.getEmailId() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}

		return criteria.list();
	}

	public List<AttendanceDTO> search(AttendanceDTO dto) {
		// TODO Auto-generated method stub
				return search(dto, 0, 0);
	}

	public Map<Long, AttendanceDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, AttendanceDTO> map = new HashMap<Long, AttendanceDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (AttendanceDTO) session.get(AttendanceDTO.class, id));
		
		}	
		return map;
	}

}
