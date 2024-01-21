import mickel.anim.Stage;
import mickel.anim.Qix;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Stroke;


/** The primary GUI window of the ColorPicker application.
 */
public class ColorPickerGUI
{
	// FIELDS
	// ------------------------------------------------------------
	private Controller myRed;		// Palette for the RED channel
	private Controller myGreen;		// Palette for the GREEN channel
	private Controller myBlue;		// Palette for the BLUE channel
	private Controller myAlpha;		// Palette for the ALPHA channel
	private Swatch mySample;		// Palette for the color swatch
	private Stage myStage;			// The base window for the app.


	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs and initializes each of the components for this
	 *  GUI window.
	 */
	public ColorPickerGUI()
	{
		int unit = 225;		// Used for sizing GUI elements
		int throttle = 25;	// Used for adjusting speed of animation

		// Initialize the stage
		int stageWidth = unit * 10 / 3;
		int stageHeight = unit * 32 / 15;
		myStage = new Stage("ColorPicker", stageWidth, stageHeight, throttle);
		myStage.setBackground(Color.BLACK);

		// Add animated, background elements to the stage
		for (int i = 0; i < 4; i++)
		{
			myStage.add(new Qix(stageWidth, stageHeight));
		}

		// Initialize each of the color channel controller sprites
		// TODO: See instructions on board
		myRed = new Controller(0, 0, unit, RGBA.RED);
		myGreen = new Controller(unit, 0, unit, RGBA.GREEN);
		myBlue = new Controller(0, unit, unit, RGBA.BLUE);
		myAlpha = new Controller(unit, unit, unit, RGBA.ALPHA);

		// Initialize the sample swatch sprite
		// TODO: See instructions on board
		mySample = new Swatch(unit * 2, 0, unit * 4/3, myRed, myGreen, myBlue, myAlpha);

		// Add the color channels and sample swatch to the stage
		// TODO: See instructions on board
		myStage.add(myRed);
		myStage.add(myGreen);
		myStage.add(myBlue);
		myStage.add(myAlpha);
		myStage.add(mySample);

		// Make the stage visible and start the animation
		myStage.openWindow();
		myStage.start();
	}


	// METHODS
	// ------------------------------------------------------------
	/** General purpose "class" method for drawing a colored disc onto the canvas.
	 *
	 * precondition: g is the "canvas" of the Stage.  c is the Color object that
	 *                corresponds to the current color value of this particular
	 *                channel.  x and y are the upper, left coordinates of the
	 *                disk to be drawn.  size is the diameter of the disk to be drawn.
	 * postcondition: Draws a disk on the canvas with the specified size, location,
	 *                and color.
	 *
	 * @param g		The "canvas" on which the disc is to be drawn
	 * @param x		Upper left corner of the disc
	 * @param y		Upper left corner of the disc
	 * @param c		Color of the disc
	 * @param size	Diameter of the disc
	 */
	public static void drawDisc(Graphics2D g, int x, int y, Color c, int size)
	{
		Stroke stroke = g.getStroke();
		int w = Math.max(size / 15, 4);

		g.setColor(c);
		g.fillOval(x, y, size, size);

		g.setStroke(new BasicStroke(w));
		g.setColor(Color.BLACK);
		g.drawOval(x, y, size, size);

		g.setStroke(new BasicStroke(w / 2));
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(x, y, size, size);

		g.setStroke(stroke);
	}

	/** General purpose "class" method for drawing a text string onto the canvas.
	 *
	 *  precondition: g is the "canvas" of the Stage.
	 * postcondition: Draws the specified text string centered on the given
	 *                position (x, y) in the specified color and font size.
	 *
	 * @param g			The "canvas" on which the text is to be drawn
	 * @param text		The text string to be drawn
	 * @param x			X coordinate of the text
	 * @param y			Y coordinate of the text
	 * @param c			Color of the text
	 * @param size		Height of the text (in pixels)
	 * @param centered	true if the
	 */
	public static void drawText(Graphics2D g, String text, int x, int y,
			                    Color c, int size, boolean centered)
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
