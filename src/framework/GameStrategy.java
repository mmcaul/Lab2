package framework;

import framework.Joueur;

public interface GameStrategy {

    public Joueur calculerLeVainqueur();
    public int calculerScoreTour();

}
