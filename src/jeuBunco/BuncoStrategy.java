package jeuBunco;

import framework.Jeu;
import framework.*;
import framework.Joueur;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: BuncoStrategy.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class BuncoStrategy extends Jeu {

    private static final int DE_PAR_TOUR = 3;
    private static final int BUNCO = 21;

    @Override
    public void calculerScoreTour(JoueurIterator jouIt, DeIterator dIt, int tourCourant) {

        int scoreTourBunco, scoreTour, scoreTourTotal = 0;
        int scoreDe;
        De currentDe;
        De previousDe = null;

        while(jouIt.hasNext()) {

            Joueur joueurCourant = jouIt.next();

            //Pendant que le score du joueur n'est pas zero
            do {
                resetDeIterator(); //Recommence l'itérateur
                scoreTour = 0;
                scoreTourBunco = 0;

                //Pendant que l'itérateur à encore des dés
                while (dIt.hasNext()) {

                    currentDe = dIt.next(); //Prend le prochain dé

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
                    joueurCourant.setScore(scoreTourTotal);
                    break;
                }
                //Si nous avons trois dés parielle mais pas au bon tour = 5 points
                else if (scoreTour == DE_PAR_TOUR - 1) {
                    scoreTourTotal += 5;
                }
                //Si nous avons un certain nombres de dés pareille du bon tour
                else {
                    scoreTourTotal += scoreTourBunco;
                }

                joueurCourant.setScore(scoreTourTotal);

            } while (scoreTourBunco != 0);
        }
    }

    public CollectionJoueur calculerLeVainqueur(){

        resetJoueurIterator();
        Joueur[] joueursTrier = joueurIterator.getTabJoueurs();
        CollectionJoueur colJoueurTrier = new CollectionJoueur(joueursTrier.length);

        for(int i=0; i < joueursTrier.length-1; i++) {
            int min = i;
            for (int j = i+1; j < joueursTrier.length; j++){
                if (joueursTrier[j].getScore() > joueursTrier[min].getScore())
                    min = j;
            }
            Joueur joueurTemp = joueursTrier[min];
            joueursTrier[min] = joueursTrier[i];
            joueursTrier[i] = joueurTemp;
        }

        for(int k=0; k<joueursTrier.length; k++){
            colJoueurTrier.addJoueur(joueursTrier[k]);
        }

        return colJoueurTrier;
    }

    public void resetDeIterator(){
        deIterator = tabNbDes.createIterator();
    }

}
