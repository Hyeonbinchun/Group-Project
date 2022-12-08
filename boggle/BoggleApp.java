package boggle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the App class which sets up the stage and uses the pane from paneorganizer to display all the elements
 */
public class BoggleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Show the start Menu
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new StartMenu(primaryStage).getLines(), Datas.MenuWidth, Datas.MenuHeight));
        primaryStage.show();
    }



}
