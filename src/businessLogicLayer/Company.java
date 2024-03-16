package businessLogicLayer;

public class Company {
	private int companyID;
	private String companyName;
	private String address ;
	private String email;
	private String phone;
	public Company(int companyID, String companyName, String address, String email, String phone) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
