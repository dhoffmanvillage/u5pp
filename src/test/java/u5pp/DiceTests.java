package u5pp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class DiceTests {

    private final int DEFAULT_SIDES = 6;
    private final int DEFAULT_START = 1;
    private final String DEFAULT_COLOR = "green";

    @Test
    void defaultConstructorAndAccessorsWorksCorrectly() throws Exception {
        Dice defaultDice = new Dice();
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(DEFAULT_SIDES, defaultDice.getSides()),
            () -> assertEquals(DEFAULT_START, defaultDice.getCurrentSide()),
            () -> assertEquals(DEFAULT_COLOR, defaultDice.getColor())
        );
    }

    @Test
    void sidedConstructorAndAccessorsWorkCorrectly() throws Exception {
        int numSides = 8;
        Dice sidedDice = new Dice(numSides);
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(numSides, sidedDice.getSides()),
            () -> assertEquals(DEFAULT_START, sidedDice.getCurrentSide()),
            () -> assertEquals(DEFAULT_COLOR, sidedDice.getColor())
        );
    }

    @Test
    void startedConstructorAndAccessorsWorkCorrectly() throws Exception {
        int numSides = 20;
        int startingSide = 19;
        Dice startedDice = new Dice(numSides, startingSide);
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(numSides, startedDice.getSides()),
            () -> assertEquals(startingSide, startedDice.getCurrentSide()),
            () -> assertEquals(DEFAULT_COLOR, startedDice.getColor())
        );
    }

    @Test
    void invalidStartedConstructorWorksCorrectly() throws Exception {
        int numSides = 3;
        int startingSide = 4;
        Dice startedDice = new Dice(numSides, startingSide);
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(numSides, startedDice.getSides()),
            () -> assertEquals(DEFAULT_START, startedDice.getCurrentSide()),
            () -> assertEquals(DEFAULT_COLOR, startedDice.getColor())
        );
    }

    @Test
    void coloredConstructorAndAccessorsWorksCorrectly() throws Exception {
        int numSides = 10;
        int startingSide = 4;
        String color = "teal";
        Dice coloredDice = new Dice(numSides, startingSide, color);
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(numSides, coloredDice.getSides()),
            () -> assertEquals(startingSide, coloredDice.getCurrentSide()),
            () -> assertEquals(color, coloredDice.getColor())
        );
    }

    @Test
    void equalsWorksCorrectly() throws Exception {
        Dice d1 = new Dice(30, 2);
        Dice d2 = new Dice(5, 2);
        Dice d3 = new Dice(30, 3);

        assertAll("Two dice are equal if they are on the same side", 
            () -> assertTrue(d1.equals(d2)),
            () -> assertFalse(d1.equals(d3))
        );
    }

    @Test
    void toStringWorksCorrectly() throws Exception {
        int numSides = 10, currentSide = 5;
        String color = "forest green", expectedOutput = "The " + color + " " + numSides + "-sided dice is showing " + currentSide;
        Dice testDice = new Dice(numSides, currentSide, color);

        assertEquals(expectedOutput, testDice.toString());
    }

    @Test
    void changeNumSidesWorksCorrectly() throws Exception {
        int newSides = 8;
        Dice d = new Dice();
        d.changeNumSides(newSides);
        assertEquals(newSides, d.getSides());
    }

    @Test
    void changeColorWorksCorrectly() throws Exception {
        String newColor = "maroon";
        Dice d = new Dice();
        d.changeColor(newColor);
        assertEquals(newColor, d.getColor());
    }

    @Test
    void changeCurrentSideWorksCorrectly() throws Exception {
        int validFace = 2;
        int invalidFace = 7;
        Dice d = new Dice();
        d.changeSide(validFace);
        d.changeSide(invalidFace);
        assertEquals(validFace, d.getCurrentSide());
    }

    @Test
    void rollWorksCorrectly() throws Exception {
        final int ROLL = 0, SIDE = 1;
        int[][] rollsAndSides = new int[100][2];
        Dice diceToRoll = new Dice(100);

        for(int i = 0; i < rollsAndSides.length; i++) {
            rollsAndSides[i][ROLL] = diceToRoll.roll();
            rollsAndSides[i][SIDE] = diceToRoll.getCurrentSide();
        }

        assertAll("Dice rolls are between 1 and numSides, returns and updates the new currentSide, and are pseudorandom.",
                () -> assertTrue(isRandom(rollsAndSides)),
                () -> assertTrue(allEquals(rollsAndSides)),
                () -> assertTrue(allValid(diceToRoll.getSides(), rollsAndSides))
            );
    }

    boolean isRandom(int[][] rollsAndSides) {
        for(int i = 1; i < rollsAndSides.length; i++) {
            if(rollsAndSides[i][0] != rollsAndSides[i-1][0]) {
                return true;
            }
        }
        return false;
    }

    boolean allEquals(int[][] rollsAndSides) {
        for(int[] x : rollsAndSides) {
            if(x[0] != x[1]) {
                return false;
            }
        }
        return true;
    }

    boolean allValid(int sides, int[][] rollsAndSides) {
        for(int[] x : rollsAndSides) {
            if(x[0] <= 0 || x[0] > sides) {
                return false;
            }
        }
        return true;
    }
}