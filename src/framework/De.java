package framework;


import java.sql.SQLOutput;
import java.util.Random;

public class De implements Comparable {

    private int currentFace = 0;
    private int maxFaces;
    Random rand = new Random(maxFaces);

    public De(int maxFaces){
        this.maxFaces = maxFaces;
    }

    public void setCurrentFace(int currentFace){
        this.currentFace = currentFace;
    }

    public int getCurrentFace(){
        return currentFace;
    }

    public void rollDe(){
        currentFace = rand.nextInt();
    }

    @Override
    public int compareTo(Object o) throws IllegalArgumentException{
        De comparableDe = (De) o;

        if(o == null){
            throw new IllegalArgumentException();
        } else {
            if (comparableDe.getCurrentFace() > currentFace) {
                return 1;
            } else if (comparableDe.getCurrentFace() < currentFace) {
                return -1;
            } else if (comparableDe.getCurrentFace() == currentFace) {
                return 0;
            }
        }
        return -99;
    }


}
