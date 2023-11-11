import java.awt.Color;


/**
 * Objects of this class can be used to represent the suits for standard
 * playing cards (SPADES, HEARTS, DIAMONDS, CLUBS).
 */
public class CardSuit implements Comparable<CardSuit>
{
	
	// FIELDS
	//---------------------------------------------------------------------------	
	private char suit;
	private Color color;
	
	
	private static final char   SPADES_VALUE = 0x2660;		//6;
	private static final char    CLUBS_VALUE = 0x2663;		//5;
	private static final char   HEARTS_VALUE = 0x2665;		//3;
	private static final char DIAMONDS_VALUE = 0x2666;		//4;
	
	public static final CardSuit SPADES   = new CardSuit(SPADES_VALUE);
	public static final CardSuit HEARTS   = new CardSuit(HEARTS_VALUE);
	public static final CardSuit DIAMONDS = new CardSuit(DIAMONDS_VALUE);
	public static final CardSuit CLUBS    = new CardSuit(CLUBS_VALUE);
	
	/**
	 * An array of all possible card suits.
	 */
	public static final CardSuit[] SUITS = new CardSuit[] { SPADES, HEARTS,
	                                                        DIAMONDS, CLUBS };
	
	// Used for the toString() method
	private static final char   SPADES_CHAR = SPADES_VALUE;		//'s';	//6;
	private static final char   HEARTS_CHAR = HEARTS_VALUE;		//'h';	//3;
	private static final char DIAMONDS_CHAR = DIAMONDS_VALUE;	//'d';	//4;
	private static final char    CLUBS_CHAR = CLUBS_VALUE;		//'c';	//5;
	
	private static final char[] SUIT_CHARS = new char[] {  SPADES_CHAR, ' ', ' ',
														   CLUBS_CHAR, ' ',
														   HEARTS_CHAR,
														   DIAMONDS_CHAR  };
	
	
	
	
	// CONSTRUCTORS
	//---------------------------------------------------------------------------
	private CardSuit(char s)
	{
		suit = s;
		if (s == HEARTS_VALUE || s == DIAMONDS_VALUE) { color = Color.RED; }
		else { color = Color.BLACK; }
	}
	
	
	
	
	// ACCESSOR METHODS
	//---------------------------------------------------------------------------
	/**
	 * Returns a String representing the card suit.
	 *
	 * @return     The card's value as a String.
	 */
	public String toString()
	{
		return "" + SUIT_CHARS[suit - SPADES_VALUE];
	}
	
	
	/**
	 * Returns the suit's color value (i.e. red or black).
	 *
	 * @return     The color of the suit (red or black)
	 */
	public Color getColor()
	{
		return color;
	}
	
	
	/**
	 * Returns the suit's ASCII char value
	 *
	 * @return     The ASCII value of the suit
	 */
	public char getSuit()
	{
		return suit;
	}
	
	
	/**
	 * Compares this card suit with another card suit and returns their relative
	 * difference. The rank order of the suits from highest to lowest is SPADE,
	 * HEARTS, DIAMONDS, CLUBS.
	 *
	 * @param that      The other card value to be compared against.
	 */
	public int compareTo(CardSuit that)
	{
		if (this == that) { return 0; }

		char thisValue = this.getSuit();
		char otherValue = that.getSuit();

		if (thisValue == otherValue) { return 0; }

		int thisRank = 4;
		     if (thisValue ==   HEARTS_VALUE) { thisRank = 3; }
		else if (thisValue == DIAMONDS_VALUE) { thisRank = 2; }
		else if (thisValue ==    CLUBS_VALUE) { thisRank = 1; }

		int otherRank = 4;
		     if (otherValue ==   HEARTS_VALUE) { otherRank = 3; }
		else if (otherValue == DIAMONDS_VALUE) { otherRank = 2; }
		else if (otherValue ==    CLUBS_VALUE) { otherRank = 1; }

		return thisRank - otherRank;
	}
	
	
	/**
	 * Compares this card suit with another for equality.
	 *
	 * @param x      The other card suit to be compared against.
	 */
	public boolean equals(Object that)
	{
		if (this == that) { return true; }
		if ( !(that instanceof CardSuit) ) { return false; }

		return this.getSuit() == ((CardSuit)that).getSuit();
	}
	
	
}