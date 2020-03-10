package jeuBunco;

import framework.Jeu;
import framework.*;
import framework.Joueur;

public class BuncoStrategy extends Jeu {

    private static final int MAX_TOURS = 6;
    private static final int DE_PAR_TOUR = 3;
    private static final int BUNCO = 21;

    /*public BuncoStrategy(CollectionDes collectionDes, CollectionJoueur collectionJoueur,
                         int numTours, GameStrategy strategieJeu){
        super(collectionDes, collectionJoueur, numTours, strategieJeu);
    }*/

    @Override
    public void calculerScoreTour(Joueur joueurCourant, int tourCourant) {

        int scoreTourBunco, scoreTour, scoreTourTotal = 0;
        int scoreDe = 0;
        De currentDe;
        De previousDe = null;

        while(scoreDe == tourCourant) {
            while(deIterator.hasNext()){
                scoreTour = 0;
                scoreTourBunco = 0;

                currentDe = deIterator.next();

                currentDe.rollDe();

                scoreDe = currentDe.getCurrentFace();

                if (scoreDe == tourCourant) {
                    scoreTourBunco++;
                }
                if(previousDe != null){
                    if (currentDe.compareTo(previousDe) == 0) {
                        scoreTour++;
                    }
                }
                previousDe = currentDe;

                if(scoreTourBunco == DE_PAR_TOUR) {
                    scoreTourTotal = BUNCO;
                } else if(scoreTour == DE_PAR_TOUR) {
                    scoreTourTotal = 5;
                } else if(scoreTour == 0){
                    joueurCourant.setScore(scoreTourTotal);
                } else {
                    scoreTourTotal += scoreTourBunco;
                }
                joueurCourant.setScore(scoreTourTotal);
            }
        }


    }

    @Override
    public Joueur calculerLeVaiqueur() {
        Joueur winner = new Joueur(1); //NOT OFFICIAL, need to implement strategy

        return winner;
    }

}
