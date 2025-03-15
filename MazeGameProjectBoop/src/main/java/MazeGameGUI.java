
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
	private int unit = 30; 			//objects in this maze will be 40 pixels in size.

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
	 *  
	 *  [0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
	 *  [0 0 0 0 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1]
	 *  [1 0 1 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1]
	 *  [1 0 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1]
	 *  [0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
	 *  [0 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1]
	 *  [1 1 1 0 0 1 1 1 1 1 1 1 1 1 0 0 0 1 1 1]
	 *  [1 0 0 1 0 0 0 1 1 1 1 1 1 1 0 1 0 0 1 1]
	 *  [1 1 0 0 0 1 0 1 1 1 1 1 0 0 0 1 1 0 1 1]
	 *  [1 1 1 1 1 1 0 1 1 1 1 1 1 0 1 1 1 0 0 1]
	 *  [1 1 1 1 1 0 0 1 1 1 1 1 1 0 0 0 1 1 1 1]
	 *  [1 0 0 0 0 0 1 1 1 1 1 1 1 1 0 1 0 1 1 1]
	 *  [1 0 1 0 1 1 1 1 1 1 1 1 0 0 0 1 0 0 0 0]
	 *  [0 0 1 0 1 1 1 1 0 1 1 1 0 1 1 1 1 1 1 0]
	 *  [0 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0]
	 *  [0 0 1 1 1 0 0 1 1 1 1 1 1 1 1 0 0 0 0 1]
	 *  [1 0 1 1 1 1 0 1 1 1 1 1 1 1 1 0 1 0 1 1]
	 *  [1 1 1 1 1 0 0 1 1 1 1 1 1 1 1 0 1 0 0 1]
	 *  [1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 0 1 1 1 0]
	 *  [1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 4]
	 *  
	 *  
	 */
	public MazeGameGUI()
	{
		// TODO: Implement steps 1 - 6 of the algorithm above
		int stageWidth = unit*20;
		int stageHeight = unit*20;
		myStage = new Stage("Rupal's Maze Game", stageWidth, stageHeight);
		Color bgColor = new Color(200, 188, 44);
		myStage.setBackground(bgColor);
		
		myScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = myScreenSize.width;
		int height = myScreenSize.height;
		myStage.setLocation(width/2 - stageWidth/2, height/2 - stageHeight/2);
		
		// TODO: Implement steps 7 - 11 of the algorithm above
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
		// TODO: Implement the algorithm above
//		Color wallColor = new Color(0, 0, 0);
		Color pathColor = new Color(255, 190, 240);
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				myStage.add(new Wall(i*unit, j*unit, unit, pathColor));	
			}
		}
//		myStage.add(new Path(0*unit,0*unit,unit,pathColor));
//		
//		myStage.add(new Path(0*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(1*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(2*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(11*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,1*unit,unit,pathColor));
//		myStage.add(new Path(18*unit,1*unit,unit,pathColor));
//		
//		myStage.add(new Path(1*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(4*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(5*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(7*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(11*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,2*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,2*unit,unit,pathColor));
//		
//		myStage.add(new Path(1*unit,3*unit,unit,pathColor));
//		myStage.add(new Path(7*unit,3*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,3*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,3*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,3*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,3*unit,unit,pathColor));
//		
//		myStage.add(new Path(0*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(1*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(2*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(7*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,4*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,4*unit,unit,pathColor));
//		
//		myStage.add(new Path(0*unit,5*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,5*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,5*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,5*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,5*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,5*unit,unit,pathColor));
//
//		myStage.add(new Path(3*unit,6*unit,unit,pathColor));
//		myStage.add(new Path(4*unit,6*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,6*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,6*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,6*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,6*unit,unit,pathColor));
//		
//		myStage.add(new Path(1*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(2*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(4*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(5*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,7*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,7*unit,unit,pathColor));
//		
//		myStage.add(new Path(2*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(4*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,8*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,8*unit,unit,pathColor));
//
//		myStage.add(new Path(6*unit,9*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,9*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,9*unit,unit,pathColor));
//		myStage.add(new Path(18*unit,9*unit,unit,pathColor));
//
//		myStage.add(new Path(5*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,10*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,10*unit,unit,pathColor));
//
//		myStage.add(new Path(1*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(2*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(4*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(5*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,11*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,11*unit,unit,pathColor));
//
//		myStage.add(new Path(1*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(18*unit,12*unit,unit,pathColor));
//		myStage.add(new Path(19*unit,12*unit,unit,pathColor));
//
//		myStage.add(new Path(0*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(1*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(11*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,13*unit,unit,pathColor));
//		myStage.add(new Path(19*unit,13*unit,unit,pathColor));
//
//		myStage.add(new Path(0*unit,14*unit,unit,pathColor));
//		myStage.add(new Path(3*unit,14*unit,unit,pathColor));
//		myStage.add(new Path(4*unit,14*unit,unit,pathColor));
//		myStage.add(new Path(5*unit,14*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,14*unit,unit,pathColor));
//		myStage.add(new Path(18*unit,14*unit,unit,pathColor));
//		myStage.add(new Path(19*unit,14*unit,unit,pathColor));
//
//		myStage.add(new Path(0*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(1*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(5*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(16*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,15*unit,unit,pathColor));
//		myStage.add(new Path(18*unit,15*unit,unit,pathColor));
//
//		myStage.add(new Path(1*unit,16*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,16*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,16*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,16*unit,unit,pathColor));
//		myStage.add(new Path(14*unit,16*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,16*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,16*unit,unit,pathColor));
//		
//		myStage.add(new Path(5*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(6*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(7*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(8*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(9*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(10*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(13*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(17*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(18*unit,17*unit,unit,pathColor));
//		myStage.add(new Path(19*unit,17*unit,unit,pathColor));
//
//
//		myStage.add(new Path(5*unit,18*unit,unit,pathColor));
//		myStage.add(new Path(12*unit,18*unit,unit,pathColor));
//		myStage.add(new Path(15*unit,18*unit,unit,pathColor));
//		myStage.add(new Path(19*unit,18*unit,unit,pathColor));
//
//		myStage.add(new Path(19*unit,19*unit,unit,pathColor));
		
		
		// AV CODE
		
		myStage.add(new Path(1*unit,1*unit,unit,pathColor));
		myStage.add(new Path(2*unit,1*unit,unit,pathColor));
		myStage.add(new Path(3*unit,1*unit,unit,pathColor));
		myStage.add(new Path(4*unit,1*unit,unit,pathColor));
		myStage.add(new Path(9*unit,1*unit,unit,pathColor));
		myStage.add(new Path(10*unit,1*unit,unit,pathColor));
		myStage.add(new Path(11*unit,1*unit,unit,pathColor));
		myStage.add(new Path(17*unit,1*unit,unit,pathColor));
		myStage.add(new Path(18*unit,1*unit,unit,pathColor));

		myStage.add(new Path(4*unit,2*unit,unit,pathColor));
		myStage.add(new Path(6*unit,2*unit,unit,pathColor));
		myStage.add(new Path(7*unit,2*unit,unit,pathColor));
		myStage.add(new Path(11*unit,2*unit,unit,pathColor));
		myStage.add(new Path(13*unit,2*unit,unit,pathColor));
		myStage.add(new Path(14*unit,2*unit,unit,pathColor));
		myStage.add(new Path(15*unit,2*unit,unit,pathColor));
		myStage.add(new Path(18*unit,2*unit,unit,pathColor));
		
		myStage.add(new Path(1*unit,3*unit,unit,pathColor));
		myStage.add(new Path(2*unit,3*unit,unit,pathColor));
		myStage.add(new Path(3*unit,3*unit,unit,pathColor));
		myStage.add(new Path(4*unit,3*unit,unit,pathColor));
		myStage.add(new Path(7*unit,3*unit,unit,pathColor));
		myStage.add(new Path(8*unit,3*unit,unit,pathColor));
		myStage.add(new Path(9*unit,3*unit,unit,pathColor));
		myStage.add(new Path(11*unit,3*unit,unit,pathColor));
		myStage.add(new Path(15*unit,3*unit,unit,pathColor));
		myStage.add(new Path(18*unit,3*unit,unit,pathColor));

		myStage.add(new Path(1*unit,4*unit,unit,pathColor));
		myStage.add(new Path(4*unit,4*unit,unit,pathColor));
		myStage.add(new Path(9*unit,4*unit,unit,pathColor));
		myStage.add(new Path(11*unit,4*unit,unit,pathColor));
		myStage.add(new Path(12*unit,4*unit,unit,pathColor));
		myStage.add(new Path(13*unit,4*unit,unit,pathColor));
		myStage.add(new Path(15*unit,4*unit,unit,pathColor));
		myStage.add(new Path(16*unit,4*unit,unit,pathColor));
		myStage.add(new Path(17*unit,4*unit,unit,pathColor));
		myStage.add(new Path(18*unit,4*unit,unit,pathColor));

		myStage.add(new Path(1*unit,5*unit,unit,pathColor));
		myStage.add(new Path(3*unit,5*unit,unit,pathColor));
		myStage.add(new Path(4*unit,5*unit,unit,pathColor));
		myStage.add(new Path(5*unit,5*unit,unit,pathColor));
		myStage.add(new Path(6*unit,5*unit,unit,pathColor));
		myStage.add(new Path(7*unit,5*unit,unit,pathColor));
		myStage.add(new Path(9*unit,5*unit,unit,pathColor));
		myStage.add(new Path(13*unit,5*unit,unit,pathColor));
		myStage.add(new Path(18*unit,5*unit,unit,pathColor));

		myStage.add(new Path(7*unit,6*unit,unit,pathColor));
		myStage.add(new Path(9*unit,6*unit,unit,pathColor));
		myStage.add(new Path(10*unit,6*unit,unit,pathColor));
		myStage.add(new Path(11*unit,6*unit,unit,pathColor));
		myStage.add(new Path(13*unit,6*unit,unit,pathColor));
		myStage.add(new Path(14*unit,6*unit,unit,pathColor));
		myStage.add(new Path(15*unit,6*unit,unit,pathColor));
		myStage.add(new Path(16*unit,6*unit,unit,pathColor));
		myStage.add(new Path(18*unit,6*unit,unit,pathColor));

		myStage.add(new Path(1*unit,7*unit,unit,pathColor));
		myStage.add(new Path(2*unit,7*unit,unit,pathColor));
		myStage.add(new Path(3*unit,7*unit,unit,pathColor));
		myStage.add(new Path(4*unit,7*unit,unit,pathColor));
		myStage.add(new Path(5*unit,7*unit,unit,pathColor));
		myStage.add(new Path(7*unit,7*unit,unit,pathColor));
		myStage.add(new Path(11*unit,7*unit,unit,pathColor));
		myStage.add(new Path(16*unit,7*unit,unit,pathColor));
		myStage.add(new Path(18*unit,7*unit,unit,pathColor));

		myStage.add(new Path(1*unit,8*unit,unit,pathColor));
		myStage.add(new Path(5*unit,8*unit,unit,pathColor));
		myStage.add(new Path(7*unit,8*unit,unit,pathColor));
		myStage.add(new Path(8*unit,8*unit,unit,pathColor));
		myStage.add(new Path(9*unit,8*unit,unit,pathColor));
		myStage.add(new Path(10*unit,8*unit,unit,pathColor));
		myStage.add(new Path(11*unit,8*unit,unit,pathColor));
		myStage.add(new Path(12*unit,8*unit,unit,pathColor));
		myStage.add(new Path(13*unit,8*unit,unit,pathColor));
		myStage.add(new Path(14*unit,8*unit,unit,pathColor));
		myStage.add(new Path(16*unit,8*unit,unit,pathColor));
		myStage.add(new Path(18*unit,8*unit,unit,pathColor));

		myStage.add(new Path(1*unit,9*unit,unit,pathColor));
		myStage.add(new Path(3*unit,9*unit,unit,pathColor));
		myStage.add(new Path(4*unit,9*unit,unit,pathColor));
		myStage.add(new Path(5*unit,9*unit,unit,pathColor));
		myStage.add(new Path(14*unit,9*unit,unit,pathColor));
		myStage.add(new Path(16*unit,9*unit,unit,pathColor));
		myStage.add(new Path(18*unit,9*unit,unit,pathColor));

		myStage.add(new Path(1*unit,10*unit,unit,pathColor));
		myStage.add(new Path(5*unit,10*unit,unit,pathColor));
		myStage.add(new Path(7*unit,10*unit,unit,pathColor));
		myStage.add(new Path(8*unit,10*unit,unit,pathColor));
		myStage.add(new Path(9*unit,10*unit,unit,pathColor));
		myStage.add(new Path(10*unit,10*unit,unit,pathColor));
		myStage.add(new Path(11*unit,10*unit,unit,pathColor));
		myStage.add(new Path(12*unit,10*unit,unit,pathColor));
		myStage.add(new Path(14*unit,10*unit,unit,pathColor));
		myStage.add(new Path(16*unit,10*unit,unit,pathColor));
		myStage.add(new Path(18*unit,10*unit,unit,pathColor));

		myStage.add(new Path(1*unit,11*unit,unit,pathColor));
		myStage.add(new Path(2*unit,11*unit,unit,pathColor));
		myStage.add(new Path(3*unit,11*unit,unit,pathColor));
		myStage.add(new Path(5*unit,11*unit,unit,pathColor));
		myStage.add(new Path(7*unit,11*unit,unit,pathColor));
		myStage.add(new Path(12*unit,11*unit,unit,pathColor));
		myStage.add(new Path(14*unit,11*unit,unit,pathColor));
		myStage.add(new Path(15*unit,11*unit,unit,pathColor));
		myStage.add(new Path(16*unit,11*unit,unit,pathColor));
		myStage.add(new Path(18*unit,11*unit,unit,pathColor));

		myStage.add(new Path(3*unit,12*unit,unit,pathColor));
		myStage.add(new Path(5*unit,12*unit,unit,pathColor));
		myStage.add(new Path(7*unit,12*unit,unit,pathColor));
		myStage.add(new Path(8*unit,12*unit,unit,pathColor));
		myStage.add(new Path(9*unit,12*unit,unit,pathColor));
		myStage.add(new Path(10*unit,12*unit,unit,pathColor));
		myStage.add(new Path(12*unit,12*unit,unit,pathColor));
		myStage.add(new Path(16*unit,12*unit,unit,pathColor));
		myStage.add(new Path(18*unit,12*unit,unit,pathColor));

		myStage.add(new Path(1*unit,13*unit,unit,pathColor));
		myStage.add(new Path(2*unit,13*unit,unit,pathColor));
		myStage.add(new Path(3*unit,13*unit,unit,pathColor));
		myStage.add(new Path(5*unit,13*unit,unit,pathColor));
		myStage.add(new Path(10*unit,13*unit,unit,pathColor));
		myStage.add(new Path(12*unit,13*unit,unit,pathColor));
		myStage.add(new Path(13*unit,13*unit,unit,pathColor));
		myStage.add(new Path(14*unit,13*unit,unit,pathColor));
		myStage.add(new Path(16*unit,13*unit,unit,pathColor));
		myStage.add(new Path(18*unit,13*unit,unit,pathColor));

		myStage.add(new Path(3*unit,14*unit,unit,pathColor));
		myStage.add(new Path(5*unit,14*unit,unit,pathColor));
		myStage.add(new Path(6*unit,14*unit,unit,pathColor));
		myStage.add(new Path(7*unit,14*unit,unit,pathColor));
		myStage.add(new Path(8*unit,14*unit,unit,pathColor));
		myStage.add(new Path(10*unit,14*unit,unit,pathColor));
		myStage.add(new Path(14*unit,14*unit,unit,pathColor));
		myStage.add(new Path(16*unit,14*unit,unit,pathColor));
		myStage.add(new Path(18*unit,14*unit,unit,pathColor));
		
		myStage.add(new Path(1*unit,15*unit,unit,pathColor));
		myStage.add(new Path(2*unit,15*unit,unit,pathColor));
		myStage.add(new Path(3*unit,15*unit,unit,pathColor));
		myStage.add(new Path(8*unit,15*unit,unit,pathColor));
		myStage.add(new Path(10*unit,15*unit,unit,pathColor));
		myStage.add(new Path(11*unit,15*unit,unit,pathColor));
		myStage.add(new Path(12*unit,15*unit,unit,pathColor));
		myStage.add(new Path(13*unit,15*unit,unit,pathColor));
		myStage.add(new Path(14*unit,15*unit,unit,pathColor));
		myStage.add(new Path(16*unit,15*unit,unit,pathColor));
		myStage.add(new Path(17*unit,15*unit,unit,pathColor));
		myStage.add(new Path(18*unit,15*unit,unit,pathColor));

		myStage.add(new Path(1*unit,16*unit,unit,pathColor));
		myStage.add(new Path(8*unit,16*unit,unit,pathColor));
		myStage.add(new Path(14*unit,16*unit,unit,pathColor));
		myStage.add(new Path(15*unit,16*unit,unit,pathColor));
		myStage.add(new Path(18*unit,16*unit,unit,pathColor));

		myStage.add(new Path(1*unit,17*unit,unit,pathColor));
		myStage.add(new Path(8*unit,17*unit,unit,pathColor));
		myStage.add(new Path(15*unit,17*unit,unit,pathColor));
		myStage.add(new Path(18*unit,17*unit,unit,pathColor));

		myStage.add(new Path(1*unit,18*unit,unit,pathColor));
		myStage.add(new Path(2*unit,18*unit,unit,pathColor));
		myStage.add(new Path(3*unit,18*unit,unit,pathColor));
		myStage.add(new Path(4*unit,18*unit,unit,pathColor));
		myStage.add(new Path(5*unit,18*unit,unit,pathColor));
		myStage.add(new Path(6*unit,18*unit,unit,pathColor));
		myStage.add(new Path(7*unit,18*unit,unit,pathColor));
		myStage.add(new Path(8*unit,18*unit,unit,pathColor));
		myStage.add(new Path(9*unit,18*unit,unit,pathColor));
		myStage.add(new Path(10*unit,18*unit,unit,pathColor));
		myStage.add(new Path(11*unit,18*unit,unit,pathColor));
		myStage.add(new Path(12*unit,18*unit,unit,pathColor));
		myStage.add(new Path(13*unit,18*unit,unit,pathColor));
		myStage.add(new Path(14*unit,18*unit,unit,pathColor));
		myStage.add(new Path(15*unit,18*unit,unit,pathColor));
		myStage.add(new Path(16*unit,18*unit,unit,pathColor));
		myStage.add(new Path(17*unit,18*unit,unit,pathColor));
		myStage.add(new Path(18*unit,18*unit,unit,pathColor));

	}
	
	//chan
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
		// TODO: Implement the algorithm above
//		Color playerColor = new Color(255, 25, 0);
//		Player player1 = new Player(0*unit, 0*unit, unit, playerColor);
//		myStage.add(player1);

		//AV Code
		Color playerColor = new Color(200, 48, 200);
		Player player1 = new Player(17*unit, 18*unit, unit, playerColor);
		myStage.add(player1);
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
//		Color finishColor = new Color(0, 15, 255);
//		myStage.add(new Finish(19*unit, 19*unit, unit, finishColor));
		
		//AV Code
		Color finishColor = new Color(150, 100, 13);
		myStage.add(new Finish(1*unit, 1*unit, unit, finishColor));

	}
	
	private void addTraps(){
//		myStage.add(new Trap(6*unit, 2*unit));
//		myStage.add(new Trap(13*unit, 8*unit));
		
		//AV Code
		myStage.add(new Trap(11*unit, 6*unit));
		myStage.add(new Trap(14*unit, 18*unit));
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