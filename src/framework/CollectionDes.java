package framework;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: CollectionDes.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class CollectionDes {

    //Initialisation des variables de classes
    int numOfDes, position = 0;
    De[] tabDes;

    /**
     * Constructeur par paramètre
     * @param nbDes : int
     */
    public CollectionDes(int nbDes){
        numOfDes = nbDes;
        tabDes = new De[nbDes];
    }

    /**
     * Méthode pour ajouter un De à la collection
      * @param de : De
     */
    public void addDe(De de){
        tabDes[position] = de;
        position++;
    }

    /**
     * Méthode pour créer un Itérateur de la collection créé précedamment
     * @return DeIterator
     */
    public DeIterator createIterator(){
        return new DeIterator(tabDes);
    }
}
