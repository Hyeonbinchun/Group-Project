package boggle;

import java.util.Iterator;

/**
 * Dice class
 */
public class Dice implements Container {
    private Iterator<String> diceList;

    /**
     * Constructor that will convert either arrays and arraylist to Iterator type
     */
    public Dice() {
        if (Datas.boardSize == 5) {
            this.diceList = Datas.dice_big_grid.iterator();
        } else {
            this.diceList = new IteratorConverter(Datas.dice_small_grid);
        }
    }

    /**
     * @return Iterator<String> a collection of the possible letters that can be in the letterBoard
     */
    @Override
    public Iterator<String> getIterator() {
        return this.diceList;
    }



}
