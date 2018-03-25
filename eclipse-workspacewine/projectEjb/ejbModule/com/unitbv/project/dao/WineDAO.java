package com.unitbv.project.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.Stock_Supplier;
import com.unitbv.model.Wine;
import com.unitbv.projectejb.dao.WineDAORemote;
import com.unitbv.projectejb.dto.Stock_SupplierDTO;
import com.unitbv.projectejb.dto.WineDTO;


/**
 * Session Bean implementation class WineDAO
 */
@Stateless
public class WineDAO implements WineDAORemote {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public WineDAO() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void insert(WineDTO entity) {
    	Wine wine=new Wine();
		dtoToEntity(entity, wine);
		entityManager.persist(wine);
	}

	@Override
	public WineDTO findById(int id) {
		WineDTO wineDTO = new WineDTO();
		Wine wine= entityManager.find(Wine.class, id);
	    entityToDTO(wine, wineDTO);
		return wineDTO;
	}

	@Override
	public void delete(WineDTO entity) {
		Wine wine=new Wine();
		dtoToEntity(entity, wine);
		entityManager.remove(wine);
		
	}

	@Override
	public void update(WineDTO entity) {
		Wine wine=new Wine();
		dtoToEntity(entity, wine);
		entityManager.merge(wine);
		
	}
	
	public static void dtoToEntity(WineDTO wineDTO, Wine wine) {
		
		List<Stock_Supplier> stockSupplier=new ArrayList<Stock_Supplier>();
		
		wine.setDescription(wineDTO.getDescription());
		wine.setName(wineDTO.getName());
		wine.setStockSupplier(stockSupplier);
		wine.setType(wineDTO.getType());
		wine.setVariety(wineDTO.getVariety());
		wine.setYear(wineDTO.getYear());
	}

	public static void entityToDTO(Wine wine, WineDTO wineDTO) {
		
		List<Stock_SupplierDTO> stockSupplier=new ArrayList<Stock_SupplierDTO>();
		
		wineDTO.setDescription(wine.getDescription());
		wineDTO.setName(wine.getName());
		wineDTO.setStockSupplier(stockSupplier);
		wineDTO.setType(wine.getType());
		wineDTO.setVariety(wine.getVariety());
		wineDTO.setYear(wine.getYear());
	}

}
