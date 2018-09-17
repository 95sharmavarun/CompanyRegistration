package action;

import com.opensymphony.xwork2.ActionSupport;

import dbAccess.CompanyAddDao;


public class AddCompanyAction extends ActionSupport {
private String CompanyName,CompanyAddress;

public String getCompanyName() {
	return CompanyName;
}

public void setCompanyName(String companyName) {
	this.CompanyName = companyName;
}

public String getCompanyAddress() {
	return CompanyAddress;
}

public void setCompanyAddress(String companyAddress) {
	this.CompanyAddress = companyAddress;
}

@Override
public String execute() throws Exception {
	int i=CompanyAddDao.addcompany(this);
	if(i>0)
	{
		System.out.println("company added");
	    return SUCCESS;  
	}
	 return ERROR;  
}


	
}
