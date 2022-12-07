package boggle;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResultMenu {
    private Label roundLabel;
    private Label wordsFoundLabel;
    private Label averageScoreLabel;
    private Label highestScoreLabel;
    private Stage ResultMenu;
    private VBox lines;
    public ResultMenu(Stage stage) {
        this.lines = new VBox(Datas.verticalSpacing);
        this.ResultMenu = stage;
        this.roundLabel = new Label("Round played: " + (GameStats.getRound()+1));
        this.highestScoreLabel = new Label("Highest Score in a round: " + GameStats.getHighest());
        this.wordsFoundLabel = new Label("Words Found: " + GameStats.getPlayerWords().size());
        this.averageScoreLabel = new Label("Total Score: " + GameStats.getTotalScore());
        Button resultButton = new Button();
        resultButton.setText("yay");
        resultButton.setOnAction(e -> Platform.exit());
        lines.getChildren().addAll(this.roundLabel, this.highestScoreLabel,
                this.wordsFoundLabel, this.averageScoreLabel, resultButton);
        lines.setAlignment(Pos.CENTER);
    }

public VBox getLines() {
    return this.lines;
}
public VBox getLines() {return this.lines;}

