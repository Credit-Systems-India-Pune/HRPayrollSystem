package com.csi.payroll.mgt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.SalaryDTO;



public interface SalaryDAOImp {
	
	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(SalaryDTO dto);

	/**
	 * Update a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void update(SalaryDTO dto);

	/**
	 * Delete a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(SalaryDTO dto);
	

    /**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     
     */
	public SalaryDTO findByName(String name,String month);
	

	/**
	 * Find a Role by it's pk.
	 * 
	 * @param id
	 * 
	 * @return RoleDTO
	 */
	public SalaryDTO findByPk(long id);

	/**
	 * Search Roles with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<SalaryDTO> search(SalaryDTO dto, long pageNo, int pageSize);

	/**
	 * Search Roles.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<SalaryDTO> search(SalaryDTO dto);
	
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, SalaryDTO> getMapDTO(Set<Long> ids);

}
