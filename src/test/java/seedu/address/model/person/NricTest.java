package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NricTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Nric(null));
    }

    @Test
    public void constructor_invalidNric_throwsIllegalArgumentException() {
        String invalidNric = "";
        assertThrows(IllegalArgumentException.class, () -> new Nric(invalidNric));
    }

    @Test
    public void isValidNric() {
        // null nric number
        assertThrows(NullPointerException.class, () -> Nric.isValidNric(null));

        // invalid nric numbers
        assertFalse(Nric.isValidNric("")); // empty string
        assertFalse(Nric.isValidNric(" ")); // spaces only
        assertFalse(Nric.isValidNric("s91p")); // less than 3 numbers
        assertFalse(Nric.isValidNric("nric")); // non-numeric
        assertFalse(Nric.isValidNric("s9011p04a")); // alphabets within digits
        assertFalse(Nric.isValidNric("S5808 994Z")); // spaces within digits
        assertFalse(Nric.isValidNric("B1234567B")); //invalid nric, starting with B

        // valid nric numbers
        assertTrue(Nric.isValidNric("S4003873F")); //NRICs should only contain alphabets or numbers
        // and it should start with S,T,F,G,M (or lower-case) followed by 7 digits, and ending with an alphabet
        assertTrue(Nric.isValidNric("s8674080z")); //valid lowercase nric
        assertTrue(Nric.isValidNric("t9292321a")); //valid lowercase nric, starting with t
        assertTrue(Nric.isValidNric("f9693094k")); //valid lowercase nric, starting with f
        assertTrue(Nric.isValidNric("g3338998t")); //valid lowercase nric, starting with g
        assertTrue(Nric.isValidNric("m1234567b")); //valid lowercasenric, starting with m
        assertTrue(Nric.isValidNric("M1234567B")); //valid lowercase nric, starting with M
    }

    @Test
    public void equals() {
        Nric nric = new Nric("S6946660E");

        // same values -> returns true
        assertTrue(nric.equals(new Nric("S6946660E")));

        // same object -> returns true
        assertTrue(nric.equals(nric));

        // null -> returns false
        assertFalse(nric.equals(null));

        // different types -> returns false
        assertFalse(nric.equals(5.0f));

        // different values -> returns false
        assertFalse(nric.equals(new Nric("S3494047I")));
    }
}
