package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import framework.De;

class compareToTest {

	@Test
	void inferiorTest() {
		De de1 = new De(4);
		De de2 = new De(5);
		int output = de1.compareTo(de2);
		assertEquals(1, output);
	}
	
	@Test
	void superiorTest() {
		De de1 = new De(4);
		De de2 = new De(5);
		int output = de2.compareTo(de1);
		assertEquals(-1, output);
	}
	
	@Test
	void equalsTest() {
		De de1 = new De(3);
		De de2 = new De(3);
		int output = de1.compareTo(de2);
		assertEquals(0, output);
	}

}
