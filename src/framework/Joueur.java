package framework;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: Joueur.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public class Joueur implements Comparable {

    //Variable de classe
    private int numJoueur, score;

    /**
     * Constructeur par paramètre
     * @param numJoueur : int
     */
    public Joueur(int numJoueur){
        this.numJoueur = numJoueur;
    }

    /**
     * Getter qui retourne le numéro du joueur
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
     * Méthode qui compare les joueurs basée sur leurs numéro de joueurs
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
     * Méthode qui retourne un String contenant le numéro du joueur et son score
     * @return : String
     */
    public String toString(){
        return ("Joueur numero: " + getNumJoueur() + " = Score: " + getScore());
    }
}
