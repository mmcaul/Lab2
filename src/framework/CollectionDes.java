package framework;

public class CollectionDes {

    int numOfDes = 0;
    De[] tabDes;

    public CollectionDes(int nbDes){
        numOfDes = nbDes;
        tabDes = new De[nbDes];
    }

    public void addDe(De de){
        for(int i=0; i<numOfDes; i++){
            tabDes[i] = de;
        }
    }

    public DeIterator createIterator(){
        return new DeIterator(tabDes);
    }


}
