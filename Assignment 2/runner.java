//Nicholas Harrison
//Assignment 2
//Turned in on 9/29
//Due 9/30

/*
Input is handled by a text file that will be included with the program for redundancy.  The user must input the name of the file with the extension and the pogram handles the calculations
Output is what the shape is and its perimeter and area
Summary: This program was used to apply concepts of object oriented programming by having us write a program that can accept input from a text file and parse through it applying
constraints to it and performing calculations to give the user the area and perimeter of different shapes.
*/

import java.io.*;
import java.util.*;

//runner class that instantiates and runs all other classes
public class runner
{
	//main method
	public static void main (String [] args)throws IOException
	{

	//scanner for entering file name and reading in the text file
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the name ofthe file to be read in with the file extension(Example.txt)");
	String input=scan.next();

	 ArrayList A = new ArrayList();
	 Scanner sc = new Scanner(new File(input));
	 System.out.println();

	//takes in the text file and puts it in an array list
	while(sc.hasNext())
	 {
	 	  A.add(sc.next());
	 }
	 	 A.trimToSize();
	 	 //System.out.println(A);

	//parses through the array list
	for(int i = 0; i < A.size(); i++)
	{
		if(A.get(i).equals("triangle"))
	    {
	    	int[] vals = new int[2];
		    for(int j = 0; j < 2; j++)
		    {
			     vals[j] = -1;
			     try
	    	 {
	    	  vals[j] = Integer.parseInt((String) A.get(i + j + 1));
	    	 }
	    	 catch(NumberFormatException e){}

	    }
	    if (vals[1]==-1)
	    {
			EquilateralTriangle tri1= new EquilateralTriangle("Equilateral Triangle",vals[0], 0);
			System.out.println(tri1.toString()+"\t Area="+tri1.findArea(vals[0],0)+"\t Perimeter="+tri1.findPerimeter(vals[0],0));
			System.out.println();
		}
		else
		{
			IsocelesTriangle tri2= new IsocelesTriangle("IsocelesTriangle",vals[0],vals[1]);
			System.out.println(tri2.toString()+"\t Area="+tri2.findArea(vals[0],vals[1])+"\t Perimeter="+tri2.findPerimeter(vals[0],vals[1]));
			System.out.println();
		}
	   }

		if(A.get(i).equals("quadrilateral"))
		{
		    int[] vals = new int[2];
		    for(int j = 0; j < 2; j++)
		    {
			     vals[j] = -1;
		    try
		    {
			      vals[j] = Integer.parseInt((String) A.get(i + j + 1));
		     }
			     catch(NumberFormatException e){}
    	    }
		    if (vals[1]==-1)
		    {
				Square sqr1= new Square("Square",vals[0], 0);
				System.out.println(sqr1.toString()+"\t Area="+sqr1.findArea(vals[0],0)+"\t Perimeter="+sqr1.findPerimeter(vals[0],0));
				System.out.println();
			}
			else
			{
				Rectangle rec2= new Rectangle("Rectangle",vals[0],vals[1]);
				System.out.println(rec2.toString()+"\t Area="+rec2.findArea(vals[0],vals[1])+"\t Perimeter="+rec2.findPerimeter(vals[0],vals[1]));
				System.out.println();
			}
		 }

		 if(A.get(i).equals("pentagon"))
		 {
		 	Pentagon pent1= new Pentagon("Pentagon",Integer.parseInt((String)A.get(i+1)),0);
		 	System.out.println(pent1.toString()+"\t Area="+pent1.findArea(Integer.parseInt((String)A.get(i+1)),0)+"\t Perimeter="+pent1.findPerimeter(Integer.parseInt((String)A.get(i+1)),0));
		 	System.out.println();
		 }

		 if(A.get(i).equals("hexagon"))
		 {
			Hexagon hex1= new Hexagon("Hexagon",Integer.parseInt((String)A.get(i+1)),0);
			System.out.println(hex1.toString()+"\t Area="+hex1.findArea(Integer.parseInt((String)A.get(i+1)),0)+"\t Perimeter="+hex1.findPerimeter(Integer.parseInt((String)A.get(i+1)),0));
			System.out.println();
		}

		 if(A.get(i).equals("octagon"))
		 {
			Octagon oct1= new Octagon("Octagon",Integer.parseInt((String)A.get(i+1)),0);
			System.out.println(oct1.toString()+"\t Area="+oct1.findArea(Integer.parseInt((String)A.get(i+1)),0)+"\t Perimeter="+oct1.findPerimeter(Integer.parseInt((String)A.get(i+1)),0));
			System.out.println();
		 }
	   }
	}

}















