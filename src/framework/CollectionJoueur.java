package framework;

public class CollectionJoueur {

    int numOfJoueurs, position=0;
    Joueur[] tabJoueurs;

    public CollectionJoueur(int numOfJoueurs){
        this.numOfJoueurs = numOfJoueurs;
        tabJoueurs = new Joueur[this.numOfJoueurs];
    }

    public void addJoueur(Joueur joueur){
        tabJoueurs[position] = joueur;
        position++;
    }

    public JoueurIterator createIterator(){
        return new JoueurIterator(tabJoueurs);
    }

}
