package Task1;

import java.util.Iterator;
import java.util.Random;

public class RandomsIterator implements Iterator<Integer> {

    protected Random random;
    protected int max;
    protected int min;

    public RandomsIterator(Random random, int min, int max) {
        this.random = random;
        this.max = max;
        this.min = min;
    }

    public boolean hasNext() {
        return true;
    }

    public Integer next() {
        return random.nextInt(max + 1 - min) + min;
    }

    public void remove() {}
}
