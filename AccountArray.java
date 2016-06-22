//Nicholas Harrison
//CMSC 256
//Assignment 1

//the runner class that instantiates the other classes
class AccountArray
{
	  //main method
	  public static void main (String [] args)
	  {
		//creates an array of accounts for holding the checking and savings accounts
		Account[] array = new Account[10];

		//count sets the balances for the accounts
		int count=0;

		//goes through the array instantiating
		//the checkings and savings classes to the accounts array
		for (int i=0; i<10; i++)
		 {
			//if statement divies the array between savings and checking
			if (i<5)
			{
				array[i]= new Checking(i);
				array[i].setAccNum(i+100);
				count+=1000;
				array[i].setAccBal(count);
			}
			else
			{
				array[i]=new Savings(i);
				array[i].setAccNum(i+100);
		 		count+=1000;
		 		array[i].setAccBal(count);
		 	}
		}

		//output
		for (int i=0; i<10; i++)
		{
			System.out.println(array[i].toString());
			System.out.println("Interest Earned = " + array[i].computeInterest(3));
			System.out.println();
		}
	  }
}

