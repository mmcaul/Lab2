package jeuBunco;

import framework.Jeu;
import framework.*;
import framework.Joueur;
import org.w3c.dom.ls.LSOutput;

public class BuncoStrategy extends Jeu {

    private static final int MAX_TOURS = 6;
    private static final int DE_PAR_TOUR = 3;
    private static final int BUNCO = 21;

    @Override
    public void calculerScoreTour(Joueur joueurCourant, int tourCourant) {

        int scoreTourBunco, scoreTour, scoreTourTotal = 0;
        int scoreDe;
        De currentDe;
        De previousDe = null;

        //Pendant que le score du joueur n'est pas zero
        do {
            resetDeIterator(); //Recommence l'itérateur
            scoreTour = 0;
            scoreTourBunco = 0;

            //Pendant que l'itérateur à encore des dés
            while(deIterator.hasNext()) {

                currentDe = deIterator.next(); //Prend le prochain dé

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
            }

            //Si nous avons trois dés parielle au bon tour = Bunco
            if (scoreTourBunco == DE_PAR_TOUR) {
                scoreTourTotal += BUNCO;
            }
            //Si nous avons trois dés parielle mais pas au bon tour = 5 points
            else if (scoreTour == DE_PAR_TOUR-1) {
                scoreTourTotal += 5;
            }
            //Si nous avons aucune face du même tour = 0 points
            else if (scoreTourBunco == 0) {
                joueurCourant.setScore(0);
                scoreTourTotal += 0;
            }
            //Si nous avons un certain nombres de dés pareille du bon tour
            else {
                scoreTourTotal += scoreTourBunco;
            }

            joueurCourant.setScore(scoreTourTotal);

        }while(scoreTourBunco != 0);
    }

    @Override
    public String calculerLeVaiqueur(int tourNb) {

        Joueur currentJoueur;
        Joueur previousJoueur = null;
        Joueur winner = null;

        resetJoueurIterator();
        while(joueurIterator.hasNext()){
            currentJoueur = joueurIterator.next();
            if(previousJoueur != null){
                if(previousJoueur.getScore() < currentJoueur.getScore()){
                    winner = currentJoueur;
                }
            }
            previousJoueur = currentJoueur;
        }

        if(winner != null){
            return winner.toString(tourNb);
        } else {
            return "Il n'y a pas de vainqueur pour ce tour # " + tourNb + "! :(";
        }
    }

}
