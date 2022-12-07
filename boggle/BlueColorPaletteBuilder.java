package boggle;

public class BlueColorPaletteBuilder implements ColorPaletteBuilder{
    private ColorPalette blueColorPalette;

    public BlueColorPaletteBuilder() {
        this.blueColorPalette = new ColorPalette();
    }

    @Override
    public void buildBoxColorBuilder() {
        blueColorPalette.setBoxColor("BLUE");
    }

    @Override
    public void buildStrokeColorBuilder() {
        blueColorPalette.setStrokeColor("ORANGE");
    }

    public ColorPalette getColorPalette() {
        return this.blueColorPalette;
    }

}