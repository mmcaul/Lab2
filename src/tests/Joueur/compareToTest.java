package tests.Joueur;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import framework.Joueur;

public class compareToTest {

	private Joueur joueur1;
	private Joueur joueur2;
	
	@Test
	public void numInferieurTest() {
		assertEquals(joueur1.compareTo(joueur2), 1);
	}
	
	@Test
	public void numSuperieurTest() {
		assertEquals(joueur2.compareTo(joueur1), -1);
	}
	
	@Test
	public void numEgalTest() {
		joueur2 = new Joueur(0);
		assertEquals(joueur1.compareTo(joueur2), 0);
	}
}
