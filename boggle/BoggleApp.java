package boggle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the App class which sets up the stage and uses the pane from paneorganizer to display all the elements
 */
public class BoggleApp extends Application {

    private int MenuHeight = 250; // set height of the menu
    private int MenuWidth = 200; // set the width of the menu

    public static void main(String[] args) {
        launch(args);
    }

    /*
     * Show the start Menu
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new StartMenu(primaryStage).getLines(), MenuWidth, MenuHeight));
        primaryStage.show();
    }


}
