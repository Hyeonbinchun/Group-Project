package boggle;

import java.util.Iterator;

public class Dice implements Container {
    private Iterator<String> diceList;

    public Dice() {
        if (Datas.boardSize == 5) {
            this.diceList = Datas.dice_big_grid.iterator();
        } else {
            this.diceList = new IteratorConverter(Datas.dice_small_grid);
        }
    }
    @Override
    public Iterator<String> getIterator() {
        return this.diceList;
    }



}
