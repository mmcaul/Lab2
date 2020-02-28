package framework;

import java.util.Iterator;

public class JoueurIterator implements Iterator {

    Joueur[] joueurs;
    int position = 0;

    public JoueurIterator(Joueur[] joueurs){
        this.joueurs = joueurs;
    }

    @Override
    public boolean hasNext() {
        if(position >= joueurs.length || joueurs[position] == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Joueur next() {
        Joueur joueur = joueurs[position];
        position = position + 1;
        return joueur;
    }
}
