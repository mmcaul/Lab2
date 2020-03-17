package framework;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 �tudiant(e)s: M�lissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh
 Professeur : Benoit Galarneau
 Nom du fichier: Joueur.java
 Date cr��: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class Joueur implements Comparable {

    //Variable de classe
    private int numJoueur, score;

    /**
     * Constructeur par param�tre
     * @param numJoueur : int
     */
    public Joueur(int numJoueur){
        this.numJoueur = numJoueur;
        this.score = 0;
    }

    /**
     * Getter qui retourne le num�ro du joueur
     * @return : int
     */
    public int getNumJoueur(){
        return this.numJoueur;
    }

    /**
     * Setter pour le score du joueur
     * @param score : int
     */
    public void setScore(int score){
        this.score = score;
    }

    /**
     * Getter qui retourne le score du joueur
     * @return : int
     */
    public int getScore(){
        return this.score;
    }

    /**
     * M�thode qui compare les joueurs bas�e sur leurs num�ro de joueurs
     * @param o : Object
     * @return : int
     */
    @Override
    public int compareTo(Object o) {
        Joueur comparableJoueur = (Joueur) o;

        if(comparableJoueur.getNumJoueur() > numJoueur){
            return 1;
        } else if (comparableJoueur.getNumJoueur() < numJoueur){
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * M�thode qui retourne un String contenant le num�ro du joueur et son score
     * @return : String
     */

    public String toString(){
        return ("Joueur numero: " + getNumJoueur() + " = Score: " + getScore());
    }
}