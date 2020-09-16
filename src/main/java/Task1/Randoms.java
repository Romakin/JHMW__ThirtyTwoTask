package Task1;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected RandomsIterator iter;

    public Randoms(int min, int max) {
        this.random = new Random();
        iter = new RandomsIterator(random, min, max);
    }

    public Iterator<Integer> iterator() {
        return this.iter;
    }

}
