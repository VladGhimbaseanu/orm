package com.unitbv.project.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.ClientB2C;
import com.unitbv.model.ClientOrder;
import com.unitbv.model.Order_Item;
import com.unitbv.projectejb.dao.ClientOrderDAORemote;
import com.unitbv.projectejb.dto.ClientB2CDTO;
import com.unitbv.projectejb.dto.ClientOrderDTO;
import com.unitbv.projectejb.dto.Order_ItemDTO;

/**
 * Session Bean implementation class ClientOrderDAO
 */
@Stateless
public class ClientOrderDAO implements ClientOrderDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientOrderDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		dtoToEntity(entity, order);
		entityManager.persist(order);
		
	}

	@Override
	public ClientOrderDTO findById(int id) {
		ClientOrderDTO clientOrderDTO = new ClientOrderDTO();
		ClientOrder order= entityManager.find(ClientOrder.class, id);
	    entityToDto(order, clientOrderDTO);
		return clientOrderDTO;
	}

	@Override
	public void delete(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		dtoToEntity(entity, order);
		entityManager.remove(order);
		
	}

	@Override
	public void update(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		dtoToEntity(entity, order);
		entityManager.merge(order);
		
	}
	
    public static void dtoToEntity(ClientOrderDTO clientOrderDTO, ClientOrder clientOrder) {
	
	    List<Order_Item> orderItems=new ArrayList<Order_Item>();
		
		ClientB2C clientB2C=new ClientB2C();
		ClientB2CDAO.dtoToEntity(clientOrderDTO.getClientB2C(), clientB2C);
		
		clientOrder.setId(clientOrderDTO.getId());
		clientOrder.setDate(clientOrderDTO.getDate());
		clientOrder.setOrderNo(clientOrderDTO.getOrderNo());
		clientOrder.setClientB2C(clientB2C);
		clientOrder.setOrderItems(orderItems);
	}

	public static void entityToDto( ClientOrder clientOrder,ClientOrderDTO clientOrderDTO)  {
          List<Order_ItemDTO> orderItems=new ArrayList<Order_ItemDTO>();
		
		ClientB2CDTO clientB2CDTO=new ClientB2CDTO();
		ClientB2CDAO.entityToDto(clientOrder.getClientB2C(), clientB2CDTO);
		
		clientOrderDTO.setId(clientOrder.getId());
		clientOrderDTO.setDate(clientOrder.getDate());
		clientOrderDTO.setOrderNo(clientOrder.getOrderNo());
		clientOrderDTO.setClientB2C(clientB2CDTO);
		clientOrderDTO.setOrderItems(orderItems);
		
	}

}
