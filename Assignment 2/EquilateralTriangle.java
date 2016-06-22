//Nicholas Harrison
//Assignment 2
//Due 9/30

//equilateral triangle class
public class EquilateralTriangle extends Polygon
{
	//constructor
	public EquilateralTriangle(String type, int len1, int len2)
	{
			super(type,len1,len2);
	}

	public double findArea(int len1, int len2)
	{
		double area=0;
		area=((len1*len1)*Math.sqrt(3))/4;
		return area;
	}

	public double findPerimeter(int len1, int len2)
	{
		int perimeter = 3*len1;
		return perimeter;
	}

	public String toString()
	{
		String s= shape;
		return s;
	}
}