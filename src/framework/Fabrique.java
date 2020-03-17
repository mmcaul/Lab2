package framework;

import jeuBunco.BuncoStrategy;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: Fabrique.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class Fabrique {

    /**
     * Méthode fabrique qui génère le jeu courant.
     * @param args : String[]
     */
    public static void main(String[] args) {

        //Nous voulons joueur un jeu Bunco
		Jeu monJeu = new BuncoStrategy();

        monJeu.commencerJeu();

    }
}
