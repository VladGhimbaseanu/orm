package com.unitbv.project.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.Promo;
import com.unitbv.model.Stock_Supplier;
import com.unitbv.projectejb.dao.PromoDAORemote;
import com.unitbv.projectejb.dto.PromoDTO;
import com.unitbv.projectejb.dto.Stock_SupplierDTO;

/**
 * Session Bean implementation class PromoDAO
 */
@Stateless
public class PromoDAO implements PromoDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PromoDAO() {
    
    }

	@Override
	public void insert(PromoDTO entity) {
		Promo promo=new Promo();
		dtoToEntity(entity, promo);
		entityManager.persist(promo);
		
	}

	@Override
	public PromoDTO findById(int id) {
		PromoDTO promoDTO = new PromoDTO();
		Promo promo= entityManager.find(Promo.class, id);
		entityToDto(promo, promoDTO);
		return promoDTO;
	}

	@Override
	public void delete(PromoDTO entity) {
		Promo promo=new Promo();
		dtoToEntity(entity, promo);
		entityManager.remove(promo);
		
	}

	@Override
	public void update(PromoDTO entity) {
		Promo promo=new Promo();
		dtoToEntity(entity, promo);
		entityManager.merge(promo);
		
	}
	
	public static void dtoToEntity(PromoDTO promoDTO, Promo promo) {
		
		Stock_Supplier stockSupplier=new Stock_Supplier();
		
		promo.setId(promoDTO.getId());
		promo.setDiscount(promoDTO.getDiscount());
		promo.setStartDate(promoDTO.getStartDate());
		promo.setEndDate(promoDTO.getEndDate());
		promo.setStockSupplier(stockSupplier);
	}

	public static void entityToDto(Promo promo, PromoDTO promoDTO) {
		Stock_SupplierDTO stockSupplierDTO=new Stock_SupplierDTO();
	//	StockSupplierDAO.dtoToStockSupplier(promo.getStockSupplier(), stockSupplierDTO);
		
		promoDTO.setId(promo.getId());
		promoDTO.setDiscount(promo.getDiscount());
		promoDTO.setStartDate(promo.getStartDate());
		promoDTO.setEndDate(promo.getEndDate());
		promoDTO.setStockSupplier(stockSupplierDTO);
	}

}
