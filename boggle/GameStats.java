package boggle;

import java.util.HashSet;
import java.util.Set;

/**
 * The BoggleStats class for the first Assignment in CSC207, Fall 2022
 * The BoggleStats will contain statsitics related to game play Boggle 
 */
public class GameStats {

    /**
     * set of words the player finds in a given round 
     */  
    private static Set<String> playerWords = new HashSet<String>();
    /**
     * set of words the computer finds in a given round 
     */  
    private Set<String> computerWords = new HashSet<String>();  
    /**
     * the player's score for the current round
     */  
    private static int pScore;
    /**
     * the computer's score for the current round
     */  
    private static int cScore;
    /**
     * the player's total score across every round
     */  
    private static int pScoreTotal;
    /**
     * the computer's total score across every round
     */  
    private static int cScoreTotal;
    /**
     * the average number of words, per round, found by the player
     */  
    private double pAverageWords;
    /**
     * the average number of words, per round, found by the computer
     */  
    private double cAverageWords; 
    /**
     * the current round being played
     */  
    private static int round;

    /**
     * the highest score
     */
    private static int highest;

    /* BoggleStats constructor
     * ----------------------
     * Sets round, totals and averages to 0.
     * Initializes word lists (which are sets) for computer and human players.
     */
    public GameStats() {
        this.highest = 0;
        this.round = 0;
        this.pScoreTotal = 0;
        this.cScoreTotal = 0;
        this.pScore = 0;
        this.cScore = 0;
        this.cAverageWords = 0.0;
        this.pAverageWords = 0.0;
        this.playerWords = new HashSet<String>();
        this.computerWords = new HashSet<String>();
    }




    /* 
     * Add a word to a given player's word list for the current round.
     * You will also want to increment the player's score, as words are added.
     *
     * @param word     The word to be added to the list
     * @param player  The player to whom the word was awarded
     */
    public static void addWord(String word) {
        playerWords.add(word);
        pScore += word.length() - 3;
        pScoreTotal += word.length() - 3;
        if(getScore() > highest){
            highest = getScore();
        }
    }

    /* 
     * End a given round.
     * This will clear out the human and computer word lists, so we can begin again.
     * The function will also update each player's total scores, average scores, and
     * reset the current scores for each player to zero.
     * Finally, increment the current round number by 1.
     */
    public void endRound() {

        System.out.println("Current pscore: "+ this.getScore());
        System.out.println("Highest: " + this.getHighest());
        this.round += 1;
        this.cScoreTotal += this.cScore;
        this.cScore = 0;
        this.pScore = 0;
        this.pAverageWords = (this.pAverageWords * (this.round-1) + this.playerWords.size())/this.round;
        this.cAverageWords = (this.cAverageWords * (this.round-1) + this.computerWords.size()/this.round);
        this.playerWords.clear();
        this.computerWords.clear();
        
    }

    /* 
     * Summarize one round of boggle.  Print out:
     * The words each player found this round.
     * Each number of words each player found this round.
     * Each player's score this round.
     */
    public void summarizeRound() {
        System.out.println("Round Summary:");
        System.out.println("Player found:" + this.getPlayerWords());
        System.out.println("Player found:" + this.getComputerWords());
        System.out.println("Number of words player found: " + this.playerWords.size()
                + " Score this round:" + this.pScore);
        System.out.println("Number of words computer found: " + this.computerWords.size()
                + " Score this round:" + this.cScore);

    }

    /* 
     * Summarize the entire boggle game.  Print out:
     * The total number of rounds played.
     * The total score for either player.
     * The average number of words found by each player per round.
     */
    public static String[] summarizeGame() {
        String[] summary = new String[3];
        summary[0] = Integer.toString(getRound());
        summary[1] = Integer.toString(getPlayerWords().size());
        summary[2] = Integer.toString(getTotalScore());
        return summary;
    }

    /* 
     * @return Set<String> The player's word list
     */
    public static Set<String> getPlayerWords() {
        return playerWords;
    }

    /*
     * @return Set<String> The computer's word list
     */
    public Set<String> getComputerWords() {
        return this.computerWords;
    }

    /*
     * @return int The number of rounds played
     */
    public static int getRound() { return round; }

    /*
    * @return int The current player score
    */
    public static int getScore() {
        return pScore;
    }
    public static int getHighest() {return highest;}
    public static int getTotalScore(){return pScoreTotal;}

}
