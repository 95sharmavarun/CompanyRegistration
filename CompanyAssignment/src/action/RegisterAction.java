package action;

import com.opensymphony.xwork2.ActionSupport;

import dbAccess.RegisterDao;

public class RegisterAction extends ActionSupport{
private String username,password,email,mobile,role;

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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	int i=RegisterDao.save(this);
	if(i>0)
	{
		System.out.println("registration done");
	    return SUCCESS;  
	}
	 return ERROR;  
}

public String addnewadmin()throws Exception{
	int i=RegisterDao.newadmin(this);
	if(i>0)
	{
		System.out.println("registration done");
	    return SUCCESS;  
	}
	 return ERROR;
}


}
