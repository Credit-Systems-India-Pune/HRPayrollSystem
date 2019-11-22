package com.csi.payroll.mgt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.dto.TimeSheetDTO;



public interface TimeSheetDAOInt {
	
	
	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(TimeSheetDTO dto);

	/**
	 * Update a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void update(TimeSheetDTO dto);

	/**
	 * Delete a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(TimeSheetDTO dto);
	

    /**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     
     */
	public TimeSheetDTO findByName(String name);
	

	/**
	 * Find a Role by it's pk.
	 * 
	 * @param id
	 * 
	 * @return RoleDTO
	 */
	public TimeSheetDTO findByPk(long id);

	/**
	 * Search Roles with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<TimeSheetDTO> search(TimeSheetDTO dto, long pageNo, int pageSize);

	/**
	 * Search Roles.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<TimeSheetDTO> search(TimeSheetDTO dto);
	
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, TimeSheetDTO> getMapDTO(Set<Long> ids);

}
