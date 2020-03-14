package jeuBunco;

import framework.Jeu;
import framework.*;
import framework.Joueur;

public class BuncoStrategy extends Jeu {

    private static final int MAX_TOURS = 6;
    private static final int DE_PAR_TOUR = 3;
    private static final int BUNCO = 21;

    @Override
    public void calculerScoreTour(Joueur joueurCourant, int tourCourant) {

        int scoreTourBunco = 0, scoreTour = 0, scoreTourTotal = 0;
        int scoreDe;
        De currentDe;
        De previousDe = null;

        //Pendant que le score du joueur n'est pas zero
        do {
            resetDeIterator(); //Recommence l'itérateur
            currentDe = deIterator.next(); //Prend le prochain dé

            //Pendant que l'itérateur à encore des dés
            while(deIterator.hasNext()) {
                currentDe.rollDe(); //Roule le dé
                scoreDe = currentDe.getCurrentFace(); //Récupère la face du dé

                // Si la face du dé est le même que le tour courant
                if (scoreDe == tourCourant) {
                    scoreTourBunco++; //Incrémente le score pour calculer un tour donnant un Bunco
                }
                if (previousDe != null) {
                    //Si le dé courant et précedent au la même face
                    if (currentDe.getCurrentFace() == previousDe.getCurrentFace()) {
                        scoreTour++; //Incrémente un score pour voir si nous avons 3 dés pareille
                    }
                }
                previousDe = currentDe;
                currentDe = deIterator.next(); //Va au prochain dé dans l'itération
            }

            //Si nous avons trois dés parielle au bon tour = Bunco
            if (scoreTourBunco == DE_PAR_TOUR) {
                scoreTourTotal = BUNCO;
            }
            //Si nous avons trois dés parielle mais pas au bon tour = 5 points
            else if (scoreTour == DE_PAR_TOUR-1) {
                scoreTourTotal = 5;
            }
            //Si nous avons aucune face du même tour = 0 points
            else if (scoreTourBunco == 0) {
                joueurCourant.setScore(0);
                scoreTourTotal = 0;
            }
            //Si nous avons un certain nombres de dés pareille du bon tour
            else {
                scoreTourTotal += scoreTourBunco;
            }

            joueurCourant.setScore(scoreTourTotal);

        }while(scoreTourTotal != 0);
    }

    @Override
    public Joueur calculerLeVaiqueur() {
        Joueur winner = new Joueur(1); //NOT OFFICIAL, need to implement strategy

        return winner;
    }

}
