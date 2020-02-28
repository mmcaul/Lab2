package framework;

public class CollectionJoueur {

    int numOfJoueurs = 0;
    Joueur[] tabJoueurs;

    public CollectionJoueur(int numOfJoueurs){
        this.numOfJoueurs = numOfJoueurs;
        tabJoueurs = new Joueur[this.numOfJoueurs];
    }

    public void addJoueur(Joueur joueur){
        numOfJoueurs++;
        tabJoueurs[numOfJoueurs] = joueur;
    }

    public JoueurIterator createIterator(){
        return new JoueurIterator(tabJoueurs);
    }


}
