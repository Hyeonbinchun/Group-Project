package boggle;

public class Hint implements ButtonObject{
    GridViewer gridviewer;
    public Hint(GridViewer gridviewer1){
        gridviewer = gridviewer1;
    }


    @Override
    public void press() {
        gridviewer.hint();
    }
}
