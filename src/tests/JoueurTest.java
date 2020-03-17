package tests;

import framework.Joueur;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JoueurTest {
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	@Before
	public void faireAvant() {
		joueur1 = new Joueur(0);
		joueur2 = new Joueur(1);
	}
	
	@Test
	public void numJoueur1Test() {
		int numero = joueur1.getNumJoueur();
		assertEquals(numero, 0);
	}
	
	@Test
	public void numJoueur2Test() {
		int numero = joueur2.getNumJoueur();
		assertEquals(numero, 1);
	}
	
	@Test
	public void getScoreJoueurTest() {
		int score = joueur1.getScore();
		assertEquals(score, 0);
	}
	
	@Test
	public void setScoreJoueurTest() {
		joueur1.setScore(1);
		assertEquals(joueur1.getScore(), 1);
	}
	

	
}
