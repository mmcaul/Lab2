package framework;


import java.util.Scanner;

public abstract class Jeu implements GameStrategy{

    protected DeIterator deIterator;
    protected JoueurIterator joueurIterator;

    Scanner sc = new Scanner(System.in);
    int nbToursFait = 1;
    int nbJoueurs, nbDes, nbFaceDe, nbTours;
    CollectionJoueur tabNbJoueurs;
    CollectionDes tabNbDes;

    public abstract void calculerScoreTour(Joueur j, int tourCourant);
    //public abstract String calculerLeVaiqueur(int nbT);
    public abstract CollectionJoueur calculerLeVainqueur(int nbT);

    public final void commencerJeu(){

        Joueur winner = null;

        setNbJoueurs();
        setNbFaceDe();

        while(nbToursFait <= nbTours){
            resetJoueurIterator();
            while(joueurIterator.hasNext()){
                Joueur joueurCourant = joueurIterator.next();
                calculerScoreTour(joueurCourant, nbToursFait);
            }
            JoueurIterator joueurItTrier = calculerLeVainqueur(nbToursFait).createIterator();

            winner = joueurItTrier.next();

            if(winner.getScore() != 0){
                System.out.println(winner.toString(nbToursFait));
            } else {
                System.out.println("Il n'y a pas de vainqueur pour ce tour # " + nbToursFait + "! :(");
            }

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
                nbTours = nbFaceDe;
            }

            for(int i=0; i<nbDes; i++){
                tabNbDes.addDe(new De(nbFaceDe));
            }
            deIterator = tabNbDes.createIterator();
        }
    }

   public void resetDeIterator(){
        deIterator = tabNbDes.createIterator();
   }

   public void resetJoueurIterator(){
        joueurIterator = tabNbJoueurs.createIterator();
   }
}