package com.unitbv.projectejb.dao;


import javax.ejb.Remote;

import com.unitbv.projectejb.dto.PlatformUserDTO;

@Remote
public interface PlatformUserDAORemote extends GenericDAO<PlatformUserDTO>{

}
