package boggle;

import java.util.*;

/**
 * The BoggleGame class for the first Assignment in CSC207, Fall 2022
 */
public class Boggle {

    // Constructor for a blueColorPalette with path of text file make sure it's correct path on your computer!!!
    Dictionary boggleDict = new Dictionary("/Users/a1660453695/Desktop/git life/Group-Project/boggle/wordlist.txt");

    private static char[][] letterBoard; // the letter will be placed on board

    // hashmap that store valid words as well as the path on the letterBoard
    private Map<String, ArrayList<Position>> allWords = new HashMap<String, ArrayList<Position>>();

    /**
     * Constructor for boggle, finding all valid words on the letterBoard
     */
    public Boggle(){
        this.findAllWords(allWords, letterBoard);
    }


    /**
     * Fill letterBoard with proper size
     * @param size
     * @return the filled letterBoard with letter
     */
    public static char[][] initalizeBoard(int size) {
        String letters = randomizeLetters();
        int i = 0;
        letterBoard = new char[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if (letters.length() == 150 || letters.length() == 96) {
                    letterBoard[row][col] = letters.charAt(i*6);
                } else {
                    letterBoard[row][col] = letters.charAt(i);
                }
                i++;
            }
        }
        return letterBoard;
    }

    /*
     * This method should return a String of letters (length 16 or 25 depending on the size of the grid).
     *
     * @return String a String of random letters (length 16 or 25 depending on the size of the grid)
     */
    private static String randomizeLetters(){
        String random_letter = "";
        String[] letters;
        Dice dice = new Dice();
        Iterator<String> diceCollection = dice.getIterator();
        letters = shuffle(diceCollection);

        for (int row=0; row < letters.length; row++) {
                random_letter += letters[row];
        }

        return random_letter;
    }

    /*
     * This function is supporting randomizeLetters().
     * @return a shuffled dice.
     *
     */
    private static String[] shuffle(Iterator<String> dice) {
        String[] shuffledDice = new String[Datas.boardSize * Datas.boardSize];
        Random rand = new Random();
        int curr = 0;
        while (dice.hasNext()) {
            String temp = "";
            String str = dice.next();
            for (int i = 0; i < str.length(); i ++) {
                temp += str.charAt(rand.nextInt(str.length()));
            }
            shuffledDice[curr] = temp;
            curr++;
        }
        return shuffledDice;
    }

    /* 
     * This should be a recursive function that finds all valid words on the boggle board.
     * Every word should be valid (i.e. in the boggleDict) and of length 4 or more.
     * Words that are found should be entered into the allWords HashMap.  This HashMap
     * will be consulted as we play the game.
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     * @param boggleDict A dictionary of legal words
     * @param boggleGrid A boggle grid, with a letter at each position on the grid
     */
    private void findAllWords(Map<String,ArrayList<Position>> allWords, char[][] gridLetters) {
        Map<String,ArrayList<Position>> result = new HashMap<>();
        for(int row = 0; row < gridLetters.length; row++) {
            for(int col = 0; col < gridLetters.length; col++) {
                Position curr = new Position(row, col);
                String currChr = Character.toString(gridLetters[curr.getRow()][curr.getCol()]);
                if (boggleDict.isPrefix(currChr)) {
                    result = possiblePath(curr, gridLetters, boggleDict, new ArrayList<Position>(),
                            currChr);
                    for (Map.Entry<String, ArrayList<Position>> pair: result.entrySet()) {
                        if (pair.getKey().length()>=4 ) {
                            allWords.put(pair.getKey(), pair.getValue());
                        }
                    }
                }

            }

        }
    }



    /* Helper function
     *
     * @return ArrayList<Position>
     */
    private Map<String,ArrayList<Position>> possiblePath(Position curr, char[][] gridLetters, Dictionary boggleDict,
                                                         ArrayList<Position> passed, String prefix) {

        Map<String,ArrayList<Position>> temp = new HashMap<>();

        ArrayList<Position> moves = availableDirection(curr, gridLetters, passed);
        Map<String,ArrayList<Position>> ans = new HashMap<>();
        String currChr = Character.toString(gridLetters[curr.getRow()][curr.getCol()]);
        if (boggleDict.containsWord(prefix)){
            ans.put(currChr, new ArrayList<>(Arrays.asList(curr)));
        }
        for (Position move: moves) {
            String movedChr = Character.toString(gridLetters[move.getRow()][move.getCol()]);
            if (boggleDict.isPrefix(prefix + movedChr)) {
                ArrayList<Position> pas = new ArrayList<>(passed);
                pas.add(curr);
                temp = possiblePath(move, gridLetters, boggleDict, pas,
                        prefix + movedChr);
                for (Map.Entry<String, ArrayList<Position>> pair: temp.entrySet()) {
                    ArrayList<Position> l = new ArrayList<>(Arrays.asList(curr));
                    l.addAll(pair.getValue());
                    ans.put(currChr + pair.getKey() ,l);
                }

            }
        }
        return ans;

    }

    /* Find all possible direction which is not passed
     *
     * @return ArrayList of position
     */
    private ArrayList<Position> availableDirection(Position curr, char[][] gridLetters, ArrayList<Position> passed) {
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(-1, 0, 1));
        ArrayList<Position> direction = new ArrayList<>();
        for (Integer i: d) {
            if (gridLetters.length > i + curr.getRow() && i + curr.getRow() >= 0) {
                for (Integer j : d) {

                    if (gridLetters.length > j + curr.getCol() && j + curr.getCol() >= 0 &&
                            !exist(new Position(i + curr.getRow(), j + curr.getCol()), passed)
                            && !(i==0 && j==0)) {
                            direction.add(new Position(i + curr.getRow(), j + curr.getCol()));

                    }

                }
            }
        }

        return direction;
    }


    /* Find whether element Position in ArrayList<Posision>
     *
     * @return Boolean
     */
    public boolean exist(Position p, ArrayList<Position> passed) {
        for (Position pa: passed) {
            if(pa.getRow() == p.getRow() && pa.getCol() == p.getCol()) {
                return true;
            }
        }
        return false;

    }


    /* Get valid words list from a map
     *
     *  @return an arrayList of valid words
     */
    public ArrayList<String> getValidWords(){
        ArrayList<String> validWords = new ArrayList<>();
        for (String key:allWords.keySet()) {
            validWords.add(key);
        }

        return validWords;
    }





}
