package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dbAccess.CompanyDb;
import viewThings.Company;



public class CompanyAction extends ActionSupport implements SessionAware {
	private String  CompanyName;
	



	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		this.CompanyName = companyName;
	}



	private List<Company> list=new ArrayList<>();
	private CompanyDb comdb=new CompanyDb(list);
	
	public List<Company> getList() {
		return list;
	}
	public void setList(List<Company> list) {
		this.list = list;
	}
	
	
	
	private  Map<String, Object> sessionMap1;
	@Override
	public void setSession(Map<String, Object> sessionMap1) {
		this.sessionMap1 = sessionMap1;
		
	}
	@Override
	public String execute() throws Exception {
		list=comdb.searchAll();
		System.out.println("%%%%%%% "+list.getClass().getName());
		//sessionMap1.put("action",list.get(3));
		System.out.println(Arrays.toString(list.toArray()));
		return SUCCESS;
	}
	
	public String approve() throws Exception
	{
				comdb.approve(this);
		return SUCCESS;
	}
	public String delete() throws Exception
	{
				comdb.delete(this);
		return SUCCESS;
	}
}
