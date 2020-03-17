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

    Joueur[] joueurs;
    int positionJoueur = 0;

    public JoueurIterator(Joueur[] joueurs){
        this.joueurs = joueurs;
    }

    public Joueur[] getTabJoueurs(){
        return joueurs;
    }

    @Override
    public boolean hasNext() {
        if(positionJoueur >= (joueurs.length)-1 || joueurs[positionJoueur] == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Joueur next() {
        Joueur joueur = joueurs[positionJoueur];
        positionJoueur = positionJoueur + 1;
        return joueur;
    }
}
