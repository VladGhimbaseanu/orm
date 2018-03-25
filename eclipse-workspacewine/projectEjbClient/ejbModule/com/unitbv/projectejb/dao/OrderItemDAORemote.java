package com.unitbv.projectejb.dao;

import javax.ejb.Remote;

import com.unitbv.projectejb.dto.Order_ItemDTO;


@Remote
public interface OrderItemDAORemote extends GenericDAO<Order_ItemDTO>{

}
