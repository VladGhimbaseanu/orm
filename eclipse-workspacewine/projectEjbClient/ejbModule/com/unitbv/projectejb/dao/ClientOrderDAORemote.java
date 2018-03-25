package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.ClientOrderDTO;


@Remote
public interface ClientOrderDAORemote extends GenericDAO<ClientOrderDTO>{

}
