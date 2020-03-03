package framework;

import java.util.Iterator;

public class DeIterator implements Iterator {

    De[] des;
    int position = 0;

    public DeIterator(De[] des){
        this.des = des;
    }

    @Override
    public boolean hasNext() {
        if(position >= des.length || des[position] == null){
            return false;
        } else {
            return true;
        }
    }

    public int size(){
        return des.length;
    }

    public De get(){
        return des[position];
    }

    @Override
    public De next() {
        De de = des[position];
        position = position + 1;
        return de;
    }
}
