package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.Stock_SupplierDTO;


@Remote
public interface StockSupplierDAORemote extends GenericDAO<Stock_SupplierDTO>{

}
