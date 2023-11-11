import java.awt.Color;


/**
 * This class encapsulates the basic behaviors and characteristics of a
 * standard playing card. Each card has a suit (SPADES, HEARTS, DIAMONDS,
 * CLUBS) and a value (ACE through KING).
 */
public class Card implements Comparable<Card>
{
	
	// FIELDS
	//---------------------------------------------------------------------------
	private CardValue value;		// Value of the card (e.g., Ace, 2, etc.)
	private CardSuit suit;			// Suit of the card (e.g., clubs, spades)
	private Color color;			// Color.RED or Color.BLACK
	private boolean isShowing;		// Card is turned face-up (value/suit showing)
	
	
	
	
	// CONSTRUCTORS
	//---------------------------------------------------------------------------
	/**
	 * Creates a playing card object with the specified value and suit
	 *
	 * @param cardValue         The card's value.
	 * @param cardSuit          The card's suit.
	 */
	public Card(CardValue cardValue, CardSuit cardSuit)
	{
		value = cardValue;
		suit = cardSuit;
		color = suit.getColor();
		isShowing = true;
	}
	
	
	
	
	// ACCESSOR METHODS
	//---------------------------------------------------------------------------
	/**
	 * Determines whether the card is currently positioned face-up or face-down.
	 *
	 * @return     <code>true</code> if card is currently positioned face-up
	 *             (value/suit showing).  <code>false</code> if card is positioned
	 *             face-down (back of card is showing).
	 */
	public boolean isShowing()
	{
		return isShowing;
	}
	
	
	/**
	 * Returns the card's value.
	 *
	 * @return     The value of the card (Ace, 2, 3, ..., Jack, Queen, King)
	 */
	public CardValue getValue()
	{
		return value;
	}
	
	
	/**
	 * Returns the card's suit.
	 *
	 * @return     The suit of the card (Heart, Diamond, Club, Spade)
	 */
	public CardSuit getSuit()
	{
		return suit;
	}
	
	
	/**
	 * Returns the card's color value (i.e. red or black).
	 *
	 * @return     The color of the card's suit (red or black)
	 */
	public Color getColor()
	{
		return color;
	}
	
	
	/**
	 * Causes a card to be displayed on the screen.
	 */
	public void display()
	{
		System.out.print(this.toString() + " ");
	}
	
	
	/**
	 * Represents the card as a String containing the card's value and suit.
	 *
	 * @return     The card's value and suit.
	 */
	public String toString()
	{
		if (isShowing()) { return "" + value + suit; }
		else { return "##"; }
	}
	
	
	/**
	 * Compares this card with another card and returns the difference in their
	 * values. If the card values are equal, then suits are compared.
	 *
	 * @param that      The other card to be compared against.
	 */
	public int compareTo(Card that)
	{
		if (this == that) { return 0; }

		int diff = this.getValue().compareTo(that.getValue());

		if (diff != 0) { return diff; }

		return this.getSuit().compareTo(that.getSuit());
	}
	
	
	/**
	 * Compares this card with another card for equality based on card value and
	 * card suit.
	 *
	 * @param x      The other card to be compared against.
	 */
	public boolean equals(Object that)
	{
		if (this == that) { return true; }
		if ( !(that instanceof Card) ) { return false; }

		return this.getSuit().equals( ((Card)that).getSuit() ) &&
		       this.getValue().equals( ((Card)that).getValue() );
	}
	
	
	
	
	// MODIFIER METHODS
	//---------------------------------------------------------------------------
	/**
	 * Causes a card's orientation to be changed between being face-up and face-down.
	 */
	public void flip()
	{
		isShowing = !isShowing;
	}
	
	
}