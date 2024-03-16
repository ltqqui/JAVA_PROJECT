package businessLogicLayer;

public class Product {
	private int productID;
	private String productName;
	private float price;
	private int companyID;
	public Product() {};
	public Product(int productID, String productName, float price, int companyID) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.companyID = companyID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price + ", companyID="
				+ companyID + "]";
	}
	
}
