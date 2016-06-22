//Nicholas Harrison
//Assignment 2
//Due 9/30

//rectangle class
public class Rectangle extends Square
{
	public Rectangle(String type, int len1, int len2)
	{
		super(type,len1,len2);
	}

	public double findArea(int len1, int len2)
	{
		double area=0;
		area=len1*len2;
		return area;
	}

	public double findPerimeter(int len1, int len2)
	{
		int perimeter = (2*len1)+(2*len2);
		return perimeter;
	}

	public String toString()
	{
		String s= shape;
		return s;
	}
}