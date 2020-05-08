package atmMachine;

//checks the balance in the account
public class CheckBalance
{
	public static void checkBalance()
	{
		System.out.println("===============CHECK BALANCE===============");
		System.out.println("Card Number          : " + Account.getCardNum());
		System.out.println("Checking Balance     : " + Account.getBalance());
		System.out.println("===========================================");
	}
}

//ACT DIAGRAM FOR CHECH BALANCE NEEDS TO CHANGE... 
//TAKE ERROR PATH OUT