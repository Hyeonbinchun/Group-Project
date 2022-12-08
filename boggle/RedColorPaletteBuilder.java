package boggle;

/**
 * RedColorPaletteBuilder implements from ColorPaletteBuilder. It builds red color palette
 */
public class RedColorPaletteBuilder implements ColorPaletteBuilder{
    private ColorPalette RedColorPalette; // redColorPalette data structure

    /**
     * Constructor for RedColorPalette
     */
    public RedColorPaletteBuilder() {
        this.RedColorPalette = new ColorPalette();
    }

    /**
     * set box color to red
     */
    @Override
    public void buildBoxColorBuilder() {
        RedColorPalette.setBoxColor("RED");
    }

    /**
     * set stroke color to Green
     */
    @Override
    public void buildStrokeColorBuilder() {
        RedColorPalette.setStrokeColor("GREEN");
    }

    /**
     *
     * @return RedColorPalette
     */
    public ColorPalette getColorPalette() {
        return this.RedColorPalette;
    }

}