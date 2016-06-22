//Nicholas Harrison
//Assignment 2 Question 1


import java.util.*;
import java.io.*;


//this program is supposed to crack passwords
public class A2Q1 
{
    //variable for how long it takes to crack the password
	static long startTime; 
	
	//main method
	public static void main(String[] args) throws IOException 
	{
                //time starts
				startTime = System.currentTimeMillis(); 
                
				attempttoLogin(args[0]); 
				
				//time ends
                long endTime = System.currentTimeMillis(); //endtime
                
				System.out.println("time used: "+(endTime-startTime)/1000+" seconds"); 
	}//end of main method
        
        public static void attempttoLogin(String user) throws IOException
        {
            Login login = new Login();
            //number of attempts to login
			int tries = 0;
            
			//the attmept to login begins
			//if the user inputs user1
			if(user.equals("user1"))
            {
                   //only need numerical characters since the month of the birthday is being guess seperately
					char[] numberstotest = "0123456789".toCharArray(); 
                    //since the password is always goign to be a length of 8 and 3 of those characters are a month abreviation we just need 5 digits
					user1 pwcrack1 = new user1(numberstotest, 5); 
	
                    while(true)
					{
						//start guessing the password
						String attemptCrack = pwcrack1.checkMonth()+pwcrack1.toString(); 
						
						//increasing the number of times we ahve tried to crack the password
						tries++; 
				
						//checks if the password is correct
						if (login.login("user1", attempt))
						{
							System.out.println("Password for user1 is: " + attempt);
							System.out.println("number of attempts: "+tries);
							//we are done and the program is ended
							break;
						}
				
						//we try again with the nextWord month, so if we started at Janxxxxx it would become Febxxxxx
					attemptCrack = pwcrack1.checkMonth()+pwcrack1.toString(); 
				
					pwcrack1.nextWordAttempt(); 
					}
			}
        
            
            
			//if the user input is user2
			if(user.equals("user2"))
            {
                 //we know user2's password is a person's name so we do not need numbers in this passowrd
				char[] nameChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                    
                //the user class is created 
				user2 pwcrack2 = new user2(nameChar, 4);
                    
                //first attempt to crack the password
				String attemptCrack = pwcrack2.newName().get(pwcrack2.getIndex())+pwcrack2.toString();
				
				while(true)
				{ 
					//number of attempts to login
					tries++;
						
					//test if password matches
					if (login.login("user2", attempt))
							{
								System.out.println("Password for user2 is: " + attempt);
								System.out.println("number of attempts: "+tries);
								break;
							}
				
				
					//tries again
					attemptCrack = pwcrack2.getName()+pwcrack2.toString();
				
					pwcrack2.nextWordAttempt();
				}
			}
                
            //if user input is user3
            if(user.equals("user3"))
            {
                //user3 class is instantiated
				user3 pwcrack3= new user3();
                    
				//number of tries is initialized to zero
				int commonAttempts = 0;
                    
				//we know user3's password is multiple words put together
				pwcrack3.words=pwcrack3.newWord();
                boolean found = false;
                    
				//this will contain the attempts
				ArrayList<String> tests = new ArrayList();
                    
				//this will contain the common passwords that are tried
				ArrayList<String> commonpwTries = new ArrayList();
                    
				commonpwTries=pwcrack3.testCommon();
                
				while(true)
				{				   
					//if this break is activated then the commone password is not in our library
					if(commonAttempts>=commonpwTries.size())
					{
						break;
					}		
					//our guess is correct and we are done cracking user3's password
					if (login.login("user3", commonpwTries.get(commonAttempts)))
					{
						System.out.println("Password for user5 is: " + commonpwTries.get(commonAttempts));
						System.out.println("number of attempts: "+(commonAttempts+1));
						found=true;
						break;
					}
							
					//we move on to the nextWord possible common passowrd in the library
					commonAttempts++;
                }   
                
                //try again
				if(found==false)
                {
					while(true)
					{
						   //attempt to crack the password again
							String test=pwcrack3.nextWordAttempt();
							if (login.login("user3", test))//Login.login(attempt)) 
							{
								System.out.println("Password for user3 is: " + test);
								System.out.println("number of attempts: "+tries);
								break;
							}
						
						//number of attempts is incremented
						tries++;
					}  
                }  
            }
            
            
            //if user input is user4
			if(user.equals("user4"))
            {
               //we know that this password will be simple/made of simple characters
			   char[] charset = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray(); 
               user4 pwcrack4 = new user4(charset, 8);
	
               //first try at the password
			   String attemptCrack = pwcrack4.toString();
                    
                while(true)
				{
					//increment number of tries
					tries++;
					
					//test if the password is correct
					if (login.login("user4", attempt)) 
					{
						System.out.println("Password for user1 is: " + attempt);
						System.out.println("number of attempts: "+tries);
						break;
					}
					
					attemptCrack = pwcrack4.toString();
					pwcrack4.nextWordAttempt();
				}
            } 
                                                
    	}
}        




//class for user 1
class user1
{
	//characters to be used to try to crack the passowrd
	private char[] characters; 
	
	//our guess as to what the password is
	private char[] pwGuess; 
    
	//numerical representation of the month abbreviation currently being tried
	private int month=0;

	//constructor
	public user1(char[] setOfChars, int attemptLen) 
	{
		characters= setOfChars;
		pwGuess = new char[attemptLen];
        
		//initalize to start counting through months
		int month=0;
		Arrays.fill(pwGuess, characters[0]);
	}
        
        //counts through the months
	public String checkMonth()
    {
		if(month==0)
		{
			return "Jan";
		}
		else if(month==1)
		{
			return "Feb";
		}
		else if(month==2)
		{
			return "Mar";
		}
		else if(month==3)
		{
			return "Apr";
		}
		else if(month==4)
		{
			return "May";
		}
		else if(month==5)
		{
			return "Jun";
		}
		else if(month==6)
		{
			return "Jul";
		}
		else if(month==7)
		{
			return "Aug";
		}
		else if(month==8)
		{
			return "Sep";
		}
		else if(month==9)
		{
			return "Oct";
		}
		else if(month==10)
		{
			return "Nov";
		}
		else
			return "Dec";
    }

	public void nextWordAttempt() 
	{
		int index = pwGuess.length - 1;
		
		//while we are still counting through the months
		while(index >= 0) 
		{
			if (pwGuess[index] == characters[characters.length-1]) 
			{
				//increment month
				if (index == 0) 
				{
					pwGuess = new char[pwGuess.length]; 
                    month++;
					
					//where the characters used to guess the password is passed in
					Arrays.fill(pwGuess, characters[0]);
					break;
				}
				else 
				{
					pwGuess[index] = characters[0];
					index--;
				}
			} 
			
			//loops through the set of characters
			else 
			{
				pwGuess[index] = characters[Arrays.binarySearch(characters, pwGuess[index])+1];
				break;
			}
		}
	}

	//output
	public String toString() 
	{
		return String.valueOf(pwGuess);
	}
}

//class for user2
class user2 
{ 
    private char[] characters; 
    private char[] pwGuess;
    private static int index=0;
    
	//builds a list of names form our text file
	static ArrayList<String> name=new ArrayList<>();
    
    //constructor
    public user2(char[] setOfChars, int attemptLen) 
    {
		characters= setOfChars;
		pwGuess = new char[attemptLen-1];
		Arrays.fill(pwGuess, characters[0]);
    }
    
    //generic getter for the index
	public static int getIndex() 
    {
        return index;
    }
    
     
    public static ArrayList<String> newName() throws FileNotFoundException, IOException 
    {
    
	//input from textfile 
	BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream("namesQ1.txt")));
       String nextWord = null;
       
	   //while there is osmething still to read
	   while((nextWord=bufferedreader.readLine())!=null)
       {
           //only reads in words that are 8 characters or less 
            if(nextWord.length()<9) 
            {
                //add to the array list
				name.add(nextWord); 
            }    
        } 
        return name;
    }
    
	//generic getter for the name from the text file
	public static String getName()
    {
        return name.get(index);
    }
    
    
	public void nextWordAttempt() throws IOException 
    {
		int inc = pwGuess.length - 1;
		while(inc >= 0) 
		{
			if (pwGuess[inc] == characters[characters.length-1]) 
			{
				if (inc == 0) 
				{
                    index++;
                    //a guess is created based on how long the name is from the file input
					pwGuess = new char[8-name.get(index).length()];
					//add to the array
					Arrays.fill(pwGuess, characters[0]);
					break;
				}
				//if not
				else 
				{
                    pwGuess[inc] = characters[0];
					inc--;
				}
			} 
			
			//search for the last name
			else 
			{
				pwGuess[inc] = characters[Arrays.binarySearch(characters, pwGuess[inc])+1];
				break;
			}
		}
	}
    
	//output
	public String toString() 
    {
		return String.valueOf(pwGuess);
    }

}

//class for user2
class user3
{
    //the arraylist containing words from the text file input
	static ArrayList<String> testWords=new ArrayList<>();
    //arraylist of the passwords we attempt
	static ArrayList<String> trypw=new ArrayList<>();
    
    public static ArrayList testCommon() throws FileNotFoundException, IOException
    {
       //file input 
       BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream("commonQ1.txt")));
       String nextWord = null;
       
	   //while there are still words in the list
	   while((nextWord=bufferedreader.readLine())!=null)
       {
            //only places words that are 8 characters or shorter in the array list
            if(nextWord.length()<=8) 
            {
                //add it to the arraylist
				trypw.add(nextWord); 
            }    
        }
        return trypw;
    }
    
    public static ArrayList<String> newWord() throws FileNotFoundException, IOException
    {
       //using both of the text files to try to be more thourough
	   BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream("wordlistQ1.txt"))); //brings in wordlist.txt
       
       String nextWord = null;
       while((nextWord=bufferedreader.readLine())!=null)
       {
            //again only adds words that are 8 characters or less
            if(nextWord.length()<9) 
            {
                testWords.add(nextWord); 
            }    
        } 
        return testWords;
    }
    
    public String nextWordAttempt() throws IOException
    {
        //sets the string to null
		String passAttempt="";
        int count=0;
        while(passAttempt.length()<=8)
        {
            //increments through the words in the arraylists
			if(passAttempt.length()+testWords.get(count).length()<9)
            {
                System.out.println(passAttempt);
                if(passAttempt.length()==8)
                {
                    return passAttempt;
                } 
                passAttempt=passAttempt+testWords.get(count);
          
            }
        }
        System.out.println(passAttempt);
        return passAttempt;
    }
}

//class for user input of user4
class user4
{
    private char[] characters;
    private char[] pwGuess;
    
    //constructor
	public user4(char[] setOfChars, int attemptLen) 
    {
		characters= setOfChars;
		pwGuess = new char[attemptLen];
		Arrays.fill(pwGuess, characters[0]);
    }
    
    public void nextWordAttempt() 
	{
		int index = pwGuess.length - 1;
		//runs until the index is 0
		while(index >= 0) 
		{
			//increments through the lists
			if (pwGuess[index] == characters[characters.length-1]) 
			{
				if (index == 0) 
				{
					pwGuess = new char[pwGuess.length];
					Arrays.fill(pwGuess, characters[0]);
					break;
				}
				else 
				{
					pwGuess[index] = characters[0];
					index--;
				}
			} 
			
			//increments through the lists
			else 
			{
				int testpw=0;
				for(int i=0; i<characters.length;i++)
				{
					if(characters[i]==pwGuess[index])
					{
						testpw=i;
						break;
					}    
				}
				pwGuess[index] = characters[testpw+1];
				break;
			}
		}
	}
    
   //output
	public String toString() 
	{
		return String.valueOf(pwGuess);
	}
}



