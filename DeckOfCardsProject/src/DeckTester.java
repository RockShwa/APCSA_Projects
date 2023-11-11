import java.util.Scanner;

/**
 * A driver class used to test the functionality of the Deck class.
 */
public class DeckTester
{
	
	// FIELDS
	//---------------------------------------------------------------------------
	private Deck deck1;								// Sample deck #1
	private Deck deck2;								// Sample deck #2
	private Deck deck3;								// Sample deck #3

	private Card[] emptySet  = new Card[] {  };		// An empty array of cards

	// @: Hearts
	// ^: Diamonds
	// %: Clubs
	// $: Spades

	// sampleSet: [ A@, K$, 2@, Q%, 3^, J$, 4^, 10^, 5%, 9@, 6%, 8^, 7@ ]
	private Card[] sampleSet = new Card[] { new Card(CardValue.ACE  , CardSuit.HEARTS  ),
                                            new Card(CardValue.KING , CardSuit.SPADES  ),
                                            new Card(CardValue.TWO  , CardSuit.HEARTS  ),
                                            new Card(CardValue.QUEEN, CardSuit.CLUBS   ),
                                            new Card(CardValue.THREE, CardSuit.DIAMONDS),
                                            new Card(CardValue.JACK , CardSuit.SPADES  ),
                                            new Card(CardValue.FOUR , CardSuit.DIAMONDS),
                                            new Card(CardValue.TEN  , CardSuit.DIAMONDS),
                                            new Card(CardValue.FIVE , CardSuit.CLUBS   ),
                                            new Card(CardValue.NINE , CardSuit.HEARTS  ),
                                            new Card(CardValue.SIX  , CardSuit.CLUBS   ),
                                            new Card(CardValue.EIGHT, CardSuit.DIAMONDS),
                                            new Card(CardValue.SEVEN, CardSuit.HEARTS  )
                                          };
	
	
	
	
	// CONSTRUCTORS
	//---------------------------------------------------------------------------
	/**
	 * Initializes 3 sample decks for testing.
	 */
	public DeckTester()
	{
		deck1 = new Deck(sampleSet);
		deck2 = new Deck(emptySet);
		deck3 = new Deck();
	}
	
	
	
	
	// METHODS
	//---------------------------------------------------------------------------
	// Conducts a series of tests, one for each method of the Deck class.
	public void beginTest()
	{
		this.testSize();
		this.testIsEmpty();

		this.testToString();

		this.testGetCard();
		this.testGetCardsRange();
		this.testGetCards();

		this.testEquals();

		this.testDeal();
		this.testDealN();

		this.testInsertCard();
		this.testInsertCards();
		this.testAddCard();
		this.testAddCards();

		this.testContains();
		this.testHasDuplicates();

		this.testShuffle();
		this.testSort();

		this.testPickACardAnyCard();

		print("=====================================================");
		print("TESTING IS COMPLETE. GOODBYE.");
	}

	// Tests the size() method
	public void testSize()
	{
		print("=====================================================");
		print("TESTING: size() method...");
		print("...deck1 should show a size of '13' cards");
		print("...deck2 should show a size of '0' cards");
		print("...deck3 should show a size of '56' cards");
		print("-----------------------------------------------------");

		print("deck1.size(): " + deck1.size());
		print("deck2.size(): " + deck2.size());
		print("deck3.size(): " + deck3.size());

		more();
	}

	// Tests the isEmpty() method
	public void testIsEmpty() {
		print("=====================================================");
		print("TESTING: isEmpty() method...");
		print("...deck1 should show 'false'");
		print("...deck2 should show 'true'");
		print("...deck3 should show 'false'");
		print("-----------------------------------------------------");

		print("deck1.isEmpty(): " + deck1.isEmpty());
		print("deck2.isEmpty(): " + deck2.isEmpty());
		print("deck3.isEmpty(): " + deck3.isEmpty());

		more();
	}

	// Tests the custom deck constructor and toString() method
	public void testToString()
	{
		print("=====================================================");
		print("TESTING: toString() method...");
		print("...deck1 should show a Deck w/ 13 'random' cards");
		print("...deck2 should show an empty deck");
		print("...deck3 should show a standard Deck of 56 cards");
		print("-----------------------------------------------------");

		print("deck1.toString(): " + deck1.toString());
		print("deck2.toString(): " + deck2.toString());
		print("deck3.toString(): " + deck3.toString());

		more();
	}


	// Tests the getCard(int n) method
	public void testGetCard()
	{
		print("=====================================================");
		print("TESTING: getCard(int n) method...");
		print("...card #0 should be the A@");
		print("...card #4 should be the 3^");
		print("...card #12 should be the 7@");
		print("-----------------------------------------------------");

		print("deck1.getCard(0): " + deck1.getCard(0));
		print("deck1.getCard(4): " + deck1.getCard(4));
		print("deck1.getCard(12): " + deck1.getCard(12));

		more();
	}

	// Tests the getCards(int first, int last) method
	public void testGetCardsRange()
	{
		print("=====================================================");
		print("TESTING: getCards(int first, int last) method...");
		print("...cards #0 thru #3 should be A@ K$ 2@ Q%");
		print("...cards #4 thru #12 should be 3^ J$ 4^ 10^ 5% 9@ 6% 8^ 7@");
		print("-----------------------------------------------------");

		print("deck1.getCards(0, 3): " + arrayToString(deck1.getCards(0, 3)));
		print("deck1.getCards(4, 12): " + arrayToString(deck1.getCards(4, 12)));

		more();
	}

	// Tests the getCards() method
	public void testGetCards()
	{
		print("=====================================================");
		print("TESTING: getCards() method...");
		print("...deck1 contains A@ K$ 2@ Q% 3^ J$ 4^ 10^ 5% 9@ 6% 8^ 7@");
		print("...deck2 contains no cards");
		print("...deck3 contains all 56 cards in sorted order");
		print("-----------------------------------------------------");

		print("deck1.getCards(): " + arrayToString(deck1.getCards()));
		print("deck2.getCards(): " + arrayToString(deck2.getCards()));
		print("deck3.getCards(): " + arrayToString(deck3.getCards()));

		more();
	}

	// Tests the equals() method
	public void testEquals()
	{
		print("=====================================================");
		print("TESTING: equals() method...");
		print("...deck1.equals(deck2) is 'false'");
		print("...deck1.equals(deck1) is 'true'");
		print("...deck2.equals(deck2) is 'true'");
		print("-----------------------------------------------------");

		print("deck1.equals(deck2): " + deck1.equals(deck2));
		print("deck1.equals(deck1): " + deck1.equals(deck1));
		print("deck2.equals(deck2): " + deck2.equals(deck2));

		more();
	}

	// Tests the deal() method
	public void testDeal()
	{
		print("=====================================================");
		print("TESTING: deal() method...");
		print("...Card dealt from deck1 is A@");
		print("     ...deck1 contains K$ 2@ Q% 3^ J$ 4^ 10^ 5% 9@ 6% 8^ 7@");
		print("");
		print("...Card dealt from deck2 is null");
		print("     ...deck2 contains no cards");
		print("");
		print("...Card dealt from deck3 is ?$");
		print("     ...deck3 contains all 55 cards, none of which is ?$");
		print("-----------------------------------------------------");

		print("deck1.deal(): " + deck1.deal());
		print("deck1.toString(): " + deck1.toString());
		print("");

		print("deck2.deal(): " + deck2.deal());
		print("deck2.toString(): " + deck2.toString());
		print("");

		print("deck3.deal(): " + deck3.deal());
		print("deck3.toString(): " + deck3.toString());

		more();
	}

	// Tests the deal(int n) method
	public void testDealN()
	{
		print("=====================================================");
		print("TESTING: deal(int n) method...");
		print("...Cards dealt from deck1 are K$ 2@");
		print("...Cards dealt from deck1 are Q% 3^ J$");
		print("...Cards remaining in deck1 are 4^ 10^ 5% 9@ 6% 8^ 7@");
		print("-----------------------------------------------------");

		print("deck1.deal(2): " + arrayToString(deck1.deal(2)));
		print("deck1.deal(3): " + arrayToString(deck1.deal(3)));
		print("deck1.toString(): " + deck1.toString());

		more();
	}

	// Tests the insertCard(int n, Card c) method
	public void testInsertCard()
	{
		print("=====================================================");
		print("TESTING: insertCard(int n, Card c) method...");
		print("...dealing 1 Card from top of deck3 and add to top of deck2");
		print("     ...deck3 should show 54 cards, none of which is ?$ or A$");
		print("     ...deck2 should show A$");
		print("");
		print("...dealing 1 Card from top of deck3 and add to top of deck1");
		print("     ...deck3 should show 53 cards, none of which is ?$, A$, or 2$");
		print("     ...deck1 should show 2$ 4^ 10^ 5% 9@ 6% 8^ 7@");
		print("");
		print("...dealing 1 Card from top of deck3 and bottom to top of deck1");
		print("     ...deck3 should show 52 cards, none of which is ?$, A$, 2$, or 3$");
		print("     ...deck1 should show 2$ 4^ 10^ 5% 9@ 6% 8^ 3$ 7@");
		print("-----------------------------------------------------");

		deck2.insertCard(0, deck3.deal());
		print("deck2.insertCard(0, deck3.deal()): ...");
		print("deck3.size(): " + deck3.size());
		print("deck3.toString(): " + deck3.toString());
		print("deck2.toString(): " + deck2.toString());
		print("");

		deck1.insertCard(0, deck3.deal());
		print("deck1.insertCard(0, deck3.deal()): ...");
		print("deck3.size(): " + deck3.size());
		print("deck3.toString(): " + deck3.toString());
		print("deck1.toString(): " + deck1.toString());
		print("");

		deck1.insertCard(deck1.size()-1, deck3.deal());
		print("deck1.insertCard(deck1.size()-1, deck3.deal()): ...");
		print("deck3.size(): " + deck3.size());
		print("deck3.toString(): " + deck3.toString());
		print("deck1.toString(): " + deck1.toString());

		more();
	}

	// Tests the insertCards(int n, Card[] c) method
	public void testInsertCards()
	{
		print("=====================================================");
		print("TESTING: insertCards(int n, Card[] c) method...");
		print("...dealing 2 Cards from top of deck3 and add to top of deck1");
		print("     ...deck3 should show 50 cards, none of which is ?$, A$, 2$, 3$, 4$, or 5$");
		print("     ...deck1 should show 4$ 5$ 2$ 4^ 10^ 5% 9@ 6% 8^ 3$ 7@");
		print("-----------------------------------------------------");

		deck1.insertCards(0, deck3.deal(2));
		print("deck1.insertCards(0, deck3.deal(2)): ...");
		print("deck3.size(): " + deck3.size());
		print("deck3.toString(): " + deck3.toString());
		print("deck1.toString(): " + deck1.toString());

		more();
	}

	// Tests the addCard(Card c) method
	public void testAddCard()
	{
		print("=====================================================");
		print("TESTING: addCard(Card c) method...");
		print("...dealing 1 Card from top of deck3 and add to bottom of deck1");
		print("     ...deck3 should show 49 cards, none of which is ?$, A$, 2$, 3$, 4$, 5$, or 6$");
		print("     ...deck1 should show 4$ 5$ 2$ 4^ 10^ 5% 9@ 6% 8^ 3$ 7@ 6$");
		print("-----------------------------------------------------");

		deck1.addCard(deck3.deal());
		print("deck1.addCard(deck3.deal()): ...");
		print("deck3.size(): " + deck3.size());
		print("deck3.toString(): " + deck3.toString());
		print("deck1.toString(): " + deck1.toString());

		more();
	}

	// Tests the addCards(Card[] c) method
	public void testAddCards()
	{
		print("=====================================================");
		print("TESTING: addCards(Card[] c) method...");
		print("...dealing 7 Cards from top of deck3 and add to bottom of deck2");
		print("     ...deck3 should show 42 cards, none of which is a SPADE");
		print("     ...deck2 should show A$ 7$ 8$ 9$ 10$ J$ Q$ K$");
		print("-----------------------------------------------------");

		deck2.addCards(deck3.deal(7));
		print("deck2.addCards(deck3.deal(7)): ...");
		print("deck3.size(): " + deck3.size());
		print("deck3.toString(): " + deck3.toString());
		print("deck2.toString(): " + deck2.toString());

		more();
	}

	// Tests the contains(Card c) method
	public void testContains()
	{
		print("=====================================================");
		print("TESTING: contains(Card c) method...");
		print("...deck1 contains A@ is false");
		print("...deck2 contains 7$ is true");
		print("...deck2 contains J% is true");
		print("-----------------------------------------------------");

		Card a = new Card(CardValue.ACE, CardSuit.HEARTS);
		Card b = new Card(CardValue.SEVEN, CardSuit.SPADES);
		Card c = new Card(CardValue.JACK, CardSuit.CLUBS);
		print("deck1.contains(A@): " + deck1.contains(a));
		print("deck2.contains(7$): " + deck2.contains(b));
		print("deck3.contains(J%): " + deck3.contains(c));

		more();
	}

	// Tests the hasDuplicates() method
	public void testHasDuplicates()
	{
		print("=====================================================");
		print("TESTING: hasDuplicates() method...");
		print("...deck1 has no duplicates (shows 'false')");
		print("...deck2 has no duplicates (shows 'false')");
		print("...deck3 has no duplicates (shows 'false')");
		print("");
		print("...after reading the top card from deck3 and adding it to the bottom of deck3...");
		print("     ...deck3 has duplicates (shows 'true')");
		print("-----------------------------------------------------");

		print("deck1.hasDuplicates(): " + deck1.hasDuplicates());
		print("deck2.hasDuplicates(): " + deck2.hasDuplicates());
		print("deck3.hasDuplicates(): " + deck3.hasDuplicates());
		print("");

		deck3.addCard(deck3.getCard(0));
		print("deck3.add(deck3.get(0)): ...");
		print("deck3.hasDuplicates(): " + deck3.hasDuplicates());

		more();
	}

	// Tests the shuffle() method
	public void testShuffle()
	{
		print("=====================================================");
		print("TESTING: shuffle() method...");
		print("...deck1 shows 12 Cards in a random order");
		print("...deck2 shows 8 Cards in a random order");
		print("...deck3 shows 43 Cards in a random order");
		print("-----------------------------------------------------");

		deck1.shuffle();
		print("deck1.size(): " + deck1.size());
		print("deck1.shuffle(): " + deck1.toString());
		print("");

		deck2.shuffle();
		print("deck2.size(): " + deck2.size());
		print("deck2.shuffle(): " + deck2.toString());
		print("");

		deck3.shuffle();
		print("deck3.size(): " + deck3.size());
		print("deck3.shuffle(): " + deck3.toString());
		print("");

		more();
	}

	// Tests the sort() method
	public void testSort()
	{
		print("=====================================================");
		print("TESTING: sort() method...");
		print("...deck1 shows 2$ 3$ 4^ 4$ 5% 5$ 6% 6$ 7@ 8^ 9@ 10^");
		print("...deck2 shows 7$ 8$ 9$ 10$ J$ Q$ K$ A$");
		print("...deck3 shows 43 Cards in ascending order based on the Card class' natural ordering");
		print("-----------------------------------------------------");

		deck1.sort();
		print("deck1.size(): " + deck1.size());
		print("deck1.sort(): " + deck1.toString());
		print("");

		deck2.sort();
		print("deck2.size(): " + deck2.size());
		print("deck2.sort(): " + deck2.toString());
		print("");

		deck3.sort();
		print("deck3.size(): " + deck3.size());
		print("deck3.sort(): " + deck3.toString());
		print("");

		more();
	}

	// Tests the pickACardAnyCard() method
	public void testPickACardAnyCard() {
		print("=====================================================");
		print("TESTING: pickACardAnyCard() method...");
		print("...Removing a random Card from deck1...");
		print("     ...one of the following Cards is removed: 2$ 3$ 4^ 4$ 5% 5$ 6% 6$ 7@ 8^ 9@ 10^");
		print("");
		print("...Removing a random Card from deck2...");
		print("     ...one of the following Cards is removed: 7$ 8$ 9$ 10$ J$ Q$ K$ A$");
		print("");
		print("...Removing a random Card from deck3...");
		print("     ...one of the HEARTS, DIAMONDS, or CLUBS is removed");
		print("-----------------------------------------------------");

		print("deck1.pickACardAnyCard(): " + deck1.pickACardAnyCard());
		print("deck1.toString(): " + deck1.toString());
		print("");

		print("deck2.pickACardAnyCard(): " + deck2.pickACardAnyCard());
		print("deck2.toString(): " + deck2.toString());
		print("");

		print("deck3.pickACardAnyCard(): " + deck3.pickACardAnyCard());
		print("deck3.toString(): " + deck3.toString());

		more();
	}
	
	
	
	
	// PRIVATE UTILITY METHODS
	//-------------------------------------------------------------------
	private Scanner kb = new Scanner(System.in);

	private void more()
	{
		print("");
		System.out.print("Press [ENTER] to continue testing...");
		kb.nextLine();
		print("");
		print("");
	}

	private void print(String s)
	{
		s = s.replaceAll("\\@", CardSuit.HEARTS.toString());
		s = s.replaceAll("\\$", CardSuit.SPADES.toString());
		s = s.replaceAll("\\%", CardSuit.CLUBS.toString());
		s = s.replaceAll("\\^", CardSuit.DIAMONDS.toString());
		System.out.println(s);
	}

	private static String arrayToString(Card[] a) {
		String s = "";
		if (a == null) { return s; }
		for (Card c : a) { s += c.toString() + " "; }
		return s;
	}


	public static void main(String[] args) {
		DeckTester tester = new DeckTester();
		tester.beginTest();
	}
}