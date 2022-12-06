package boggle;

public class ColorPalette implements ColorPalettePlan{
    private String boxColor;
    private String StrokeColor;


    @Override
    public void setBoxColor(String boxColor) {
        this.boxColor = boxColor;
    }

    @Override
    public void setStrokeColor(String StrokeColor) {
        this.StrokeColor = StrokeColor;
    }

    public String getBoxColor() {
        return boxColor;
    }

    public String getStrokeColor() {
        return StrokeColor;
    }
}