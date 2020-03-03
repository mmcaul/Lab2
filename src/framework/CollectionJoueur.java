package framework;

public class CollectionJoueur {

    int numOfJoueurs;
    Joueur[] tabJoueurs;

    public CollectionJoueur(int numOfJoueurs){
        this.numOfJoueurs = numOfJoueurs;
        tabJoueurs = new Joueur[this.numOfJoueurs];
    }

    public void addJoueur(Joueur joueur){
        for(int i=0; i<numOfJoueurs; i++){
            tabJoueurs[i] = joueur;
        }
    }

    public JoueurIterator createIterator(){
        return new JoueurIterator(tabJoueurs);
    }

}
