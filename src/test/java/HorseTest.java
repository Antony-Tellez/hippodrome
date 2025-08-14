import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {
    private Horse horse;

    @BeforeEach
    void setUp() {
        horse = new Horse("TestHorse", 3.0, 0);
    }

    @Test
    void constructorShouldThrowExceptionWhenNameIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(null, 3.0, 0)
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionWhenNameIsBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("   ", 3.0, 0)
        );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionWhenSpeedIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("Horse", -1.0, 0)
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionWhenDistanceIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("Horse", 3.0, -1.0)
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getNameShouldReturnCorrectName() {
        assertEquals("TestHorse", horse.getName());
    }

    @Test
    void getSpeedShouldReturnCorrectSpeed() {
        assertEquals(3.0, horse.getSpeed());
    }

    @Test
    void getDistanceShouldReturnCorrectDistance() {
        assertEquals(0.0, horse.getDistance());
    }

    @Test
    void moveShouldIncreaseDistance() {
        double initialDistance = horse.getDistance();
        horse.move();
        assertTrue(horse.getDistance() > initialDistance);
    }
}
