package tests;

import framework.De;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DeTest {

    private De de1;
    private De de2;

    @Before
    public void faireAvant(){
        de1 = new De(6);
        de2 = new De(6);
    }

    @Test
    public void deSuperieurTest(){
        de1.setCurrentFace(4);
        de2.setCurrentFace(5);
        assertEquals(1, de1.compareTo(de2));
    }

    @Test
    public void deInferieurTest(){
        de1.setCurrentFace(4);
        de2.setCurrentFace(5);
        assertEquals(de2.compareTo(de1), -1);
    }

    @Test
    public void memeDeTest(){
        de1.setCurrentFace(4);
        assertEquals(0, de1.compareTo(de1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void deNullTest(){
        de1.setCurrentFace(4);
        de1.compareTo(null);
    }
}
