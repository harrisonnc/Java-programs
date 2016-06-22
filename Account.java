//Nicholas Harrison
//CMSC 256
//Assignment 1

//Parent class of checking and savings

abstract class Account
{
	//holds the primary traits of the accounts that are made
	protected int AccNum;
	protected double AccBal;

	//constructor
	public Account(int AccountNumber)
		{
		AccNum=AccountNumber;
		AccBal=0;
		}

	//getters and setters for the Account Number and Account Balance
	//if the number or balance are negative, the values are set to zero then
	//there should be no other singular zeroes

	//number getter
	public int getAccNum()
    {
        return AccNum;
	}

	//balance getter
	public double getAccBal()
	{
		return AccBal;
	}

	//number setter
	public void setAccNum(int x)
    {
        //error checking for negative numbers
        if (x>=0)
		{
			AccNum = x;
		}
		else
		{
			AccNum = 0;
		}
    }

	//balance setter
	public void setAccBal(int y)
	{
		//error checking for negative numbers
		if (y>=0)
		{
			AccBal = y;
		}
		else
		{
			AccBal = 0;
		}
	}

	//toString for output
	public String toString()
	{
		String s= "Account Number ="+AccNum+" Account Balance= "+ AccBal;
    	return s;
	}

	//abstract class
	abstract double computeInterest(int num);

}

