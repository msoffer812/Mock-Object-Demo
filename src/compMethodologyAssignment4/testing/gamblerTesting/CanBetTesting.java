/**
 * extends Gambler to access protected method of canBet();
 */
package compMethodologyAssignment4.testing.gamblerTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compMethodologyAssignment4.Gambler;
import compMethodologyAssignment4.IRandomValueGenerator;
import compMethodologyAssignment4.MockObjectValueGenerator;

class CanBetTesting extends Gambler{

	public CanBetTesting() {
		super(new MockObjectValueGenerator(), -27);
		addMoney(100);
	}

	@Test
	void twoHundredWithHundredBalanceAndNegativeTwentySevenMinimumReturnsFalse()
	{
		assertFalse(canBet(200));
	}
	
	@Test
	void seventyFourWithHundredBalanceAndNegativeTwentySevenMinimumReturnsTrue()
	{
		assertTrue(canBet(74));
	}
	
	@Test
	void seventyFiveWithHundredBalanceAndNegativeTwentySevenMinimumReturnsFalse()
	{
		assertFalse(canBet(128));
	}
	
	@Test
	void fiveWithHundredBalanceAndNegativeTwentySevenMinimumReturnsTrue()
	{
		assertTrue(canBet(5));
	}
	
	@Test
	void negativeFiveWithHundredBalanceAndNegativeTwentySevenMinimumReturnsFalse()
	{
		assertFalse(canBet(-5));
	}
}
