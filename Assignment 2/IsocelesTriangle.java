//Nicholas Harrison
//Assignment 2
//Due 9/30

//isoceles triangle class
public class IsocelesTriangle extends EquilateralTriangle
{
	public IsocelesTriangle(String type, int len1, int len2)
	{
		super(type,len1,len2);
	}


	public double findArea(int len1, int len2)
	{
		double area=.5*len1*len2;
		return area;
	}

	public double findPerimeter(int len1, int len2)
	{
		double perimeter=(Math.sqrt(((.5*len1)*(.5*len1))+((len2)*(len2)))*2)+len1;
		return perimeter;
	}

	public String toString()
	{
		String s= shape;
		return s;
	}

}