package boggle;

import java.util.*;

/**
 * The BoggleGame class for the first Assignment in CSC207, Fall 2022
 */
public class Boggle {
    //change path!!
    Dictionary boggleDict = new Dictionary("C:\\Users\\천현빈\\Documents\\GitHub\\Group-Project\\boggle\\wordlist.txt");

    private static char[][] letterBoard;
    private Map<String, ArrayList<Position>> allWords = new HashMap<String, ArrayList<Position>>();

    public Boggle(){
        this.findAllWords(allWords, letterBoard);
    }



    public static char[][] initalizeBoard(int size) {
        String letters = randomizeLetters(size);
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
     * There will be one letter per grid position, and they will be organized left to right,
     * top to bottom. A strategy to make this string of letters is as follows:
     * -- Assign a one of the dice to each grid position (i.e. dice_big_grid or dice_small_grid)
     * -- "Shuffle" the positions of the dice to randomize the grid positions they are assigned to
     * -- Randomly select one of the letters on the given die at each grid position to determine
     *    the letter at the given position
     *
     * @return String a String of random letters (length 16 or 25 depending on the size of the grid)
     */
    private static String randomizeLetters(int size){
        String random_letter = "";
        String[] letters = new String[0];
        if (size == 4) {
            letters = shuffle(Datas.dice_small_grid);
        } else if (size == 5) {
            letters =  shuffle(Datas.dice_big_grid);
        }
        //System.out.println(letters);
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
    private static String[] shuffle(String[] dice) {
        String[] d = dice;
        Random rand = new Random();
        for (int row=0; row < d.length; row++) {
            for (int col=0; col < d[0].length(); col++) {
                int ran_row = rand.nextInt(d.length);
                int ran_col = rand.nextInt(d[0].length());
                String saved = d[ran_row].substring(ran_col,ran_col+1);
                String curr = d[row].substring(col,col+1);
                d[row] = d[row].substring(0,col) + saved + d[row].substring(col+1);
                d[ran_row] = d[ran_row].substring(0,ran_col) + curr + d[ran_row].substring(ran_col+1);
            }
        }
        return d;
    }

    /* 
     * This should be a recursive function that finds all valid words on the boggle board.
     * Every word should be valid (i.e. in the boggleDict) and of length 4 or more.
     * Words that are found should be entered into the allWords HashMap.  This HashMap
     * will be consulted as we play the game.
     *
     * Note that this function will be a recursive function.  You may want to write
     * a wrapper for your recursion. Note that every legal word on the Boggle grid will correspond to
     * a list of grid positions on the board, and that the Position class can be used to represent these
     * positions. The strategy you will likely want to use when you write your recursion is as follows:
     * -- At every Position on the grid:
     * ---- add the Position of that point to a list of stored positions
     * ---- if your list of stored positions is >= 4, add the corresponding word to the allWords Map
     * ---- recursively search for valid, adjacent grid Positions to add to your list of stored positions.
     * ---- Note that a valid Position to add to your list will be one that is either horizontal, diagonal, or
     *      vertically touching the current Position
     * ---- Note also that a valid Position to add to your list will be one that, in conjunction with those
     *      Positions that precede it, form a legal PREFIX to a word in the Dictionary (this is important!)
     * ---- Use the "isPrefix" method in the Dictionary class to help you out here!!
     * ---- Positions that already exist in your list of stored positions will also be invalid.
     * ---- You'll be finished when you have checked EVERY possible list of Positions on the board, to see
     *      if they can be used to form a valid word in the dictionary.
     * ---- Food for thought: If there are N Positions on the grid, how many possible lists of positions
     *      might we need to evaluate?
     *
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

    public ArrayList<String> getValidWords(){
        ArrayList<String> validWords = new ArrayList<>();
        for (String key:allWords.keySet()) {
            validWords.add(key);
        }

        return validWords;
    }


}
