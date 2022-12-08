package boggle;

/**
 * ColorPalette that implements ColorPalettePLan
 */
public class ColorPalette implements ColorPalettePlan{
    private String boxColor; // Store box color
    private String StrokeColor; // Store stroke color

    /**
     * Set box color
     */
    @Override
    public void setBoxColor(String boxColor) {
        this.boxColor = boxColor;
    }

    /**
     * Set stroke color
     */
    @Override
    public void setStrokeColor(String StrokeColor) {
        this.StrokeColor = StrokeColor;
    }

    /**
     * Getter of boxColor
     */
    public String getBoxColor() {
        return boxColor;
    }

    /**
     * Getter of strokeColor
     */
    public String getStrokeColor() {
        return StrokeColor;
    }
}