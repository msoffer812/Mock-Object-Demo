package compMethodologyAssignment4.testing.gamblerTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compMethodologyAssignment4.Gambler;
import compMethodologyAssignment4.MockObjectValueGenerator;

class AddMoneyTesting {

	private Gambler gambler;
	
	@BeforeEach
	void initializeGamblerObject() {
		gambler = new Gambler(new MockObjectValueGenerator(), -5);
	}
	
	@Test
	void negativeSevenDoesNotAffectBalance()
	{
		assertEquals(gambler.getCurrentBalance(), 0);
		gambler.addMoney(-7);
		assertEquals(gambler.getCurrentBalance(), 0);
	}
	
	@Test
	void greaterThanMaxIntegerDoesNotAffectBalance()
	{
		assertEquals(gambler.getCurrentBalance(), 0);
		gambler.addMoney(Integer.MAX_VALUE + 1);
		assertEquals(gambler.getCurrentBalance(), 0);
	}
	
	@Test
	void numberThatIncreasesBalanceToPastMaxIntegerValueHasNoEffectOnBalance()
	{
		assertEquals(gambler.getCurrentBalance(), 0);
		gambler.addMoney(5);
		assertEquals(gambler.getCurrentBalance(), 5);
		gambler.addMoney(Integer.MAX_VALUE - 4);
		assertEquals(gambler.getCurrentBalance(), 5);
	}
	
	@Test
	void tenAddsTenToBalance()
	{
		assertEquals(gambler.getCurrentBalance(), 0);
		gambler.addMoney(10);
		assertEquals(gambler.getCurrentBalance(), 10);
	}

}
