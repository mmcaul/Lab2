package framework;

import java.util.Iterator;

public class JoueurIterator implements Iterator {

    Joueur[] joueurs;
    int position = joueurs.length-1;

    public JoueurIterator(Joueur[] joueurs){
        this.joueurs = joueurs;
    }

    @Override
    public boolean hasNext() {
        if(position >= (joueurs.length)-1 || joueurs[position] == null){
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return joueurs.length;
    }

    public Joueur current(){
        return joueurs[position];
    }

    @Override
    public Joueur next() {
        position = position + 1;
        Joueur joueur = joueurs[position];
        return joueur;
    }
}
