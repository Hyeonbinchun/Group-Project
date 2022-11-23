package boggle;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The BoggleGrid class for the first Assignment in CSC207, Fall 2022
 * The BoggleGrid represents the grid on which we play Boggle 
 */
public class GridViewer {

    /**
     * size of grid
     */  
    private final int size;
    private final GridPane board;
    private final boolean[][] picked;
    private final char[][] letterBoard;
    private GameStets gameStets;
    private ArrayList<Position> pickedPosition;
    private Label wordLabel;
    private Label scoreLabel;
    private Label messageLabel;
    private String word;
    private ArrayList<String> foundWords;
    private ArrayList<Rectangle> gridBox;
    private Position lastPicked;
    private Boggle boggle;

    /**
     * BoggleGrid constructor
     * @param size size of the grid
     */
    public GridViewer(int size) {
        this.size = size;
        this.gameStets = new GameStets();
        this.foundWords = new ArrayList<>();
        this.board = new GridPane();
        this.picked = new boolean[size][size];
        this.letterBoard = Boggle.initalizeBoard(size);
        this.board.setFocusTraversable(true);
        this.pickedPosition = new ArrayList<>();
        this.word = "";
        this.GridButtons();
        this.allFalse();

        //Initialize boggle to get all valid words
        //this.boggle = new Boggle();
        //System.out.println(this.boggle.getValidWords().toString());

        this.board.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            Node clicked = e.getPickResult().getIntersectedNode();
            int row = GridPane.getRowIndex(clicked);
            int col = GridPane.getColumnIndex(clicked);
            Position current = new Position(row, col);
            if(this.pickedPosition.size() == 0) {
                if (!this.picked[row][col] && !current.inside(this.pickedPosition)) {
                    ((Rectangle) clicked).setStroke(Datas.strokeColor);
                    this.picked[row][col] = true;
                    this.pickedPosition.add(current);
                    this.addLetter(current);
                }
            } else {
                lastPicked = this.pickedPosition.get(this.pickedPosition.size() - 1);
                if (!this.picked[row][col] && !current.inside(this.pickedPosition) &&
                        current.inside(valid(lastPicked))) {
                    ((Rectangle) clicked).setStroke(Datas.strokeColor);
                    this.picked[row][col] = true;
                    this.pickedPosition.add(current);
                    this.addLetter(current);

                }
            }

            e.consume();
        });

    }

    private ArrayList<Position> valid(Position curr) {
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(-1, 0, 1));
        ArrayList<Position> direction = new ArrayList<>();
        for (Integer i: d) {
            if (letterBoard.length > i + curr.getRow() && i + curr.getRow() >= 0) {
                for (Integer j : d) {
                    if (letterBoard.length > j + curr.getCol() && j + curr.getCol() >= 0 && !(i==0 && j==0)) {
                        direction.add(new Position(i + curr.getRow(), j + curr.getCol()));

                    }
                }
            }
        }

        return direction;
    }

    private void GridButtons() {
        this.board.setStyle("-fx-background-color: black");
        this.gridBox = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Label letter = new Label();
                letter.setText(String.valueOf(letterBoard[i][j]));
                letter.setFont(new Font("Arial", 30));
                letter.setTextFill(Datas.textColor);

                Rectangle box = new Rectangle(130, 130, Color.TRANSPARENT);
                box.setStroke(Datas.boxColor);
                box.setStrokeWidth(5);
                this.board.add(letter, i, j);
                this.board.add(box, i, j);
                this.gridBox.add(box);

                GridPane.setHalignment(letter, HPos.CENTER);
                GridPane.setValignment(letter, VPos.CENTER);
                GridPane.setHalignment(box, HPos.CENTER);
                GridPane.setValignment(box, VPos.CENTER);

            }
        }
        this.board.requestFocus();

    }


    public void addButtons(BorderPane pane) {
        Button checkButton = new Button("Check Word"); //button that check the word.
        checkButton.setOnAction(e -> {
            this.checkWord();
            this.board.requestFocus();
            e.consume();
        });
        Button clearButton = new Button("Clear"); //button that clear the board
        clearButton.setOnAction(e -> {
            this.clearWord();
            this.board.requestFocus();
            e.consume();
        });
        pane.setRight(checkButton);
        pane.setLeft(clearButton);

        VBox vbox = new VBox(Datas.verticalSpacing);
        this.scoreLabel = new Label("Score: 0");
        this.scoreLabel.setFont(new Font("Arial", 15));
        this.wordLabel = new Label("Current Word: ");
        this.wordLabel.setFont(new Font("Arial", 15));
        this.messageLabel = new Label("GOOD LUCK!");
        this.scoreLabel.setFont(new Font("Arial", 15));

        vbox.getChildren().addAll(this.scoreLabel, this.messageLabel, this.wordLabel);
        pane.setCenter(vbox);

    }

    private void checkWord() {
        for(String words: boggle.getValidWords()) {
            if (words == this.word && !this.foundWords.contains(this.word)) {
                this.foundWords.add(words.toLowerCase());

            }
        }

    }

    private void clearWord() {
        this.word = "";
        this.wordLabel.setText("Current Word: ");
        allFalse();
        for (Rectangle box : this.gridBox) {
            box.setStroke(Datas.boxColor);
        }
        this.pickedPosition = new ArrayList<>();
        lastPicked = new Position();

    }

    private void addLetter(Position position) {
        this.word = this.word + Character.toString(letterBoard[position.getCol()][position.getRow()]).toLowerCase();
        this.wordLabel.setText("Current Word: " + word.toLowerCase());
    }

    private void allFalse() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.picked[i][j] = false;
            }
        }
    }

    public Node getGrid() {
        return this.board;
    }



}
