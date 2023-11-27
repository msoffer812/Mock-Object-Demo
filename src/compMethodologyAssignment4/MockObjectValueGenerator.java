/**
 * Mock object that mimics the valid random number for testing
 */
package compMethodologyAssignment4;

public class MockObjectValueGenerator implements IRandomValueGenerator{
	double randomDouble;
	
	public MockObjectValueGenerator()
	{
		randomDouble = 0;
	}
	
	/**
	 * 
	 * set "random" double, used for unit testing
	 */
	public void setRandomDouble(double randomDouble)
	{
		this.randomDouble = randomDouble;
	}
	
	/**
	 * @return "random" int between two numbers
	 * get range,get random amount in the range, then add to min.
	 */
	@Override
	public int getRandomInt(int min, int max)
	{	
		int newRandomInt = 
				(int)Math.round((randomDouble * (max - min)) + min); 
		
		return newRandomInt;
	}
	
	/**
	 * @return boolean based on random probability happening
	 */
	@Override
	public boolean getBooleanProbability(double probability)
	{
		return randomDouble < probability;
	}
}

