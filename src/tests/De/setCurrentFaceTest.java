package tests.De;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import framework.De;

class setCurrentFaceTest {

	@Test
	void test1() {
		De de1 = new De(4);
		de1.setCurrentFace(1);
		int output = de1.getCurrentFace();
		assertEquals(1, output);
	}

}
