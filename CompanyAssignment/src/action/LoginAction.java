package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dbAccess.CompanyDb;
import dbAccess.UserDb;
import viewThings.Company;
import viewThings.User;

public class LoginAction  extends ActionSupport implements SessionAware {

	private String username,password,email,mobile;
	private User newuser;
	private Company comp;
	private UserDb db=new UserDb();
	
	
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
	private  Map<String, Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}

	@Override
	public String execute() throws Exception {
		
		newuser=db.findByUsername(username);
		String loggedUserName = null;
		String role=null;
		if(newuser!=null) {
			if(username.equals(newuser.getUsername()) && password.equals(newuser.getPassword())) {
				System.out.println("Login done");
				//System.out.println("@@@@@@ "+username+"$$$$$$$$$$ "+password+"************ "+newuser.getUsername()+"########### "+newuser.getPassword());
				sessionMap.put("username",newuser.getUsername().toUpperCase());
				sessionMap.put("password",newuser.getPassword());
				sessionMap.put("role",newuser.getRole());
				//System.out.println("checking action "+comp.getAction());
				//sessionMap.put("action",comp.getAction());
				System.out.println("checking session "+sessionMap.get("username").toString());
				System.out.println("checking session pass "+sessionMap.get("password").toString());
				System.out.println("checking session role "+sessionMap.get("role").toString());
				//System.out.println("checking session action "+sessionMap.get("action").toString());
				return SUCCESS;
			}
			else {
					addFieldError("msg","username or password didn't match");
					return INPUT;
				}
				}
			else 
					addFieldError("msg","username didnt match");
					return INPUT;
					
		}
	
	
	public String logout1() {
		//String str=(String)sessionMap.containsKey(newuser.getUname());
        
       // if (sessionMap.containsKey(sessionMap.get("username"))) {
            //sessionMap.remove(sessionMap.get("username").toString());
            //sessionMap.remove(sessionMap.get("password").toString());
            sessionMap.clear();
            System.out.println("Logout done");
            //System.out.println("checking session "+sessionMap.get("username").toString());
       //}
        return SUCCESS;
    }
	
	
	public String logout() {
		//String str=(String)sessionMap.containsKey(newuser.getUname());
        System.out.println("in logout "+sessionMap.get("username").toString());
       // if (sessionMap.containsKey(sessionMap.get("username"))) {
            sessionMap.remove(sessionMap.get("username").toString());
            sessionMap.remove(sessionMap.get("password").toString());
            sessionMap.clear();
            System.out.println("Logout done");
            //System.out.println("checking session "+sessionMap.get("username").toString());
       //}
        return SUCCESS;
    }
	
	
	}
	
	
