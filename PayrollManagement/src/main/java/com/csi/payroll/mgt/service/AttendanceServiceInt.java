package com.csi.payroll.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.AttendanceDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;

public interface AttendanceServiceInt {
	
	/**
     * Add a role
     * 
     * @param dto
     * 
     * @throws DuplicateRecordException
     *             : throws when role already exists
     */
	
	
	public long add(AttendanceDTO dto) throws DuplicateRecordException;
	/**
     * Delete a role
     * 
     * @param dto
     
     */
	public void delete(AttendanceDTO dto) ;
	/**
     * Update a Role
     * 
     * @param dto
     
     * @throws DuplicateRecordException
     *             : if updated role record is already exist
     */
	public void update(AttendanceDTO dto) throws DuplicateRecordException;
	   /**
     * Find role by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     *
     */
	public AttendanceDTO findByPK(long pk) ;
	
	
	/**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     * 
     */
	public AttendanceDTO findByName(String name);
	
	
	 
	 /**
    * Search Roles
    * 
    * @return list : List of Roles
    * @param dto
    *            : Search Parameters
    *
    */
	public List<AttendanceDTO> search(AttendanceDTO dto);
	 /**
    * Search Roles with pagination
    * 
    * @return list : List of Roles
    * @param dto
    *            : Search Parameters
    * @param pageNo
    *            : Current Page No.
    * @param pageSize
    *            : Size of Page
    * 
    */
	public List search(AttendanceDTO dto, int pageNo, int pageSize) ;
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, AttendanceDTO> getMapDTO(Set<Long> ids);

}
