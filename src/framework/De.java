package framework;


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
    public int compareTo(Object o) {
        De comparableDe = (De) o;

        try{
            if(comparableDe.getCurrentFace() > currentFace){
                return 1;
            } else if (comparableDe.getCurrentFace() < currentFace){
                return -1;
            } else if (comparableDe.getCurrentFace() == currentFace){
                return 0;
            }
        } catch (IllegalArgumentException e){
            System.out.println("Invalid entry!");
        }
        return -99;
    }


}
