package framework;

<<<<<<< HEAD
public class Jeu implements GameStrategy {

    private final int BUNCO = 21;

    private DeIterator deIterator;
    private JoueurIterator joueurIterator;
    private GameStrategy strategieJeu;
    private int numTours;

    public Jeu(CollectionDes collectionDes, CollectionJoueur collectionJoueur,
               int numTours, GameStrategy strategieJeu){
        deIterator = collectionDes.createIterator();
        joueurIterator = collectionJoueur.createIterator();
        this.numTours = numTours;
        this.strategieJeu = strategieJeu;
=======
import java.util.Scanner;

public abstract class Jeu implements GameStrategy{

    Scanner sc = new Scanner(System.in);
    int nbToursFait = 0;
    int nbJoueurs, nbDes, nbFaceDe, nbTours;
    CollectionJoueur tabNbJoueurs;
    JoueurIterator joueurIterator;
    CollectionDes tabNbDes;
    DeIterator desIterator;

    public abstract void calculerScoreTour();
    public abstract Joueur calculerLeVaiqueur();


    public final void commencerJeu(){

        setNbJoueurs();
        setNbFaceDe();
        setNbTours();

        while(nbToursFait != nbTours){

            for(int i=0;i<nbJoueurs; i++){
                calculerScoreTour();
            }
            calculerLeVaiqueur();
            nbToursFait++;
        }
>>>>>>> dd010f39ec411bd6a2423f627c627144cd7be0f9
    }

    public void setNbJoueurs(){
        System.out.println("Combien de joueurs veulent jouer?");
        System.out.print(">>");

        if(sc.hasNextInt()){
            nbJoueurs = sc.nextInt();
            tabNbJoueurs = new CollectionJoueur(nbJoueurs);

            for(int i=0; i<nbJoueurs; i++){
                tabNbJoueurs.addJoueur(new Joueur(i));
            }
            joueurIterator = tabNbJoueurs.createIterator();
        }
    }

    public void setNbFaceDe(){
        System.out.println("Combien de dés allez-vous utiliser?");
        System.out.print(">>");

        if(sc.hasNextInt()){
            nbDes = sc.nextInt();
            tabNbDes = new CollectionDes(nbDes);

            System.out.println("Combien de faces ont vos dés?");
            System.out.print(">>");

            if(sc.hasNextInt()){
                nbFaceDe = sc.nextInt();
            }

            for(int i=0; i<nbDes; i++){
                tabNbDes.addDe(new De(nbFaceDe));
            }
            desIterator = tabNbDes.createIterator();
        }
    }

<<<<<<< HEAD
    @Override
    public int calculerScoreTour() {
        int scoreTot = 0;

        while (deIterator.hasNext()){
            int scoreRoll = 0;

            for (int i = 0; i < 3; i ++){
                if (deIterator.get().getCurrentFace() == numTours) {
                    scoreRoll++;
                }
            }
            if (scoreRoll == 3){
                scoreTot += BUNCO;
            } else {
                scoreTot += scoreRoll;
            }
        }

        return 0;
=======
    public void setNbTours(){
        System.out.println("Combien de tours voulez-vous jouer?");
        System.out.print(">>");
        if(sc.hasNextInt()){
            nbTours = sc.nextInt();
        }

>>>>>>> dd010f39ec411bd6a2423f627c627144cd7be0f9
    }
}
