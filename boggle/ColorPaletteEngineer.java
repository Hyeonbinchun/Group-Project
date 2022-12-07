package boggle;

public class ColorPaletteEngineer {
    private ColorPaletteBuilder colorPaletteBuilder;

    public ColorPaletteEngineer(String colorType){
        switch (colorType) {
            case "BLUE" -> this.colorPaletteBuilder = new BlueColorPaletteBuilder();
            case "RED" -> this.colorPaletteBuilder = new RedColorPaletteBuilder();
            case "ORANGE" -> this.colorPaletteBuilder = new OrangeColorPaletteBuilder();
        }

    }
    public ColorPalette getColorPalette() {
        return this.colorPaletteBuilder.getColorPalette();
    }

    public void makeColorPalette() {
        this.colorPaletteBuilder.buildBoxColorBuilder();
        this.colorPaletteBuilder.buildStrokeColorBuilder();
    }
}
