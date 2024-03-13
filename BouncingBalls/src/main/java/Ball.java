
import mickel.anim.Sprite;
import mickel.io.Key;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Ellipse2D;

/** Represents a Ball that dynamically bounces around the interior
 *  of a rectangular Stage.
 */
public class Ball extends Sprite
{
	// FIELDS
	// ------------------------------------------------------------
	private int myPosX;		// X-coordinate of this Ball
	private int myPosY;		// Y-coordinate of this Ball

	private int myDirX;		// Horizontal speed of this Ball
	private int myDirY;		// Vertical speed of this Ball

	private int mySize;		// Diameter of this Ball
	private Color myColor;	// Color of this Ball


	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs a large, red Ball that is initially located in
	 *  the upper left corner of the screen.
	 *
	 *     algorithm: Assign mySize a value of 100.
	 *                Assign myPosX and myPosY a value of
	 *                  one half mySize plus one.
	 *                Assign myDirX a value of 2.
	 *                Assign myDirY a value of 1.
	 *                Assign myColor a Color value of RED.
	 */
	public Ball() {
		mySize = 100;
		myPosX = mySize/2 + 1;
		myPosY = mySize/2 + 1;
		myDirX = 2;
		myDirY = 1;
		myColor = Color.RED;
	}

	/** Constructs a small, green Ball that is initially centered
	 *  on a specified region of the screen.
	 *
	 *  precondition: width >= 0, height >= 0
	 *     algorithm: Assign mySize a value of 25.
	 *                Assign myPosX a value of half of width
	 *                Assign myPosY a value of half of height
	 *                Assign myDirX a value of -2.
	 *                Assign myDirY a value of 5.
	 *                Assign myColor a Color value of GREEN.
	 *
	 * @param width		Width of the stage
	 * @param height	Height of the stage
	 */
	public Ball(int width, int height) {
		mySize = 25;
		myPosX = width/2;
		myPosY = height/2;
		myDirX = -2;
		myDirY = 5;
		myColor = Color.GREEN;
	}

	/** Constructs a Ball that initially has the specified
	 *  location, size, and color.
	 *
	 *     algorithm: Assign mySize a value of size.
	 *                Assign myPosX the value of x.
	 *                Assign myPosY the value of y.
	 *                Assign myDirX the value of 3.
	 *                Assign myDirY the value of 3.
	 *                Assign myColor the value of c.
	 *
	 * @param x		The x-coordinate of this Ball's location
	 * @param y		The y-coordinate of this Ball's location
	 * @param size	The diameter of this Ball
	 * @param c		The Color of this Ball
	 */
	public Ball(int x, int y, int size, Color c) {
		mySize = size;
		myPosX = x;
		myPosY = y;
		myDirX = 3;
		myDirY = 3; 
		myColor = c;
	}


	// METHODS
	// ------------------------------------------------------------
	/** Performs one frame of movement for this Ball object.
	 *
	 *  precondition:
	 * postcondition: The location of this Ball will be incremented
	 *                by one frame in its current direction of
	 *                movement. If the resulting location lies
	 *                beyond the boundaries of the Stage, this Ball's
	 *                direction will be adjusted accordingly to
	 *                reflect a "bounce".
	 *     algorithm: Increment myPosX by myDirX.
	 *                Increment myPosY by myDirY.
	 *                Declare an int variable w and initialize it
	 *                  with the value of the width of this Ball's
	 *                  Stage.
	 *                Declare an int variable h and initialize it
	 *                  with the value of the height of this Ball's
	 *                  Stage.
	 *                If the left edge of this Ball is less than 0
	 *                  and this Ball is moving left, negate the
	 *                  value of myDirX.
	 *                If the right edge of this Ball is greater than
	 *                  w and this Ball is moving right, negate the
	 *                  value of myDirX.
	 *                If the top edge of this Ball is less than 0
	 *                  and this Ball is moving up, negate the
	 *                  value of myDirY.
	 *                If the bottom edge of this Ball is greater than
	 *                  h and this Ball is moving down, negate the
	 *                  value of myDirY.
	 */
	public void act() // POSSIBLE QUIZ METHOD
	{
		myPosX += myDirX;
		myPosY += myDirY;
		
		int w = this.getStage().getWidth();
		int h = this.getStage().getHeight();

		if (myPosX < 0 && myDirX < 0) {
			myDirX *= -1;
		}
		if (myPosX + mySize > w && myDirX > 0) {
			myDirX *= -1;
		}
		if (myPosY < 0 && myDirY < 0) {
			myDirY *= -1;
		}
		if (myPosY + mySize > h && myDirY > 0) {
			myDirY *= -1;
		}
	}


	/** Draws a representation of the current state of this Ball
	 *  onto the graphics canvas, g.
	 *
	 *  precondition: g is the "canvas" of the Stage
	 * postcondition: Draws a representation of the current state
	 *                of this Ball onto the graphics canvas, g.
	 *     algorithm: Set the Color of g to be myColor.
	 *                Paint a filled oval onto g that is located at
	 *                  (myPosX, myPosY) with a width and height of
	 *                  mySize.
	 *
	 * @param g	The "canvas" on which this Ball is to be drawn.
	 */
	public void draw(Graphics2D g)
	{
		g.setColor(myColor);
		g.fillOval(myPosX, myPosY, mySize, mySize);
	}


	/** Gets the boundaries of this Sprite.
	 *
	 * postcondition: Returns a Shape object that corresponds to the
	 *                characteristics used in the draw() method.
	 *     algorithm: Return a new Ellipse2D.Double object that uses
	 *                  myPosX and myPosY for the x and y parameters
	 *                  and mySize for the width and height parameters.
	 *
	 * @return   The Shape specifying the boundaries of this Sprite
	 */
	public Shape getShape()
	{
		return new Ellipse2D.Double(myPosX, myPosY, mySize, mySize);
	}


	/* The following methods are event-handling methods that respond
	 * to keyboard events and mouse events. You may wish to experiment
	 * with these to add additional "user controls" for Ball objects.
	 */
	 // user types any key
	public void keyPressed (Key k) {
		if(!k.equals(Key.R)) {
			mySize += 10;
		}
	}
	public void keyReleased(Key k) { 
		if(!k.equals(Key.R)) {
			mySize -= 10;
		}
	}

	// user types a character (so everything except F1 or Alt, etc.)
	public void keyTyped (Key k) {
		if (k.equals(Key.R)) {
			myColor = new Color(100, 0, 100, 100);
		}
	}

	public void mousePressed (int x, int y) { 
		// change speed
		myDirX += 5;
	}
	public void mouseReleased(int x, int y) { 
		myDirY += 5;
	}
	// ensures that the position change does not go past the stage height
	public void mouseClicked (int x, int y) { 
		Ball ball = new Ball(x, y, 100, Color.BLUE);
		this.getStage().add(ball);
	}
	public void mouseMoved (int x, int y) { 
		if (myPosY + mySize + 25 < this.getStage().getHeight()) {
			myPosY += 25;
		}
	}
	// ensures that the position change does not go past the stage width
	public void mouseDragged (int x, int y) { 
		if (myPosX + mySize + 25 < this.getStage().getWidth()) {
			myPosX += 25;
		}
	}
	// adds new ball
	public void mouseEntered (int x, int y) { 
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		myColor = new Color(r, g, b);
	}
	public void mouseExited  (int x, int y) { 
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		myColor = new Color(r, g, b);
	}

}
