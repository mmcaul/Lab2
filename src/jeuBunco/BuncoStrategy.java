package jeuBunco;

import framework.Jeu;
import framework.Joueur;

public class BuncoStrategy extends Jeu {
    static final int MAX_TOURS = 6;

    @Override
    public void calculerScoreTour(){
        int score = 0;


    }

    @Override
    public Joueur calculerLeVaiqueur() {
        Joueur winner = new Joueur(1); //NOT OFFICIAL, need to implement strategy

        return winner;
    }

}
