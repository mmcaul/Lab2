package framework;

import java.util.Random;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: De.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class De implements Comparable {

    //Variable de classe
    private int currentFace = 0;
    private int maxFaces;
    Random rand = new Random();

    /**
     * Constructeur par paramètre
     * @param maxFaces : int
     */
    public De(int maxFaces){
        this.maxFaces = maxFaces;
    }

    /**
     * Méthode pour set la face de dé en cours
     * @param currentFace : int
     */
    public void setCurrentFace(int currentFace){
        this.currentFace = currentFace;
    }

    /**
     * Méthode qui retourne la face de dé en cours
     * @return : int
     */
    public int getCurrentFace(){
        return currentFace;
    }

    /**
     * Méthode qui génère une nouvelle face de dé dans les valeurs possible
     * défini dans le jeu.
     */
    public void rollDe(){
        currentFace = rand.nextInt(maxFaces)+1;
    }

    /**
     * Méthode permettant la comparaison entre deux dés
     * @param o : Object
     * @return : int
     * @throws IllegalArgumentException
     */
    @Override
    public int compareTo(Object o) throws IllegalArgumentException{
        De comparableDe = (De) o;

        if(o == null){
            throw new IllegalArgumentException();
        } else {
            if (comparableDe.getCurrentFace() > currentFace) {
                return 1;
            } else if (comparableDe.getCurrentFace() < currentFace) {
                return -1;
            } else if (comparableDe.getCurrentFace() == currentFace) {
                return 0;
            }
        }
        return -99;
    }
    

}
