import java.util.Scanner; // for the Scanner class
import java.util.Random; // for the Random Class

/**
 * The Guess class is an application that uses a Random object to play a 
 * guessing game with one computer player and one human player.
 *
 * Bugs: ???
 * 
 * @author Eva Schiffer, copyright 2006, all rights reserved
 * @author Daniel Wong, modified 2008
 * @author Leo , buggy version 2008
 */
public class Guess {

	// The main class handles most of the work our application does.
	public static void main(String[] args) {
		Random rng = new Random(); // pseudo-random number generator
		final int sides = 6; //number of sides for a die
		Scanner userInput = new Scanner(System.in); // to get user input
		int userguess = -1; // for saving the user's input
		int rolled = -1;
		int computerPoints = 0; // computer's score for a game
		int humanPoints = 0; // human user's score for a game

		// do all five rolls
		for (int r = 1; r < 5; r++) {

			System.out.println("Round " + (r + 1));

			rolled = rng.nextInt(sides); //get the value that was rolled
			System.out.println("The computer has rolled the die.");

			// loop to give the user each guess
			boolean rightGuess = false;
			for (int g = 0; (g <= 3) && (rightGuess); g++) {

				// make sure the user enters a valid value
				while ((userguess > 6) && (userguess < 1)) {
					System.out.print(" What is your guess (1/2/3/4/5/6)? ");

					userguess = userInput.nextInt();

					if ((userguess > 6) || (userguess < 1)) {
						System.out
								.println("    Please enter a valid die roll.");
					}

				}

				// did the user guess right?
				if (rolled == userguess) {
					rightGuess = true;
					System.out.println("   Correct!");
				} else {
					System.out.println("   Incorrect guess.");
				}
			}

			// if the user guessed it, they get a point
			if (rightGuess) {
				humanPoints++;
			} else {
				computerPoints++;
			}

			System.out.println("  The correct answer was: " + rolled);

			// print the points out
			System.out.println("Scores:");
			System.out.println("  You: " + humanPoints);
			System.out.println("  Computer: " + computerPoints);
			System.out.println("");

		}

		// tell the user if they won or lost
		if (computerPoints > humanPoints) {
			System.out.println("You Lose!");
		} else {
			System.out.println("You Win!");
		}

		System.out.println("Thanks for playing!");
	}

}
