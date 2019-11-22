package com.csi.payroll.mgt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.csi.payroll.mgt.dto.RoleDTO;



/**
 * 
 * Role DAO interface.
 * 
 * @author Navigable Set
 * @version 1.0
 * 
 */

public interface RoleDAOInt {

	
	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @return pk of dto
	 */
	public long add(RoleDTO dto);

	/**
	 * Update a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void update(RoleDTO dto);

	/**
	 * Delete a Role.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(RoleDTO dto);
	

    /**
     * Find Role by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     
     */
	public RoleDTO findByName(String name);
	

	/**
	 * Find a Role by it's pk.
	 * 
	 * @param id
	 * 
	 * @return RoleDTO
	 */
	public RoleDTO findByPk(long id);

	/**
	 * Search Roles with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<RoleDTO> search(RoleDTO dto, long pageNo, int pageSize);

	/**
	 * Search Roles.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<RoleDTO> search(RoleDTO dto);
	
	
	/**
	 * Get map of id v/s it's dto, key is id and value is dto
	 * 
	 * @param ids
	 * @return Map
	 */
	public Map<Long, RoleDTO> getMapDTO(Set<Long> ids);
	
}
