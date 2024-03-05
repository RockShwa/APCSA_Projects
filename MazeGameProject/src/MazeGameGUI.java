
import mickel.anim.*;
import java.awt.*;


/** The primary GUI window of the MazeGame application.
 */
public class MazeGameGUI
{
	// FIELDS
	// ------------------------------------------------------------
	private Stage myStage;			// The base window for the app.
	private Dimension myScreenSize;
	private int UNIT = 40; 			//objects in this maze will be 40 pixels in size.

	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** 
	 * CREATE THE STAGE
	 *  1. Declare an int variable called stageWidth and initialize to a number of pixels. Choose a multiple of unit (unit * 10, for example).
	 *	2. Declare an int variable called stageHeight and initialize to a number of pixels. Choose a multiple of unit.
	 *  3. Initialize myStage as a new Stage entitled "Maze Game" with a width of stageWidth and a height of stageHeight.
	 *  4. Declare and create a new Color (R, G, B, A) for the background of your maze.
	 *  5. Set the background of myStage to be the Color you created.
	 *  6. Remove the block comments below and don't alter the code =)
	 *  
	 * CALL METHODS TO CREATE SPRITES
	 *  7. Invoke this object's addWalls() method.
	 *  8. Invoke this object's addFinish() method.
	 *  9. Invoke this object's addPlayer() method
	 *  
	 * OPEN WINDOW & START GAME
	 *  10. Tell myStage to open its window.
	 *  11. Tell myStage to start its animation cycle.
	 *  
	 * NEXT STEP: 
	 *  Click the link to go to the MazeObject class and complete its implementation {@link MazeObject}
	 *  
	 */
	public MazeGameGUI()
	{
		// TODO: Implement steps 1 - 6 of the algorithm above
		
		/*
		myScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = myScreenSize.width;
		int height = myScreenSize.height;
		myStage.setLocation(width/2 - stageWidth/2, height/2 - stageHeight/2);
		*/
		
		// TODO: Implement steps 7 - 11 of the algorithm above
	}


	// METHODS
	// ------------------------------------------------------------
	/** 
	 * ADD WALLS
	 * 	This method will have you create all of the maze walls to be added to the GUI. You can brute force their creation or
	 * 		use programming techniques (like looping) to create a pattern. The maze design is up to you and should be unique.
	 * 
	 *	1. Declare and create a new Color (R, G, B, A) named wallColor for the walls of your maze
	 *	2. Create Wall objects for your maze.
	 *	   	NOTE: The x and y coordinates for wall on the GUI are reversed for the row and column on the underlying 2d array.
	 *			If you want to create a wall at row 4 and column 2, you would make the reference Wall wall42.
	 *			When you instantiate wall42, you should use new Wall(2 * unit, 4 * unit, unit, wallColor) since the row corresponds
	 *			to the y variable and the column corresponds to the x variable. 
	 *  3. Add the walls to myStage.
	 *  
	 * NEXT STEP: 
	 *  Click the link to go to the Finish class and complete its implementation {@link Finish}
	 */
	private void addWalls()
	{
	// 1 1 1 1 1 1 1 1 1 1 *
	// 1 0 0 0 1 1 0 0 0 1 *
	// 1 0 1 0 1 1 3 1 0 1 *
	// 1 0 1 0 0 0 0 1 0 1 *
	// 4 0 1 1 1 1 0 1 0 1 *
	// 1 1 1 1 0 0 0 1 1 1 *
	// 1 0 1 1 0 1 1 0 1 1 *
	// 1 0 1 1 0 1 1 0 1 1 *
	// 1 0 3 0 0 0 0 0 0 2 *
	// 1 1 1 1 1 1 1 1 1 1

		Color wallColor = new Color(51,102,204,1);

		for (int c = 0; c < 10; c++) {
			myStage.add(new Wall(c * UNIT, 0, UNIT, wallColor));
		}
		

		myStage.add(new Wall(0 * UNIT, 1 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(4 * UNIT, 1 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(5 * UNIT, 1 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(9 * UNIT, 1 * UNIT, UNIT, wallColor));

		myStage.add(new Wall(0 * UNIT, 2 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(4 * UNIT, 2 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(5 * UNIT, 2 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(7 * UNIT, 2 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(9 * UNIT, 2 * UNIT, UNIT, wallColor));

		myStage.add(new Wall(0 * UNIT, 3 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(2 * UNIT, 3 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(7 * UNIT, 3 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(9 * UNIT, 3 * UNIT, UNIT, wallColor));

		myStage.add(new Wall(2 * UNIT, 4 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(3 * UNIT, 4 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(4 * UNIT, 4 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(5 * UNIT, 4 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(7 * UNIT, 4 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(9 * UNIT, 4 * UNIT, UNIT, wallColor));

		myStage.add(new Wall(0 * UNIT, 5 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(1 * UNIT, 5 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(2 * UNIT, 5 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(3 * UNIT, 5 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(7 * UNIT, 5 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(8 * UNIT, 5 * UNIT, UNIT, wallColor));
		myStage.add(new Wall(9 * UNIT, 5 * UNIT, UNIT, wallColor));

		for (int i = 6; i < 8; i++) {
			myStage.add(new Wall(0 * UNIT, i * UNIT, UNIT, wallColor));
			myStage.add(new Wall(2 * UNIT, i * UNIT, UNIT, wallColor));
			myStage.add(new Wall(3 * UNIT, i * UNIT, UNIT, wallColor));
			myStage.add(new Wall(5 * UNIT, i * UNIT, UNIT, wallColor));
			myStage.add(new Wall(6 * UNIT, i * UNIT, UNIT, wallColor));
			myStage.add(new Wall(8 * UNIT, i * UNIT, UNIT, wallColor));
			myStage.add(new Wall(9 * UNIT, i * UNIT, UNIT, wallColor));
		}

		myStage.add(new Wall(0 * UNIT, 8 * UNIT, UNIT, wallColor));

		
		for (int c = 0; c < 10; c++) {
			myStage.add(new Wall(c * UNIT, 10 * UNIT, UNIT, wallColor));
		}
	}
	
	
	/** 
	 * ADD PLAYER
	 *  This method creates a new Player object and adds it to the maze in the starting position of your choice.
	 *  
	 *	1. Declare and create a new Color (R, G, B, A) named playerColor for the maze Player
	 *  2. Create a new Player object called player1.
	 *  	NOTE: The x and y coordinates for player on the GUI are reversed for the row and column on the underlying 2d array.
	 *     		If you want to start the player at row 9 and column 5, you would make the reference Player player1.
	 *	    	When you instantiate player1, you should use new Player(5 * unit, 9 * unit, unit, playerColor) since the row corresponds
	 *			to the y variable and the column corresponds to the x variable.
	 *  3. Add player1 to myStage.
	 *  
	 *  NEXT STEP: 
	 *   Click the link to go to the keyPressed method in the Player class and complete its implementation {@link Player#keyPressed(mickel.io.Key)}
	 */
	private void addPlayer()
	{
		// NOT DONE
		Color playerColor = new Color(102,51,153,1);
		
	}
	
	/** 
	 * ADD FINISH
	 *  This method creates a new Finish object and adds it to the maze in the ending position of your choice.
	 *  
	 *	1. Declare and create a new Color (R, G, B, A) named finishColor for the maze's Finish
	 *  2. Add a new Finish object called finish.
	 *     	NOTE: The x and y coordinates for finish on the GUI are reversed for the row and column on the underlying 2d array.
	 *     		If you want to finish the maze at row 0 and column 1, you would make the reference Finish finish.
	 *	   		When you instantiate finish, you should use new Finish(1 * unit, 0 * unit, unit, finishColor) since the row corresponds
	 *			to the y variable and the column corresponds to the x variable.
	 *	3. Add finish to myStage.
	 *
	 * NEXT STEP: 
	 *   Click the link to go to the Player class and complete its implementation {@link Player}
	 */
	private void addFinish()
	{
		// TODO: Implement the algorithm above
		
	}
	
	
	public static void drawText(Graphics2D g, String text, int x, int y,Color c, int size, boolean centered)
	{
		g.setFont(new Font("Arial", Font.BOLD, size));
		FontMetrics metrics = g.getFontMetrics();
		if (centered)
		{
		x -= metrics.stringWidth(text) / 2;
		y += metrics.getAscent() / 2;
		}
		
		g.setColor(Color.BLACK);
		g.drawString(text, x + 1, y + 1);
		g.drawString(text, x + 1, y - 1);
		g.drawString(text, x - 1, y + 1);
		g.drawString(text, x - 1, y - 1);
		
		g.setColor(c);
		g.drawString(text, x, y);
		
		g.setColor(new Color(255, 255, 255, 127));
		g.drawString(text, x, y);
	}
}