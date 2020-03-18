package coen275.project.topquiz.Model;

import java.sql.*;
import java.util.ArrayList;
public class UserDao {
	
	private User extractUser(ResultSet rs) throws SQLException {
			User user = new User();
			user.setName(rs.getString("Username"));
	    	user.setAdmin(rs.getInt("isAdmin")==1);
	    	return user;
		}
		
		public ArrayList<String> getAllUserNames() {
			Connection connection = ConnectionFactory.getConnection();
	        try {	
	        	PreparedStatement ps = connection.prepareStatement("SELECT username FROM topquiz.users");
	            ResultSet rs = ps.executeQuery();
	            ArrayList<String> usernames= new ArrayList<String>();
	            
	            while(rs.next())
	            {
	            	usernames.add(rs.getString("Username"));
	            }
	            return usernames;
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
		        int i=ps.executeUpdate();
		        if(i == 1) {
		            return user;}
		       
			 } catch (SQLException ex) {
		            ex.printStackTrace();
			 }
			return null;
		}
		public User findUser(String username)
		{
			Connection connection = ConnectionFactory.getConnection();
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users where username='"+username+"'");
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
		public int extractUserID(String username){
			Connection connection = ConnectionFactory.getConnection();
			try {
				 PreparedStatement ps = connection.prepareStatement("select distinct Id from topquiz.users WHERE username=?");
				 ps.setString(1, username);
				 ResultSet rs2 = ps.executeQuery();
				 int userid=0;
				 if(rs2.next())
				 {
					 userid=rs2.getInt("Id");
				 }
				 return userid;
			} catch (SQLException ex) {
	            ex.printStackTrace();
	        }
			return 0;
	    }
		
	}
