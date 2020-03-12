package coen275.project.topquiz.Model;
import java.util.*;

public class User {
	
	private String name;
	private boolean admin;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the administrator
	 */
	public boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the administrator to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
	
	public User(String name, boolean isAdmin)
	{
		this.name = name;
		this.admin = isAdmin;
	}
	
	public User() {}
}
