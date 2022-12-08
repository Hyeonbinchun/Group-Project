package boggle;

/**
 * Interface of ColorPaletteBuilder
 */
public interface ColorPaletteBuilder {
    void buildBoxColorBuilder();
    void buildStrokeColorBuilder();
    ColorPalette getColorPalette();
}