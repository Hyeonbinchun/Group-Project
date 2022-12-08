package boggle;
// This is the Singleton class

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameViewer {


    private BorderPane board = new BorderPane(); // board data structure
    private GridViewer boggleGrid;// boggleGrid data structure
    private static GameViewer firstInstance = null; // firstInstance data structure

    /**
     * Constructor for the gameViewer GUI
     * @param size board size that user picked
     */
    private GameViewer(int size){
        boggleGrid = new GridViewer(size);
        board.setCenter(boggleGrid.getGrid());
        // buttons here
        BorderPane bottomButtons = new BorderPane();
        boggleGrid.addButtons(bottomButtons);
        board.setBottom(bottomButtons);
        Button button = new Button("End Game");
        bottomButtons.setBottom(button);
        button.setOnAction(e -> {
            resultMenu();
        });
        BorderPane.setAlignment(button, Pos.CENTER);
    }

    /**
     * Showing the resultMenu GUI when called
     */
    public static void resultMenu(){
        Stage resultStage = new Stage();
        resultStage.setScene(new Scene(new ResultMenu(resultStage).getLines(), Datas.MenuWidth, Datas.MenuHeight));
        resultStage.show();
    }

    /**
     *
     * @param size
     * @return GameViewer
     */
    public static GameViewer getInstance(int size){
        if (firstInstance == null){
            firstInstance = new GameViewer(size);
        }
        return firstInstance;
    }

    /**
     * getter of the boardview
     * @return board pane
     */
    public BorderPane getBoard() {return board;}
}
