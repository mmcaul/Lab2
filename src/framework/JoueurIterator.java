package framework;

import java.util.Iterator;

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
