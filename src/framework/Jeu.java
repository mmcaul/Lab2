package framework;

import java.util.Scanner;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: Jeu.java
 Date créé: 2020-02-25
 Date dern. modif. 2020-03-17
 *******************************************************/

public abstract class Jeu implements GameStrategy{

    //Variable de classe
    protected DeIterator deIterator;
    protected JoueurIterator joueurIterator;
    JoueurIterator joueurItTrier;

    Scanner sc = new Scanner(System.in);
    int nbToursFait = 1;
    int nbJoueurs, nbDes, nbFaceDe, nbTours;
    protected CollectionJoueur tabNbJoueurs;
    protected CollectionDes tabNbDes;

    //Méthodes abstraites puisque les stratégies de jeu ne serons implémenter
    //que par les differents jeu concrète
    public abstract void calculerScoreTour(JoueurIterator j, DeIterator dIt, int tourCourant);
    public abstract CollectionJoueur calculerLeVainqueur();

    /**
     * Méthode qui sert de template pour démarrer un jeu
     */
    public final void commencerJeu(){

        //Decide du nombre de joueurs et du nombres de face présente sur un dé
        setNbJoueurs();
        setNbFaceDe();

        //Pendant que nous n'avons pas compléter le nombres de tours requis
        while(nbToursFait <= nbTours){
            //Crée un nouvel iterateur avec les joueurs courant
            resetJoueurIterator();

            calculerScoreTour(joueurIterator, deIterator, nbToursFait);

            joueurItTrier = calculerLeVainqueur().createIterator();
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

   public CollectionDes getTabNbDes(){
        return this.tabNbDes;
   }

   public DeIterator getDeIterator(){
        return this.deIterator;
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

    public void resetDeIterator(){
        deIterator = tabNbDes.createIterator();
    }
}