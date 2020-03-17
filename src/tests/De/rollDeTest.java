package tests.De;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import framework.De;

public class rollDeTest {

	/*
	 * Test de la methode rollDe qui permet de roll la face du de aleatoirement
	 */
	@Test
	public void rollDeTest() {
		
		De de1 = new De(6);
		de1.setCurrentFace(4);
		int firstRoll = de1.getCurrentFace();
		de1.rollDe();
		int secondRoll = de1.getCurrentFace();
		
		/*
		 * Tant que le numero du de rouler est identique qu'au depart, on le roll encore.
		 * Ceci est fait pour bien verifier que le de puisse roll correctement
		 */
		if (firstRoll == secondRoll) {
			de1.rollDe();
			secondRoll = de1.getCurrentFace();
		}
		
		assertNotEquals(firstRoll,secondRoll);
	}

}
