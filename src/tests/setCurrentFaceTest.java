package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.FacesException;
import framework.De;

class setCurrentFaceTest {

	@Test
	void test1() throws FacesException {
		De de1 = new De(4);
		de1.setCurrentFace(1);
		int output = de1.getCurrentFace();
		assertEquals(1, output);
	}
	
	@Test
	void test2() throws FacesException {
		De de1 = new De(1);
		assertThrows(FacesException.class, () -> de1.setCurrentFace(7));
	}
	
	@Test
	void test3() throws FacesException {
		De de1 = new De(2);
		assertThrows(FacesException.class, () -> de1.setCurrentFace(0));
	}

}
