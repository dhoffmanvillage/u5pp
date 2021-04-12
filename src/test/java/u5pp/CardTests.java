package u5pp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class CardTests {
    private static final String DEFAULT_VALUE = "2";
    private static final String DEFAULT_SUIT = "clubs";

    @Test
    void defaultConstructorAndAccessorsWorksCorrectly() throws Exception {
        Card card = new Card();
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(DEFAULT_VALUE, card.getValue()),
            () -> assertEquals(DEFAULT_SUIT, card.getSuit())
        );
    }

    @Test
    void suitedConstructorAndAccessorsWorksCorrectly() throws Exception {
        String suit = "spades";
        Card card = new Card(suit);
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(DEFAULT_VALUE, card.getValue()),
            () -> assertEquals(suit, card.getSuit())
        );
    }

    @Test
    void suitedAndValuedConstructorAndAccessorsWorksCorrectly() throws Exception {
        String suit = "spades", value = "ace";
        Card card = new Card(suit, value);
        
        assertAll("Default constructor and all accessors work correctly", 
            () -> assertEquals(value, card.getValue()),
            () -> assertEquals(suit, card.getSuit())
        );
    }

    @Test
    void changeValueWorksCorrectly() throws Exception {
        String validValue = "JACK", invalidValue = "JOCK";
        Card c = new Card();
        c.changeValue(validValue);
        c.changeValue(invalidValue);

        assertEquals(validValue.toLowerCase(), c.getValue());
    }

    @Test
    void changeSuitWorksCorrectly() throws Exception {
        String validValue = "HEaRTS", invalidValue = "HeOrts";
        Card c = new Card();
        c.changeSuit(validValue);
        c.changeSuit(invalidValue);

        assertEquals(validValue.toLowerCase(), c.getSuit());
    }

    @Test
    void toStringWorksCorrectly() throws Exception {
        String suit = "diamonds", value = "10", expectedOutput = "The " + value + " of " + suit;
        Card card = new Card(suit, value);

        assertEquals(expectedOutput, card.toString());
    }

    @Test
    void equalsWorksCorrectly() throws Exception {
        String suitOne = "hearts", suitTwo = "diamonds", valueOne = "ace", valueTwo = "two";
        Card c1 = new Card(suitOne, valueOne), c2 = new Card(suitOne, valueOne), c3 = new Card(suitTwo, valueOne),
            c4 = new Card(suitOne, valueTwo), c5 = new Card(suitTwo, valueTwo);

        assertAll("equals checks both value and suit correctly", 
            () -> assertTrue(c1.equals(c2)),
            () -> assertFalse(c1.equals(c3)),
            () -> assertFalse(c1.equals(c4)),
            () -> assertFalse(c1.equals(c5)),
            () -> assertTrue(c5.equals(c5))
        );
    }
}