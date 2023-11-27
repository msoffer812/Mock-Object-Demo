/**
 * Interface for random number generator
 */
package compMethodologyAssignment4;

public interface IRandomValueGenerator {
	public double getRandomInt(int min, int max);
	public boolean getBooleanProbability(double probability);
}
