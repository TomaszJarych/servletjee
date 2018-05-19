package pl.coderslab.session;

public class Sess04Product {
	private String name;
	private int quantity;
	private double pricePerItem;
	private double totalPrice;
	public Sess04Product(String name, int quantity, double pricePerItem) {
		this.name = name;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
		this.totalPrice = quantity*pricePerItem;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	@Override
	public String toString() {
		return "name=" + name + ", quantity=" + quantity + ", pricePerItem=" + pricePerItem
				+ ", totalPrice=" + totalPrice;
	}
	
	

	
}
