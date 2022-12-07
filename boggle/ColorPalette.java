package boggle;

public class ColorPalette implements ColorPalettePlan{
    private String boxColor;
    private String StrokeColor;

    /*
     * Set box color
     */
    @Override
    public void setBoxColor(String boxColor) {
        this.boxColor = boxColor;
    }

    /*
     * Set stroke color
     */
    @Override
    public void setStrokeColor(String StrokeColor) {
        this.StrokeColor = StrokeColor;
    }

    /*
     * Getter of boxColor
     */
    public String getBoxColor() {
        return boxColor;
    }

    /*
     * Getter of strokeColor
     */
    public String getStrokeColor() {
        return StrokeColor;
    }
}