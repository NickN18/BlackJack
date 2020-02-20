import java.util.ArrayList;

/**
 * @author nicolasnoriega
 * @descrition Simulates a game of BlackJack between a single player and a dealer following the standard rules
 * @datedue February 13th, 2020
 */

class PlayerCharacter 
{	
	ArrayList<Card> hand;
	int numOfPlayerCards;
	
	private static int currentPlayerBet;
	
	static class Dealer extends PlayerCharacter
	{
		
		ArrayList<Card> hand = new ArrayList<Card>();
		
		public void addCard(Card newCard)
		{
			hand.add(newCard);
			numOfPlayerCards++;
		}
		
		public int getHandSum()
		{
			int totalSumOfHand = 0;
			
			for(Card countSum: hand)
			{
				totalSumOfHand += countSum.getValue();
			}
			return totalSumOfHand;
		}
		
		public void getHand(boolean hideDealerCard) 
		{
			System.out.println("Dealer's hand: ");
			
			for(int i = 0; i < numOfPlayerCards; i++)
			{
				if(i == 0 && !hideDealerCard)
				{
					System.out.println("[Hidden Card]");
				} else 
				{
					System.out.println(hand.get(i).toString());
				}
			}
		}
	}
	
	static class Player extends PlayerCharacter
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		
		public void addCard(Card newCard)
		{
			hand.add(newCard);
			numOfPlayerCards++;
		}
		
		public int getHandSum()
		{
			int totalSumOfHand = 0;
			
			for(Card countSum: hand)
			{
				totalSumOfHand += countSum.getValue();
			}
			return totalSumOfHand;
		}
		
		public void getHand() 
		{
			System.out.println("Your hand: ");
			
			for(int i = 0; i < numOfPlayerCards; i++)
			{
				System.out.println(hand.get(i).toString());
			}
		}
		
		public void playerBet(int playerBettingMoney, int currentBet)
		{
			if(playerBettingMoney == 0)
			{
				System.out.println("No more betting money!");
				return;
			}
			
			playerBettingMoney -= currentBet;
			
			currentPlayerBet = currentBet;
			
			System.out.println("New bet: $" + currentBet);
			System.out.println("Betting money left: $" + playerBettingMoney);
			
		}
		
		public void doubleDown(int playerBettingMoney)
		{
			if(playerBettingMoney == 0)
			{
				System.out.println("No more out of betting money to double down!");
			}
			
			currentPlayerBet = currentPlayerBet * 2;
			
			System.out.println("New bet: $" + currentPlayerBet);
			
		}
		
		
	}
	
}
