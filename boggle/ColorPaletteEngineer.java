package boggle;

/**
 * ColorPaletteEngineer
 *
 * set the different types of colorPaletteBuilders depending on the color user choose
 */
public class ColorPaletteEngineer {
    private ColorPaletteBuilder colorPaletteBuilder;

    /**
     * Initializer that create different types of colorPaletteBuilders depending on the colorType argument
     */
    public ColorPaletteEngineer(String colorType){
        switch (colorType) {
            case "BLUE" -> this.colorPaletteBuilder = new BlueColorPaletteBuilder();
            case "RED" -> this.colorPaletteBuilder = new RedColorPaletteBuilder();
            case "ORANGE" -> this.colorPaletteBuilder = new OrangeColorPaletteBuilder();
        }

    }

    /**
     * Building the box color and stroke color depending on which color user choose.
     */
    public void makeColorPalette() {
        this.colorPaletteBuilder.buildBoxColorBuilder();
        this.colorPaletteBuilder.buildStrokeColorBuilder();
    }

    /*
     * Return the colorPalette
     */
    public ColorPalette getColorPalette() {
        return this.colorPaletteBuilder.getColorPalette();
    }



}
