package framework;

public class Jeu implements GameStrategy {

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
        int size = 0;

        for (int i = 0; i < deIterator.size(); i++){
            if (deIterator.get() == numTours){
                score ++;
            }
            
        }

        return 0;
    }
}
