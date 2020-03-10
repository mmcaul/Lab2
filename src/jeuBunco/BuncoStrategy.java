package jeuBunco;

import framework.Jeu;
import framework.*;
import framework.Joueur;

public class BuncoStrategy extends Jeu {
    static final int MAX_TOURS = 6;
    static final int DE_PAR_TOUR = 3;

    public BuncoStrategy(CollectionDes collectionDes, CollectionJoueur collectionJoueur,
                         int numTours, GameStrategy strategieJeu){
        super(collectionDes, collectionJoueur, numTours, strategieJeu);
    }

    @Override
    public int calculerScoreTour() {
        int scoreTot = 0;

        while (deIterator.hasNext()) {
            int scoreRoll = 0;

            for (int i = 0; i < DE_PAR_TOUR; i++) {
                if (deIterator.get(i).getCurrentFace() == numTours) {
                    scoreRoll++;
                }
            }
            if (scoreRoll == 3) {
                scoreTot += BUNCO;
            } else {
                scoreTot += scoreRoll;
            }
        }

        return 0;
    }

    @Override
    public Joueur calculerLeVaiqueur() {
        Joueur winner = new Joueur(1); //NOT OFFICIAL, need to implement strategy

        return winner;
    }

}
