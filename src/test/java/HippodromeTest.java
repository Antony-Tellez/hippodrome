import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HippodromeTest {
    private List<Horse> horses;
    private Hippodrome hippodrome;

    @BeforeEach
    void setUp() {
        horses = new ArrayList<>();
        horses.add(new Horse("Horse1", 3.0, 0));
        horses.add(new Horse("Horse2", 3.5, 0));
        horses.add(new Horse("Horse3", 4.0, 0));
        hippodrome = new Hippodrome(horses);
    }

    @Test
    void constructorShouldThrowExceptionWhenListIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Hippodrome(null)
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionWhenListIsEmpty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Hippodrome(new ArrayList<>())
        );
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorsesShouldReturnSameList() {
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void moveShouldCallMoveOnAllHorses() {
        hippodrome.move();
        assertTrue(horses.stream().allMatch(h -> h.getDistance() > 0));
    }

    @Test
    void getWinnerShouldReturnHorseWithMaxDistance() {
        horses.get(0).move();
        horses.get(1).move();
        horses.get(2).move();
        Horse winner = hippodrome.getWinner();

        assertEquals(
                horses.stream().max((h1, h2) -> Double.compare(h1.getDistance(), h2.getDistance())).get(),
                winner
        );
    }
}
