//Nicholas Harrison
//CMSC 256
//Assignment 1

//handles the savings accounts
class Savings extends Account
{
	//constructor that pulls from Account via super
	public Savings(int AccountNumber)
	{
		super(AccountNumber);
	}

	//interest rate
	private double irate;

	//interest rate getter
	public double getirate()
	{
		return irate;
	}

	//interest rate setter
	public void setirate(int x)
    {
		//error checking for negative numbers
		if (x>=0)
		{
			irate = x;
		}
		else
		{
			irate=0;
		}
	}

	//figuures out interest and returns it
	public double computeInterest(int num)
	{
		double interest;
		interest=(Math.pow(1.02,num)*AccBal)-AccBal;
		return interest;
	}

	//output
	public String toString()
	{
  		String s= "Savings \nAccount # = "+getAccNum()+"\nAccount Balance = "+ getAccBal();
		return s;
	}

}

