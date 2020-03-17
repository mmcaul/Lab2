package tests.Iterators;

import framework.CollectionDes;
import framework.DeIterator;
import framework.De;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class deIteratorTest {

	De de1;
	De de2;
	De de3;
	CollectionDes colDe;
	DeIterator iterateurDe;
	
	@Before
	public void beforeTest() {
		de1 = new De(2);
		de2 = new De(3);
		de3 = new De(1);
		
		colDe = new CollectionDes(3);
		colDe.addDe(de1);
		colDe.addDe(de2);
		colDe.addDe(de3);
		
		iterateurDe = colDe.createIterator();
	}
	
	@Test
	public void nextTest() {
		De res = iterateurDe.next();
		assertEquals(res, de1);
	}
	
	@Test
	public void hasNextTrueTest() {
		assertEquals(iterateurDe.hasNext(), true);
	}
	
	@Test
	public void hasNextFalseTest() {
		colDe = new CollectionDes(1);
		colDe.addDe(de1);
		
		iterateurDe = colDe.createIterator();
		iterateurDe.next();
		
		assertEquals(iterateurDe.hasNext(), false);
	}
}
