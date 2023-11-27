/**
 * a class that keeps a balance for a set of bets placed in different gambling games
 */
package compMethodologyAssignment4;

public class Gambler 
{
	IRandomValueGenerator randomValueGenerator;		/* Class that generates a random value */
	double balance;									/* the user's balance that changes depending on their bets */
	double minBalance;								/* Minimum balance after which the balance cannot go under */
	
	public Gambler(IRandomValueGenerator randomValueGenerator, 
			double minBalance)
	{
		this.randomValueGenerator = randomValueGenerator;
		this.minBalance = minBalance;
		this.balance = 0;
	}
	
	/**
	 * 
	 * @return the current balance
	 */
	public double getCurrentBalance()
	{
		return 5;
	}
	
	/**
	 * 
	 * @param amnt
	 * @return if the amount bet can go under minimum balance
	 */
	public boolean canBet(double amnt)
	{
		return true;
	}
	
	/**
	 * add given amount to the balance
	 * @param amnt
	 */
	public void addMoney(double amnt)
	{
		balance += amnt;
	}
	
	/**
	 * 
	 * @param amnt
	 * @param min
	 * @param max
	 * @param selectedNumber
	 * @return amount balance was changed by the bet
	 */
	public double betOnANumber(double amnt, int min, int max, int selectedNumber)
	{
		return 0;
	}
	
	/**
	 * 
	 * @param amnt
	 * @param p
	 * @return amount balance was changed by the bet
	 */
	public double betOnProbability(double amnt, double p)
	{
		return 0;
	}
}
