package tests.De;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import framework.De;
import org.junit.jupiter.api.Test;

public class rollDeTest {

	@Test
	void test() {
		
		De de1 = new De(6);
		de1.setCurrentFace(4);
		int firstRoll = de1.getCurrentFace();
		de1.rollDe();
		int secondRoll = de1.getCurrentFace();
		assertNotEquals(firstRoll,secondRoll);
	}

}
