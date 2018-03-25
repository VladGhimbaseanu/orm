package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.ClientB2BDTO;


@Remote
public interface ClientB2BDAORemote extends GenericDAO<ClientB2BDTO> {

}
