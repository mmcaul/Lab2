package tests.De;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import framework.De;

public class getCurrentFaceTest {

	/*
	 * Test de la methode getCurrentFace
	 */
	@Test
	public void getCurrentFaceTest() {
		De de1 = new De(4);
		de1.setCurrentFace(4);
		int output = de1.getCurrentFace();
		assertEquals(4, output);
	}
}
