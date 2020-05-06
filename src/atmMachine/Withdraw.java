package atmMachine;

import java.util.Scanner;

//subracts an Amount from the account balance
public class Withdraw 
{
	static String name = "Withdawal from Balance";
	public static void withdraw() 
	{
		double withdrawAmount;
		double accBalance;
		
		int choice;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Your balance is " + Account.getBalance());

		for(int i = 0; i < 3; i++)//user gets 3 tries
		{
			System.out.println("How much woul you like to withdraw?");
			withdrawAmount = scan.nextDouble();
			
			if(withdrawAmount >= Account.getBalance()) 
			{
				System.out.println("Withdrawal Amount is Greater than your Balance.\nPlease Try Again.");
			}
			else 
			{
				accBalance = Account.getBalance() - withdrawAmount;
				
				System.out.println("Your new balance is " + accBalance);
				Account.setBalance(accBalance);
				i += 2;
			}
		
		}
	}
}
//DO SOME TEST TO CHECK IF ITS RIGHT