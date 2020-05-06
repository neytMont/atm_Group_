package atmMachine;

//checks the balance in the account
public class CheckBalance
{
	static String name = "Check Balance";
	public static void checkBalance()
	{
		System.out.println("Card Number : " + Account.getCardNum());
		System.out.println("Balance     : " + Account.getBalance());
	}
}


//ACT DIAGRAM FOR CHECH BALANCE NEEDS TO CHANGE... 
//TAKE ERROR PATH OUT