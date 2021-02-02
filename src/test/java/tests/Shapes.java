package tests;

public class Shapes 
{	
	public static void main(String[] args) 
	{
	Triangle t=new Triangle(15,20);
	Rect r = new Rect(10,20);
	System.out.println("area of rectangle : "+r.area());
	System.out.println("area of triangle : "+t.areaTriangle());

	}

}
