package standaloneClient;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.unitbv.projectejb.dao.ClientB2BDAORemote;
import com.unitbv.projectejb.dao.StockClientB2BDAORemote;
import com.unitbv.projectejb.dto.ClientB2BDTO;
import com.unitbv.projectejb.dto.Stock_ClientB2BDTO;


public class TestInsertDB {
	public static void main(String[] args) throws NamingException, SQLException {

		InitialContext  context;
//		PlatformUserDAORemote platformUser;
//		try {
//			context = new InitialContext();
//			platformUser=(PlatformUserDAORemote)context.lookup(
//					"java:global/projectEar/projectEjb/PlatformUserDAO!com.unitbv.projectejb.dao.PlatformUserDAORemote");
//			
//
//			PlatformUserDTO user=new PlatformUserDTO();
//			user.setUsername("Vlad");
//			user.setPassword("vlad123");
//			user.setAddress("Str. Crisana nr.28");
//			user.setEmail("vlad_flm@yahoo.com");
//	        platformUser.insert(user);
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		ClientB2BDAORemote client;
		StockClientB2BDAORemote stock;
		try {
			context = new InitialContext();
			client=(ClientB2BDAORemote)context.lookup(
					"java:global/projectEar/projectEjb/ClientB2BDAO!com.unitbv.projectejb.dao.ClientB2BDAORemote");
			
			ClientB2BDTO clientB2b = new ClientB2BDTO();
			clientB2b.setAddress("1");
			clientB2b.setCompanyName("1");
			clientB2b.setCUI("12");
			clientB2b.setEmail("vlad@");
			clientB2b.setPassword("123");
			clientB2b.setSubscribed(true);
			clientB2b.setUsername("us");
			clientB2b.setVisibility(true);
			
			//client.insert(clientB2b);
			
			ClientB2BDTO c= client.findById(2);
			
			stock=(StockClientB2BDAORemote)context.lookup(
					"java:global/projectEar/projectEjb/Stock_ClientB2BDAO!com.unitbv.projectejb.dao.StockClientB2BDAORemote");
			
			Stock_ClientB2BDTO stock_client=new Stock_ClientB2BDTO();
			stock_client.setActive(true);
			stock_client.setLimitQuanity(1);
			stock_client.setPrice(2);
			stock_client.setQuantity(1);
			stock_client.setClientB2B(c);
			
			stock.insert(stock_client);
		}
	 catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
//		ClientB2CDAORemote clientb2c ;
//		try {
//			context=new InitialContext();
//			clientb2c=(ClientB2CDAORemote)context.lookup("java:global/projectEar/projectEjb/ClientB2CDAO!com.unitbv.projectejb.dao.ClientB2CDAORemote");
//			
//			ClientB2CDTO client=new ClientB2CDTO();
//			client.setUsername("Vlad");
//			client.setPassword("vlad123");
//			client.setAddress("Str. Crisana nr.28");
//			client.setEmail("vlad_flm@yahoo.com");
//			client.setCNP("123456789");
//			client.setDateRegister(new Date());
//			client.setLastName("Vlad");
//			client.setFirstName("Vlad");
//			clientb2c.insert(client);
//		}
//	 catch (NamingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println(e.getMessage());
//	}
	}
}
