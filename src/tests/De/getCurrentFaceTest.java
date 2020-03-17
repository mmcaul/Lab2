package tests.De;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import framework.De;

class getCurrentFaceTest {

	@Test
	void test1() {
		De de1 = new De(4);
		de1.setCurrentFace(4);
		int output = de1.getCurrentFace();
		assertEquals(4, output);
	}
}
