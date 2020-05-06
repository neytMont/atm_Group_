package atmMachine;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;



//transfers fund from one file to another
public class TransferFund
{
	public static void transferFund() 
	{
		double transferAmount;//amount to be transfered 
		
		Scanner scan = new Scanner(System.in);
		System.out.println("==================TRANSFER================");
		System.out.println("Your balance is " + Account.getBalance());//balance from the user
		
		for(int i = 0; i < 3; i++)//user gets 3 tries
		{
			System.out.println("How much would you like to Transfer?");
			transferAmount = scan.nextDouble();
			
			if(transferAmount >= Account.getBalance()) 
			{
				System.out.println("Transfer Amount is Greater than your Balance.\nPlease Try Again.");
			}
			else 
			{
				double newBalance = Double.parseDouble(Account.balance) - transferAmount;//for the user that is transferring
				
				System.out.println("Enter the Card Number of the Person you want to transfer the money ");
				
				int cardNum2 = scan.nextInt();//accound that the money is being transferred to
				try 
				{
					Path fileScan = Paths.get(cardNum2 + ".txt");//find the file with the card num
					List<String> lines = Files.readAllLines(fileScan);//make the list 
					String numCard2 = lines.get(0);
					String numPin2 = lines.get(1);
					String balanceFromFile2 = lines.get(2);//take the third num. account balance of the transfee
				
					double accBalance2 = Double.parseDouble(balanceFromFile2) + transferAmount;//add the transfer amount
					
					FileWriter fw = new FileWriter(numCard2 + ".txt");
					fw.write(numCard2 + "\n" + numPin2 + "\n" + accBalance2);
					fw.close();
					
					System.out.println("Transfer was successful");
				}
				catch(Exception e) 
				{
					System.out.println("Card does not Exist");
					System.exit(0);
				}
				Account.setBalance(newBalance);
				System.out.println("==========================================");
				i += 2;
			}
		}
	}
}
