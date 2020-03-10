package tests.Jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import framework.*;

public class calculerScoreTourTest {

    @Test
    void test(){
        De de1 = new De(4);
        De de2 = new De(3);
        De de3 = new De(1);

        CollectionDes colDe = new CollectionDes(3);
        CollectionJoueur colJ = new CollectionJoueur(3);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

    }
}
