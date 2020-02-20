import java.util.Scanner;

/**
 * @author nicolasnoriega
 * @descrition Simulates a game of BlackJack between a single player and a dealer following the standard rules
 * @datedue February 13th, 2020
 */


public class BlackJackDriver 
{
	public static void main(String[] args)
	{
		final Deck deck = new Deck();
		final PlayerCharacter.Dealer dealer = new PlayerCharacter.Dealer();
		final PlayerCharacter.Player player = new PlayerCharacter.Player();
		
		Scanner input = new Scanner(System.in);
		
		int playerBettingMoney = 100;
		int playerCurrentBet;
		int initialMenuCalls = 0; // keeps tracks of the amount of times initialMenu() has been called
		
		boolean playerStand = false;
 		
		System.out.println("You have $" + playerBettingMoney + " to bet.");
		initialMenu();
		
		String userInput = input.next().toLowerCase();
		char userChoice = userInput.charAt(0); 
		
		while(userChoice != 'x') 
		{
			switch(userChoice)
			{
				case 's':
					deck.shuffleCards();
					break;
				
				case 'd':
					player.addCard(deck.dealTopCard());// adds two cards to the players hand
					player.addCard(deck.dealTopCard());
					player.getHand();
					System.out.println("Your hand's value: " + player.getHandSum());
					System.out.println(" ");
					
					dealer.addCard(deck.dealTopCard());//adds two cards to the dealer's hand
					dealer.addCard(deck.dealTopCard());
					dealer.getHand(false);//hides the first card of the dealer
					
					playMenu();
					String playingInput = input.next().toLowerCase();
					char playingChoice = playingInput.charAt(0);
					while(player.getHandSum() < 21 && playerStand != true)
					{
						switch(playingChoice)
						{
							case 'h':
								player.addCard(deck.dealTopCard()); //adds another card to the players hand
								player.getHand();
								System.out.println("Your new hand's value: " + player.getHandSum());
								break;
								
							case 's':
								playerStand = true;
								break;
								
							case 'd':
								player.doubleDown(playerBettingMoney);
								break;
						}
						
						if(dealer.getHandSum() < 21)
						{
							dealer.addCard(deck.dealTopCard());
						}
						
						System.out.println(" ");
						dealer.getHand(true);
						System.out.println("Dealer's new hand value: " + dealer.getHandSum());
						
						/*
						 * This next section compares the hands between the player and dealer
						 * Using the standard rules of Blackjack, the logic is geared to
						 * fairly judge each hand in comparison to the other and make a decision 
						 * on what to print to the player
						 */
						
						if(player.getHandSum() > 21 && dealer.getHandSum() < 21)
						{
							System.out.println("Your hand is a bust! Dealer wins!"); 
							return;
						}
						
						if(player.getHandSum() == 21 && dealer.getHandSum() <= 21)
						{
							System.out.println("You've got 21! You win!");
							return;
						}
						
						if(player.getHandSum() < 21 && dealer.getHandSum() == 21)
						{
							System.out.println("Dealer has 21! Dealer wins!");
						}
						
						if(dealer.getHandSum() > 21)
						{
							System.out.println("Dealer has busted! You win!");
						}
						
						playMenu();
						playingInput = input.next().toLowerCase();
						playingChoice = playingInput.charAt(0);
					}
					break;
				
				case 'b':
					System.out.println("How much would you like to bet?: ");
					playerCurrentBet = input.nextInt();
					player.playerBet(playerBettingMoney, playerCurrentBet); //calls the playerBet method to bet more money
					break;
				
				case 'x':
					break;
				
				default:
					System.out.println("Unknown Input!");
			}
			
			if(initialMenuCalls < 2) 
			{
				initialMenu();
				initialMenuCalls++;
			}
			userInput = input.next().toLowerCase();
			userChoice = userInput.charAt(0);
		}
		input.close();
	}

	public static void initialMenu()
	{
		System.out.println("Please select an option:");
		System.out.println("S) Shuffle (MUST BE DONE SECOND)");
		System.out.println("D) Deal");
		System.out.println("B) Bet More (MUST BE DONE FIRST)");
		System.out.println("X) Quit/Exit");
	}
	
	public static void playMenu()
	{
		System.out.println("H) Hit");
		System.out.println("S) Stand");
		System.out.println("D) Double Down");
		//System.out.println("T) Split");
	}
}
