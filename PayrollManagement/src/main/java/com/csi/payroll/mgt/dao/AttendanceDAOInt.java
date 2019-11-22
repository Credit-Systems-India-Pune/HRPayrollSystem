
package com.csi.payroll.mgt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.AttendanceDTO;


public interface AttendanceDAOInt {
	
	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(AttendanceDTO dto);

	/**
	 * Update a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void update(AttendanceDTO dto);

	/**
	 * Delete a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(AttendanceDTO dto);
	

    /**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     
     */
	public AttendanceDTO findByName(String name);
	

	/**
	 * Find a Role by it's pk.
	 * 
	 * @param id
	 * 
	 * @return RoleDTO
	 */
	public AttendanceDTO findByPk(long id);

	/**
	 * Search Roles with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<AttendanceDTO> search(AttendanceDTO dto, long pageNo, int pageSize);

	/**
	 * Search Roles.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<AttendanceDTO> search(AttendanceDTO dto);
	
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, AttendanceDTO> getMapDTO(Set<Long> ids);

}
