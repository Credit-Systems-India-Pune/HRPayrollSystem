package com.csi.payroll.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.SalaryDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;

public interface SalaryServiceInt {
	

	/**
     * Add a role
     * 
     * @param dto
     * 
     * @throws DuplicateRecordException
     *             : throws when role already exists
     */
	
	
	public long add(SalaryDTO dto) throws DuplicateRecordException;
	/**
     * Delete a role
     * 
     * @param dto
     
     */
	public void delete(SalaryDTO dto) ;
	/**
     * Update a Role
     * 
     * @param dto
     
     * @throws DuplicateRecordException
     *             : if updated role record is already exist
     */
	public void update(SalaryDTO dto) throws DuplicateRecordException;
	   /**
     * Find role by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     *
     */
	public SalaryDTO findByPK(long pk) ;
	
	
	/**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     * 
     */
	public SalaryDTO findByName(String name,String month);
	
	
	 
	 /**
    * Search Roles
    * 
    * @return list : List of Roles
    * @param dto
    *            : Search Parameters
    *
    */
	public List<SalaryDTO> search(SalaryDTO dto);
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
	public List search(SalaryDTO dto, int pageNo, int pageSize) ;
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, SalaryDTO> getMapDTO(Set<Long> ids);

}
