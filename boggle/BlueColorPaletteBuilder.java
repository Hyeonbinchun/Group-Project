package boggle;

/**
 * BlueColorPaletteBuilder implements from ColorPaletteBuilder. It builds blue color palette
 */
public class BlueColorPaletteBuilder implements ColorPaletteBuilder{
    private ColorPalette blueColorPalette; // ColorPalette data structure

    /**
     * Constructor for a blueColorPalette
     */
    public BlueColorPaletteBuilder() {
        this.blueColorPalette = new ColorPalette();
    }

    /**
     * set box color
     */
    @Override
    public void buildBoxColorBuilder() {
        this.blueColorPalette.setBoxColor("BLUE");
    }

    /**
     * set stroke color
     */
    @Override
    public void buildStrokeColorBuilder() {
        this.blueColorPalette.setStrokeColor("ORANGE");
    }

    /**
     *
     * @return blueColorPalette
     */
    public ColorPalette getColorPalette() {
        return this.blueColorPalette;
    }

}