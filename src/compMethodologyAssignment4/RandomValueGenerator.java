/**
 * returns a random double
 */
package compMethodologyAssignment4;

import java.util.Random;

public class RandomValueGenerator implements IRandomValueGenerator
{
	Random rand;
	/**
	 * constructor to generate new random object
	 */
	public RandomValueGenerator()
	{
		rand = new Random();
	}
	
	/**
	 * 
	 * @return random double, used in the two methods
	 */
	private double getRandomDouble()
	{
		return rand.nextDouble();
	}
	
	/**
	 * @return random int between two numbers
	 * get range,get random amount in the range, then add to min.
	 */
	@Override
	public int getRandomInt(int min, int max)
	{
		double randomDouble = getRandomDouble();
		
		int newRandomInt = 
				(int)Math.round((randomDouble * (max - min)) + min); 
		
		return newRandomInt;
	}
	
	/**
	 * @return boolean based on random probability happening
	 * < because inclusive of zero but not 1
	 */
	@Override
	public boolean getBooleanProbability(double probability)
	{
		return getRandomDouble() < probability;
	}
}
