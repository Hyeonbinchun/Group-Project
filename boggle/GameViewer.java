package boggle;
// This is the Singleton class

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GameViewer {

    private int ViewerHeight; //Viewer height
    private int ViewerWidth; //Viewer width
    private BorderPane board = new BorderPane();
    private GridViewer bogglegrid;


    /**
     *
     * Set buttons here i.e hint
     */

    private static GameViewer firstInstance = null;
    private GameViewer(int size){
        bogglegrid = new GridViewer(size);
        ViewerWidth = 135 * size;
        ViewerHeight = 120 +  135 * size;
        board.setCenter(bogglegrid.getGrid());
        // buttons here
        BorderPane bottomButtons = new BorderPane();
        bogglegrid.addButtons(bottomButtons);
        board.setBottom(bottomButtons);
        Button button = new Button("End Game");
        bottomButtons.setBottom(button);
        button.setOnAction(e -> Platform.exit());
        BorderPane.setAlignment(button, Pos.CENTER);
    }

    public static GameViewer getInstance(int size) {
        if (firstInstance == null){
            firstInstance = new GameViewer(size);
        }
        return firstInstance;
    }

    public void newRound(int size) {

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
