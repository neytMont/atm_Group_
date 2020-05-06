package atmMachine;

public class Account
{
	static int cardNum;
	static int pinNum;
	static String balance;
	
	public Account(int card,int pin, String bal) 
	{
		Account.cardNum = card;
		Account.pinNum = pin;
		Account.balance = bal;
	}
	
	/**
	 * Gets the Balance in the Account.
	 * 
	 * @return balance. Balance as a double.
	 */
	public static double getBalance()
	{
		return Double.parseDouble(balance);
	} // End of getBalance

	public static int getCardNum() 
	{
		return cardNum;
	}

	/**
	 * Sets the Balance in the Account.
	 * 
	 * @param balance is the Balance in the Account.
	 */
	public static void setBalance(double bal) 
	{
		
		if (Double.parseDouble(balance) >= 0)
		{
			balance = String.valueOf(bal);
		} // End of if-statement
	} // End of setBalance
}
