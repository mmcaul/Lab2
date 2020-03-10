package framework;

public class Jeu implements GameStrategy {

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
    }

    @Override
    public Joueur[] calculerLeVainqueur(Jeu jeu)
    {
        JoueurIterator joueurs = jeu.joueurIterator;

        //table contenant tout les joueurs, va chercher le joueur[] dans l'itérateur
        Joueur[] joueursTab = joueurs.joueurs;
        int size = joueursTab.length;

        //joueur vide 
        Joueur joueur = new Joueur(0);

        //tableau vide dans lequel on rajoutera les jours du tableau précédent en ordre décroissant de score
        Joueur[] rankings = new Joueur[size];


        for(int i = 0; i < rankings.length; i++)
        {
            //trouver joueur avec plus grand maximum
            for(int j = 0; j < size;j++)
            {
                //si score joueur inférieur au suivant, prochain joueur devient le meneur
                if(joueur.getScore()< joueursTab[j].getScore())
                {
                    joueur = joueursTab[j];
                }
            }

            //enlève le joueur du tableau une fois qu'il est assigné au ranking
            for(int j = 0; j< size; j++)
            {
                if(joueursTab[j].compareTo(joueur) == 1){ joueursTab[j] = null;}
            }

            //assigne le joueur trouvé dans le tableau de ranking
            rankings[i]= joueur;

        }
        return rankings;
    }

    @Override
    public int calculerScoreTour() {
        return 0;
    }
}
