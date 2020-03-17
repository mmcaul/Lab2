package framework;


import java.util.Scanner;

public abstract class Jeu implements GameStrategy{

    protected DeIterator deIterator;
    protected JoueurIterator joueurIterator;
    JoueurIterator joueurItTrier;

    Scanner sc = new Scanner(System.in);
    int nbToursFait = 1;
    int nbJoueurs, nbDes, nbFaceDe, nbTours;
    CollectionJoueur tabNbJoueurs;
    CollectionDes tabNbDes;

    public abstract void calculerScoreTour(JoueurIterator j, DeIterator dIt, int tourCourant);
    public abstract CollectionJoueur calculerLeVainqueur(int nbT);

    public final void commencerJeu(){

        setNbJoueurs();
        setNbFaceDe();

        while(nbToursFait <= nbTours){
            resetJoueurIterator();
            //while(joueurIterator.hasNext()){
                //Joueur joueurCourant = joueurIterator.next();
                calculerScoreTour(joueurIterator, deIterator, nbToursFait);
                //calculerScoreTour(joueurCourant, deIterator, nbToursFait);
            //}
            joueurItTrier = calculerLeVainqueur(nbToursFait).createIterator();
            System.out.println("Voici les standings du tour #" + nbToursFait + " :");

            for(int t=0; t<joueurItTrier.getTabJoueurs().length; t++){
                System.out.println(joueurItTrier.next().toString());
            }

            System.out.println();
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

   public void setDeIterator(DeIterator dIt){
        this.deIterator = dIt;
   }

   public void setTabNbDes(CollectionDes colD){
        this.tabNbDes = colD;
   }

   public void resetJoueurIterator(){
        joueurIterator = tabNbJoueurs.createIterator();
   }
}