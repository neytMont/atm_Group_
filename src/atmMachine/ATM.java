package atmMachine;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ATM
{
	public static void main(String args[]) 
	{
		int cardNumberFromFile = 0;//holder of the cardNumber
		int pinNumberFromFile = 0;//holder of the pinNumber
		String balanceFromFile = null;//holder of balance that is on the file. String so that it can read
		
		Scanner sc = new Scanner(System.in);
		List<String> lines = null;
		
		System.out.println("==========================================================================================");
		System.out.println("==========================================================================================");
		System.out.println(
				"888       888          888                                                888                       \r\n" + 
				"888   o   888          888                                                888                       \r\n" + 
				"888  d8b  888          888                                                888                       \r\n" + 
				"888 d888b 888  .d88b.  888  .d8888b  .d88b.  88888b.d88b.   .d88b.        888888  .d88b.            \r\n" + 
				"888d88888b888 d8P  Y8b 888 d88P\"    d88\"\"88b 888 \"888 \"88b d8P  Y8b       888    d88\"\"88b           \r\n" + 
				"88888P Y88888 88888888 888 888      888  888 888  888  888 88888888       888    888  888           \r\n" + 
				"8888P   Y8888 Y8b.     888 Y88b.    Y88..88P 888  888  888 Y8b.           Y88b.  Y88..88P           \r\n" + 
				"888P     Y888  \"Y8888  888  \"Y8888P  \"Y88P\"  888  888  888  \"Y8888         \"Y888  \"Y88P\"            \r\n" + 
				"                                                                                                    \r\n" + 
				"   8888888b.   .d8888b.     888b    888              d8888 88888888888 888b     d888 \r\n" + 
				"   888   Y88b d88P  \"88b    8888b   888             d88888     888     8888b   d8888 \r\n" + 
				"   888    888 Y88b. d88P    88888b  888            d88P888     888     88888b.d88888 \r\n" + 
				"   888   d88P  \"Y8888P\"     888Y88b 888           d88P 888     888     888Y88888P888 \r\n" + 
				"   8888888P\"  .d88P88K.d88P 888 Y88b888          d88P  888     888     888 Y888P 888 \r\n" + 
				"   888 T88b   888\"  Y888P\"  888  Y88888         d88P   888     888     888  Y8P  888 \r\n" + 
				"   888  T88b  Y88b .d8888b  888   Y8888        d8888888888     888     888   \"   888 \r\n" + 
				"   888   T88b  \"Y8888P\" Y88b888    Y888       d88P     888     888     888       888");
		System.out.println("==========================================================================================");
		System.out.println("==========================================================================================\n\n\n");

		System.out.println("===========================================");
		System.out.print("Please Enter Card Number: "); // give a 6 digit card num
		String cardNum1 = sc.next();//takes the card number from user
		boolean willUserExit = false;
		
		try 
		{
			Path fileScan = Paths.get(cardNum1 + ".txt");//search for card num text file
			lines = Files.readAllLines(fileScan);//put all lines in a List of strings
			cardNumberFromFile = Integer.parseInt(lines.get(0));//the card number that is on the file(file name)
			pinNumberFromFile = Integer.parseInt(lines.get(1));//the pin number that is on the file
			balanceFromFile = lines.get(2);//balance amount on the file
		}
		/**Expexted in the file
		 * line 0 => card number
		 * line 1 => pin number
		 * line 2 => checking balance
		 */
		catch(Exception e) 
		{
			System.out.println("Error: Card does not Exist");
			System.exit(0);
		}

		//fix pin number attempts
		for(int i = 0; i < 3; i++) 
		{
			System.out.print("Please Enter Pin Number : "); // 5 digit pin num
			//if card num and pin num are right then thats when you get this menu
			//if not the program will exit after 3 tries
			try 
			{
				String pinNum = sc.next();
				
				if(Integer.parseInt(pinNum) == pinNumberFromFile) 
				{
					i += 2;
					Account userBankAccount = new Account(cardNumberFromFile, pinNumberFromFile, balanceFromFile);//THE ACCOUNT OF THE CURRENT USER
					
					//WELCOME Message
					System.out.println("===========================================\n\n");
					System.out.println("Hello, Welcome to your Bank Account");
					//after the program has the balance show this menu
					while(!willUserExit) 
					{
						menuChoice();
						//return to menu
						System.out.println("Would like to return to MENU?");
						System.out.println("1. Yes\n2. No");
						int userReturn = sc.nextInt();
						
						if(userReturn == 1) 
						{
							willUserExit = false;
						}
						else if(userReturn == 2) 
						{
							willUserExit = true;
						}
					}
					//print the receipt
					PrintReceipt.printReceipt();
				}
				else //else if the pin number entered by the user is right
				{
					System.out.println("Wrong Pin Number. Please try again");
					if(i == 2) //if the user has used the 3 attempts. else go back to loop
					{
						System.out.println("Login Attempt Exceeded Allowed Ammount.");
						System.exit(0);
					}	
				}
			}
			catch(NumberFormatException ex) 
			{
				System.out.println("Error: Wrong Pin Number. Please try again");
			}
		}//end of for loop pin num verification
		
		//save to file
		//opens the same text then writes the new balance	
		try 
		{
			String numCard = String.valueOf(Account.cardNum);//string val of card num
			String numPin = String.valueOf(Account.pinNum);//string val of pin num
			String numBalance = String.valueOf(Account.balance);//string val of balance
			
			FileWriter fw = new FileWriter(numCard + ".txt");
			fw.write(numCard + "\n" + numPin + "\n" + numBalance);
			fw.close();
		}
		catch(Exception e)
		{
			System.out.print("Writing to file problem");
		}
		

	
	} // End of menu
	
	public static void menuChoice() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose from the following Transactions or Exit.");
		System.out.println("1 - Deposit Funds.");
		System.out.println("2 - Withdraw Funds.");
		System.out.println("3 - Check Balance.");
		System.out.println("4 - Transfer Balance.");
		System.out.println("5 - Exit.");
		
		int choice = sc.nextInt();//choice for menu
		//switch case to send to diff class
		switch(choice) 
		{
			case 1:
				Deposit.deposit();
				break;
			case 2:
				Withdraw.withdraw();
				break;
			case 3:
				CheckBalance.checkBalance();
				break;
			case 4:
				TransferFund.transferFund();
				break;
			case 5:
				System.out.println("Thank you for using our ATM. Have a nice day.");
				System.exit(0);					
		}
	}
} // End of ATM class

