package framework;

import framework.Joueur;

public interface GameStrategy {

    public Joueur[] calculerLeVainqueur(Jeu jeu);
    public int calculerScoreTour();

}
