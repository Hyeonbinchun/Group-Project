package boggle;

public class RedColorPaletteBuilder implements ColorPaletteBuilder{
    private ColorPalette colorPalette;

    public RedColorPaletteBuilder() {
        this.colorPalette = new ColorPalette();
    }

    @Override
    public void buildBoxColorBuilder() {
        colorPalette.setBoxColor("RED");
    }

    @Override
    public void buildStrokeColorBuilder() {
        colorPalette.setStrokeColor("GREEN");
    }

    public ColorPalette getColorPalette() {
        return this.colorPalette;
    }

}