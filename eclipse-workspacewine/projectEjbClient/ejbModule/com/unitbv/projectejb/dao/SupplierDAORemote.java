package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.SupplierDTO;


@Remote
public interface SupplierDAORemote extends GenericDAO<SupplierDTO>{

}
