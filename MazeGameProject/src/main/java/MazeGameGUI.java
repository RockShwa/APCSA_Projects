
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
	private int UNIT = 40; 	 //objects in this maze will be 40 pixels in size.
	private Color backgroundColor;		

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
		int stageWidth = UNIT * 20;
		int stageHeight = UNIT * 20;
		myStage = new Stage("Maze Game", stageWidth, stageHeight);
		backgroundColor = new Color(146, 183, 187, 255);
		myStage.setBackground(backgroundColor);
		
		
		myScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = myScreenSize.width;
		int height = myScreenSize.height;
		myStage.setLocation(width/2 - stageWidth/2, height/2 - stageHeight/2);
		
		addWalls();
		addFinish();
		addPlayer();
		addTraps();

		myStage.openWindow();
		myStage.start();
	}


	// METHODS
	// ------------------------------------------------------------
	/** 
	 * ADD WALLS
	 * 	This method will have you create all of the maze walls to be added to the GUI. You can brute force their creation or
	 * 		use programming techniques (like looping) to create a pattern. The maze design is up to you and should be unique.
	 * 
	 *	1. Declare and create a new Color (R, G, B, A) named backgroundColor for the walls of your maze
	 *	2. Create Wall objects for your maze.
	 *	   	NOTE: The x and y coordinates for wall on the GUI are reversed for the row and column on the underlying 2d array.
	 *			If you want to create a wall at row 4 and column 2, you would make the reference Wall wall42.
	 *			When you instantiate wall42, you should use new Wall(2 * unit, 4 * unit, unit, backgroundColor) since the row corresponds
	 *			to the y variable and the column corresponds to the x variable. 
	 *  3. Add the walls to myStage.
	 *  
	 * NEXT STEP: 
	 *  Click the link to go to the Finish class and complete its implementation {@link Finish}
	 */
	private void addWalls()
	{
	// TODO: Create a int[][] that contains your board walls and interate through it in the addWalls

	// 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
	// 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 1 1 1 
	// 1 0 1 0 1 0 1 0 1 0 1 1 1 1 0 1 1 0 1 1 
	// 1 0 1 0 1 0 1 0 1 0 0 0 0 1 0 1 1 0 1 1
	// 4 0 1 0 0 0 1 0 1 1 1 1 3 1 0 0 0 0 1 1
	// 1 1 3 1 1 1 1 0 1 1 1 0 0 1 1 1 1 0 1 1
	// 1 0 0 0 1 0 0 0 0 0 0 0 1 1 1 0 0 0 1 1
	// 1 0 1 1 1 0 1 1 1 1 1 0 1 1 1 0 1 1 1 1
	// 1 0 0 0 1 0 0 0 0 1 1 0 0 1 0 0 1 1 0 2
	// 1 0 1 0 1 1 1 1 0 1 1 0 1 0 0 1 1 1 0 1
	// 1 0 1 0 0 0 0 0 0 1 1 0 0 0 1 1 1 1 0 1
	// 1 0 1 0 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0 1
	// 1 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 1 0 1
	// 1 0 1 0 1 1 0 1 1 1 1 1 1 0 1 1 1 1 0 1
	// 1 0 0 1 0 1 0 1 1 0 1 0 1 0 0 0 0 0 0 1
	// 1 1 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 0 1 1
	// 1 1 0 1 1 1 0 1 1 1 1 1 0 1 0 1 1 0 1 1
	// 1 0 0 0 0 1 0 1 1 1 1 1 0 1 0 0 0 0 1 1
	// 1 0 1 1 0 1 0 0 0 3 0 0 0 1 0 1 1 1 1 1
	// 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
	
		// Color wallColor = new Color(51,102,204,255);

		// Row: 0
		for (int c = 0; c < 20; c++) {
			myStage.add(new Wall(c * UNIT, 0, UNIT, backgroundColor));
		}
		
		// Row: 1
		myStage.add(new Wall(0 * UNIT, 1 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 1 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 1 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 1 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 1 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 1 * UNIT, UNIT, backgroundColor));

		// Row: 2
		myStage.add(new Wall(0 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(11 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 2 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 2 * UNIT, UNIT, backgroundColor));

		// Row: 3
		myStage.add(new Wall(0 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 3 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 3 * UNIT, UNIT, backgroundColor));

		// Row: 4
		myStage.add(new Wall(2 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(11 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 4 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 4 * UNIT, UNIT, backgroundColor));

		// Row: 5
		myStage.add(new Wall(0 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(1 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(3 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 5 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 5 * UNIT, UNIT, backgroundColor));

		// Row: 6 
		myStage.add(new Wall(0 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 6 * UNIT, UNIT, backgroundColor));
		
		// Row: 7
		myStage.add(new Wall(0 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(3 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 7 * UNIT, UNIT, backgroundColor));
		

		// Row: 8
		myStage.add(new Wall(0 * UNIT, 8 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 8 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 8 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 8 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 8 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 8 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 8 * UNIT, UNIT, backgroundColor));

		// Row: 9
		myStage.add(new Wall(0 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 9 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 9 * UNIT, UNIT, backgroundColor));

		// Row: 10
		myStage.add(new Wall(0 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 10 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 10 * UNIT, UNIT, backgroundColor));

		// Row: 11
		myStage.add(new Wall(0 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(6 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(11 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 11 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 11 * UNIT, UNIT, backgroundColor));

		// Row: 12
		myStage.add(new Wall(0 * UNIT, 12 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 12 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 12 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 12 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 12 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 12 * UNIT, UNIT, backgroundColor));

		// Row: 13
		myStage.add(new Wall(0 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(11 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 13 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 13 * UNIT, UNIT, backgroundColor));

		// Row: 14
		myStage.add(new Wall(0 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(3 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(12 * UNIT, 14 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 14 * UNIT, UNIT, backgroundColor));

		// Row: 15
		myStage.add(new Wall(0 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(1 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(14 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 15 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 15 * UNIT, UNIT, backgroundColor));

		// Row: 16
		myStage.add(new Wall(0 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(1 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(3 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(4 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(11 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 16 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 16 * UNIT, UNIT, backgroundColor));

		// Row: 17
		myStage.add(new Wall(0 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(7 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(8 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(9 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(10 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(11 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 17 * UNIT, UNIT, backgroundColor));
		
		// Row: 18
		myStage.add(new Wall(0 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(2 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(3 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(5 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(13 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(15 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(16 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(17 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(18 * UNIT, 18 * UNIT, UNIT, backgroundColor));
		myStage.add(new Wall(19 * UNIT, 18 * UNIT, UNIT, backgroundColor));

		// Row: 19
		for (int c = 0; c < 20; c++) {
			myStage.add(new Wall(c * UNIT, 19 * UNIT, UNIT, backgroundColor));
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
		Color playerColor = new Color(102,51,153,255);
		myStage.add(new Player(19 * UNIT, 8 * UNIT, UNIT, playerColor));
		
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
		Color finishColor = new Color(118, 19, 140, 255);
		myStage.add(new Finish(0 * UNIT, 4 * UNIT, UNIT, finishColor));
		
	}

	private void addTraps() {
		myStage.add(new Trap(12 * UNIT, 4 * UNIT));
		myStage.add(new Trap(2 * UNIT, 5 * UNIT));
		// myStage.add(new Trap(9 * UNIT, 18 * UNIT));
	}
	
	
	public static void drawText(Graphics2D g, String text, int x, int y, Color c, int size, boolean centered)
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