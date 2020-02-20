import java.util.Random;

/**
 * @author nicolasnoriega
 * @descrition Simulates a game of BlackJack between a single player and a dealer following the standard rules
 * @datedue February 13th, 2020
 */

public class Deck 
{
	private Card[] deck;
	private int numOfCardsPerDeck = 52;
	private int topCardIndex = 0;
	private int nextCardToBeDealt;
	
	public Deck()
	{
		Card.Ranks[] Rank = {
				Card.Ranks.Ace, 
				Card.Ranks.Two, 
				Card.Ranks.Three, 
				Card.Ranks.Four, 
				Card.Ranks.Five, 
				Card.Ranks.Six, 
				Card.Ranks.Seven, 
				Card.Ranks.Eight, 
				Card.Ranks.Nine, 
				Card.Ranks.Ten, Card.Ranks.Jack, Card.Ranks.Queen, Card.Ranks.King 
				};
		
		Card.Suits[] Suit = {
				Card.Suits.Clubs,
				Card.Suits.Spades,
				Card.Suits.Diamonds,
				Card.Suits.Hearts
				};
		
		deck = new Card[numOfCardsPerDeck];
		nextCardToBeDealt = 0;
		
		for(int i = 0; i < deck.length; i++)
		{
			deck[i] = new Card(Suit [i / 13], Rank[i % 13]);
		}
		
	}
	
	public void shuffleCards()
	{	
		nextCardToBeDealt = 0;
		
		for(int i = 0; i < deck.length; i++)
		{
			Random random = new Random();
			
			int cardToBeSwappedWith = random.nextInt(numOfCardsPerDeck);
			
			Card temp = deck[i];
			deck[i] = deck[cardToBeSwappedWith];
			deck[cardToBeSwappedWith] = temp;
		}
		
	}
	
	public Card dealTopCard() 
	{
		Card topCards = this.deck[0]; //Grabs the first card
		
		for(int i = 1; i < numOfCardsPerDeck; i++)
		{
			this.deck[i - 1] = this.deck[i];
		}
		this.deck[numOfCardsPerDeck - 1] = null;
		
		numOfCardsPerDeck--;
		
		return topCards;
	}
	

}
