package boggle;

import java.util.Iterator;

public class IteratorConverter implements Iterator<String> {
    private int curr = 0;
    private static String[] dice;

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
