package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.WineDTO;


@Remote
public interface WineDAORemote extends GenericDAO<WineDTO>{

}
