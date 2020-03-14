package framework;

public class Joueur implements Comparable {

    private int numJoueur, score;

    public Joueur(int numJoueur){
        this.numJoueur = numJoueur;
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

        if(comparableJoueur.getScore() > score){
            return 1;
        } else if (comparableJoueur.getScore() < score){
            return -1;
        } else {
            return 0;
        }
    }

    public String toString(int nbTour){
        return ("Le winner est le joueur numero: " + getNumJoueur() + " pour le tour # " + nbTour);
    }
}
