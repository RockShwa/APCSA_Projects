/**
 * Objects of this class can be used to represent the values for standard
 * playing cards (JOKER, ACE through KING).
 */
public class CardValue implements Comparable<CardValue>
{
	
	// FIELDS
	//---------------------------------------------------------------------------
	private static final int JOKER_VALUE = 0;
	private static final int   ACE_VALUE = 1;
	private static final int   TWO_VALUE = 2;
	private static final int THREE_VALUE = 3;
	private static final int  FOUR_VALUE = 4;
	private static final int  FIVE_VALUE = 5;
	private static final int   SIX_VALUE = 6;
	private static final int SEVEN_VALUE = 7;
	private static final int EIGHT_VALUE = 8;
	private static final int  NINE_VALUE = 9;
	private static final int   TEN_VALUE = 10;
	private static final int  JACK_VALUE = 11;
	private static final int QUEEN_VALUE = 12;
	private static final int  KING_VALUE = 13;
	
	
	public static final CardValue JOKER = new CardValue(JOKER_VALUE);
	public static final CardValue   ACE = new CardValue(ACE_VALUE);
	public static final CardValue   TWO = new CardValue(TWO_VALUE);
	public static final CardValue THREE = new CardValue(THREE_VALUE);
	public static final CardValue  FOUR = new CardValue(FOUR_VALUE);
	public static final CardValue  FIVE = new CardValue(FIVE_VALUE);
	public static final CardValue   SIX = new CardValue(SIX_VALUE);
	public static final CardValue SEVEN = new CardValue(SEVEN_VALUE);
	public static final CardValue EIGHT = new CardValue(EIGHT_VALUE);
	public static final CardValue  NINE = new CardValue(NINE_VALUE);
	public static final CardValue   TEN = new CardValue(TEN_VALUE);
	public static final CardValue  JACK = new CardValue(JACK_VALUE);
	public static final CardValue QUEEN = new CardValue(QUEEN_VALUE);
	public static final CardValue  KING = new CardValue(KING_VALUE);
	
	/**
	 * An array of all possible card values.
	 */
	public static final CardValue[] VALUES = { JOKER, ACE, TWO, THREE, FOUR,
		 									   FIVE, SIX, SEVEN, EIGHT, NINE,
		 									   TEN, JACK, QUEEN, KING };
	
	private int value;
	
	
	private static final String[] STRING_VALUES = new String[] { "?",  "A", "2",
	                                                             "3",  "4", "5",
	                                                             "6",  "7", "8",
	                                                             "9", "10", "J",
	                                                             "Q",  "K"};
	
	
	
	
	// CONSTRUCTORS
	//---------------------------------------------------------------------------
	private CardValue(int v)
	{
		value = v;
	}
	
	
	
	
	// ACCESSOR METHODS
	//---------------------------------------------------------------------------
	/**
	 * Returns a String representing the card value as "A", "2", "3", ..., "10",
	 * "J", "Q", or "K".
	 *
	 * @return     The card's value as a String.
	 */
	public String toString()
	{
		return STRING_VALUES[value];
	}
	
	
	/**
	 * Returns the card's numeric value (ACE = 1, ..., KING = 13)
	 *
	 * @return     The color of the suit (red or black)
	 */
	public int getValue()
	{
		return value;
	}
	
	
	/**
	 * Compares this card value with another card value and returns their
	 * difference. ACE is considered high.
	 *
	 * @param that      The other card value to be compared against.
	 */
	public int compareTo(CardValue that)
	{
		if (this == that) { return 0; }

		int thisValue = this.getValue();
		int thatValue = that.getValue();

		if (thisValue == 1) { thisValue = 14; }	// Give ACE a high value
		if (thatValue == 1) { thatValue = 14; }	// Give ACE a high value

		return thisValue - thatValue;
	}
	
	
	/**
	 * Compares this card value with another for equality.
	 *
	 * @param x      The other card suit to be compared against.
	 */
	public boolean equals(Object that)
	{
		if (this == that) { return true; }
		if ( !(that instanceof CardValue) ) { return false; }

		return this.getValue() == ((CardValue)that).getValue();
	}
	
	
}