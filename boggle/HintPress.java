package boggle;

/**
 * HintPress class with command pattern
 */
public class HintPress implements Command{
    Hint theButton; // theButton data structure

    public HintPress(Hint button){
        theButton = button;
    }


    @Override
    public void execute() {
        theButton.press();
    }
}
