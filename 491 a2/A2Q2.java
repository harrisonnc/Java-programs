//Assignment 2 Question 2 
//Nicholas Harrison

import java.util.*;
import java.io.*;

//question 2 tests wheather a password entered by the user is a valid password or not
public class A2Q2
{
	//main method
	public static void main(String [] args) throws IOException
	{
		Scanner scan=new Scanner(System.in);
		String pw;
		//loops untill the password is valid
		do {
			System.out.println("Please choose a password: ");
			pw = scan.nextLine();
			//validPW(pw);
		} while(!validPW(pw));
	}//end main
	
	//Method to test validity of the password the user inputs
	public static boolean validPW(String password)
	{
		Scanner scan2=new Scanner(System.in);
		
		//text file for dicitonary words
		File file = new File("wordlistQ2.txt");
		int count=0;
		
		//makes sure the length of the password is 8 characters or more
		if (password.length() < 8)
		{
			System.out.println("No, the password has to be at least 8 characters long, Please choose a password: ");
			//password = scan2.nextLine();
			return false;
			
		}
		
		//determines the number of digits and letters in the password if it is over 8 characters long
		else
		{
			for (int i=0; i<password.length(); i++)
			{
				if (Character.isLetterOrDigit(password.charAt(i)))
				{
					if (Character.isDigit(password.charAt(i)))
					{
						count++;
					}
				}
			}
		}
		
		
		
		//check that it is not all numbers
		if (count==password.length())
		{
			System.out.println("No, the password has to contain at least 1 letter, Please choose a password:");
			return false;
		}
		
				
		//check to make sure that the password is not a concatanation of dictionary words starting from the left side of the password
		int start=0;
		for (int j=0; j<=password.length();j++) 
		{ 
			//password.substring (start,j); 
			try
			{
				Scanner dictionary = new Scanner(file);
				int flag=0;
				if (j==password.length())
				{
					flag=1;
				}
				//System.out.println(password.substring(start,j));
				while(dictionary.hasNextLine())
				{
					String linesearch = dictionary.nextLine().toLowerCase();
					//System.out.println(linesearch);
					
					if (password.substring (start,j).toLowerCase().equals(linesearch))
					{
						//System.out.println("j="+ j);
						//System.out.println("stringlen -1"+ (password.length()-1));
						//System.out.println(password.substring(start,j));
						if(flag==1)
						{
							
							System.out.println("No, the password cannot be the combination of dictionary words, Please choose a password:");
							return false;
						}
						//System.out.println("j="+ j);
						//System.out.println("stringlen -1"+ (password.length()-1));
						//System.out.println(password.substring(start,j));
						start=j;
				
											
						//if()
					}
				}
			}
			catch(FileNotFoundException e) 
			{ 
			//makes sure there is a file
			}
			
		}
		
		//check to make sure the password is not a combination of dictionary words starting from the right side of the password
		start=password.length();
		for (int j=password.length(); j>=0;j--) 
		{ 
			//password.substring (start,j); 
			try
			{
				Scanner dictionary = new Scanner(file);
				int flag=0;
				if (j==0)
				{
					flag=1;
				}
				//System.out.println(password.substring(j,start));
				while(dictionary.hasNextLine())
				{
					String linesearch = dictionary.nextLine().toLowerCase();
					//System.out.println(linesearch);
					
					if (password.substring (j,start).toLowerCase().equals(linesearch))
					{
						//System.out.println("j="+ j);
						//System.out.println("stringlen -1"+ (password.length()-1));
						//System.out.println(password.substring(start,j));
						if(flag==1)
						{
							
							System.out.println("No, the password cannot be the combination of dictionary words, Please choose a password:");
							return false;
						}
						//System.out.println("j="+ j);
						//System.out.println("stringlen -1"+ (password.length()-1));
						//System.out.println(password.substring(start,j));
						start=j;
				
											
						//if()
					}
				}
			}
			catch(FileNotFoundException e) 
			{ 
			//makes sure there is a file
			}
			
		}
		
		//check to make sure the password is not a pattern 		
		if (count== password.length()/2||count==0)
		{
			System.out.println("No, the password is too simple, Please choose a password:");
			return false;
		}
		
		//finally if the password makes it through all of these checks it should be a valid password
		else
		{
		System.out.println("Congragulations, your new password has been set!");
		return true;
		}
	
	
	}

}