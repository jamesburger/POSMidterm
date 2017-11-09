
public class Product {
	
	private String productName = "";
	private String productType = ""; 
	private String productDes = "";
	private double productPrice = 0.0;
	private int productQty = 0;
	
	Product(){
		
	}
	
	public Product(String productName, double productPrice, int productQty) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
	}

	public Product(String productName, String productType, String productDes, double productPrice, int productQty) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productDes = productDes;
		this.productPrice = productPrice;
		this.productQty = productQty;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	
	@Override
	
	public String toString() {
		return productName + " " + productType + " " + productDes + " " + productPrice + " " + productQty;
	}

}
