package boggle;

public interface ColorPaletteBuilder {
    void buildBoxColorBuilder();
    void buildStrokeColorBuilder();
    ColorPalette getColorPalette();
}