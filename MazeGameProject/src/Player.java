import mickel.io.Key;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;

public class Player extends MazeObject
{
	private int startX;     	// Starting X position on the GUI, for use with Trap
	private int startY;      	// Starting Y position on the GUI, for use with Trap
	private int myPosX;			// X-coordinate of this player on the GUI
	private int myPosY;			// Y-coordinate of this player on the GUI
	private int mySize;			// Length and Height of this player on the GUI
	private Color myColor;		// Color of this Player object
	private String message; 	// The message displayed on the GUI
	private boolean trapActivated;
	private boolean finished;
	
	/** 
	 * PLAYER CONSTRUCTOR
	 * 1. Place the starting location of this Player on the board maintained in the parent class by invoking the MazeObject constructor.
	 *    	NOTE: Remember that on the board the y coordinate should be entered before the x coordinate
	 *    	since 2D arrays take the row first and then the column.
	 *    
	 *    	EXAMPLE: If your player has a starting x coordinate of 200 and a y coordinate of 360 on the GUI,
	 *    	the starting position of this player should be (360/UNIT, 200/UNIT) or (9, 5) on the 2D array called board.
	 *    
	 *    	TYPE: We will use 2 to denote the player on the board.  
	 * 
	 * 2. Initialize startX, startY, myPosX, myPosY,mySize, myColor, and message for this Player.
	 *    	- startX and myPosX should be initialized to the same value in the constructor.
	 *    	- startY and myPosY should also be initialized to the same value.
	 *    	- message will be displayed when the maze is complete. It should be initialized to an empty string.
	 *    
	 * NEXT STEP: 
	 *  Click the link to go to the draw method and complete its implementation {@link #draw()}	
	 * 
	 * @param x		x-coordinate of the object's location
	 * @param y		y-coordinate of the object's location
	 * @param size	length/height of the object
	 * @param c		color of the object
	 */
	public Player(int x, int y, int size, Color c)
	{
		super(y/MazeObject.UNIT, x/MazeObject.UNIT, 2);
		startX = x;
		myPosX = x;
		startY = y;
		myPosY = y;
		mySize = size;
		myColor = c;
		message = "";
	}
	
	
	/**
	 * DRAW
	 * 	1. Set the Color of g to be this Player's color
	 * 	2. Paint a filled oval onto g that is located at (myPosX, myPosY) with a width and height of mySize. 
	 * 	3. Invoke the static MazeGameGUI drawText() method by passing through g, this Player's message, half the
	 *    	width of this Player's Stage, half the height of this Player's Stage, a font color, a font size of 20, 
	 *    	and true to center the text.
	 *    
	 * NEXT STEP: 
	 *  Click the link to go to the getShape method and complete its implementation {@link #getShape()}	
	 *  
	 * @param g		Graphics2D object
	 */
	public void draw(Graphics2D g)
	{
		g.setColor(myColor);
		g.fillOval(myPosX, myPosY, mySize, mySize);
		if (finished == true) {
			MazeGameGUI.drawText(g, message, this.getStage().getWidth()/2, this.getStage().getHeight()/2, Color.WHITE, 20, true);
		} else {
			MazeGameGUI.drawText(g, message, this.getStage().getWidth()/2, this.getStage().getHeight()/2, Color.WHITE, 12, false);
		}
	}
	
	
	/** 
	 * GET SHAPE
	 *	1. Return a new Ellipse2D.Double object that uses myPosX and myPosY for the x and y parameters
	 *  	and mySize for the width and height parameters.
	 * 
	 * NEXT STEP: 
	 *  Click the link to go to the addPlayer method in the MazeGameGUI class and complete its implementation {@link MazeGameGUI#addPlayer()}
	 */
	public Shape getShape()
	{
		return new Ellipse2D.Double(myPosX, myPosY, mySize, mySize);
	}
	
	/**
	 * KEY PRESSED EVENT HANDLER
	 * 	This event handler will run every time a key is pressed. Implementing this method will allow you to move the Player
	 * 		through the Maze and should prevent the Player from moving somewhere that is unavailable, i.e. into a Wall, Trap, off the board, etc.
	 * 
	 * 	1. If the LEFT key is pressed...
	 * 		If subtracting a unit from myPosX results in a non-negative number, and if there isn't a Wall 
	 * 		in the resulting location, then...
	 * 			- decrease myPosX by a unit
	 * 			- change the Player's previous location on the board to a 0
	 * 			- change the Player's current location on the board to a 2
	 * 	2. If the RIGHT key is pressed...
	 * 		If adding a unit to myPosX results in a number less than the width of this Player's Stage, and if there 
	 * 		isn't a wall in the resulting location, then...
	 *    		- increase myPosX by a unit
	 *    		- change the Player's previous location on the board to a 0 
	 *    		- change the Player's current location on the board to a 2 
	 * 	3. If the DOWN key is pressed...
	 * 		If adding a unit to myPosY results in a number less than the height of this Player's Stage, and if there 
	 * 		isn't a wall in the resulting location, then...
	 *    		- increase myPosY by a unit
	 *    		- change the Player's previous location on the board to a 0
	 *    		- change the Player's current location on the board to a 2
	 * 4. If the UP key is pressed...
	 * 		If subtracting a unit from myPosY results in a non-negative number, and if there isn't a Wall 
	 * 		in the resulting location, then...
	 * 			- decrease myPosY by a unit
	 * 			- change the Player's previous location on the board to a 0
	 * 			- change the Player's current location on the board to a 2
	 * 	5. In all instances (LEFT, RIGHT, DOWN, or UP)...
	 * 		If this Player is about to move into the same location on the board as a Finish object (denoted by 4), 
	 * 			- move the Player into the new position
	 *    		- set the background of this Player's Stage to the same color as this Player
	 *    		- change the message instance field to "You beat (Your name here)'s Maze!"
	 *	6. At the bottom of the keyPressed method but after the if/else if structure, call this Player's
	 *    	printBoard() method to view the current state of the board in the console.
	 *  
	 * NEXT STEP:
	 *  Test your project (play your maze game) to verify its functionality. Then, continue with Phase 2 of the project (instructions on Schoology).   
	 *    
	 *  @param k	the key that was pressed
	 */
	public void keyPressed(Key k) 
	{
		if (k == Key.LEFT) 
		{
			if ((myPosX - UNIT >= 0) && (board[myPosY/UNIT][myPosX/UNIT - 1] != 1)) {
				myPosX -= UNIT;
				board[myPosY/UNIT][myPosX/UNIT + 1] = 0;
				if (board[myPosY/UNIT][myPosX/UNIT] == 4) {
					getStage().setBackground(myColor);
					message = "You beat Aubrey's Maze!";
				}
				board[myPosY/UNIT][myPosX/UNIT] = 2;
			}
		}
		else if (k == Key.RIGHT) 
		{ 
			if ((myPosX + UNIT < this.getStage().getWidth()) && (board[myPosY/UNIT][myPosX/UNIT + 1] != 1)) {
				myPosX += UNIT;
				board[myPosY/UNIT][myPosX/UNIT - 1] = 0;
				if (board[myPosY/UNIT][myPosX/UNIT] == 4) {
					getStage().setBackground(myColor);
					message = "You beat Aubrey's Maze!";
				}
				board[myPosY/UNIT][myPosX/UNIT] = 2;
			}
		}
		else if (k == Key.DOWN ) 
		{ 
			if ((myPosY + UNIT < this.getStage().getHeight()) && (board[myPosY/UNIT + 1][myPosX/UNIT] != 1)) {
				myPosY += UNIT;
				board[myPosY/UNIT - 1][myPosX/UNIT] = 0;
				if (board[myPosY/UNIT][myPosX/UNIT] == 4) {
					getStage().setBackground(myColor);
					message = "You beat Aubrey's Maze!";
				}
				board[myPosY/UNIT][myPosX/UNIT] = 2;
			}
		}
		else if (k == Key.UP) 
		{ 
			if ((myPosY - UNIT >= 0) && (board[myPosY/UNIT - 1][myPosX/UNIT] != 1)) {
				myPosY -= UNIT;
				board[myPosY/UNIT + 1][myPosX/UNIT] = 0;
				if (board[myPosY/UNIT][myPosX/UNIT] == 4) {
					getStage().setBackground(myColor);
					message = "You beat Aubrey's Maze!";
				}
				board[myPosY/UNIT][myPosX/UNIT] = 2;
			}
		}
		printBoard();
	}

	// Add a private helper method to the Player class entitled checkForTraps() which returns a boolean.
	//  *     The method should take a String parameter called direction.
	//  *  	- Declare local integer variables for the absolute distance the Player is from the Trap, and 
	//  *        the minimum distance the Player is from the Trap.
	//  *      - Initialize the minimum distance the Player is from the Trap to a very large integer value.
	//  *      - Use a nested for loop to iterate through the 2D array called board.
	//  *  	  -  If the you encounter a Trap on the board (Traps are coded as 3), calculate the absolute distance
	//  *           of this Player from the Trap. (HINT: the direction will help you calculate this correctly.)
	//  *        -  If the absolute distance of the Player from the Trap is less than the minimum distance,
	//  *           re-assign the minimum distance to the new minimum value.
	//  *      - Update this Player's message to "The nearest trap is " + minimum distance + " spaces away!" .
	//  *      - If the minimum distance is a very large integer value, make this Player's message an empty String.
	//  *      - Return true if any Traps are on the board and false otherwise. 
	// private void checkForTraps() {

	private boolean checkForTraps(String direction) {
		int absoluteDistance;
		int minimumDistance = Integer.MAX_VALUE;
		for (int c = 0; c < 20; c++) {
			for (int r = 0; r < 20; r++) {
				if (board[c][r] == 3) {
					absoluteDistance = 
				}
			}
		}
	}

}
