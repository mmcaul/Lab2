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

    private int numJoueur, score;

    public Joueur(int numJoueur){
        this.numJoueur = numJoueur;
        this.score = 0;
    }

    public int getNumJoueur(){
        return this.numJoueur;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

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
    
    public String toString(){
        return ("Joueur numero: " + getNumJoueur() + " = Score: " + getScore());
    }
}
