package boggle;
import java.util.*;


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

    private int BoardSize;
    private VBox lines;
    private Stage ColorMenu;
    private String[] colorBoxList = {"RED", "BLUE", "ORANGE"};
    private ColorPaletteBuilder colorPalette;



    /*
     * Showing the start menu, choose the board size.
     */
    public ColorMenu(Stage stage) {
        this.ColorMenu = stage;
        lines = new VBox(Datas.verticalSpacing); //Set vertical box spacing
        lines.setAlignment(Pos.CENTER);

        Label describe1 = new Label("Choose the color of the grid: ");
        lines.getChildren().add(describe1);

        for (int i = 0; i< colorBoxList.length; i++) {
            this.AddButton(colorBoxList[i]);
        }

    }

    private void AddButton(String box) {
        Button button = new Button();
        button.setText(box);
        button.setOnAction(e -> {
            // Edit to make the pattern work
            if (box.equals("BLUE")){
                this.colorPalette = new BlueColorPaletteBuilder();
            } else if (box.equals("RED")){
                this.colorPalette = new RedColorPaletteBuilder();
            } else if (box.equals("ORANGE")){
                this.colorPalette = new OrangeColorPaletteBuilder();
            }
            ColorPaletteEngineer colorPaletteEngineer = new ColorPaletteEngineer(this.colorPalette);
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

    /**
     * Called when user pick the grid size, show the Game board with size scene.
     *
     */
//    private void sizeMenu() throws IOException {
//        Stage colorStage = new Stage();
//        colorStage.setScene(new Scene(new SizeMenu(colorStage).getLines(), Datas.MenuWidth, Datas.MenuHeight));
//        colorStage.show();
//    }
    private void startGame() throws IOException {
        System.out.println("start game with: " + Datas.boardSize);
        Stage stage = new Stage();
        GameViewer board = GameViewer.getInstance(Datas.boardSize);
        stage.setScene(new Scene(board.getBoard(), (135 * Datas.boardSize), (155 +  135 * Datas.boardSize)));
        stage.setTitle("Boggle");
        stage.show();
    }

    public VBox getLines() {
        return this.lines;
    }


}
