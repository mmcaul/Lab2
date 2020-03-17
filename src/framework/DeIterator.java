package framework;

import java.util.Iterator;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: DeIterator.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class DeIterator implements Iterator {

    //Variable de classe
    De[] des;
    int positionDe = 0;

    /**
     * Constructeur par paramètre
     * @param des : De[]
     */
    public DeIterator(De[] des){
        this.des = des;
    }

    /**
     * Méthode qui détermine si il y a un prochain dé présent
     * @return : boolean
     */
    @Override
    public boolean hasNext() {
        if(positionDe >= des.length || des[positionDe] == null){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Méthode qui retourne le prochain De dans la collection
     * @return : De
     */
    @Override
    public De next() {
        De de = des[positionDe];
        positionDe = positionDe + 1;
        return de;
    }
}
