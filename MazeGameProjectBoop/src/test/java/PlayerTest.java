import org.junit.jupiter.api.*;
import mickel.io.Key;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {
    private Player player;
    private int UNIT;
    // Can test the keyPressed method and checkForTraps
    // What keyPressed does:
        // 2) Checks if a specific key (UP, DOWN, LEFT, or RIGHT) is pressed
        // 3) If it is pressed, it checks if the space Player wants to move is not on a wall and is not
        // going out of the bounds of the maze. It then checks if it is on a trap (calls checkForTraps)
        // Then, it moves the player to that space, sets the previous position to clear
        // 4) Calls checkIfOnTrap()
        // 5) Calls checkFinish()
        // 6) It lastly sets the player's new position to a 2
    @BeforeEach
    public void setUp() {
        UNIT = 40; // Size of all the components (Player, Finish, Walls, and Traps)
        player = new Player(19 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
    }

    @Test
    public void testPlayerCanMoveLeftIfNoWall() {
        player.keyPressed(Key.LEFT);
        Player expected = new Player(18 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        assertEquals(player, expected);
    }

    @Test
    public void testPlayerCannotMoveIfRunsIntoWall() {
        @SuppressWarnings("unused")
        Wall wall = new Wall(19 * UNIT, 7 * UNIT, UNIT, Color.BLUE);
        player.keyPressed(Key.UP);
        Player expected = new Player(19 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        assertEquals(player, expected);    
    }

    @Test 
    public void testPlayerMovesToStartAfterHittingTrap() {
        @SuppressWarnings("unused")
        Trap trap = new Trap(18 * UNIT, 8 * UNIT);
        player.keyPressed(Key.LEFT);
        Player expected = new Player(19 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        assertEquals(expected, player);
    }

    // @Test
    // public void testMinDistancePlayerFromTrap() {
    //     Trap trap = new Trap(18 * UNIT, 7 * UNIT);
    //     player.checkForTraps();
    //     // Need to access the message to check this, how?
    // }
}
