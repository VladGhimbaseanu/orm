package com.unitbv.project.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.ClientOrder;
import com.unitbv.model.Order_Item;
import com.unitbv.model.Stock_ClientB2B;
import com.unitbv.projectejb.dao.OrderItemDAORemote;
import com.unitbv.projectejb.dto.ClientOrderDTO;
import com.unitbv.projectejb.dto.Order_ItemDTO;
import com.unitbv.projectejb.dto.Stock_ClientB2BDTO;


/**
 * Session Bean implementation class OrderItemDAO
 */
@Stateless
public class OrderItemDAO implements OrderItemDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public OrderItemDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Order_ItemDTO entity) {
		Order_Item orderItem=new Order_Item();
		dtoToEntity(entity, orderItem);
		entityManager.persist(orderItem);

	}

	@Override
	public Order_ItemDTO findById(int id) {
		Order_ItemDTO orderItemDTO = new Order_ItemDTO();
		Order_Item orderItem= entityManager.find(Order_Item.class, id);
	    entityToDto(orderItem, orderItemDTO);
		return orderItemDTO;
	}

	@Override
	public void delete(Order_ItemDTO entity) {
		Order_Item orderItem=new Order_Item();
		dtoToEntity(entity, orderItem);
		entityManager.remove(orderItem);

	}

	@Override
	public void update(Order_ItemDTO entity) {
		Order_Item orderItem=new Order_Item();
		dtoToEntity(entity, orderItem);
		entityManager.merge(orderItem);

	}

	public static void dtoToEntity(Order_ItemDTO orderItemDTO, Order_Item orderItem) {

		ClientOrder order = new ClientOrder();
		ClientOrderDAO.dtoToEntity(orderItemDTO.getOrder(), order);

		Stock_ClientB2B stock = new Stock_ClientB2B();
		Stock_ClientB2BDAO.dtoToEntity(orderItemDTO.getStockClientB2B(), stock);

		orderItem.setId(orderItemDTO.getId());
		orderItem.setPrice(orderItemDTO.getPrice());
		orderItem.setQuantity(orderItemDTO.getQuantity());
		orderItem.setOrder(order);
		orderItem.setStockClientB2B(stock);

	}

	public static void entityToDto(Order_Item orderItem, Order_ItemDTO orderItemDTO) {
		ClientOrderDTO orderDTO = new ClientOrderDTO();
		ClientOrderDAO.entityToDto(orderItem.getOrder(), orderDTO);

		Stock_ClientB2BDTO stockDTO = new Stock_ClientB2BDTO();
		Stock_ClientB2BDAO.entityToDto(orderItem.getStockClientB2B(), stockDTO);

		orderItemDTO.setId(orderItem.getId());
		orderItemDTO.setPrice(orderItem.getPrice());
		orderItemDTO.setQuantity(orderItem.getQuantity());
		orderItemDTO.setOrder(orderDTO);
		orderItemDTO.setStockClientB2B(stockDTO);
	}

}
