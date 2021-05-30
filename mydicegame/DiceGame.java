// Bardia Parmoun
// 101143006

package mydicegame;

import java.util.Scanner;

/**
 * The class that handles the dice game
 * @author Bardia Parmoun - 101143006
 */
public class DiceGame {
	/**
	 * Keeps track of the die object that will be rolled
	 */
    private Die die;

	/**
	 * Keeps track of the number of sides of each die
	 */
    private int numberOfSides;
	
	/**
	 * Keeps track of the number of dice
	 */
    private int numberOfDice;
	
	/**
	 * The default constructor for the dicegame
	 */
	public DiceGame (){
		this(2,6);
	}
	
	/**
	 * The constructor for the dicegame with specified values
	 * @param numDice the number of the dice
	 * @param numSides the number of sides of each die
	 */
	public DiceGame (int numDice, int numSides){
		this.numberOfDice = numDice;
		this.numberOfSides = numSides;
		this.die = new Die(numSides);
	}
	
	/**
	 * The function that handles the actual game
	 */
	public void play(){
		System.out.println("Welcome to the Game of Dice!");
		System.out.printf("Starting a game with %d %d-sided dice.\n", numberOfDice, numberOfSides);
		
		int computerWallet = 100;
		int playerWallet = 100;
		int pot = 0;
		
        Scanner sc = new Scanner(System.in);
		
		int playerBet = 0;
		int computerBet = 0;

		while (computerWallet > 0 && playerWallet > 0){
			pot = 0;
			playerBet = 0;
			computerBet = 0;

			System.out.println("---------------------------------------");
			System.out.printf("You have $%d\n", playerWallet);
			System.out.printf("The computer has $%d\n", computerWallet);
			System.out.print("Place your bet (-1 to quit playing) >>>");
			
			try {
				playerBet = Integer.parseInt(sc.nextLine());

				if (playerBet == -1) {
					break;
				}

				if (playerBet > playerWallet || playerBet <= 0) {
					System.out.println("You have to bet a positive value, but less than your remaining money!");
				} else {
					playerWallet -= playerBet;
					pot += playerBet;

					if (playerBet > computerWallet) {
						computerBet = computerWallet;
						pot += computerWallet;
						computerWallet = 0;
					} else {
						pot += playerBet;
						computerWallet -= playerBet;
						computerBet = playerBet;
					}
				}

				if (pot > 0) {
					int playerTotal = 0;
					int computerTotal = 0;

					String playerRoll = "";
					String computerRoll = "";

					for (int i = 0; i < numberOfDice; i++) {
						int playerDie = die.roll();
						int computerDie = die.roll();

						playerTotal += playerDie;
						computerTotal += computerDie;

						playerRoll += Integer.toString(playerDie) + " ";
						computerRoll += Integer.toString(computerDie) + " ";
					}

					System.out.printf("%d Dice :: You rolled > { %s}\n", numberOfDice, playerRoll);
					System.out.printf("%d Dice :: Computer rolled > { %s}\n", numberOfDice, computerRoll);

					if (playerTotal > computerTotal) {
						System.out.println("You win this round!");
						playerWallet += pot;
					} else if (computerTotal > playerTotal) {
						System.out.println("The computer wins this round!");
						computerWallet += pot;
					} else {
						computerWallet += computerBet;
						playerWallet += playerBet;
						System.out.println("It's a tie no one wins :(");
					}
				}
			}
			
			catch (NumberFormatException e){
				System.out.println("The bet must be an integer value");
			}
		}
		
		if (playerWallet == 0){
			System.out.println("Oh no, you're out of credit!");
		}
		
		else if (computerWallet == 0){
			System.out.println("Computer ran out of money, you win!!");
		}
		
		System.out.println("Good Bye!");
	} 
	
	/**
	 * The main method for the class to get arguments from the user
	 * @param args the arguments that are entered when the program is ran
	 */
    public static void main(String[] args) {
        if (args.length == 2) {
			try{
				int numSides = Integer.parseInt(args[0]);
				int numDice = Integer.parseInt(args[1]);
				DiceGame game = new DiceGame(numDice, numSides);
				game.play();
			}
			
			catch (NumberFormatException e){
				System.out.println("Invalid argument");
			}
        }
		
		else if (args.length == 0){
			DiceGame game = new DiceGame();
			game.play();
		}
		
		else {
			System.out.println("Invalid argument");
		}
    }
}
