//Nicholas Harrison
//Assignment 2
//Due 9/30

//pentagon class
public class Pentagon extends Polygon
{
	public Pentagon(String type, int len1, int len2)
		{
			super(type,len1,len2);
		}

	public double findArea(int len1, int len2)
		{
			double area=0;
			area=1.72*(len1*len1);
			return area;
		}

		public double findPerimeter(int len1, int len2)
		{
			int perimeter = 5*len1;
			return perimeter;
		}

		public String toString()
		{
			String s= shape;
			return s;
	}
}