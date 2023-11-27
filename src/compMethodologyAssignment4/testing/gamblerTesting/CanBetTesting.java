package compMethodologyAssignment4.testing.gamblerTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compMethodologyAssignment4.Gambler;
import compMethodologyAssignment4.IRandomValueGenerator;
import compMethodologyAssignment4.MockObjectValueGenerator;

class CanBetTesting{

	Gambler gambler;
	
	@BeforeAll
	void initializeGambler()
	{
		gambler = new Gambler(new MockObjectValueGenerator(), -27);
		gambler.addMoney(100);
	}
	
	@Test
	void twoHundredWithHundredBalanceAndNegativeTwentySevenMinimumReturnsFalse()
	{
		assertFalse(gambler.canBet(200));
	}
	
	@Test
	void seventyFourWithHundredBalanceAndNegativeTwentySevenMinimumReturnsTrue()
	{
		assertTrue(gambler.canBet(74));
	}
	
	@Test
	void seventyFiveWithHundredBalanceAndNegativeTwentySevenMinimumReturnsFalse()
	{
		assertFalse(gambler.canBet(75));
	}
	
	@Test
	void fiveWithHundredBalanceAndNegativeTwentySevenMinimumReturnsTrue()
	{
		assertTrue(gambler.canBet(5));
	}
	
	@Test
	void negativeFiveWithHundredBalanceAndNegativeTwentySevenMinimumReturnsFalse()
	{
		assertFalse(gambler.canBet(-5));
	}
}
