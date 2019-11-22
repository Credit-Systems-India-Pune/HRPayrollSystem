package com.csi.payroll.mgt.service;

import java.util.List;

import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;



/**
 *  User Service Interface
 * 
 * @author NavigableSet
 * @version 1.0
 * @Copyright (c) NavigableSet
 */


public interface UserServiceInt {

	
	/**
     * Add a user
     * 
     * @param dto
     * 
     * @throws DuplicateRecordException
     *             : throws when user already exists
     */
	
	
	public long add(UserDTO dto) throws DuplicateRecordException;
	/**
     * Delete a user
     * 
     * @param dto
     
     */
	public void delete(UserDTO dto) ;
	/**
     * Update a User
     * 
     * @param dto
     
     * @throws DuplicateRecordException
     *             : if updated user record is already exist
     */
	public void update(UserDTO dto) throws DuplicateRecordException;
	   /**
     * Find user by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     *
     */
	public UserDTO findByPK(long pk) ;
	 /**
     * Find user by login
     * 
     * @param login
     *            : get parameter
     * @return dto
     
     */
	public UserDTO findByLogin(String login) ;
	 
	 /**
     * Search Users
     * 
     * @return list : List of Users
     * @param dto
     *            : Search Parameters
     *
     */
	public List<UserDTO> search(UserDTO dto);
	 /**
     * Search Users with pagination
     * 
     * @return list : List of Users
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     * 
     */
	public List search(UserDTO dto, int pageNo, int pageSize) ;
	
	
	
	 /**
     * Change Password By pk
     * 
     * @param pk
     *            ,oldPassword,newPassword : get parameter
     * @return dto
     * 
     */
    public boolean changePassword(Long id, String oldPassword,
            String newPassword) ;

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
    
    
    
    /**
     * Register a User
     * 
     * @param dto
     * @return
     * 
     */
    public long registerUser(UserDTO dto)  ;
    
    
    /**
     * forget password
     */
    public boolean forgetPassword(String login);
	
}
