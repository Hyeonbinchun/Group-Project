package boggle;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class StartMenu {

    private int BoardSize;
    private VBox lines;
    private Stage StartMenu;

    private int[] gridSize = {5, 4}; // The size of the grid available here, you can adjust size here.


    /*
     * Showing the start menu, choose the board size.
     */
    public StartMenu(Stage stage) {
        this.StartMenu = stage;
        lines = new VBox(Datas.verticalSpacing); //Set vertical box spacing
        lines.setAlignment(Pos.CENTER);

        Label titleLine = new Label("Welcome");
        Label describe1 = new Label("Choose the size of the grid: ");
        lines.getChildren().addAll(titleLine, describe1);

        for (int s: this.gridSize) {
            this.AddButton(s);
        }

    }

    private void AddButton(int size) {
        Button button = new Button();
        button.setText(size + " * " + size);
        button.setOnAction(e -> {
            Datas.boardSize = size;
            try {
                this.colorMenu();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            StartMenu.close(); // close the main menu
        });
        lines.getChildren().add(button);

    }

    /**
     * Called when user pick the grid size, show the Game board with size scene.
     *
     */
    private void colorMenu() throws IOException {
        Stage colorStage = new Stage();
        colorStage.setScene(new Scene(new ColorMenu(colorStage).getLines(), Datas.MenuWidth, Datas.MenuHeight));
        colorStage.show();
    }

    public VBox getLines() {
        return this.lines;
    }


}
