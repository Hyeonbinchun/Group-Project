package boggle;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Gridviewer class represents the boggle grid GUI.
 * 
 */
public class GridViewer {

    /**
     * size of grid
     */  
    //private final int Datas.boardSize;
    private final GridPane board;
    private final boolean[][] picked;
    private char[][] letterBoard;
    private ArrayList<Position> pickedPosition;
    private Label highestLabel;
    private Label wordLabel;
    private Label scoreLabel;
    private Label messageLabel;
    private Label roundLabel;
    private String word;
    private ArrayList<String> foundWords;
    private ArrayList<Rectangle> gridBox;
    private Position lastPicked;
    private Boggle boggle;
    private GameStats stats;


    /**
     * BoggleGrid constructor
     * @param size size of the grid
     */
    public GridViewer(int size) {
        Datas.boardSize = size;
        this.stats = new GameStats();
        this.foundWords = new ArrayList<>();
        this.board = new GridPane();
        this.picked = new boolean[size][size];
        this.letterBoard = Boggle.initalizeBoard(size);
        this.board.setFocusTraversable(true);
        this.pickedPosition = new ArrayList<>();
        this.word = "";
        this.GridButtons();
        this.allFalse();
        this.stats = new GameStats();

        //Initialize boggle to get all valid words
        this.boggle = new Boggle();

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

    /**
     * Add grid button that come up with a game board
     */
    private void GridButtons() {
        this.board.setStyle(Datas.boardColor);
        this.gridBox = new ArrayList<>();
        for (int i = 0; i < Datas.boardSize; i++) {
            for (int j = 0; j < Datas.boardSize; j++) {
                Label letter = new Label();
                letter.setText("");
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

    /**
     * add clickable button 'check word', 'clear'
     * and display the message and score
     * @param pane
     */

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
        Button hintButton = new Button("Hint"); //button that make a hint
        hintButton.setOnAction(e -> {
            Hint hint = new Hint(this);
            hint.press();
            this.board.requestFocus();
            e.consume();
        });
        Button newGameButton = new Button("New Round"); //button that restart the game
        newGameButton.setOnAction(e -> {
            this.newRound();
            this.board.requestFocus();
          
            e.consume();
        });
        VBox buttons =  new VBox(Datas.verticalSpacing);
        buttons.getChildren().addAll(checkButton, clearButton, hintButton, newGameButton);
        pane.setRight(buttons);

        VBox vbox = new VBox(Datas.verticalSpacing);
        this.roundLabel = new Label("Round: " + (stats.getRound()+1));
        this.roundLabel.setFont(Datas.fontSize);
        this.highestLabel = new Label("Highest score: 0");
        this.highestLabel.setFont(Datas.fontSize);
        this.scoreLabel = new Label("Score: 0");
        this.scoreLabel.setFont(Datas.fontSize);
        this.wordLabel = new Label("Current Word: ");
        this.wordLabel.setFont(Datas.fontSize);
        this.messageLabel = new Label("GOOD LUCK!");
        this.scoreLabel.setFont(Datas.fontSize);

        vbox.getChildren().addAll(this.roundLabel, this.highestLabel, this.scoreLabel,
                this.messageLabel, this.wordLabel);
        pane.setCenter(vbox);

    }


    /**
     * Check if word is valid and make update
     */
    private void checkWord() {
        for(String word: boggle.getValidWords()) {
            if (this.foundWords.contains(this.word)) {
                this.messageLabel.setText("You already found ‘"+ this.word + "’ try another word");
                clearWord();
                return;
            }
            if (word.toLowerCase().equals(this.word) && !this.foundWords.contains(this.word)) {
                addWord();
                return;
            }
        }
        this.messageLabel.setText("This word is not valid");
        this.messageLabel.setFont(Datas.fontSize);
    }

    /**
     * add valid word to wordlist, and update the score
     */
    private void addWord() {
        this.foundWords.add(this.word);
        this.messageLabel.setText("You found: "+ this.word + " !!!");
        this.messageLabel.setFont(Datas.fontSize);
        this.stats.addWord(this.word);
        this.scoreLabel.setText("Score: " + this.stats.getScore());
        if(this.stats.getScore() >= this.stats.getHighest()){
            this.highestLabel.setText("Highest score: " + this.stats.getHighest());}
        clearWord();
    }


    /**
     * Clear all letters that select
     */
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


    /**
     * add letter at selected position to word.
     * @param position
     */
    private void addLetter(Position position) {
        this.word = this.word + Character.toString(letterBoard[position.getCol()][position.getRow()]).toLowerCase();
        this.wordLabel.setText("Current Word: " + word.toLowerCase());
    }


    private void newRound() {
        this.stats.endRound();
        clearWord();
        this.board.getChildren().clear();
        this.letterBoard = Boggle.initalizeBoard(Datas.boardSize);
        this.boggle = new Boggle();
        this.GridButtons();
        this.allFalse();
        this.foundWords.clear();
        this.scoreLabel.setText("Score: 0");
        this.roundLabel.setText("Round: " + (stats.getRound()+1));
    }
    /**
     * reset the picked position.
     */
    private void allFalse() {
        for (int i = 0; i < Datas.boardSize; i++) {
            for (int j = 0; j < Datas.boardSize; j++) {
                this.picked[i][j] = false;
            }
        }
    }

    public void hint() {
        boolean found = false;
        if (this.foundWords.contains(this.word)) {
            this.messageLabel.setText("You already found: " + this.word);
            this.messageLabel.setFont(Datas.fontSize);
            return;
        }
        for(String word: boggle.getValidWords()) {
            if (word.toLowerCase().startsWith(this.word)) {
                if (!this.foundWords.contains(word.toLowerCase())){
                    found = true;
                    this.messageLabel.setText("Hint: " + word);
                    this.messageLabel.setFont(Datas.fontSize);
                }

            }
        }
        if (!found) {
            this.messageLabel.setText("No word starts with: " + this.word);
            this.messageLabel.setFont(Datas.fontSize);
        }


    }
    public Node getGrid() {
        return this.board;
    }



}
