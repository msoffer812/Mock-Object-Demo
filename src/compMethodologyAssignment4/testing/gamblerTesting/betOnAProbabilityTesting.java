package compMethodologyAssignment4.testing.gamblerTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import compMethodologyAssignment4.Gambler;
import compMethodologyAssignment4.IRandomValueGenerator;
import compMethodologyAssignment4.MockObjectValueGenerator;
class betOnAProbabilityTesting {

	Gambler gambler; 
	
	@BeforeAll
	void initializeGambler() {
		MockObjectValueGenerator valueGenerator = new MockObjectValueGenerator();
		valueGenerator.setRandomDouble(.37);			/*Set up "random" value generator to always generate .37 as the random factor */
		gambler = new Gambler(valueGenerator, -20); 	/* Set with the new valueGenerator and minimum balance is negative 20 */
	}
	
	@Test
	void gambleOfTwentyOneWithBalanceZeroAndMinimumBalanceOfTwentyWillNotBetOrAffectBalance() {
		assertEquals(0, gambler.getCurrentBalance());
		assertEquals(0, gambler.betOnProbability(21, .30));
		assertEquals(0, gambler.getCurrentBalance());
	}
	
	@Test 
	void gambleOfFifteenWithProbabilityThirtyAndRandomGeneratorThirtyReturnsNegativeFifteenAndChangesBalance(){
		assertEquals(0, gambler.getCurrentBalance());
		assertEquals(-15, gambler.betOnProbability(15, .29));
		assertEquals(-15, gambler.getCurrentBalance());
	}
	
	@Test 
	void gambleOfFifteenWithProbabilityThirtyAndRandomGeneratorTwentyNineReturnsThirtyFiveAndChangesBalance(){
		assertEquals(0, gambler.getCurrentBalance());
		assertEquals(35, gambler.betOnProbability(15, .30));
		assertEquals(35, gambler.getCurrentBalance());
	}
	
	@Test 
	void negativeFifteenPercentProbabilityAmountThrowsInputMismatchException(){
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> gambler.betOnProbability(5, -.15));
	}
}
