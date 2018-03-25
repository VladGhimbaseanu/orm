package com.unitbv.project.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.ClientB2B;
import com.unitbv.model.Stock_ClientB2B;
import com.unitbv.projectejb.dao.ClientB2BDAORemote;
import com.unitbv.projectejb.dto.ClientB2BDTO;
import com.unitbv.projectejb.dto.Stock_ClientB2BDTO;


/**
 * Session Bean implementation class ClientB2BDAO
 */
@Stateless
public class ClientB2BDAO implements ClientB2BDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientB2BDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		dtoToEntity(entity, client);
		entityManager.persist(client);
	}

	@Override
	public ClientB2BDTO findById(int id) {
		ClientB2BDTO clientB2BDTO = new ClientB2BDTO();
		ClientB2B client= entityManager.find(ClientB2B.class, id);
	    entityToDto(client, clientB2BDTO);
		return clientB2BDTO;
	}

	@Override
	public void delete(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		dtoToEntity(entity, client);
		entityManager.remove(client);
		
	}

	@Override
	public void update(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		dtoToEntity(entity, client);
		entityManager.merge(client);
		
	}
	
	public static void dtoToEntity(ClientB2BDTO clientB2BDTO, ClientB2B clientB2b) {
		
		List<Stock_ClientB2B> stocks=new ArrayList<Stock_ClientB2B>();
		
		clientB2b.setVisibility(clientB2BDTO.isVisibility());
		clientB2b.setCompanyName(clientB2BDTO.getCompanyName());
		clientB2b.setCUI(clientB2BDTO.getCUI());
		clientB2b.setSubscribed(clientB2BDTO.isSubscribed());
		clientB2b.setStocClientB2B(stocks);
		clientB2b.setId(clientB2BDTO.getId());
		clientB2b.setAddress(clientB2BDTO.getAddress());
		clientB2b.setEmail(clientB2BDTO.getEmail());
		clientB2b.setPassword(clientB2BDTO.getPassword());
		clientB2b.setUsername(clientB2BDTO.getUsername());
		
		//todo stocks
	}

	public static void entityToDto(ClientB2B clientB2b,ClientB2BDTO clientB2BDTO)  {
		List<Stock_ClientB2BDTO> stocksDTO=new ArrayList<Stock_ClientB2BDTO>();
		
		
		clientB2BDTO.setVisibility(clientB2b.getVisibility());
		clientB2BDTO.setCompanyName(clientB2b.getCompanyName());
		clientB2BDTO.setCUI(clientB2b.getCUI());
		clientB2BDTO.setSubscribed(clientB2b.isSubscribed());
		clientB2BDTO.setStocClientB2B(stocksDTO);
		clientB2BDTO.setId(clientB2b.getId());
		clientB2BDTO.setAddress(clientB2b.getAddress());
		clientB2BDTO.setEmail(clientB2b.getEmail());
		clientB2BDTO.setPassword(clientB2b.getPassword());
		clientB2BDTO.setUsername(clientB2b.getUsername());
		
	}

}
