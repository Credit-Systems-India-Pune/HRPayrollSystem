package com.csi.payroll.mgt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csi.payroll.mgt.dto.UserDTO;



/**
 * Hibernate implementation of User DAO.
 * 
 * @author Navigable Set
 * @version 1.0
 *
 */
@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(UserDTO dto) {
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(UserDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);
	}

	public UserDTO findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("login", login));
		return (UserDTO) criteria.uniqueResult();
	}

	public UserDTO findByPk(long id) {
		System.out.println("id==========="+id);
		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = (UserDTO) session.get(UserDTO.class, id);
		// session.evict(dto);
		return dto;
	}

	public List<UserDTO> search(UserDTO dto, long pageNo, int pageSize) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {

				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));

			}
			if (dto.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		return criteria.list();
	}

	public List<UserDTO> search(UserDTO dto) {
		return search(dto, 0, 0);
	}

	public UserDTO authenticate(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.like("login", dto.getLogin()));
		criteria.add(Restrictions.like("password", dto.getPassword()));
		
		return (UserDTO)criteria.uniqueResult();
	}

}
