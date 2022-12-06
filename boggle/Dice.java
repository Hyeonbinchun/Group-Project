package boggle;

import java.util.Iterator;

public class Dice implements Container {
    private String diceList[];

    public Dice() {
        super();
        if (Datas.boardSize == 5) {
            this.diceList = Datas.dice_big_grid;
        } else {
            this.diceList = Datas.dice_small_grid;
        }
    }
    @Override

    public Iterator<String> getIterator() {
        return new diceCollection(this);
    }

    public String[] getDice() {
        return this.diceList;
    }
    public int length() {
        return this.diceList.length;
    }

    public static class diceCollection implements Iterator<String> {
        private int curr = 0;
        private static Dice dice;

        public diceCollection(Dice dice) {
            super();
            this.dice = dice;
        }

        @Override
        public boolean hasNext() {
            if (curr < diceCollection.dice.length()) {
                return true;
            }
            return false;

        }

        @Override
        public String next() {
            if (this.hasNext()) {
                return dice.diceList[curr++];
            }
            return null;
        }
    }
}
