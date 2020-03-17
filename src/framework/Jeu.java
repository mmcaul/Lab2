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
    int nbJoueurs, nbDes, nbFaceDe, nbTours, valueScore;
    protected CollectionJoueur tabNbJoueurs;
    protected CollectionDes tabNbDes;

    //Méthodes abstraites puisque les stratégies de jeu ne serons implémenter
    //que par les differents jeu concrète
    //public abstract void calculerScoreTour(JoueurIterator j, DeIterator dIt, int tourCourant);
    public abstract int calculerScoreTour(Joueur j, DeIterator dIt, int tourCourant);
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
            //Crée un nouvel iterateur avec le joueur courant
            resetJoueurIterator();

            /*
            //Calcule le score de chacun des joueurs pour le tour courant
            calculerScoreTour(joueurIterator, deIterator, nbToursFait);
             */

            while(joueurIterator.hasNext()){
                Joueur jCourant = joueurIterator.next();

                int runningScore = 0;
                valueScore = calculerScoreTour(jCourant, deIterator, nbToursFait);

                if(valueScore == 0 || valueScore == 21){
                    jCourant.setScore(valueScore);
                } else{
                    while(valueScore!=0){
                        valueScore = calculerScoreTour(jCourant, deIterator,nbToursFait);
                        runningScore += valueScore;
                    }
                    jCourant.setScore(runningScore);
                }



            }


            //Retourne une collection de joueurs trier en fonction de leurs scores
            joueurItTrier = calculerLeVainqueur().createIterator();
            System.out.println("Voici les standings du tour #" + nbToursFait + " :");

            //Pour tout les joueurs dans le jeu
            for(int t=0; t<joueurItTrier.getTabJoueurs().length; t++){
                //Print les numéros et les scores
                System.out.println(joueurItTrier.next().toString());
            }

            System.out.println();
            nbToursFait++; //Incrémente les nombres de tour
        }
    }

    /**
     * Méthode qui determine le nombres de joueurs du jeu
     */
    public void setNbJoueurs(){
        System.out.println("Combien de joueurs veulent jouer?");
        System.out.print(">>");

        //Prend la prochaine entrée de clavier et verfie que c'est un int
        if(sc.hasNextInt()){
            nbJoueurs = sc.nextInt();
            //Instancie une nouvelle collection de joueurs avec le nombre demander
            tabNbJoueurs = new CollectionJoueur(nbJoueurs);

            //Pour le nombre de joueurs demander
            for(int i=0; i<nbJoueurs; i++){
                //Crée et ajoute un nouveau joueur dans la collection
                //et lui donne le numéro correspondant a sa position
                tabNbJoueurs.addJoueur(new Joueur(i));
            }
            //Crée un itérateur pour pouvoir parcourir la collection
            joueurIterator = tabNbJoueurs.createIterator();
        }
    }

    /**
     * Méthode qui determine le nombres de face qu'on un dé
     */
    public void setNbFaceDe(){
        System.out.println("Combien de dés allez-vous utiliser?");
        System.out.print(">>");

        //Prend la prochaine entrée de clavier et verfie que c'est un int
        if(sc.hasNextInt()){
            nbDes = sc.nextInt();
            //Instancie une nouvelle collection de dés avec le nombre demander
            tabNbDes = new CollectionDes(nbDes);

            System.out.println("Combien de faces ont vos dés?");
            System.out.print(">>");

            //Prend le prochaine entrée de clavier et verifie que c'est un int
            if(sc.hasNextInt()){
                nbFaceDe = sc.nextInt();
                //Met le nombres de tour du jeu égale au nombres de face du dé
                nbTours = nbFaceDe;
            }

            //Pour le nombres de dés demandé
            for(int i=0; i<nbDes; i++){
                //Ajoute un nouveau dé avec le bon nombres de faces
                tabNbDes.addDe(new De(nbFaceDe));
            }
            //Crée un itérateur pour pouvoir parcourir la collection
            deIterator = tabNbDes.createIterator();
        }
    }

    /**
     * Retourne le deIterateur utilisé
     * Cette méthode est nécessaire pour le resetDeIterator dans BuncoStrategy
     * @return DeIterator
     */
   public DeIterator getDeIterator(){
        return this.deIterator;
   }

    /**
     * Méthode qui set le DeIterator
     * Cette méthode est nécessaire pour le fonctionnement des tests
     * @param dIt : DeIterator
     */
   public void setDeIterator(DeIterator dIt){
        this.deIterator = dIt;
   }

    /**
     * Méthode qui set la collection de dés
     * Cette méthode est nécessaire pour le fonctionnement des tests
     * @param colD : CollectionDes
     */
   public void setTabNbDes(CollectionDes colD){
        this.tabNbDes = colD;
   }

    /**
     * Recommence l'itération des joueurs pour le prochain tour
     */
   public void resetJoueurIterator(){
        joueurIterator = tabNbJoueurs.createIterator();
   }

    /**
     * Recommence l'itération des dés pour le prochain joueur
     */
    public void resetDeIterator(){
        deIterator = tabNbDes.createIterator();
    }
}