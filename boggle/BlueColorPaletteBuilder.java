package boggle;

public class BlueColorPaletteBuilder implements ColorPaletteBuilder{
    private ColorPalette colorPalette;

    public BlueColorPaletteBuilder() {
        this.colorPalette = new ColorPalette();
    }

    @Override
    public void buildBoxColorBuilder() {
        colorPalette.setBoxColor("BLUE");
    }

    @Override
    public void buildStrokeColorBuilder() {
        colorPalette.setStrokeColor("ORANGE");
    }

    public ColorPalette getColorPalette() {
        return this.colorPalette;
    }

}