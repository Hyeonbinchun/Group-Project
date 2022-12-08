package boggle;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ResultMenu GUI class
 */
public class ResultMenu {
    private Label roundLabel; // label that shows the round played
    private Label wordsFoundLabel; // label that shows the word player found
    private Label averageScoreLabel; // label that shows the average score per round
    private Label highestScoreLabel; // label that shows the highest score in a round
    private Stage ResultMenu; // resultMenu data Structure
    private VBox lines; // VBox that stores labels and buttons

    /**
     * Constructor that create necessary labels and buttons on result menu
     * @param stage
     */
    public ResultMenu(Stage stage) {
        this.lines = new VBox(Datas.verticalSpacing);
        this.ResultMenu = stage;
        this.roundLabel = new Label("Round played: " + (GameStats.getRound() + 1));
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

    /**
     *
     * @return labels and buttons on result menu
     */
    public VBox getLines() {
        return this.lines;
    }

}

