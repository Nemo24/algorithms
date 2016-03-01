package basicjava;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by mm on 15/10/15.
 */
public class IterableTest<T> implements Iterable<T> {
    Random rand = new Random();
    int count = 0;
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public IterableTest() {
    }
}
