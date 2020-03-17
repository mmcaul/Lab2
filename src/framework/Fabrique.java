package framework;

import jeuBunco.BuncoStrategy;

public class Fabrique {

    public static void main(String[] args) {

		Jeu monJeu = new BuncoStrategy();

        monJeu.commencerJeu();

    }
}
