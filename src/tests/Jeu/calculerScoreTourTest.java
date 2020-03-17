package tests.Jeu;

import jeuBunco.BuncoStrategy;
import org.junit.jupiter.api.Test;

import framework.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculerScoreTourTest {

    @Test
    void BuncoTest(){

        /**
         * Ce test fonctionne mais nous devons mettre en commentaire l'appel
         * a la methode rollDe() dans calculerScoreTour de la class BuncoStrategy
         * pour assurer que nvons la bonne face pour un Bunco
         */
    	
        Jeu newGame = new BuncoStrategy();

        CollectionDes colDe = new CollectionDes(3);
        CollectionJoueur colJ = new CollectionJoueur(2);
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        colJ.addJoueur(j1);
        colJ.addJoueur(j2);

        JoueurIterator jIt = colJ.createIterator();

        De de1 = new De(4);
        de1.setCurrentFace(4);
        De de2 = new De(4);
        de2.setCurrentFace(4);
        De de3 = new De(4);
        de3.setCurrentFace(4);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

        DeIterator deIt = colDe.createIterator();
        newGame.setTabNbDes(colDe);
        newGame.setDeIterator(deIt);

        newGame.calculerScoreTour(jIt, deIt,4);

        assertEquals(21, j1.getScore());
        assertEquals(1, j1.compareTo(j2));
    }

    @Test
    void TroisMauvaisTour(){

        /**
         * Ce test fonctionne mais nous devons mettre en commentaire l'appel
         * a la methode rollDe() dans calculerScoreTour de la class BuncoStrategy
         * pour assurer que nous avons la bonne face pour un Bunco
         */

        Jeu newGame = new BuncoStrategy();

        CollectionDes colDe = new CollectionDes(3);
        CollectionJoueur colJ = new CollectionJoueur(2);
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        colJ.addJoueur(j1);
        colJ.addJoueur(j2);

        JoueurIterator jIt = colJ.createIterator();

        De de1 = new De(4);
        de1.setCurrentFace(4);
        De de2 = new De(4);
        de2.setCurrentFace(4);
        De de3 = new De(4);
        de3.setCurrentFace(4);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

        DeIterator deIt = colDe.createIterator();
        newGame.setTabNbDes(colDe);
        newGame.setDeIterator(deIt);

        newGame.calculerScoreTour(jIt, deIt,2);

        assertEquals(5, j1.getScore());
    }

    @Test
    void MoinsTroisBonTour(){

        /**
         * Ce test fonctionne mais nous devons mettre en commentaire l'appel
         * a la methode rollDe() dans calculerScoreTour de la class BuncoStrategy
         * pour assurer que nous avons la bonne face pour un Bunco
         */

        Jeu newGame = new BuncoStrategy();

        CollectionDes colDe = new CollectionDes(3);
        CollectionJoueur colJ = new CollectionJoueur(2);
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        colJ.addJoueur(j1);
        colJ.addJoueur(j2);

        JoueurIterator jIt = colJ.createIterator();

        De de1 = new De(4);
        de1.setCurrentFace(4);
        De de2 = new De(4);
        de2.setCurrentFace(3);
        De de3 = new De(4);
        de3.setCurrentFace(2);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

        DeIterator deIt = colDe.createIterator();
        newGame.setTabNbDes(colDe);
        newGame.setDeIterator(deIt);

        newGame.calculerScoreTour(jIt, deIt,4);

        assertEquals(1, j1.getScore());
        //NEED TO FIND A WAY TO PROVE SAME PLAYER!!!!
    }

    @Test
    void ZeroProchainJoueur(){

        /**
         * Ce test fonctionne mais nous devons mettre en commentaire l'appel
         * a la methode rollDe() dans calculerScoreTour de la class BuncoStrategy
         * pour assurer que nous avons la bonne face pour un Bunco
         */

        Jeu newGame = new BuncoStrategy();

        CollectionDes colDe = new CollectionDes(3);
        CollectionJoueur colJ = new CollectionJoueur(2);
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        colJ.addJoueur(j1);
        colJ.addJoueur(j2);

        JoueurIterator jIt = colJ.createIterator();

        De de1 = new De(4);
        de1.setCurrentFace(1);
        De de2 = new De(4);
        de2.setCurrentFace(3);
        De de3 = new De(4);
        de3.setCurrentFace(2);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

        DeIterator deIt = colDe.createIterator();
        newGame.setTabNbDes(colDe);
        newGame.setDeIterator(deIt);

        newGame.calculerScoreTour(jIt, deIt,4);

        assertEquals(0, j1.getScore());
        assertEquals(1, j1.compareTo(j2));
    }

    @Test
    void ClassementFinal(){


    }
}
