package jeuBunco;

import framework.Jeu;
import framework.*;
import framework.Joueur;

public class BuncoStrategy extends Jeu {

    static final int MAX_TOURS = 6;
    static final int DE_PAR_TOUR = 3;
    static final int BUNCO = 21;

    public BuncoStrategy(CollectionDes collectionDes, CollectionJoueur collectionJoueur,
                         int numTours, GameStrategy strategieJeu){
        super(collectionDes, collectionJoueur, numTours, strategieJeu);
    }

    @Override
    public void calculerScoreTour() {

        int scoreTourJoueur = 0;

        while(joueurIterator.hasNext()){
            Joueur joueurCourant = joueurIterator.next();

            while(deIterator.hasNext()){
                int scoreRoll = 0;

                for (int i = 0; i < DE_PAR_TOUR; i++) {
                    if (deIterator.next().getCurrentFace() == numTours) {
                        scoreRoll++;
                    }
                }
                if (scoreRoll == 3) {
                    scoreTourJoueur += BUNCO;
                } else {
                    scoreTourJoueur += scoreRoll;
                }
            }
            joueurCourant.setScore(scoreTourJoueur);
        }
    }

    @Override
    public Joueur calculerLeVaiqueur() {
        Joueur winner = new Joueur(1); //NOT OFFICIAL, need to implement strategy

        return winner;
    }

}