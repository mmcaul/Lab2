package framework;

import java.util.Iterator;

public class DeIterator implements Iterator {

    De[] des;
    int positionDe = 0;

    public DeIterator(De[] des){
        this.des = des;
    }

    @Override
    public boolean hasNext() {
        if(positionDe >= des.length || des[positionDe] == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public De next() {
        De de = des[positionDe];
        positionDe = positionDe + 1;
        return de;
    }
}
