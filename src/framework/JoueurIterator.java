package framework;

import java.util.Iterator;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh
 Professeur : Benoit Galarneau
 Nom du fichier: JoueurIterator.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class JoueurIterator implements Iterator {

    //Variables de classe
    Joueur[] joueurs;
    int positionJoueur = 0;

    /**
     * Constructeur par paramètre
     * @param joueurs : Joueur[]
     */
    public JoueurIterator(Joueur[] joueurs){
        this.joueurs = joueurs;
    }

    /**
     * Getter qui retourne le tableau des joueurs
     * @return : Joueur[]
     */
    public Joueur[] getTabJoueurs(){
        return joueurs;
    }


    /**
     * Méthode qui détermine si il y a un prochain joueur présent
     * @return : boolean
     */

    @Override
    public boolean hasNext() {
        if(positionJoueur >= (joueurs.length)-1 || joueurs[positionJoueur] == null){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Méthode qui retourne le prochain Joueur dans la collection
     * @return : Joueur
     */
    @Override
    public Joueur next() {
        Joueur joueur = joueurs[positionJoueur];
        positionJoueur = positionJoueur + 1;
        return joueur;
    }
}