package tests.Jeu;

import jeuBunco.BuncoStrategy;
import org.junit.jupiter.api.Test;

import framework.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class jeuBuncoTest {

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

        newGame.calculerScoreTour(jIt.next(), deIt,4);

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

<<<<<<< HEAD:src/tests/Jeu/calculerScoreTourTest.java
        Joueur jCourant = jIt.next();

        int score = newGame.calculerScoreTour(jCourant, deIt,2);

        jCourant.setScore(score);

        assertEquals(5, jCourant.getScore());
=======
        int res = newGame.calculerScoreTour(jIt.next(), deIt,2);

        assertEquals(5, res);
>>>>>>> 3564cd8eb0055a14c71e3a022c22dbe014f94e95:src/tests/Jeu/jeuBuncoTest.java
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
        De de2 = new De(4);
        De de3 = new De(4);

        colDe.addDe(de1);
        colDe.addDe(de2);
        colDe.addDe(de3);

        Joueur jCourant = jIt.next();

        int runningScore = 0;

        for(int i=4; i>0; i--){
            de1.setCurrentFace(i);
            de2.setCurrentFace(1);
            de3.setCurrentFace(2);

            DeIterator deIt = colDe.createIterator();

            newGame.setTabNbDes(colDe);
            newGame.setDeIterator(deIt);

            int score = newGame.calculerScoreTour(jCourant, deIt,4);

            if(score == 0 || score == 21){
                runningScore += score;
                break;
            } else{
                runningScore += score;
            }
        }

        jCourant.setScore(runningScore);

        assertEquals(1, j1.getScore());

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

        newGame.calculerScoreTour(j1, deIt,4);

        assertEquals(0, j1.getScore());
        assertEquals(1, j1.compareTo(j2));
    }

    @Test
    void calculerVainqueurTest(){
    	
    }
}
