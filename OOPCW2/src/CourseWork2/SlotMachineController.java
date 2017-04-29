package CourseWork2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SlotMachineController {

	// admin set-able values
	// loaded with specified default values
	static int initialCredits = loadDefaultValues()[0];
	static int maxBetCredits = loadDefaultValues()[1];

	// normal user's profile values
	private int credits = initialCredits;
	int noOfGames, wins, losses, netCredits;
	double netCreditsPerGame;
	boolean isAdditionalChance;

	// credits bet on a game
	private int bettingCredits = 0;

	// reels spinning status
	boolean isSpinning = false;

	// game over status
	// true denotes can't play further
	boolean gameOver = false;

	// bet max pressed status
	// resets after each spin / each 'reset'
	boolean isBetMaxPressed = false;

	// this will be displayed in status bar
	String status = "Welcome to Slot Machine!";

	// instantiate 3 reels
	Reel reel1 = new Reel();
	Reel reel2 = new Reel();
	Reel reel3 = new Reel();

	// finally displayed symbols of each reel
	Symbol reel1Symbol, reel2Symbol, reel3Symbol;

	// getters & setters ----------------------------------

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getBettingCredits() {
		return bettingCredits;
	}

	public void setBettingCredits(int bettingCredits) {
		this.bettingCredits = bettingCredits;
	}

	// ----------------------------------------------------

	/**
	 * increases total credits by one
	 */
	public void addCoin() {
		if (!(credits == 0)) {
			credits++;
		}
	}

	/**
	 * adds one credit to the betting area
	 */
	public void betOne() {
		if (credits > 0) {
			// deduct from available credits
			credits--;

			// add to betting credits
			bettingCredits++;
		}
	}

	/**
	 * adds max bet-able credits to the betting area
	 */
	public void betMax() {
		if (!isBetMaxPressed) {
			// bet max has not been pressed (after last spin)
			// bet max is allowed
			if (credits > maxBetCredits - 1) {
				// deduct from available credits
				credits -= maxBetCredits;

				// add to betting credits
				bettingCredits += maxBetCredits;
				
				// button has been pressed
				isBetMaxPressed = true;
			}
		}
		
		
	}

	/**
	 * refunds the last bet
	 */
	public void reset() {
		// refund bet credits
		credits += bettingCredits;

		// prevent resetting more than once
		bettingCredits = 0;
		
		// allow bet max to be able to be pressed
		isBetMaxPressed = false;
	}

	/**
	 * calculates score called after reels stopped spinning
	 */
	public void calculate() {

		if (isAdditionalChance) {
			// on the additional attempt spin

			// change the additional chance status to false
			isAdditionalChance = false;

		}

		// conditions are defined for matching reels
		boolean condition1 = (reel1Symbol.equals(reel2Symbol));
		boolean condition2 = (reel2Symbol.equals(reel3Symbol));
		boolean condition3 = (reel1Symbol.equals(reel3Symbol));

		if (condition1 || condition2 || condition3) {
			// either two reels, or all three reels are equal
			// either another chance, or win

			if (!(condition1 && condition2 && condition3)) {
				// only two symbols are equal

				// an extra chance to play
				isAdditionalChance = true;

				// decrease number of played games by one
				noOfGames--;

				status = "You have another chance to Play";
			} else {

				// three symbols are equal

				// game won
				wins++;

				// award credits
				int wonCredits = bettingCredits * reel1Symbol.getValue();
				credits += wonCredits;

				// update net credits
				netCredits += (wonCredits - bettingCredits);

				// update status
				status = "You won " + wonCredits + " Credits !";

				// reset betting credits
				bettingCredits = 0;
			}

		} else {
			// each symbol is different

			// game lost
			losses++;

			// update net credits
			// credits are lost
			// negative value
			netCredits -= bettingCredits;

			// reset betting credits
			bettingCredits = 0;

			// update status
			status = "You lost !";

			if (credits == 0) {
				// 0 credits remaining after the current bet
				// game over
				gameOver = true;

				// update status
				status = "Game Over!";
			}

		}
	}

	/**
	 * loads default values (initial credits & max bet credits) from file.
	 * updates variables initialCredits and maxBetCredits
	 *
	 * @return : int array containing loaded values [0] - initialCredits [1] -
	 *         maxBetCredits
	 */
	public static int[] loadDefaultValues() {
		// creating file object
		File txtFile = new File("defaultValues.txt");

		Scanner sc1;

		// cariables to store loaded values
		int loadedInitialCredits;
		int loadedMaxBetCredits;

		try {
			sc1 = new Scanner(txtFile);

			// overwrite static variables with read values
			loadedInitialCredits = sc1.nextInt();
			loadedMaxBetCredits = sc1.nextInt();

		} catch (FileNotFoundException e) {
			// error message
			JOptionPane.showMessageDialog(new JFrame(),
					"A file with customized default values can not be found. \nSpecified default values are loaded",
					"File not found", JOptionPane.ERROR_MESSAGE);

			// overwrite static variables with specified default values
			loadedInitialCredits = 10;
			loadedMaxBetCredits = 3;
		}

		// returning array
		int[] returnArray = { loadedInitialCredits, loadedMaxBetCredits };
		return returnArray;

	}

}
