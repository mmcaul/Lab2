package framework;


import java.util.Random;

import Exceptions.FacesException;

public class De implements Comparable {

    static final int MAX_FACES = 6;
    Random rand = new Random(MAX_FACES);

    private int currentFace = 0;

    public De(int currentFace) {
        this.currentFace = currentFace;
    }

    public void setCurrentFace(int currentFace) throws FacesException{
    	if (currentFace <= MAX_FACES && currentFace >= 1) {
    		this.currentFace = currentFace;
    	} else {
    		throw new FacesException();
    	}
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
            if(currentFace < comparableDe.getCurrentFace()){
                return 1;
            } else if (currentFace > comparableDe.getCurrentFace()){
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
