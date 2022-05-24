import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestProduct {
	
	public static void main(String[] args ) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Product> product;
		product = ReadInput();
		ArrayList<Client> client;
		client = ClientCreate(product);
		display(client);
		
			
			
		}
		
	

	public static ArrayList<Client> ClientCreate(ArrayList<Product> product) {
		Scanner rdf = new Scanner(System.in);
		
		int x=1;
		int j=0;
		int select=0;
		int cont = 0;
		
		
		ArrayList<Client> client= new ArrayList<>();
		
		do {
			client.add(new Client(product,3));
			System.out.println("Enter Client ID : ");
			client.get(j).setID(rdf.next());
			do {
			System.out.println("|enter which product would you like to order|\nPress 1 for A001 \nPress 2 for B002 \nPress 3 for C003");
			select = rdf.nextInt();
			if(select == 1) {
				System.out.println("enter your total order ");
				
				client.get(j).setOrder(rdf.nextInt(), 0);
				
				client.get(j).settOrder(0,client.get(j).getProduct().get(0).gettOrder());

				product.get(0).balance(client.get(j).getProduct().get(0).gettOrder());
				
				client.get(j).setQuantity(client.get(j).getProduct().get(0).getQuantity(), 0);
			
			}else if(select == 2) {
				System.out.println("enter your total order ");
				
				client.get(j).setOrder(rdf.nextInt(), 1);	
				
				client.get(j).settOrder(1,client.get(j).getProduct().get(1).gettOrder());

				product.get(1).balance(client.get(j).getProduct().get(1).gettOrder());
				
				client.get(j).setQuantity(client.get(j).getProduct().get(1).getQuantity(), 1);
				
				
				
			}else if(select == 3) {
				System.out.println("enter your total order ");
				
				client.get(j).setOrder(rdf.nextInt(), 2);
				
				client.get(j).settOrder(2,client.get(j).getProduct().get(2).gettOrder());

				product.get(2).balance(client.get(j).getProduct().get(2).gettOrder());
				
				client.get(j).setQuantity(client.get(j).getProduct().get(2).getQuantity(), 2);
				
			}
			
			
			System.out.println("press 0 to exit press 1 to continue");
			cont = rdf.nextInt();
			}while(cont!=0);
			for(int i =0; i<3;i++) {
				
				System.out.println(client.get(j).getID());
				System.out.print(" \t "+client.get(j).getProduct().get(i).getCode());
				System.out.print(" \t "+client.get(j).getProduct().get(i).gettOrder());
				System.out.print(" \t "+client.get(i).getProduct().get(j).TotalPrice(client.get(i).gettOrder(j)));
				System.out.print(" \t "+client.get(j).getProduct().get(i).getQuantity());
				System.out.println(" \t "+client.get(j).getProduct().get(i).StatusProduct());
					
			}
			
			j++;
			System.out.println("enter 1 to create new client enter 0 to exit");
			x= rdf.nextInt();
		}while(x!=0);
		return client;
	}

	public static ArrayList<Product> ReadInput() {
		ArrayList<Product> product = new ArrayList<>();
		File myObj = null;
    	Scanner scan = null;
    	int i =0;
    	try {
	    	myObj = new File("\\Users\\Acer\\Downloads\\productIn.dat.txt");
	        scan = new Scanner(myObj);
	        
	    	}
	    	catch(FileNotFoundException e) {
	    		System.out.println("file not found");
	    		System.exit(0);
	    	}
    	scan.useDelimiter(", ");
    	
		do {
			
			product.add(new Product());
			product.get(i).setCode(scan.next());
			product.get(i).setQuantity(scan.nextInt());
			product.get(i).setPrice(scan.nextDouble());
			scan.nextLine();
			//System.out.println(product.get(i));
			i++;
		}while(scan.hasNext());
		
		return product;
	}

	public static void display(ArrayList<Client> client) {
		java.io.File file = new java.io.File("custOrder.txt");

    	//File OFile = new File("\\Users\\Acer\\Downloads\\OUTPUTFILE");
    	PrintWriter Output = null;
		try {
			Output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Output.println("Client Id \t Code \t TotalOrder \t TotalPrice \t Balance \t StatusProduct");
		for(int i=0;i<client.size();i++) {
			for(int j =0; j<3;j++) {
				
				
				Output.print(client.get(i).getID());
				Output.print(" \t\t "+client.get(i).getProduct().get(j).getCode());
				Output.print(" \t "+client.get(i).gettOrder(j));
				Output.print(" \t\t "+client.get(i).getProduct().get(j).TotalPrice(client.get(i).gettOrder(j)));
				Output.print(" \t         "+client.get(i).getQuantity(j));
				Output.println(" \t\t "+client.get(i).getProduct().get(j).StatusProduct());
				Output.println();
				
				
			}
			
	}
		Output.close();
	
}
	}
