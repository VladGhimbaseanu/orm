package com.unitbv.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unitbv.model.ClientB2C;
import com.unitbv.model.ClientOrder;
import com.unitbv.projectejb.dao.ClientB2CDAORemote;
import com.unitbv.projectejb.dto.ClientB2CDTO;
import com.unitbv.projectejb.dto.ClientOrderDTO;



/**
 * Session Bean implementation class ClientB2CDAO
 */
@Stateless
public class ClientB2CDAO implements ClientB2CDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientB2CDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		dtoToEntity(entity, client);
		entityManager.persist(client);
		
	}

	@Override
	public ClientB2CDTO findById(int id) {
		ClientB2CDTO clientB2CDTO = new ClientB2CDTO();
		ClientB2C client= entityManager.find(ClientB2C.class, id);
	    entityToDto(client, clientB2CDTO);
		return clientB2CDTO;
	}

	@Override
	public void delete(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		dtoToEntity(entity, client);
		entityManager.remove(client);
	}

	@Override
	public void update(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		dtoToEntity(entity, client);
		entityManager.merge(client);
	}
	
	public static void dtoToEntity(ClientB2CDTO clientB2CDTO, ClientB2C clientB2c) {
		
		List<ClientOrder> orders=new ArrayList<ClientOrder>();
		
		clientB2c.setCNP(clientB2CDTO.getCNP());
		clientB2c.setFirstName(clientB2CDTO.getFirstName());
		clientB2c.setLastName(clientB2CDTO.getLastName());
		clientB2c.setDateRegister(clientB2CDTO.getDateRegister());
		clientB2c.setOrders(orders);
		clientB2c.setId(clientB2CDTO.getId());
		clientB2c.setAddress(clientB2CDTO.getAddress());
		clientB2c.setEmail(clientB2CDTO.getEmail());
		clientB2c.setPassword(clientB2CDTO.getPassword());
		clientB2c.setUsername(clientB2CDTO.getUsername());
		
		//todo orders
	}

	public static void entityToDto(ClientB2C clientB2c,ClientB2CDTO clientB2CDTO)  {
		List<ClientOrderDTO> orders=new ArrayList<ClientOrderDTO>();
		
		
		clientB2CDTO.setCNP(clientB2c.getCNP());
		clientB2CDTO.setFirstName(clientB2c.getFirstName());
		clientB2CDTO.setLastName(clientB2c.getLastName());
		clientB2CDTO.setDateRegister(clientB2c.getDateRegister());
		clientB2CDTO.setOrders(orders);
		clientB2CDTO.setId(clientB2c.getId());
		clientB2CDTO.setAddress(clientB2c.getAddress());
		clientB2CDTO.setEmail(clientB2c.getEmail());
		clientB2CDTO.setPassword(clientB2c.getPassword());
		clientB2CDTO.setUsername(clientB2c.getUsername());
		}

}
