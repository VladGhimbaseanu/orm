package com.unitbv.project.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.PlatformUser;
import com.unitbv.projectejb.dao.PlatformUserDAORemote;
import com.unitbv.projectejb.dto.PlatformUserDTO;


/**
 * Session Bean implementation class PlatformUserDAO
 */
@Stateless
public class PlatformUserDAO implements PlatformUserDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PlatformUserDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(PlatformUserDTO entity) {
		PlatformUser user=new PlatformUser();
		dtoToEntity(entity, user);
		entityManager.persist(user);

	}

	@Override
	public PlatformUserDTO findById(int id) {
		PlatformUserDTO platformUserDTO = new PlatformUserDTO();
		PlatformUser user=entityManager.find(PlatformUser.class, id);
	    entityToDTO(user, platformUserDTO);
		return platformUserDTO;
}

	@Override
	public void delete(PlatformUserDTO entity) {
		PlatformUser user=new PlatformUser();
		dtoToEntity(entity, user);
		entityManager.remove(user);
		
	}

	@Override
	public void update(PlatformUserDTO entity) {
		PlatformUser user=new PlatformUser();
		dtoToEntity(entity, user);
		entityManager.merge(user);
		
	}

	
	private void dtoToEntity(PlatformUserDTO platformUserDTO, PlatformUser platformUser) {
		platformUser.setId(platformUserDTO.getId());
		platformUser.setAddress(platformUserDTO.getAddress());
		platformUser.setEmail(platformUserDTO.getEmail());
		platformUser.setPassword(platformUserDTO.getPassword());
		platformUser.setUsername(platformUserDTO.getUsername());
	}

	private void entityToDTO( PlatformUser platformUser,PlatformUserDTO platformUserDTO) {
		platformUserDTO.setId(platformUser.getId());
		platformUserDTO.setAddress(platformUser.getAddress());
		platformUserDTO.setEmail(platformUser.getEmail());
		platformUserDTO.setPassword(platformUser.getPassword());
		platformUserDTO.setUsername(platformUser.getUsername());
	}


}
