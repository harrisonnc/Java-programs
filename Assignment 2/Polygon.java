//Nicholas Harrison
//Assignment 2
//Due 9/30

//parent class sets the standard for other shape classes
public abstract class Polygon
{
	protected String shape;
	protected int sideLen1;
	protected int sideLen2;

	public Polygon(String type, int len1, int len2)
	{
		shape=type;
		sideLen1=len1;
		sideLen2=len2;
	}

	//generic getters and setters for the classes
	public String getShape()
	{
		return shape;
	}

	public int getSideLen1()
	{
		return sideLen1;
	}

	public int getSideLen2()
	{
		return sideLen2;
	}

	public void setShape(String x)
	{
		shape=x;
	}

	public void setSideLen1(int y)
	{
		sideLen1=y;
	}

	public void setSideLen2(int z)
	{
		sideLen2=z;
	}

	public String toString()
	{
		String s= "The shape is "+shape;
		return s;
	}

	//abstract classes to be set up for finding the area and perimeter of the different shapes
	abstract double findArea(int len1, int len2);
	abstract double findPerimeter(int len1, int len2);
}