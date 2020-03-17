package tests.De;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import framework.De;

public class setCurrentFaceTest {

	private De de1 = new De(4);
	
	/*
	 * Test de la methode setCurrentFace a un nombre valide
	 */
	@Test
	public void setFaceValidTest() {
		de1.setCurrentFace(1);
		int output = de1.getCurrentFace();
		assertEquals(1, output);
	}
	
	/*
	 * Test de la methode setCurrentFace a un nombre inferieur a 1.
	 * Devrait throw une exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void setFaceUnder1() {
		de1.setCurrentFace(0);
	}
	
	/*
	 * Test de la methode setCurrentFace a un nombre superieur a 6.
	 * Devrait throw une exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void setFaceOver6() {
		de1.setCurrentFace(7);
	}

}
