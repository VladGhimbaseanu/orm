package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.Stock_ClientB2BDTO;


@Remote
public interface StockClientB2BDAORemote extends GenericDAO<Stock_ClientB2BDTO> {

}
