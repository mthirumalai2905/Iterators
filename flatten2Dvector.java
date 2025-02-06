import java.util.Iterator;
import java.util.List;

class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> outerIterator;
    private Iterator<Integer> innerIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        outerIterator = vec2d.iterator(); // Initialize outer iterator
        innerIterator = null; // Will be initialized when the inner iterator is available
    }

    @Override
    public Integer next() {
        // Ensure the innerIterator has a next element
        if (hasNext()) {
            return innerIterator.next();
        }
        return null; // This should not happen unless next() is called when hasNext() is false
    }

    @Override
    public boolean hasNext() {
        // Skip to the next non-empty inner iterator
        while ((innerIterator == null || !innerIterator.hasNext()) && outerIterator.hasNext()) {
            innerIterator = outerIterator.next().iterator(); // Get the next list and initialize its iterator
        }
        return innerIterator != null && innerIterator.hasNext();
    }
}
