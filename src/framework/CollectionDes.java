package framework;

public class CollectionDes {

    int numOfDes, position = 0;
    De[] tabDes;

    public CollectionDes(int nbDes){
        numOfDes = nbDes;
        tabDes = new De[nbDes];
    }

    public void addDe(De de){
        tabDes[position] = de;
        position++;
    }

    public DeIterator createIterator(){
        return new DeIterator(tabDes);
    }
}
