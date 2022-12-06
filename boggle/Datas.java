package boggle;

import java.awt.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Datas {
    protected static int MenuHeight = 250; // set height of the menu
    protected static int MenuWidth = 200; // set the width of the menu
    protected static int boardSize = 0;

    public Datas (){

    }


    // Color
    public static String boardColor = "-fx-background-color: ";
    public static final Color textColor = Color.WHITE;

    public static Color boxColor = Color.WHITE;

    public static Color strokeColor = Color.YELLOW;


    // Size
    public static Font fontSize = new Font("Arial", 15);



    // irrelevant to design patterns:
    public static final String[] dice_small_grid= //dice specifications, for small and large grids
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};

    public static final String[] dice_big_grid =
            {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
                    "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
                    "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};

    public static int verticalSpacing = 10;

}
