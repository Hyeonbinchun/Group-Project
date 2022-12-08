package boggle;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Datas class that store all useful datas that we need for the app
 */
public class Datas {
    //dice specifications, for small and large grids
    public static final String[] dice_small_grid=
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};

    public static final ArrayList<String> dice_big_grid = new ArrayList<String>(Arrays.asList("AAAFRS", "AAEEEE",
            "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
            "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
            "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"));



    public static double MenuWidth = 200; // Width of ColorMenu, StartMenu and ResultMenu
    public static int MenuHeight = 250; // height of ColorMenu, StartMenu and ResultMenu
    public static int boardSize; // Grid size that user picked, will be either 4 or 5
    public static final Color textColor = Color.WHITE; // Letter color on the board

    public static final Color boxColor = Color.WHITE; // Box color

    public static Color strokeColor = Color.YELLOW; // Stroke(boundary) color when a box selected

    public static Font fontSize = new Font("Arial", 15); // Font size of all label message


    public static String boardColor = "-fx-background-color: "; // Background color
    public static double verticalSpacing = 10; // Vertical spacing between each label in VBox
}
