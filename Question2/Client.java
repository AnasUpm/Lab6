import java.util.ArrayList;


public class Client {
	
	private String ID;
	private ArrayList<Product> product;
	private int[] tOrder;
	private int noOfOrder;
	
	private int[] quantity;
	
	
	
	Client(){
		
		
		
	}
	
	Client(ArrayList<Product> product, int noOfOrder){
		
		
		this.product = product;
		
		this.noOfOrder=noOfOrder;
		tOrder = new int[noOfOrder];
		quantity = new int[noOfOrder];
		for(int i=0;i<noOfOrder; i++) {
		tOrder[i] = 0;
		quantity[i] = product.get(i).getQuantity();
		
		
		}
		
	}

	
	
	public int getQuantity(int i) {
		return quantity[i];
	}

	public void setQuantity(int quant,int q) {
		quantity[q] = quant;
	}

	public int getNoOfOrder() {
		return noOfOrder;
	}

	public void setNoOfOrder(int noOfOrder) {
		this.noOfOrder = noOfOrder;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}

	public void setProduct(ArrayList<Product> product) {
		this.product = product;
		
	}
	
	public void setOrder(int qOrder, int index) {
		product.get(index).settOrder(qOrder);
	}
	
	

	public int gettOrder(int i) {
		return tOrder[i];
	}

	public void settOrder(int i, int order) {
		tOrder[i]= tOrder[i]+ order;
	}

	public ArrayList<String> display() {
		ArrayList<String> str = new ArrayList<>();
		
		for(int i =0; i<product.size(); i++) {
			str.add(product.get(i).getCode()+" "+product.get(i).getQuantity()+" "+product.get(i).getPrice()+"\n");
			
		}
		
		return str;
	}
	
	public String toString() {
		
		
		
		return ID;
	}
	
	

}
