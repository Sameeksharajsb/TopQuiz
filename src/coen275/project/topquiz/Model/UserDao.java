package coen275.project.topquiz.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDao {
	List<User> Users;
	private User extractUser(ResultSet rs) throws SQLException {
			User user = new User();
			user.setName(rs.getString("Username"));
	    	user.setAdmin(rs.getInt("isAdmin")==1);
	    	return user;
		}
		
		public ArrayList<User> getUsers() {
			Connection connection = ConnectionFactory.getConnection();
	        try {	
	        	PreparedStatement ps = connection.prepareStatement("SELECT * FROM topquiz.users");
	            ResultSet rs = ps.executeQuery();
	            ArrayList<User> users= new ArrayList<User>();
	            
	            while(rs.next())
	            {
	            	User user = extractUser(rs);
	            	users.add(user);
	            }
	            return users;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }
		
		public User addUser(User user) {
			Connection connection = ConnectionFactory.getConnection();
			try {
		        PreparedStatement ps = connection.prepareStatement("INSERT INTO users(Username, isAdmin) VALUES (?, ?)");
		        ps.setString(1, user.getName());
		        ps.setInt(2, (user.getAdmin())?1:0);
		        ResultSet rs = ps.executeQuery();
			 } catch (SQLException ex) {
		            ex.printStackTrace();
			 }
			return user;
		}
		public User findUser(String username)
		{
			Connection connection = ConnectionFactory.getConnection();
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select *from users where username='"+username+"'");
				if(rs.next())
	            {
					User user = new User();
					
					user.setName( rs.getString("username") );
					user.setAdmin(rs.getInt("isAdmin")==1);
					return user;
	            }
	            
			 } catch (SQLException ex) {
		            ex.printStackTrace();
			 }
			return null;
		}
		
	}
