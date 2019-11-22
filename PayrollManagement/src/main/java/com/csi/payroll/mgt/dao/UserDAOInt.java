package com.csi.payroll.mgt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.UserDTO;



/**
 * 
 * User DAO interface.
 * 
 * @author Navigable Set
 * @version 1.0
 * 
 */
public interface UserDAOInt {

	/**
	 * Adds a User.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(UserDTO dto);

	/**
	 * Update a User.
	 * 
	 * @param dto
	 * 
	 */
	public void update(UserDTO dto);

	/**
	 * Delete a User.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(UserDTO dto);

	/**
	 * Find a User by it's login.
	 * 
	 * @param userName
	 * 
	 * @return UserDTO
	 */
	public UserDTO findByLogin(String login);

	/**
	 * Find a User by it's pk.
	 * 
	 * @param id
	 * 
	 * @return UserDTO
	 */
	public UserDTO findByPk(long id);

	/**
	 * Search Users with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<UserDTO> search(UserDTO dto, long pageNo, int pageSize);

	/**
	 * Search Users.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<UserDTO> search(UserDTO dto);


	  /**
     * User Authentication
     * 
     * @return dto : Contains User's information
     * @param login
     *            : User Login
     * @param password
     *            : User Password
     * 
     */
    public UserDTO authenticate(UserDTO dto);
    
	
	
}
