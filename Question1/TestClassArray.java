package pckg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestClassArray {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	    public static void main(String[] args)
	        throws Exception
	    {
	        
	        ArrayList<Rectangle> rectangleArray;
	    	rectangleArray = createRectangleArray();
	    	
	    	
	    		
	    	try {
	    	printRectArray(rectangleArray);
	    	double averageP = AveragePerimeter(rectangleArray);
	    	double averageA = AverageArea(rectangleArray);
	    	System.out.println("the average perimeter of the rectangles is "+averageP);
	    	System.out.println("the average area of the rectangles is "+averageA);
	    	System.out.println("no of rectangles : "+Rectangle.getNoofObj());
	    	}catch(NullPointerException N) {
	    		System.out.println("Null");
	    	}
	    	finally {
	    		System.out.println("\n\nDONE EXCEPTION");
	    	}
	    	
	    }
	    
	    public static ArrayList<Rectangle> createRectangleArray() throws Exception{
			ArrayList<Rectangle> rec = new ArrayList<>();
	    	
	    	int i = 0;
	    	double _width = 0;
	    	double _length = 0;
	    	File myObj = null;
	    	Scanner scan = null;
	    
	    	
	    	try {
	    	myObj = new File("\\Users\\Acer\\Downloads\\RECTANGLE.txt");
	        scan = new Scanner(myObj);
	    	}
	    	catch(FileNotFoundException e) {
	    		System.out.println("file not found");
	    		System.exit(0);
	    	}
	    	do {
	            try {
	            	do {
	            		
	            	System.out.println("Rectangle "+(i+1));
	            	
	               // System.out.println("Please enter a numerical value for the rectangle's width:");
	                _width = scan.nextDouble();
	                //rec.get(i).setWidth(_width);
	               // System.out.println("Please enter a numerical value for the rectangle's length:");
	                _length = scan.nextDouble();
	                //rec.get(i).setLength(_length);
	                rec.add( new Rectangle(_length,_width));
	                System.out.println(rec.get(i).toString()+"\n");
	               
	                i++;
	            	}while(scan.hasNextLine());
	                }
	            catch (InputMismatchException e){
	                System.out.println("error");;
	                scan.nextLine();
	          
	            }
	            catch(IllegalArgumentException ex) {
	            	System.out.println("width cannot be negative");
	            	scan.nextLine();
	            }
	            catch(NullPointerException N) {
	            	System.out.println(N);
	            }
	    	}while(scan.hasNextLine());
	      
	      return rec;
	    	}
	    	
	    	
	    		
	    
	    public static void printRectArray(ArrayList<Rectangle> rectangleArray) {
	    	//print the rectangles and the properties
	    	java.io.File file = new java.io.File("scores2.txt");

	    	//File OFile = new File("\\Users\\Acer\\Downloads\\OUTPUTFILE");
	    	PrintWriter Output = null;
			try {
				Output = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	int j=1;
	    	for(int i = 0; i<rectangleArray.size();i++) {
	    		
	    		Output.println("rectangle "+j+"\t length : "+df.format(rectangleArray.get(i).getLength())+"\t width : "+df.format(rectangleArray.get(i).getWidth())+"\t area : "
	    				+df.format(rectangleArray.get(i).getArea())+"\t perimeter : "+df.format(rectangleArray.get(i).getPerimeter()));
	    		j++;
	    	}
	    	Output.close();

	    }
	    
	    public static double AveragePerimeter(ArrayList<Rectangle> rectangleArray) {
	    	double total = 0;
	    	for(int i = 0; i<rectangleArray.size(); i ++) {
	    		total = total + rectangleArray.get(i).getPerimeter();
	    	}
	    	return (total/rectangleArray.size());
	    }
	    
	    public static double AverageArea(ArrayList<Rectangle> rectangleArray) {
	    	double total = 0;
	    	for(int i = 0; i<rectangleArray.size(); i ++) {
	    		total = total + rectangleArray.get(i).getArea();
	    	}
	    	return (total/rectangleArray.size());
	    }
}
	    
    


