import org.junit.jupiter.api.*;
import mickel.io.Key;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
public class PlayerTest {
    // Can test the keyPressed method and checkForTraps
    // What keyPressed does:
        // 1) Checks to see if the player has activated the trap; if so, it moves the player
        // back to start and sets the appropriate numbers on board 
        // 2) Checks if a specific key (UP, DOWN, LEFT, or RIGHT) is pressed
        // 3) If it is pressed, it checks if the space Player wants to move is not on a wall and is not
        // going out of the bounds of the maze. It then checks if it is on a trap (calls checkForTraps)
        // Then, it moves the player to that space, sets the previous position to clear
        // 4) Calls checkIfOnTrap()
        // 5) Calls checkFinish()
        // 6) It lastly sets the player's new position to a 2
    @Test
    public void testPlayerCanMoveLeftIfNoWall() {
        int UNIT = 40;
        Player player = new Player(19 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        player.keyPressed(Key.LEFT);
        Player expected = new Player(18 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        assertEquals(player, expected);
    }

    @Test
    public void testPlayerCannotMoveIfRunsIntoWall() {
        int UNIT = 40;
        Player player = new Player(19 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        Wall wall = new Wall(19 * UNIT, 7 * UNIT, UNIT, Color.BLUE);
        player.keyPressed(Key.UP);
        Player expected = new Player(19 * UNIT, 8 * UNIT, UNIT, Color.WHITE);
        assertEquals(player, expected);    
    }
}
