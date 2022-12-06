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

public class SizeMenu {

    private int BoardSize;
    private VBox lines;
    private Stage ColorMenu;
    private String[] sizes = {"Small", "Large"};


    /*
     * Showing the start menu, choose the board size.
     */
    public SizeMenu(Stage stage) {
        this.ColorMenu = stage;
        lines = new VBox(Datas.verticalSpacing); //Set vertical box spacing
        lines.setAlignment(Pos.CENTER);

        Label describe1 = new Label("Choose the size of the grid: ");
        lines.getChildren().add(describe1);


        for (String size: sizes) {
            this.AddButton(size);
        }
    }

    private void AddButton(String size) {
        Button button = new Button();
        button.setText(size);
        button.setOnAction(e -> {
            // Edit to make the pattern work

            if (size.equals("Small")){

            } else {

            }
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
    private void startGame() throws IOException {
        System.out.println("start game with: " + Datas.boardSize);
        Stage stage = new Stage();
        GameViewer board = new GameViewer(Datas.boardSize);
        stage.setScene(new Scene(board.getBoard(), board.getViewerWidth(), board.getViewerHeight()));
        stage.setTitle("Boggle");
        stage.show();
    }


    public VBox getLines() {
        return this.lines;
    }


}
