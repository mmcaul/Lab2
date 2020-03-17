package framework;


public interface GameStrategy {

    void calculerScoreTour(JoueurIterator j, DeIterator dIt, int tourCourant);
    CollectionJoueur calculerLeVainqueur();
}