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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csi.payroll.mgt.dto.RoleDTO;


/**
 * Hibernate implementation of Role DAO.
 * 
 * @author Navigable Set
 * @version 1.0
 *
 */

@Repository
public class RoleDAOHibImpl implements RoleDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(RoleDTO dto) {

		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(RoleDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(RoleDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public RoleDTO findByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(RoleDTO.class);

		criteria.add(Restrictions.eq("roleName", name));

		return (RoleDTO) criteria.uniqueResult();
	}

	public RoleDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		RoleDTO dto = (RoleDTO) session.get(RoleDTO.class, id);
		
		return dto;
	}

	public List<RoleDTO> search(RoleDTO dto, long pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RoleDTO.class);

		if (dto != null) {
		
			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
				criteria.add(Restrictions.like("roleName", dto.getRoleName() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}

		return criteria.list();
	}

	public List<RoleDTO> search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, RoleDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, RoleDTO> map = new HashMap<Long, RoleDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (RoleDTO) session.get(RoleDTO.class, id));
		}	
		return map;
		
		
	}

}
