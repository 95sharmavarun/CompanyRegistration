package viewThings;

public class User {

	private String username,password,role;


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	
	}


	public User()
	{
		super();
	}
	
	
}
