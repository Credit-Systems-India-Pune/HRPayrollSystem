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

import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.dto.SalaryDTO;

@Repository
public class LeaveDAOHibImpl implements LeaveDAOInt {

	@Autowired
	private SessionFactory sessionFactory;
	
	public long add(LeaveDTO dto) {
		
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(LeaveDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);
		
	}

	public void delete(LeaveDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);
		
	}

	public LeaveDTO findByName(String name) {
		
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(LeaveDTO.class);

		criteria.add(Restrictions.eq("name", name));

		return (LeaveDTO) criteria.uniqueResult();
	}

	public LeaveDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		LeaveDTO dto = (LeaveDTO) session.get(LeaveDTO.class, id);
		
		return dto;
	}

	public List<LeaveDTO> search(LeaveDTO dto, long pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LeaveDTO.class);

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

	public List<LeaveDTO> search(LeaveDTO dto) {
		// TODO Auto-generated method stub
				return search(dto, 0, 0);
	}

	public Map<Long, LeaveDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, LeaveDTO> map = new HashMap<Long, LeaveDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (LeaveDTO) session.get(LeaveDTO.class, id));
		}	
		return map;
	}

}
