package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.PromoDTO;


@Remote
public interface PromoDAORemote extends GenericDAO<PromoDTO>{

}
