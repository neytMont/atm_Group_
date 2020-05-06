package atmMachine;

import java.util.Scanner;

public class PrintReceipt
{
	public static void printReceipt()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like a Receipt?\n1. Yes\n2. No");
		int choice = scan.nextInt();
		
		if(choice == 1) 
		{
			System.out.println("ATM");
			System.out.println("Date:");
			System.out.println("Location: LONG-BEACH-CA");
			System.out.println("ATM #: 16542M");
			System.out.println("\nUser Card: " + Account.getCardNum());
			System.out.println("Transaction #:  5623");
			System.out.println("Total Balance: " + Account.getBalance());
			System.out.println("Thank you for using our ATM.");
			System.out.println("For questions, call RIFA\nBusiness customers call NATHAN");
		}
		else 
		{
			System.out.println("Thank you for using our ATM. Have a nice day.");
		}
	}
}
