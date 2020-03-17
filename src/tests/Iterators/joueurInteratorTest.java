package tests.Iterators;

import framework.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class joueurInteratorTest {

	Joueur joueur1;
	Joueur joueur2;
	Joueur joueur3;
	CollectionJoueur colJoueur;
	JoueurIterator iterateurJoueur;
	
	@Before
	public void beforeTest() {
		joueur1 = new Joueur(0);
		joueur2 = new Joueur(1);
		joueur3 = new Joueur(2);
		
		colJoueur = new CollectionJoueur(3);
		colJoueur.addJoueur(joueur1);
		colJoueur.addJoueur(joueur2);
		colJoueur.addJoueur(joueur3);
		
		iterateurJoueur = colJoueur.createIterator();
	}
	
	@Test
	public void nextTest() {
		Joueur res = iterateurJoueur.next();
		assertEquals(res, joueur1);
	}
	
	@Test
	public void hasNextTrueTest() {
		assertEquals(iterateurJoueur.hasNext(), true);
	}
	
	@Test
	public void hasNextFalseTest() {
		colJoueur = new CollectionJoueur(1);
		colJoueur.addJoueur(joueur1);
		
		iterateurJoueur = colJoueur.createIterator();
		iterateurJoueur.next();
		
		assertEquals(iterateurJoueur.hasNext(), false);
	}
}
