//Nicholas Harrison
//CMSC 256
//Assignment 1

//handles the checking accounts
class Checking extends Account
{
	//constructor that pulls from Account via super
	public Checking(int AccountNumber)
	{
		super(AccountNumber);
	}

	//figures out the interest and returns it for the checking class
	public double computeInterest(int num)
	{
		double interest;
		//System.out.print("BALANCE "+ balance);
		interest=(AccBal-700)*.02*num;
		return interest;
	}

	//output
	public String toString()
	{
  		String s= "Checking \nAccount # = "+getAccNum()+"\nAccount Balance = "+ getAccBal();
    	return s;
	}
}

