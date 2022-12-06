package boggle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Datas {

    public static final String[] dice_small_grid= //dice specifications, for small and large grids
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};

    public static final String[] dice_big_grid =
            {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
                    "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
                    "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};

    public static int verticalSpacing = 10;

    public static int boardSize;
    public static final Color textColor = Color.WHITE;

    public static final Color boxColor = Color.WHITE;

    public static Color strokeColor = Color.YELLOW;


    public static Font fontSize = new Font("Arial", 15);

    public static double MenuWidth= 200 ;
    public static String boardColor = "-fx-background-color: ";
    public static int MenuHeight = 250;
}
