package framework;

public class CollectionDes {

    static final int MAX_DES = 3;
    int numOfDes = 0;
    De[] tabDes;

    public CollectionDes(){
        tabDes = new De[MAX_DES];
    }

    public void addDe(De de){
        tabDes[numOfDes] = de;
        numOfDes++;
    }

    public DeIterator createIterator(){
        return new DeIterator(tabDes);
    }

}
