package boggle;

public interface ColorPaletteBuilder {
    public void buildBoxColorBuilder();
    public void buildStrokeColorBuilder();
    public ColorPalette getColorPalette();
}