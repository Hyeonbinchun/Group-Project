package boggle;

/**
 * OrangeColorPaletteBuilder implements from ColorPaletteBuilder. It builds orange color palette
 */
public class OrangeColorPaletteBuilder implements ColorPaletteBuilder {
    private ColorPalette orangeColorPalette;

    public OrangeColorPaletteBuilder() {
        this.orangeColorPalette = new ColorPalette();
    }

    /**
     * set box color to orange
     */
    @Override
    public void buildBoxColorBuilder() {
        orangeColorPalette.setBoxColor("ORANGE");
    }

    /**
     * set stroke color to blue
     */
    @Override
    public void buildStrokeColorBuilder() {
        orangeColorPalette.setStrokeColor("BLUE");
    }

    /**
     *
     * @return orangeColorPalette
     */
    public ColorPalette getColorPalette() {
        return this.orangeColorPalette;
    }

}