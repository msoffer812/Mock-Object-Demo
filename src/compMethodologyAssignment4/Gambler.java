/**
 * a class that keeps a balance for a set of bets placed in different gambling games
 */
package compMethodologyAssignment4;

import java.util.InputMismatchException;

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
		return balance;
	}
	
	/**
	 * 
	 * @param amnt
	 * @return if the amount bet can go under minimum balance
	 */
	protected boolean canBet(double amnt)
	{
		if(amnt < 0)
		{
			return false;
		}
		return (balance - amnt) >= minBalance;
	}
	
	/**
	 * add given amount to the balance
	 * @param amnt
	 */
	public void addMoney(double amnt)
	{
		if(amnt > 0 && amnt <= (Integer.MAX_VALUE - balance))
		{
			balance += amnt;
		}
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
		if(canBet(amnt))
		{
			if(amnt <= 0)
			{
				throw new InputMismatchException("Gambled amount must be positive");
			} 
			int resultingNumber = randomValueGenerator.getRandomInt(min, max);
			if(selectedNumber == resultingNumber)
			{
				double winnings = betOnNumberWinnings(amnt, min, max);
				balance += winnings;
				return winnings;
			} 
			balance -= amnt;
			return amnt*-1;
		}
		return 0;
	}
	
	/**
	 * @return betOnNumber winnings amount
	 */
	private double betOnNumberWinnings(double amnt, int min, int max)
	{
		double range = (double)(max - min);
		return range * amnt;
	}
	
	/**
	 * 
	 * @param amnt
	 * @param probability
	 * @return winnings
	 */
	private double betOnProbabilityWinnings(double amnt, double probability)
	{
		double factor = Math.pow(probability, -1);
		return (factor-1)*amnt;
	}
	/**
	 * 
	 * @param amnt
	 * @param p
	 * @return amount balance was changed by the bet
	 */
	public double betOnProbability(double amnt, double p)
	{
		if(canBet(amnt))
		{
			if(amnt <= 0)
			{
				throw new InputMismatchException("Gambled amount must be positive");
			} 
			else if(p < 0 || p > 1)
			{
				throw new InputMismatchException("Probability must be between 0 and 1");
			}
			boolean won = randomValueGenerator.getBooleanProbability(p);
			if(won)
			{
				double winnings = betOnProbabilityWinnings(amnt, p);
				balance += winnings;
				return winnings;
			}
			balance -= amnt;
			return amnt*-1;
		}
		return 0;
	}
}
