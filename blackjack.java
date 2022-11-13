//Made by Benjamin Weinstein    Denise Gonzalez-Cruz   Ashley Caruso   Jonathan Davis
//Feel free to copy and paste into your ide and try it out!
import java.util.Scanner;
import java.util.Random;
public class blackjack {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		Random rand = new Random();
		int max = 10;
		int totalY = 0;
		int totalD = 0;
		int card1 = rand.nextInt(max) + 2;
		int card2 = rand.nextInt(max) + 2;
		int playerOutcome = 2;
		int deal1 = rand.nextInt(max) + 2;
		int deal2 = rand.nextInt(max) + 2;
		int dealerOutcome = 2;
		int hitOrStand = 0;
		/////////////////////////////////////////
		System.out.println("Welcome to Blackjack");
		System.out.println();
		System.out.println("YOU:");
		if (card1 == 11 && card2 == 11) {
			System.out.println("A  A");
		}
		else if (card1 == 11) {
			System.out.println("A  " + card2);
		}
		else if (card2 == 11) {
			System.out.println(card1 + "  A");
		}
		else {
		System.out.println(card1 + "  " + card2);
		}
		totalY = card1 + card2;
		System.out.println("TOTAL: " + totalY);
		System.out.println();
		//////////////////////////////////////
		System.out.println("DEALER:");
		if (deal2 == 11) {
			System.out.println("?  A");
		}
		else {
			System.out.println("?  " + deal2);
		}
		System.out.println("Dealer must draw to 16 and stand on 17.");
		//////////////////////////////////////
		System.out.println();
	 	if (totalY == 21) {
			System.out.println("YOU GOT BLACKJACK!!!");
			playerOutcome = 3;
		}
		else  {
			System.out.println("YOUR TURN");
			if (card1 == 11 && card2 == 11) {
				card1 = 1;
				totalY = totalY - 10;
				System.out.println("You have two aces. TOTAL: " + totalY);
			}
			for (int i = 0; i<10; i++) {
				System.out.print("Press 1 to HIT, 2 to STAND:   ");
				hitOrStand = input.nextInt();
				if (hitOrStand == 1) {
					System.out.println("HIT");
					int additionalCard = rand.nextInt(max) + 1;
					System.out.println(additionalCard);
					totalY = totalY + additionalCard;
					System.out.println ("TOTAL: " + totalY);
				if (totalY > 21) {
					if (card1 == 11) {
						card1 = 1;
						totalY = totalY - 10;
						System.out.println("Ace changes total to: " + totalY);
					}
					else if (card2 == 11) {
						card2 = 1;
						totalY = totalY - 10;
						System.out.println("Ace changes total to: " + totalY);
					}
					else if (additionalCard == 11) {
						additionalCard = 1;
						totalY = totalY - 10;
						System.out.println("Ace changes total to: " + totalY);
					}
					else {
					System.out.println("BUST!");
					playerOutcome = 1;
					break;
				}
				}
				else if (totalY == 21){
					break;
				}
			}
				else if (hitOrStand == 2) {
					System.out.println("STAND");
					break;
				}
				else {
				System.out.println("INVALID INPUT.");	
			}
			
			}
			}
	 	System.out.println();
	 	System.out.println("DEALER'S TURN");
	 	if (deal1 == 11 && deal2 == 11) {
			System.out.println("A  A");
		}
		else if (deal1 == 11) {
			System.out.println("A  " + deal2);
		}
		else if (card2 == 11) {
			System.out.println(deal1 + "  A");
		}
		else {
		System.out.println(deal1 + "  " + deal2);
		}
		totalD = deal1 + deal2;
		System.out.println("TOTAL: " + totalD);
	 	///////////////////////////////////////////
		if (totalD == 21) {
			System.out.println("Dealer has BLACKJACK.");
			dealerOutcome = 3;
		}
		else {
			if (deal1 == 11 && deal2 == 11) {
				deal1 = 1;
				totalD = totalD - 10;
				System.out.println("Dealer has two aces. TOTAL: " + totalD);
			}
			for (int i = 0; i<10; i++) {
				if (totalD <= 16) {
					System.out.println("HIT");
					int additionalCard = rand.nextInt(max) + 1;
					System.out.println(additionalCard);
					totalD = totalD + additionalCard;
					System.out.println ("TOTAL: " + totalD);
				if (totalD > 21) {
					if (card1 == 11) {
						card1 = 1;
						totalD = totalD - 10;
						System.out.println("Ace changes total to: " + totalD);
					}
					else if (card2 == 11) {
						card2 = 1;
						totalD = totalD - 10;
						System.out.println("Ace changes total to: " + totalD);
					}
					else if (additionalCard == 11) {
						additionalCard = 1;
						totalD = totalD - 10;
						System.out.println("Ace changes total to: " + totalD);
					}
					else {
					System.out.println("BUST!");
					dealerOutcome = 1;
					break;
				}
				}
				else if (totalD == 21){
					break;
				}
			}
				else if (totalD >= 17) {
					System.out.println("STAND");
					break;
				}
				else {
				System.out.println("INVALID INPUT.");	
			}
			
			}
		}
		if (playerOutcome == dealerOutcome && totalY == totalD) {
			System.out.println("PUSH");
		}
		else if (playerOutcome == 1 && dealerOutcome == 1) {
			System.out.println("PUSH");
		}
		else if (playerOutcome < dealerOutcome && totalY >= totalD) {
			System.out.println("YOU LOSE...");
		}
		else if (playerOutcome > dealerOutcome && totalY <= totalD) {
			System.out.println("YOU WON!!!");
		}
		else if (playerOutcome == dealerOutcome && totalY < totalD) {
			System.out.println("YOU LOSE...");
		}
		else if (playerOutcome == dealerOutcome &&  totalY > totalD) {
			System.out.println("YOU WON!!!");
		}
		}//end main	
	}//end class

/*
SAMPLE 1:
Welcome to Blackjack
YOU:
7  10
TOTAL: 17

DEALER:
?  10
Dealer must draw to 16 and stand on 17.

YOUR TURN
Press 1 to HIT, 2 to STAND:   2
STAND

DEALER'S TURN
4  10
TOTAL: 14
HIT
10
TOTAL: 24
BUST!
YOU WON!!!

SAMPLE 2:
Welcome to Blackjack
YOU:
7  10
TOTAL: 17

DEALER:
?  10
Dealer must draw to 16 and stand on 17.

YOUR TURN
Press 1 to HIT, 2 to STAND:   1
HIT
5
TOTAL: 22
BUST!

DEALER'S TURN
8  9
TOTAL: 17
STAND
YOU LOSE...

SAMPLE 3:
Welcome to Blackjack
YOU: 10  A
TOTAL: 21

DEALER:
?  A
YOU GOT BLACKJACK!!!

DEALER'S TURN
10  A
Dealer has BLACKJACK.
PUSH*/