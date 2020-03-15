package tests.Jeu;

import static org.junit.jupiter.api.Assertions.*;

import jeuBunco.BuncoStrategy;
import org.junit.jupiter.api.Test;

import framework.*;

public class calculerScoreTourTest {

    @Test
    void test(){

        BuncoStrategy newGame = new BuncoStrategy();

        De de1 = new De(4);
        De de2 = new De(4);
        De de3 = new De(4);

        de1.setCurrentFace(4);
        de2.setCurrentFace(2);
        de3.setCurrentFace(1);

        CollectionDes colDe = new CollectionDes(3);
        CollectionJoueur colJ = new CollectionJoueur(3);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

    }
}
