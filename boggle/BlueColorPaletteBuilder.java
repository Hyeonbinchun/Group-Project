package boggle;

/*
 * BlueColorPaletteBuilder implements from ColorPaletteBuilder. It builds blue color palette
 */
public class BlueColorPaletteBuilder implements ColorPaletteBuilder{

    // Create ColorPalette object
    private ColorPalette blueColorPalette;

    public BlueColorPaletteBuilder() {
        this.blueColorPalette = new ColorPalette();
    }

    @Override
    public void buildBoxColorBuilder() {
        this.blueColorPalette.setBoxColor("BLUE");
    }

    @Override
    public void buildStrokeColorBuilder() {
        this.blueColorPalette.setStrokeColor("ORANGE");
    }

    public ColorPalette getColorPalette() {
        return this.blueColorPalette;
    }

}