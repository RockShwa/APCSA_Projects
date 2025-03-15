//import java.awt.Graphics2D;

//TODO: Add to the statement below to indicate that a Trap object is a type of MazeObject
public class Trap extends MazeObject
{
	/** 
	 * TRAP CONSTRUCTOR
	 *  Place the location of the maze's Trap on the board maintained in the parent class by invoking the MazeObject constructor.
	 *    	NOTE: Remember that on the board the y coordinate should be entered before the x coordinate
	 *    		since 2D arrays take the row first and then the column.
	 *    
	 *    	EXAMPLE: If your Trap has a x coordinate of 80 and a y coordinate of 0 on the GUI,
	 *    		the position of Trap should be (0/UNIT, 80/UNIT) or (0, 2) on the 2D array called board.
	 *    
	 *    	TYPE: We will use 3 to denote the Type on the board.  
	 *  
	 * NEXT STEP: 
	 *  Go to the UPDATE MAZEGAMEGUI INSTRUCTIONS below and implement the pseudocode described there
	 *  
	 * @param x		x-coordinate of the object's location
	 * @param y		y-coordinate of the object's location
	 *
	 */
	public Trap(int x, int y)
	{
		super(y/UNIT, x/UNIT, 3);
	}
	
//	public void draw(Graphics2D g)
//	{
//		// TODO: Implement the algorithm listed above
//		g.setColor(myColor);
//		g.fillOval(myPosX, myPosY, mySize, mySize);
//	}
	
	/** 
	 * UPDATE MAZEGAMEGUI INSTRUCTIONS
	 *  1. Go to the MazeGameGUI file and add a private helper method called addTraps().
	 *  	- Instantiate at least one trap and add it to the Stage.
	 *  2. Invoke this MazeGameGUI object's addTraps() method in the MazeGameGUI constructor.
	 *  
	 * NEXT STEP: 
	 *  Go to the UPDATE PLAYER INSTRUCTIONS below and implement the pseudocode described there
	 *  
	 */
	
	/** 
	 * UPDATE PLAYER INSTRUCTIONS
	 *  1. Go to the Player file and add two boolean instance variables: trapActivated and finished.
	 *  2. Modify the draw method.
	 *  	If the instance variable is finished is true, the previously written static method drawText will be called.
	 *  	Otherwise, call drawText but place the message in the corner of the Stage (instead of the center of the Stage)
	 *        with smaller text and false for centered text.
	 *  3. Add a private helper method to the Player class entitled checkForTraps() which returns a boolean value.
	 *  	- Declare local integer variables for the absolute distance the Player is from the Trap, and 
	 *        the minimum distance the Player is from the Trap.
	 *      - Initialize the minimum distance the Player is from the Trap to a very large integer value.
	 *      - Use a nested for loop to iterate through the 2D array called board.
	 *  	  -  If the you encounter a Trap on the board (Traps are coded as 3), calculate the absolute distance
	 *           of this Player from the Trap. (HINT: absolute distance is the absolute value of the player's row 
	 *           location minus the trap's row location plus the absolute value of the player's column location minus
	 *           the trap's column location.)
	 *        -  If the absolute distance of the Player from the Trap is less than the minimum distance,
	 *           re-assign the minimum distance to the new minimum value.
	 *      - Update this Player's message to "The nearest trap is " + minimum distance + " spaces away!" .
	 *      - If the minimum distance is a very large integer value, make this Player's message an empty String.
	 *      - Return true if any Traps are on the board and false otherwise.   
	 *  4. Modify the keyPressed method.
	 *      - If trapActivated is true, 
	 *      		- send the Player back to (startX, startY) 
	 *      		- change the Trap's location on the board to a 0
	 *      		- change the Player's current location on the board to a 2
	 *        		- Set trapActivated to false.
	 *      - In all instances (LEFT, RIGHT, DOWN, or UP), 
	 *      		- declare a boolean variable and initialize to the this Player's checkForTraps() method.
	 *      		- if traps are still on the board and if this Player is about to move into the same location
	 *    	          on the board as a Trap object (denoted by 3), 
	 *    					- move the Player into the new position 
	 *     					- change the Player's previous location on the board to a 0
	 *    					- change the Player's current location on the board to a 2
	 *    					- assign trapActivated to true
	 *    					- change this Player's message to "Trap Activated! Press any key to continue...".
	 */

}
