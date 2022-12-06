package boggle;

public class HintPress implements Command{
    ButtonObject theButton;
    public HintPress(ButtonObject button){
        theButton = button;
    }


    @Override
    public void execute() {
        theButton.press();
    }
}
