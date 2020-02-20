
/**
 * @author nicolasnoriega
 * @descrition Simulates a game of BlackJack between a single player and a dealer following the standard rules
 * @datedue February 13th, 2020
 */

public class Card 
{
	private Ranks Rank;
	private Suits Suit;
	
	public enum Ranks 
	{ 
		Ace(1), 
		Two(2), 
		Three(3), 
		Four(4), 
		Five(5), 
		Six(6), 
		Seven(7), 
		Eight(8), 
		Nine(9), 
		Ten(10), Jack(10), Queen(10), King(10);
		
		private int value;
		
		private Ranks(int value)
		{
			this.value = value;
		}
		
		private int getValue()
		{
			return value;
		}
	}
	
	public enum Suits 
	{ 
		Clubs(" Clubs"), 
		Spades(" Spades"), 
		Diamonds(" Diamonds"), 
		Hearts(" Hearts");
		
		private String suitString;
		
		private Suits(String suitString)
		{
			this.suitString = suitString;
		}
		
		private String getSuit()
		{
			return suitString;
		}
		
	}
	
	public Card(Suits cardSuit, Ranks cardRank)
	{
		this.Suit = cardSuit;
		this.Rank = cardRank;
	}
	
	
	public int getValue()
	{
		return Rank.getValue();
	}
	
	public String getSuit()
	{
		return Suit.getSuit();
	}
	
	public String toString()
	{
		return Rank + " of " + Suit;
	}
	
}
