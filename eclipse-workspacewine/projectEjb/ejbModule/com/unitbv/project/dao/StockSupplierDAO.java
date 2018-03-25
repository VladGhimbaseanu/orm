package com.unitbv.project.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.Promo;
import com.unitbv.model.Stock_ClientB2B;
import com.unitbv.model.Stock_Supplier;
import com.unitbv.model.Supplier;
import com.unitbv.model.Wine;
import com.unitbv.projectejb.dao.StockSupplierDAORemote;
import com.unitbv.projectejb.dto.PromoDTO;
import com.unitbv.projectejb.dto.Stock_ClientB2BDTO;
import com.unitbv.projectejb.dto.Stock_SupplierDTO;
import com.unitbv.projectejb.dto.SupplierDTO;
import com.unitbv.projectejb.dto.WineDTO;



/**
 * Session Bean implementation class StockSupplierDAO
 */
@Stateless
public class StockSupplierDAO implements StockSupplierDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public StockSupplierDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(Stock_SupplierDTO entity) {
		Stock_Supplier stockSupplier=new Stock_Supplier();
		dtoToEntity(entity, stockSupplier);
		entityManager.persist(stockSupplier);
		
	}

	@Override
	public Stock_SupplierDTO findById(int id) {
		Stock_SupplierDTO stockSupplierDTO = new Stock_SupplierDTO();
		Stock_Supplier stocSupplier= entityManager.find(Stock_Supplier.class, id);
	    entityToDto(stocSupplier, stockSupplierDTO);
		return stockSupplierDTO;
	}

	@Override
	public void delete(Stock_SupplierDTO entity) {
		Stock_Supplier stockSupplier=new Stock_Supplier();
		dtoToEntity(entity, stockSupplier);
		entityManager.remove(stockSupplier);
		
	}

	@Override
	public void update(Stock_SupplierDTO entity) {
		Stock_Supplier stockSupplier=new Stock_Supplier();
		dtoToEntity(entity, stockSupplier);
		entityManager.merge(stockSupplier);
		
	}
	
	public static void dtoToEntity(Stock_SupplierDTO stockSupplierDTO, Stock_Supplier stockSupplier) {

		Stock_ClientB2B stockClientB2B=new Stock_ClientB2B();
		Stock_ClientB2BDAO.dtoToEntity(stockSupplierDTO.getStockClientB2B(), stockClientB2B);
		
		Supplier supplier=new Supplier();
	//	SupplierDAO.dtoToSupplier(stockSupplierDTO.getSupplier(),supplier);
		
		Wine wine =new Wine();
		//WineDAO.dtoToWine(stockSupplierDTO.getWine(), wine);
		
		List<Promo> promotions=new ArrayList<Promo>();
		for(int i=0;i<stockSupplierDTO.getPromos().size();i++) {
			Promo promo=new Promo();
			PromoDAO.dtoToEntity(stockSupplierDTO.getPromos().get(i), promo);
			promotions.add(promo);
		}

		stockSupplier.setId(stockSupplierDTO.getId());
		stockSupplier.setPrice(stockSupplierDTO.getPrice());
		stockSupplier.setQuantity(stockSupplierDTO.getQuantity());
		stockSupplier.setStockClientB2B(stockClientB2B);
		stockSupplier.setSupplier(supplier);
		stockSupplier.setWine(wine);
		stockSupplier.setPromos(promotions);
	}

	public static void entityToDto(Stock_Supplier stockSupplier, Stock_SupplierDTO stockSupplierDTO) {
		Stock_ClientB2BDTO stockClientB2BDTO =new Stock_ClientB2BDTO();
		Stock_ClientB2BDAO.entityToDto(stockSupplier.getStockClientB2B(), stockClientB2BDTO);
		
		SupplierDTO supplierDTO=new SupplierDTO();
	//	SupplierDAO.supplierToDto(stockSupplier.getSupplier(),supplierDTO);
		
		WineDTO wineDTO =new WineDTO();
		//WineDAO.wineToDto(stockSupplier.getWine(), wineDTO);
		
		List<PromoDTO> promotionsDTO=new ArrayList<PromoDTO>();
		for(int i=0;i<stockSupplier.getPromos().size();i++) {
			PromoDTO promoDTO=new PromoDTO();
			PromoDAO.entityToDto(stockSupplier.getPromos().get(i), promoDTO);
			promotionsDTO.add(promoDTO);
		}

		stockSupplierDTO.setId(stockSupplier.getId());
		stockSupplierDTO.setPrice(stockSupplier.getPrice());
		stockSupplierDTO.setQuantity(stockSupplier.getQuantity());
		stockSupplierDTO.setStockClientB2B(stockClientB2BDTO);
		stockSupplierDTO.setSupplier(supplierDTO);
		stockSupplierDTO.setWine(wineDTO);
		stockSupplierDTO.setPromos(promotionsDTO);
	}

}
