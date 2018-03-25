package standaloneClient;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.wineejb.StatelessEjbRemote;
import com.example.wineejb.dao.GenericDAO;
import com.example.wineejb.dao.PlatformUserDAORemote;
import com.example.wineejb.dto.PlatformUserDTO;

public class TestInsertDB {
	public static void main(String[] args) throws NamingException, SQLException {
		InitialContext context;
		try {
			context = new InitialContext();
			PlatformUserDAORemote platformUser=(PlatformUserDAORemote)context.lookup(
					"java:global/wineEar/wineEjb/PlatformUserDAO");
			
			PlatformUserDTO user=new PlatformUserDTO();
					user.setUsername("Vlad");
					user.setPassword("vlad123");
					user.setAddress("Str. Crisana nr.28");
					user.setEmail("vlad_flm@yahoo.com");
	           platformUser.insert(user);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
