package compMethodologyAssignment4.testing.gamblerTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import compMethodologyAssignment4.Gambler;
import compMethodologyAssignment4.IRandomValueGenerator;
import compMethodologyAssignment4.MockObjectValueGenerator;
class betOnANumberTesting {

	Gambler gambler; 
	
	@BeforeAll
	void initializeGambler() {
		MockObjectValueGenerator valueGenerator = new MockObjectValueGenerator();
		valueGenerator.setRandomDouble(.37);			/*Set up "random" value generator to always generate .37 as the random factor */
		gambler = new Gambler(valueGenerator, -20); 	/* Set with the new valueGenerator and minimum balance is negative 20 */
	}
	
	@Test
	void twentyOneWithBalanceZeroAndMinimumBalanceOfTwentyWillNotBetOrAffectBalance() {
		assertEquals(0, gambler.getCurrentBalance());
		assertEquals(0, gambler.betOnANumber(21, 5, 10, 7));
		assertEquals(0, gambler.getCurrentBalance());
	}
	
	@Test 
	void fifteenWithBalanceZeroAndMinimumBalanceOfTwentyAndMinFiveMaxTenGuessSevenGeneratedThirtySevenReturnsSeventyFiveAndChangesCorrespondingBalance(){
		assertEquals(0, gambler.getCurrentBalance());
		assertEquals(75, gambler.betOnANumber(15, 5, 10, 7));
		assertEquals(75, gambler.getCurrentBalance());
	}
	
	@Test 
	void fifteenWithBalanceZeroAndMinimumBalanceOfTwentyAndMinFiveMaxTenGuessSixGeneratedThirtySevenReturnsNegativeFifteenAndChangesCorrespondingBalance(){
		assertEquals(0, gambler.getCurrentBalance());
		assertEquals(-15, gambler.betOnANumber(15, 5, 10, 6));
		assertEquals(-15, gambler.getCurrentBalance());
	}
	
	@Test 
	void negativeFifteenAmountThrowsInputMismatchException(){
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> gambler.betOnANumber(-15, 5, 10, 6));
	}
}
