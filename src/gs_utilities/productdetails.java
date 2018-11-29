package gs_utilities;

import java.util.ArrayList;

public class productdetails {
	
	String ProductName;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public float getProduct_actual_price() {
		return product_actual_price;
	}
	public void setProduct_actual_price(float product_actual_price) {
		this.product_actual_price = product_actual_price;
	}
	public int getProduct_count() {
		return Product_count;
	}
	public void setProduct_count(int product_count) {
		Product_count = product_count;
	}
	public ArrayList<String> getTopping_details() {
		return topping_details;
	}
	public void setTopping_details(ArrayList<String> topping_details) {
		this.topping_details = topping_details;
	}
	public String getInstructions() {
		return Instructions;
	}
	public void setInstructions(String instructions) {
		Instructions = instructions;
	}
	float product_actual_price;
	int Product_count;
	
	
	ArrayList<String> topping_details;
	String Instructions;
}
