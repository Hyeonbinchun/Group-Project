package boggle;

public class OrangeColorPaletteBuilder implements ColorPaletteBuilder {
    private ColorPalette colorPalette;

    public OrangeColorPaletteBuilder() {
        this.colorPalette = new ColorPalette();
    }

    @Override
    public void buildBoxColorBuilder() {
        colorPalette.setBoxColor("ORANGE");
    }

    @Override
    public void buildStrokeColorBuilder() {
        colorPalette.setStrokeColor("BLUE");
    }

    public ColorPalette getColorPalette() {
        return this.colorPalette;
    }

}