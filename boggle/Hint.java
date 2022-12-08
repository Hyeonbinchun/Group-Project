package boggle;

/**
 * class Hint by using command pattern
 */
public class Hint implements ButtonObject{
    GridViewer gridviewer; // gridview data structure

    /**
     * Constructor for Hint
     * @param gridview
     */
    public Hint(GridViewer gridview){
        gridviewer = gridview;
    }

    /**
     * hint() function will be called when press()
     */
    @Override
    public void press() {
        gridviewer.hint();
    }
}
