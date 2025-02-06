import java.util.Iterator;
import java.util.List;

class ZigzagIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator1;
    private Iterator<Integer> iterator2;
    private boolean turn;  // To keep track of whose turn it is to return a value

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterator1 = v1.iterator();
        iterator2 = v2.iterator();
        turn = true; // Start with v1
    }

    @Override
    public Integer next() {
        if (turn && iterator1.hasNext()) {
            turn = false; // Switch to the next iterator
            return iterator1.next();
        } else if (!turn && iterator2.hasNext()) {
            turn = true; // Switch to the next iterator
            return iterator2.next();
        }
        return null; // In case no elements left
    }

    @Override
    public boolean hasNext() {
        return iterator1.hasNext() || iterator2.hasNext();
    }
}
