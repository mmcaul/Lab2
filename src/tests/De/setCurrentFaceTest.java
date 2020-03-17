package tests.De;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import framework.De;

public class setCurrentFaceTest {

	private De de1 = new De(4);
	
	@Test
	public void test() {
		de1.setCurrentFace(1);
		int output = de1.getCurrentFace();
		assertEquals(1, output);
	}
	
    @Test(expected=IllegalArgumentException.class)
    public void deNullTest(){
        de1.setCurrentFace(4);
        de1.compareTo(null);
    }

}
