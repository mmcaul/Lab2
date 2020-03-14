package framework;


public interface GameStrategy {

    void calculerScoreTour(Joueur j, int tourCourant);
    String calculerLeVaiqueur(int nbT);

}