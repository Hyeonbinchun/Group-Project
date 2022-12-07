package boggle;
// This is the Singleton class

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameViewer {

    private int ViewerHeight; //Viewer height
    private int ViewerWidth; //Viewer width
    private BorderPane board = new BorderPane();
    private GridViewer bogglegrid;
    private Datas datas;

    private static GameViewer firstInstance = null;
    private GameViewer(int size){
        bogglegrid = new GridViewer(size);
        ViewerWidth = 135 * size;
        ViewerHeight = 155 +  135 * size;
        board.setCenter(bogglegrid.getGrid());
        // buttons here
        BorderPane bottomButtons = new BorderPane();
        bogglegrid.addButtons(bottomButtons);
        board.setBottom(bottomButtons);
        Button button = new Button("End Game");
        bottomButtons.setBottom(button);
        button.setOnAction(e -> {
            resultMenu();
        });
        BorderPane.setAlignment(button, Pos.CENTER);
    }

    public static void resultMenu() {
        Stage resultStage = new Stage();
        resultStage.setScene(new Scene(new ResultMenu(resultStage).getLines(), Datas.MenuWidth, Datas.MenuHeight));
        resultStage.show();
    }
    public static GameViewer getInstance(int size) {
        if (firstInstance == null){
            firstInstance = new GameViewer(size);
        }
        return firstInstance;
    }

    
    /**
     * getter of the viewer height
     * @return ViewerHeight
     */
    public int getViewerHeight() {return ViewerHeight;}

    /**
     * getter of the viewer width
     * @return ViewerWidth
     */
    public int getViewerWidth() {return ViewerWidth;}

    /**
     * getter of the boardview
     * @return board pane
     */
    public BorderPane getBoard() {return board;}
}
