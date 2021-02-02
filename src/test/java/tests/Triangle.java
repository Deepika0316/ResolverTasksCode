package tests;

public class Triangle extends Test6
{
	public Triangle(double height, double width)
	{
		super(height, width);
	
	}

	public double areaTriangle()
	{
		double at=(width*height)/2;
		return at;
	}

}
