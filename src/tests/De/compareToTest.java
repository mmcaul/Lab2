package tests.De;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import framework.De;

public class compareToTest {

    private De de1;
    private De de2;

    @Before
    public void faireAvant(){
        de1 = new De(6);
        de2 = new De(6);
    }

    /*
     * Faire le test de la methode setCurrentFace ou le de #2 est superieur au de #1
     */
    @Test
    public void deSuperieurTest(){
        de1.setCurrentFace(4);
        de2.setCurrentFace(5);
        assertEquals(1, de1.compareTo(de2));
    }
    
    /*
     * Faire le test de la methode setCurrentFace ou le de #1 est inferieur au de #2
     */
    @Test
    public void deInferieurTest(){
        de1.setCurrentFace(4);
        de2.setCurrentFace(5);
        assertEquals(de2.compareTo(de1), -1);
    }

    /*
     * Faire le test de la methode setCurrentFace ou la face de 2 des est le meme numero
     */
    @Test
    public void memeDeTest(){
        de1.setCurrentFace(4);
        de2.setCurrentFace(4);
        assertEquals(0, de1.compareTo(de2));
    }
    
    /*
     * Faire le test de la methode setCurrentFace ou il devrait avoir une exception
     * lorsqu'on compare le de a un de null
     */
    @Test(expected=IllegalArgumentException.class)
    public void deNullTest(){
        de1.setCurrentFace(4);
        de1.compareTo(null);
    }

}
