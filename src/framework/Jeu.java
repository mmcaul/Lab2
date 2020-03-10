package framework;


import java.util.Scanner;

public abstract class Jeu implements GameStrategy{

    private final int BUNCO = 21;

    private DeIterator deIterator;
    private JoueurIterator joueurIterator;
    private GameStrategy strategieJeu;
    private int numTours;

    Scanner sc = new Scanner(System.in);
    int nbToursFait = 0;
    int nbJoueurs, nbDes, nbFaceDe, nbTours;
    CollectionJoueur tabNbJoueurs;
    CollectionDes tabNbDes;
    DeIterator desIterator;

    public abstract int calculerScoreTour();
    public abstract Joueur calculerLeVaiqueur();

    public Jeu(CollectionDes collectionDes, CollectionJoueur collectionJoueur,
               int numTours, GameStrategy strategieJeu) {
        deIterator = collectionDes.createIterator();
        joueurIterator = collectionJoueur.createIterator();
        this.numTours = numTours;
        this.strategieJeu = strategieJeu;
    }

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

    public void setNbTours(){
        System.out.println("Combien de tours voulez-vous jouer?");
        System.out.print(">>");
        if(sc.hasNextInt()){
            nbTours = sc.nextInt();
        }
    }
}
