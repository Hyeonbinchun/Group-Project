package boggle;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

//importing colors
import javafx.scene.paint.Color;

public class ColorMenu {

    private VBox lines;
    private Stage ColorMenu;
    private String[] colorBoxList = {"RED", "BLUE", "ORANGE"};


    /*
     * Showing the color menu, choose the color user want.
     */
    public ColorMenu(Stage stage) {
        this.ColorMenu = stage;
        lines = new VBox(Datas.verticalSpacing); //Set vertical box spacing
        lines.setAlignment(Pos.CENTER);

        Label describe1 = new Label("Choose the color of the grid: ");
        lines.getChildren().add(describe1);

        for (String s : colorBoxList) {
            this.AddButton(s);
        }

    }

    /*
     * GUI buttons
     */
    private void AddButton(String box) {
        Button button = new Button();
        button.setText(box);
        button.setOnAction(e -> {
            ColorPaletteEngineer colorPaletteEngineer = new ColorPaletteEngineer(box);
            colorPaletteEngineer.makeColorPalette();
            ColorPalette firstColor = colorPaletteEngineer.getColorPalette();

            Datas.boardColor += firstColor.getBoxColor();
            Datas.strokeColor = Color.valueOf(firstColor.getStrokeColor());;
            try {
                this.startGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ColorMenu.close(); // close the color menu
        });
        lines.getChildren().add(button);

    }

    /*
     *  Function that will show the GameViewer stage.
     */
    private void startGame() throws IOException {
        System.out.println("start game with: " + Datas.boardSize);
        Stage stage = new Stage();
        GameViewer board = GameViewer.getInstance(Datas.boardSize);
        stage.setScene(new Scene(board.getBoard(), (135 * Datas.boardSize), (155 +  135 * Datas.boardSize)));
        stage.setTitle("Boggle");
        stage.show();
    }

    /*
     * Return all the buttons and labels
     */
    public VBox getLines() {
        return this.lines;
    }


}
