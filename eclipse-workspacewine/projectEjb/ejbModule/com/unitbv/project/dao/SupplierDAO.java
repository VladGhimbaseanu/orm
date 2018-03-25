package com.unitbv.project.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.Stock_Supplier;
import com.unitbv.model.Supplier;
import com.unitbv.projectejb.dao.SupplierDAORemote;
import com.unitbv.projectejb.dto.Stock_SupplierDTO;
import com.unitbv.projectejb.dto.SupplierDTO;


/**
 * Session Bean implementation class SupplierDAO
 */
@Stateless
public class SupplierDAO implements SupplierDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public SupplierDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(SupplierDTO entity) {
		Supplier supplier=new Supplier();
		dtoToEntity(entity, supplier);
		entityManager.persist(supplier);
	}

	@Override
	public SupplierDTO findById(int id) {
		SupplierDTO supplierDTO = new SupplierDTO();
		Supplier supplier= entityManager.find(Supplier.class, id);
	    entityToDto(supplier, supplierDTO);
		return supplierDTO;
	}

	@Override
	public void delete(SupplierDTO entity) {
		Supplier supplier=new Supplier();
		dtoToEntity(entity, supplier);
		entityManager.remove(supplier);
		
	}

	@Override
	public void update(SupplierDTO entity) {
		Supplier supplier=new Supplier();
		dtoToEntity(entity, supplier);
		entityManager.merge(supplier);
		
	}
	
	public static void dtoToEntity(SupplierDTO supplierDTO, Supplier supplier) {
		
//		List<Stock_ClientB2B> stocks=new ArrayList<Stock_ClientB2B>();
		List<Stock_Supplier> stockSuppliers=new ArrayList<Stock_Supplier>();
	
		supplier.setAddress(supplierDTO.getAddress());
		supplier.setAge(supplierDTO.getAge());
		supplier.setEmail(supplierDTO.getEmail());
		supplier.setNameWineCellar(supplierDTO.getNameWineCellar());
		supplier.setPassword(supplierDTO.getPassword());
		supplier.setStockSuppliers(stockSuppliers);
		supplier.setUsername(supplierDTO.getUsername());
		supplier.setVisibility(supplierDTO.getVisibility());
	}

	public static void entityToDto(Supplier supplier,SupplierDTO supplierDTO)  {
		List<Stock_SupplierDTO> stockSuppliers=new ArrayList<Stock_SupplierDTO>();
		
		supplierDTO.setAddress(supplier.getAddress());
		supplierDTO.setAge(supplier.getAge());
		supplierDTO.setEmail(supplier.getEmail());
		supplierDTO.setNameWineCellar(supplier.getNameWineCellar());
		supplierDTO.setPassword(supplier.getPassword());
		supplierDTO.setStockSuppliers(stockSuppliers);
		supplierDTO.setUsername(supplier.getUsername());
		supplierDTO.setVisibility(supplier.isVisibility());		
	}
	
}
