//Nicholas Harrison
//Assignment 3
//Due 10/10/13

/*
Input: User enters the desired number
Output: The number of sums that equal that number with out using the number itself or zero
Summary: The purpose of this program was for us to comput the number of sums of some value using recursion
*/

import java.io.*;
import java.util.*;
public class findSums {

	//stores the number of Sums for the inputed number
	static int count=0;

    //base case for recursion
    public static void sums(int num) {
    sums(num, num);
    }

    //recursive method
    public static void sums(int num, int maxVal)
    {
        //when num = 0 then a sum of the user's number has been found so the count is incremented
        if (num == 0)
        {
   		     count++;
        }

		/*
        recursive statement(sums is called again)
		the users number is used in the beginning (5 will be used for an example)
		the program then de-increments by one so we now have 4 and sees what will add up to 5 with 4
		this is repeated recursively unitll the users number is zero meaning a Sum has been found and count is incremented by one
		5
		4 1
		3 2
		3 1 1
		2 2 1
		2 1 1 1
		1 1 1 1 1  is what the recursive statement is doing and what would be printed if you so wanted
		*/
        for (int i = Math.min(maxVal, num); i >= 1; i--)
        {
        	//num-i is the de-incrimenting;
        	sums(num-i, i);
        }
    }

    //main method
   	public static void main(String[] args) {

    //user input
    Scanner scan=new Scanner(System.in);
	System.out.println("Enter the number you wish to use");
	int num=scan.nextInt();

    //method called in main
    sums(num);

   	//print statement, 1 is subtracted from count because the program takes the Users number into account which is not part of the sums we are looking for
   	System.out.println(count-1);
    }
}