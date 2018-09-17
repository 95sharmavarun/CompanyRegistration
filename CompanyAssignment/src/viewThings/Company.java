package viewThings;

public class Company {
	private String CompanyName,CreatedBy,CompanyAddress,Action;

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getCompanyAddress() {
		return CompanyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		CompanyAddress = companyAddress;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public Company(String companyName, String createdBy, String companyAddress, String action) {
		super();
		CompanyName = companyName;
		CreatedBy = createdBy;
		CompanyAddress = companyAddress;
		Action = action;
	}
	
	
	
	
}
