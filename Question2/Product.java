

public class Product {
	
	private String Code;
	private int quantity;
	private double price;
	private int tOrder;

	
	
	Product(){
	
	}
	
	Product(String code, int quantity, double price){
		
		this.Code=code;
		this.quantity=quantity;
		this.price=price;
		
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int balance(int TotalOrder) {
		quantity= quantity-TotalOrder;
		return quantity;
	}
	
	public double TotalPrice(int TotalOrder) {
		return TotalOrder * price;
	}
	
	
	
	public int gettOrder() {
		return tOrder;
	}

	public void settOrder(int tOrder) {
		this.tOrder = tOrder;
	}

	public String StatusProduct() {
		if(quantity>100) {
			return "ok";
		}else if(quantity<100) {
			return ("MUST REORDER "+(100-quantity));
		}else if(quantity==100) {
			return("MIN");
		}else
			return("error");
	}

	
	
	


	public String toString() {
		return Code+" "+quantity+" "+price;
	}

}
