package boggle;

import java.util.ArrayList;

/**
 * Class to hold Position information associated with a BoggleGrid
 */
public class Position {
    /**
     * row
     */    
    private int row;
    /**
     * column
     */    
    private int col;

    /**
     * A grid Position.
     * Sets row and column to 0, by default
     */
    public Position() {
        this.row = 0;
        this.col = 0;
    }

    /**
     * A grid Position.
     * 
     * @param row row
     * @param col column
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

   /*
     * Useful getter and setter method for class attributes
     */
    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
    public int getRow() { return this.row; }
    public int getCol() { return this.col; }

    /**
     * Returns if current position is inside the ArrayList<Position>
     * @param positions
     * @return true if two position are the same
     */
    public boolean inside(ArrayList<Position> positions) {
        for (Position p: positions) {
            if (p.getCol() == this.getCol() && p.getRow() == this.getRow()) {
                return true;
            }
        }

        return false;

    }
}
