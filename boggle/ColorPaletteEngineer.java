package boggle;
import javafx.scene.paint.Color;

public class ColorPaletteEngineer {
    private ColorPaletteBuilder colorPaletteBuilder;
    private String type;

    public ColorPaletteEngineer(String colorType){
        if (colorType.equals("BLUE")){
            this.colorPaletteBuilder = new BlueColorPaletteBuilder();
        } else if (colorType.equals("RED")){
            this.colorPaletteBuilder = new RedColorPaletteBuilder();
        } else if (colorType.equals("ORANGE")){
            this.colorPaletteBuilder = new OrangeColorPaletteBuilder();
        }

    }
    public ColorPalette getColorPalette() {
        return this.colorPaletteBuilder.getColorPalette();
    }

    public Color[] makeColorPalette() {
        Color[] returnList = new Color[2];
        this.colorPaletteBuilder.buildBoxColorBuilder();
        returnList[0] = Color.valueOf(this.colorPaletteBuilder.getColorPalette().getBoxColor());
        this.colorPaletteBuilder.buildStrokeColorBuilder();
        returnList[1] = Color.valueOf(this.colorPaletteBuilder.getColorPalette().getStrokeColor());
        return returnList;
    }
}
