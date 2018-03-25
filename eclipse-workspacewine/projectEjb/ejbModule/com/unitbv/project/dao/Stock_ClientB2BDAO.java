package com.unitbv.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.ClientB2B;
import com.unitbv.model.Stock_ClientB2B;
import com.unitbv.model.Stock_Supplier;
import com.unitbv.projectejb.dao.StockClientB2BDAORemote;
import com.unitbv.projectejb.dto.ClientB2BDTO;
import com.unitbv.projectejb.dto.Stock_ClientB2BDTO;
import com.unitbv.projectejb.dto.Stock_SupplierDTO;


/**
 * Session Bean implementation class StockClientB2BDAO
 */
@Stateless
public class Stock_ClientB2BDAO implements StockClientB2BDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public Stock_ClientB2BDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(Stock_ClientB2BDTO entity) {
		Stock_ClientB2B stockClientB2B=new Stock_ClientB2B();
		dtoToEntity(entity, stockClientB2B);
		entityManager.persist(stockClientB2B);
		
	}

	@Override
	public Stock_ClientB2BDTO findById(int id) {
		Stock_ClientB2BDTO stockClientB2BDTO = new Stock_ClientB2BDTO();
		Stock_ClientB2B stockClientB2B= entityManager.find(Stock_ClientB2B.class, id);
		entityToDto(stockClientB2B, stockClientB2BDTO);
		return stockClientB2BDTO;
	}

	@Override
	public void delete(Stock_ClientB2BDTO entity) {
		Stock_ClientB2B stockClientB2B=new Stock_ClientB2B();
		dtoToEntity(entity, stockClientB2B);
		entityManager.remove(stockClientB2B);
		
	}

	@Override
	public void update(Stock_ClientB2BDTO entity) {
		Stock_ClientB2B stockClientB2B=new Stock_ClientB2B();
		dtoToEntity(entity, stockClientB2B);
		entityManager.merge(stockClientB2B);
		
	}
	
public static void dtoToEntity(Stock_ClientB2BDTO stockClientB2BDTO, Stock_ClientB2B stockClientB2B) {
		
	ClientB2B clientB2B=new ClientB2B();
	ClientB2BDAO.dtoToEntity(stockClientB2BDTO.getClientB2B(), clientB2B);
	
	List<Stock_Supplier> supplierStocks=new ArrayList<Stock_Supplier>();
		
	stockClientB2B.setId(stockClientB2BDTO.getId());
	stockClientB2B.setActive(stockClientB2BDTO.isActive());
	stockClientB2B.setLimitQuanity(stockClientB2BDTO.getLimitQuanity());
	stockClientB2B.setPrice(stockClientB2BDTO.getPrice());
	stockClientB2B.setQuantity(stockClientB2BDTO.getQuantity());
	stockClientB2B.setClientB2B(clientB2B);
	stockClientB2B.setStockSuppliers(supplierStocks);
	
	}

	public static void entityToDto( Stock_ClientB2B stockClientB2B, Stock_ClientB2BDTO stockClientB2BDTO) {
		
	ClientB2BDTO clientB2BDTO=new ClientB2BDTO();
	ClientB2BDAO.entityToDto(stockClientB2B.getClientB2B(), clientB2BDTO);
	
	List<Stock_SupplierDTO> supplierStocksDTO=new ArrayList<Stock_SupplierDTO>();
		
	stockClientB2BDTO.setId(stockClientB2B.getId());
	stockClientB2BDTO.setActive(stockClientB2B.isActive());
	stockClientB2BDTO.setLimitQuanity(stockClientB2B.getLimitQuanity());
	stockClientB2BDTO.setPrice(stockClientB2B.getPrice());
	stockClientB2BDTO.setQuantity(stockClientB2B.getQuantity());
	stockClientB2BDTO.setClientB2B(clientB2BDTO);
	stockClientB2BDTO.setStockSuppliers(supplierStocksDTO);
	
	
	}

}
