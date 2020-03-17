package framework;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: CollectionJoueur.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class CollectionJoueur {

    //Variable de classe
    int numOfJoueurs, position=0;
    Joueur[] tabJoueurs;

    /**
     * Constructeur par paramètre
     * @param numOfJoueurs : int
     */
    public CollectionJoueur(int numOfJoueurs){
        this.numOfJoueurs = numOfJoueurs;
        tabJoueurs = new Joueur[this.numOfJoueurs];
    }

    /**
     * Méthode perméttant l'ajout d'un joueur dans la collection
     * @param joueur : Joueur
     */
    public void addJoueur(Joueur joueur){
        tabJoueurs[position] = joueur;
        position++;
    }

    /**
     * Méthode qui crée un Itérateur pour parcourir la collection
     * @return JoueurIterator
     */
    public JoueurIterator createIterator(){
        return new JoueurIterator(tabJoueurs);
    }

}
