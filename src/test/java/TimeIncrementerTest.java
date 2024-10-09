import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeIncrementerTest {

    private TimeIncrementer time;

    @BeforeEach
    public void setUp() {
        // Sets up a new TimeIncrementer instance before each test
        time = new TimeIncrementer(0, 0, 0);
    }

    @Test
    public void testConstructorValidation() {
        // Tests that the constructor throws IllegalArgumentException for invalid time values
        assertThrows(IllegalArgumentException.class, () -> new TimeIncrementer(24, 0, 0)); // Invalid hour
        assertThrows(IllegalArgumentException.class, () -> new TimeIncrementer(0, 60, 0)); // Invalid minute
        assertThrows(IllegalArgumentException.class, () -> new TimeIncrementer(0, 0, 60)); // Invalid second
    }

    @Test
    public void testSetHoursValidation() {
        // Tests that setHours method throws IllegalArgumentException for invalid hour values
        assertThrows(IllegalArgumentException.class, () -> time.setHours(24)); // Invalid hour
        assertThrows(IllegalArgumentException.class, () -> time.setHours(-1)); // Invalid hour
    }

    @Test
    public void testSetMinutesValidation() {
        // Tests that setMinutes method throws IllegalArgumentException for invalid minute values
        assertThrows(IllegalArgumentException.class, () -> time.setMinutes(60)); // Invalid minute
        assertThrows(IllegalArgumentException.class, () -> time.setMinutes(-1)); // Invalid minute
    }

    @Test
    public void testSetSecondsValidation() {
        // Tests that setSeconds method throws IllegalArgumentException for invalid second values
        assertThrows(IllegalArgumentException.class, () -> time.setSeconds(60)); // Invalid second
        assertThrows(IllegalArgumentException.class, () -> time.setSeconds(-1)); // Invalid second
    }

    @Test
    public void testIncrementSeconds() {
        // Tests the incrementSeconds method to ensure it correctly increments seconds
        time.incrementSeconds(59);
        assertEquals("00:00:59", time.displayMilitaryTime()); // Check time after 59 seconds
        time.incrementSeconds(1);
        assertEquals("00:01:00", time.displayMilitaryTime()); // Check time after 1 more second
    }

    @Test
    public void testIncrementMinutes() {
        // Tests the incrementMinutes method to ensure it correctly increments minutes
        time.incrementMinutes(59);
        assertEquals("00:59:00", time.displayMilitaryTime()); // Check time after 59 minutes
        time.incrementMinutes(1);
        assertEquals("01:00:00", time.displayMilitaryTime()); // Check time after 1 more minute
    }

    @Test
    public void testIncrementHours() {
        // Tests the incrementHours method to ensure it correctly increments hours
        time.incrementHours(23);
        assertEquals("23:00:00", time.displayMilitaryTime()); // Check time after 23 hours
        time.incrementHours(1);
        assertEquals("00:00:00", time.displayMilitaryTime()); // Check time after 1 more hour
    }
}