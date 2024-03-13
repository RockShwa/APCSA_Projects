import java.awt.Color;



/** Enumerated type that represents the 4 primary color channels of
 * the RGBA color system (Red, Green, Blue, and Alpha).
 */
public enum RGBA
{
	// VALID VALUES
	// ------------------------------------------------------------
	RED,
	GREEN,
	BLUE,
	ALPHA;


	// METHODS
	// ------------------------------------------------------------
	/** Accessor method for retrieving the base, unshaded  color
	 *  representation for this color channel -- either Color.RED,
	 *  Color.GREEN, Color.BLUE, or Color.WHITE (for 'alpha')
	 *
	 *  precondition: this is a valid RGBA enumeration.
	 * postcondition: Returns the corresponding Color object for
	 *                this RGBA object.  The ALPHA channel returns
	 *                Color.WHITE by default.
	 *
	 * @return The Color object representing this color channel
	 */
	public Color getColor()
	{
		if      (this == RGBA.RED  )	{ return Color.RED; }
		else if (this == RGBA.GREEN)	{ return Color.GREEN; }
		else if (this == RGBA.BLUE )	{ return Color.BLUE; }
		else							{ return Color.WHITE; }
	}

	/** Accessor method for retrieving the name of this color channel.
	 *
	 *  precondition: this is a valid RGBA enumeration.
	 * postcondition: Returns the name of the color channel.
	 *     algorithm: If this is an RGBA.RED enumeration...
	 *                  ...return the string: "Red"
	 *                Otherwise, if this is an RGBA.GREEN enumeration...
	 *                  ...return the string: "Green"
	 *                Otherwise, if this is an RGBA.BLUE enumeration...
	 *                  ...return the string: "Blue"
	 *                Otherwise...
	 *                  ...return the string: "Alpha"
	 *
	 * @return The name of this color channel
	 */
	public String getName()
	{
		if (this == RGBA.RED)
		{
			return "Red";
		}
		else if (this == RGBA.GREEN)
		{
			return "Green";
		}
		else if (this == RGBA.BLUE)
		{
			return "Blue";
		}
		return "Alpha";
	}

	/** Standard method for retrieving a String representation of
	 *  an object.
	 *
	 *  precondition: this is a valid RGBA enumeration.
	 * postcondition: Returns a String representation of the
	 *                color channel (i.e., its name).
	 *
	 * @return The name of this color channel
	 */
	public String toString() { return this.getName(); }

}
