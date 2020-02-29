package jeuBunco;

import framework.GameStrategy;
import framework.Joueur;

public class BuncoStrategy implements GameStrategy {

    static final int MAX_TOURS = 6;

    @Override
    public int calculerScoreTour(){
        int score = 0;

        return score;
    }

    @Override
    public Joueur calculerLeVainqueur(){
        Joueur winner = new Joueur(1); //NOT OFFICIAL, need to implement strategy

        return winner;
    }
}
