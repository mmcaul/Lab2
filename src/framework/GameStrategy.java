package framework;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: GameStrategy.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public interface GameStrategy {

    //Méthodes qui serons à implémenter par toutes les classes implémentant GameStrategy
    public int calculerScoreTour(Joueur j, DeIterator dIt, int tourCourant);
    public CollectionJoueur calculerLeVainqueur();
}