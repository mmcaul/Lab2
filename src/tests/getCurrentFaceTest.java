package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import framework.De;

class getCurrentFaceTest {

	@Test
	void test1() {
		De de1 = new De(4);
		int output = de1.getCurrentFace();
		assertEquals(4, output);
	}
}
