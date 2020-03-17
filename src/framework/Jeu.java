package framework;

import java.util.Scanner;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #2
 �tudiant(e)s: M�lissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh
 Professeur : Benoit Galarneau
 Nom du fichier: Jeu.java
 Date cr��: 2020-02-25
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

    //M�thodes abstraites puisque les strat�gies de jeu ne serons impl�menter
    //que par les differents jeu concr�te
    //public abstract void calculerScoreTour(JoueurIterator j, DeIterator dIt, int tourCourant);
    public abstract int calculerScoreTour(Joueur j, DeIterator dIt, int tourCourant);
    public abstract CollectionJoueur calculerLeVainqueur();

    /**
     * M�thode qui sert de template pour d�marrer un jeu
     */
    public final void commencerJeu(){

        //Decide du nombre de joueurs et du nombres de face pr�sente sur un d�
        setNbJoueurs();
        setNbFaceDe();

        //Pendant que nous n'avons pas compl�ter le nombres de tours requis
        while(nbToursFait <= nbTours){
            //Cr�e un nouvel iterateur avec le joueur courant
            resetJoueurIterator();

            //Pendant qu'il reste des joueurs
            while(joueurIterator.hasNext()){
                Joueur jCourant = joueurIterator.next(); //Va chercher le joueur courant

                int runningScore = 0; //Variable pour le score courant du joueur
                //Met la valeur du roule de d�s dans la variable
                valueScore = calculerScoreTour(jCourant, deIterator, nbToursFait);

                //Si la valeur est 0 ou un Bunco(21)
                if(valueScore == 0 || valueScore == 21){
                    jCourant.setScore(valueScore); //Le score du joueur est comme suit
                } else{
                    //Pendant que la valeur n'est pas z�ro ou 21
                    while(valueScore!=21 && valueScore!=0){
                        valueScore = calculerScoreTour(jCourant, deIterator,nbToursFait);
                        runningScore += valueScore; //Incr�mente de score du joueur
                    }
                    jCourant.setScore(runningScore); //Set le score du joueur
                }
            }


            //Retourne une collection de joueurs trier en fonction de leurs scores
            joueurItTrier = calculerLeVainqueur().createIterator();
            System.out.println("Voici les standings du tour #" + nbToursFait + " :");

            //Pour tout les joueurs dans le jeu
            for(int t=0; t<joueurItTrier.getTabJoueurs().length; t++){
                //Print les num�ros et les scores
                System.out.println(joueurItTrier.next().toString());
            }

            System.out.println();
            nbToursFait++; //Incr�mente les nombres de tour
        }
    }

    /**
     * M�thode qui determine le nombres de joueurs du jeu
     */
    public void setNbJoueurs(){
        System.out.println("Combien de joueurs veulent jouer?");
        System.out.print(">>");

        //Prend la prochaine entr�e de clavier et verfie que c'est un int
        if(sc.hasNextInt()){
            nbJoueurs = sc.nextInt();
            //Instancie une nouvelle collection de joueurs avec le nombre demander
            tabNbJoueurs = new CollectionJoueur(nbJoueurs);

            //Pour le nombre de joueurs demander
            for(int i=0; i<nbJoueurs; i++){
                //Cr�e et ajoute un nouveau joueur dans la collection
                //et lui donne le num�ro correspondant a sa position
                tabNbJoueurs.addJoueur(new Joueur(i));
            }
            //Cr�e un it�rateur pour pouvoir parcourir la collection
            joueurIterator = tabNbJoueurs.createIterator();
        }
    }

    /**
     * M�thode qui determine le nombres de face qu'on un d�
     */
    public void setNbFaceDe(){
        System.out.println("Combien de d�s allez-vous utiliser?");
        System.out.print(">>");

        //Prend la prochaine entr�e de clavier et verfie que c'est un int
        if(sc.hasNextInt()){
            nbDes = sc.nextInt();
            //Instancie une nouvelle collection de d�s avec le nombre demander
            tabNbDes = new CollectionDes(nbDes);

            System.out.println("Combien de faces ont vos d�s?");
            System.out.print(">>");

            //Prend le prochaine entr�e de clavier et verifie que c'est un int
            if(sc.hasNextInt()){
                nbFaceDe = sc.nextInt();
                //Met le nombres de tour du jeu �gale au nombres de face du d�
                nbTours = nbFaceDe;
            }

            //Pour le nombres de d�s demand�
            for(int i=0; i<nbDes; i++){
                //Ajoute un nouveau d� avec le bon nombres de faces
                tabNbDes.addDe(new De(nbFaceDe));
            }
            //Cr�e un it�rateur pour pouvoir parcourir la collection
            deIterator = tabNbDes.createIterator();
        }
    }

    /**
     * Retourne le deIterateur utilis�
     * Cette m�thode est n�cessaire pour le resetDeIterator dans BuncoStrategy
     * @return DeIterator
     */
   public DeIterator getDeIterator(){
        return this.deIterator;
   }

    /**
     * M�thode qui set le DeIterator
     * Cette m�thode est n�cessaire pour le fonctionnement des tests
     * @param dIt : DeIterator
     */
   public void setDeIterator(DeIterator dIt){
        this.deIterator = dIt;
   }

    /**
     * M�thode qui set la collection de d�s
     * Cette m�thode est n�cessaire pour le fonctionnement des tests
     * @param colD : CollectionDes
     */
   public void setTabNbDes(CollectionDes colD){
        this.tabNbDes = colD;
   }

    /**
     * Recommence l'it�ration des joueurs pour le prochain tour
     */
   public void resetJoueurIterator(){
        joueurIterator = tabNbJoueurs.createIterator();
   }

    /**
     * Recommence l'it�ration des d�s pour le prochain joueur
     */
    public void resetDeIterator(){
        deIterator = tabNbDes.createIterator();
    }
}