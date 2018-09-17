package action;

import com.opensymphony.xwork2.ActionSupport;

import dbAccess.CompanyAddDao;

public class AddCompanyByAdminAction  extends ActionSupport {
	private String CompanyName,CompanyAddress,CreatedBy,Action;

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		this.CreatedBy = createdBy;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		this.Action = action;
	}

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
		int i=CompanyAddDao.addcompanybyadmin(this);
		if(i>0)
		{
			System.out.println("company added by admin");
		    return SUCCESS;  
		}
		 return ERROR;  
	}
}
