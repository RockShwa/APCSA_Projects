import mickel.anim.Sprite;

import java.awt.Color;
import java.awt.Graphics2D;


/** Represents a GUI-based color swatch that displays a
 *  composite Red-Green-Blue-Alpha (RGBA) color.
 */
public class Swatch extends Sprite
{
	// FIELDS
	// ------------------------------------------------------------
	private int mySize;				// Overall width of the channel
	private int myX;				// Upper left corner of the channel
	private int myY;				// Upper left corner of the channel

	private Controller myRed;		// Palette for the RED channel
	private Controller myGreen;		// Palette for the GREEN channel
	private Controller myBlue;		// Palette for the BLUE channel
	private Controller myAlpha;		// Palette for the ALPHA channel


	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Initializes the properties of this swatch object.
	 *
	 *  @param x		Upper left corner of the swatch
	 *  @param y		Upper left corner of the swatch
	 *  @param width	Overall width of the channel
	 *  @param r		Controller for the red channel
	 *  @param g		Controller for the green channel
	 *  @param b		Controller for the blue channel
	 *  @param a		Controller for the alpha channel
	 */
	public Swatch(int x, int y, int width,
                  Controller r, Controller g, Controller b, Controller a)
	{
		myX = x;
		myY = y + width * 2 / 5;
		mySize = width;

		myRed = r;
		myGreen = g;
		myBlue = b;
		myAlpha = a;
	}


	// METHODS
	// ------------------------------------------------------------
	/** Accessor method for retrieving the composite Color associated with
	 *  the current shades for each of the for color channel controllers.
	 *
	 *  precondition: myRed, myGreen, myBlue, and myAlpha are properly
	 *                initialized Controller objects, each with a getShade()
	 *                methods that return the numerical magnitude of the
	 *                color channel (0 through 255).
	 * postcondition: Returns a Color object that corresponds to the
	 *                combined Red, Green, Blue, and Alpha values of
	 *                the four controllers.
	 *     algorithm: Declare an int called 'rVal' and assign to it the
	 *                  value returned by invoking getShade() on myRed.
	 *                Declare an int called 'gVal' and assign to it the
	 *                  value returned by invoking getShade() on myGreen.
	 *                Declare an int called 'bVal' and assign to it the
	 *                  value returned by invoking getShade() on myBlue.
	 *                Declare an int called 'aVal' and assign to it the
	 *                  value returned by invoking getShade() on myAlpha.
	 *                Return a new Color object with a red value of rVal,
	 *                  a greed value of gVal, a blue value of bVal, and
	 *                  an alpha value of aVal.
	 *
	 * @return The Color object corresponding to this Swatch's RGB value
	 */
	public Color getColor()
	{
		int rVal = myRed.getShade();
		int gVal = myGreen.getShade();
		int bVal = myBlue.getShade();
		int aVal = myAlpha.getShade();
		return new Color(rVal, gVal, bVal, aVal);	
	}

	/** Given a decimal value between 0 and 15, inclusive, returns the
	 *  corresponding hexadecimal character as a String. For example...
	 *  		this.decimalToHex(0)      -->      "0"
	 *  		this.decimalToHex(1)      -->      "1"
	 *  		  ...
	 *  		this.decimalToHex(9)      -->      "9"
	 *  		this.decimalToHex(10)     -->      "A"
	 *  		  ...
	 *  		this.decimalToHex(15)     -->      "F"
	 *
	 *  precondition: 0 <= decimal <= 15
	 * postcondition: Returns a 1-character-long String that corresponds
	 *                to the hexadecimal value of the given decimal input.
	 *     algorithm: If decimal is less than 10...
	 *                  ...return the empty string ("") concatenated with
	 *                     decimal.
	 *                Otherwise, if decimal is 10...
	 *                  ...return "A".
	 *                Otherwise, if decimal is 11...
	 *                  ...return "B".
	 *                Otherwise, if decimal is 12...
	 *                  ...return "C".
	 *                Otherwise, if decimal is 13...
	 *                  ...return "D".
	 *                Otherwise, if decimal is 14...
	 *                  ...return "E".
	 *                Otherwise...
	 *                  ...return "F".
	 *
	 * @param decimal	Base-10 digit to be converted to a Base-16 digit.
	 * @return Hexadecimal equivalent of decimal
	 */
	private static String decimalToHex(int decimal)
	{
		if (decimal < 10)
		{
			return "" + decimal;
		}
		else if (decimal == 10)
		{
			return "A";
		}
		else if (decimal == 11)
		{
			return "B";
		}
		else if (decimal == 12)
		{
			return "C";
		}
		else if (decimal == 13)
		{
			return "D";
		}
		else if (decimal == 14)
		{
			return "E";
		}
		return "F";	// TODO: Replace this with the appropriate implementation.
	}

	/** Accessor method for retrieving a string representing the 6-digit
	 *  hexadecimal color value of this swatch.
	 *
	 *  precondition: myRed, myGreen, myBlue, and myAlpha are properly
	 *                initialized Controller objects with getColorValue()
	 *                methods that return the numerical value of the
	 *                color channel (0 through 255).
	 * postcondition: Returns a String representing the hexadecimal
	 *                value of the 24-bit, RGB value that would result
	 *                from combining the Red, Green, and Blue channels.
	 *                For example, consider the following RGB values:
	 *
	 *                      Red channel = 255 ("FF" in hex)
	 *                    Green channel =   0 ("00" in hex)
	 *                     Blue channel = 123 ("7B" in hex)
	 *
	 *                     RGB value to return = "FF007B"
	 *
	 *     algorithm: Declare a String value called 'rrggbb' and initialize
	 *                it to the empty string ("").
	 *                Declare two int values called 'v0' and 'v1'.
	 *                Declare two String values called 'hex0' and 'hex1'.
	 *                Hard-code the following steps for each of the 4 color 
	 *                channels (myRed, myGreen, and myBlue)...
	 *                NOTE: This is NOT intended to suggest using a loop.
	 *                  ...invoke its getShade() and divide the return
	 *                     value by 16, assigning the result to v0.
	 *                  ...invoke its getShade() and modulus the return
	 *                     value by 16, assigning the result to v1.
	 *                  ...invoke the decimalToHex() method with v0 as a
	 *                     parameter and assign the return value to hex0.
	 *                  ...invoke the decimalToHex() method with v1 as a
	 *                     parameter and assign the return value to hex1.
	 *                  ...Concatenate rrggbb + hex0 + hex1 and assign
	 *                     the result back to rrggbb.
	 *                Return the value of rrggbb.
	 *
	 * @return Hexadecimal representation of this Swatch's RGB value
	 */
	public String getHexString()
	{
		String rrggbb = "";
		int v0;
		int v1;
		String hex0;
		String hex1;
		v0 = myRed.getShade() / 16;
		v1 = myRed.getShade() % 16;
		hex0 = decimalToHex(v0);
		hex1 = decimalToHex(v1);
		rrggbb = rrggbb + hex0 + hex1;
		
		v0 = myGreen.getShade() / 16;
		v1 = myGreen.getShade() % 16;
		hex0 = decimalToHex(v0);
		hex1 = decimalToHex(v1);
		rrggbb = rrggbb + hex0 + hex1;
		
		v0 = myBlue.getShade() / 16;
		v1 = myBlue.getShade() % 16;
		hex0 = decimalToHex(v0);
		hex1 = decimalToHex(v1);
		rrggbb = rrggbb + hex0 + hex1;
		
		
		return rrggbb;	// TODO: Replace this with the appropriate implementation.
	}

	/** Draws all of the elements of this swatch (color sample and
	 *  hexadecimal color value) onto the Stage.
	 *
	 *  precondition: g is the "canvas" of the Stage
	 * postcondition: Draws all of the elements of this Swatch
	 *                onto the graphics canvas, g.
	 *
	 * @param g		The "canvas" on which to draw this Swatch
	 */
	public void draw(Graphics2D g)
	{
		// Color Sample
		ColorPickerGUI.drawDisc(g, myX + mySize / 20, myY, this.getColor(), mySize * 9 / 10);

		// Color Value
		int x = (myX + mySize / 20) + (mySize * 9 / 10) / 2;
		int y = (myY) + (mySize * 9 / 10) / 2;
		ColorPickerGUI.drawText(g, this.getHexString(), x, y, this.getColor(), mySize / 5, true);
	}


	/** Unused for this project.  Does nothing.
	 *
	 * postcondition: Does nothing for this project.  Leave this method
	 *                empty for now and DO NOT delete it.
	 */
	public void act() {}

}
