package com.csi.payroll.mgt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.dto.SalaryDTO;

public interface LeaveDAOInt {
	
	

	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(LeaveDTO dto);

	/**
	 * Update a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void update(LeaveDTO dto);

	/**
	 * Delete a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(LeaveDTO dto);
	

    /**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     
     */
	public LeaveDTO findByName(String name);
	

	/**
	 * Find a Role by it's pk.
	 * 
	 * @param id
	 * 
	 * @return RoleDTO
	 */
	public LeaveDTO findByPk(long id);

	/**
	 * Search Roles with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<LeaveDTO> search(LeaveDTO dto, long pageNo, int pageSize);

	/**
	 * Search Roles.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<LeaveDTO> search(LeaveDTO dto);
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, LeaveDTO> getMapDTO(Set<Long> ids);
	
	

}
