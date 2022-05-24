package pckg;

class Rectangle{
    // define two fields
    private double length, width;
    public static int noofObj;
    // define no arg constructor
    Rectangle()
    {
        length = 0.00;
         width = 0.00;
         noofObj++;
    }
   
   
    // define parameterized constructor
    Rectangle(double length, double width){
    
    	
        this.length = length;
        this.width  = width;
        noofObj++;
   
    }
    
    
    
    public void setLength(double length) throws IllegalArgumentException {
    	if (length>0) {
		this.length = length;
    	}
    	else if(length<0) {
    		throw new IllegalArgumentException("length cannot be negative");
    	}
	}


	public void setWidth(double width) throws IllegalArgumentException {
		if (width>0) {
			this.width = width;
	    	}
	    	else if(width<0) {
	    		throw new IllegalArgumentException("width cannot be negative");
	    	}
	}

	public double getLength() {
		return length;
	}


	public double getWidth() {
		return width;
	}


	public static int getNoofObj() {
		return noofObj;
	}


	// define a method to return area
    double getArea()
    {
        return (length * width);
    }
    // define a method to return perimeter
    double getPerimeter()
    {
        return (2 * (length + width));
    }
    
    public String toString() {
    	return ("The rectangle has a width of " +width + " and a lenght of " + length);
    }
}
    