package framework;

public class Jeu implements GameStrategy {

    private final int BUNCO = 21;

    private DeIterator deIterator;
    private JoueurIterator joueurIterator;
    private GameStrategy strategieJeu;
    private int numTours;

    public Jeu(CollectionDes collectionDes, CollectionJoueur collectionJoueur,
               int numTours, GameStrategy strategieJeu){
        deIterator = collectionDes.createIterator();
        joueurIterator = collectionJoueur.createIterator();
        this.numTours = numTours;
        this.strategieJeu = strategieJeu;
    }

    @Override
    public Joueur calculerLeVainqueur() {
        return null;
    }

    @Override
    public int calculerScoreTour() {
        int scoreTot = 0;

        while (deIterator.hasNext()){
            int scoreRoll = 0;

            for (int i = 0; i < 3; i ++){
                if (deIterator.get().getCurrentFace() == numTours) {
                    scoreRoll++;
                }
            }
            if (scoreRoll == 3){
                scoreTot += BUNCO;
            } else {
                scoreTot += scoreRoll;
            }
        }

        return 0;
    }
}
