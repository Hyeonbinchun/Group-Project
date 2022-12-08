package boggle;

import java.util.Iterator;

/**
 * Iterator converter that will convert an array to Iterator type
 */
public class IteratorConverter implements Iterator<String> {
    private int curr = 0; // store current index
    private static String[] dice; // store dice array

    /**
     * Constructor of dice
     * Store the array
     * @param dice
     */
    public IteratorConverter(String[] dice) {
        this.dice = dice;
    }

    @Override
    public boolean hasNext() {
        if (curr < dice.length) {
            return true;
        }
        return false;

    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return dice[curr++];
        }
        return null;
    }
}
