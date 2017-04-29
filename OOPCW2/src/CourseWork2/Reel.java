package CourseWork2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Reel extends Thread {

	// instantiating 6 Symbol objects, representing 6 symbols
	Symbol seven = new Symbol("images/redseven.png", 7);
	Symbol bell = new Symbol("images/bell.png", 6);
	Symbol watermelon = new Symbol("images/watermelon.png", 5);
	Symbol plum = new Symbol("images/plum.png", 4);
	Symbol lemon = new Symbol("images/lemon.png", 3);
	Symbol cherry = new Symbol("images/cherry.png", 2);

	// an array representing a reel, containing all the symbols
	Symbol[] reel = { seven, bell, watermelon, plum, lemon, cherry };

	// this Symbol object will be set after spinning
	public Symbol returnSymbol = null;

	/**
	 * returns the symbol, which is set after spinning
	 * 
	 * @return : returnSymbol
	 */
	public Symbol getReturnSymbol() {
		return this.returnSymbol;
	}

	/**
	 * shuffles the 'reel' array in random order
	 * returns 'reel' array
	 * @return : shuffled reel array
	 */
	public Symbol[] spin() {

		// Random number generator
		Random rgen = new Random();

		for (int i = 0; i < reel.length; i++) {
			int randomPosition = rgen.nextInt(reel.length);
			Symbol temp = reel[i];
			reel[i] = reel[randomPosition];
			reel[randomPosition] = temp;
		}

		return reel;

	}

	/**
	 * loads random image on a reel at beginning
	 */
	public void loadReel() {
		returnSymbol = reel[(int) (Math.random() * (reel.length))];
	}

	/**
	 * shuffles 'reel' array in randomly arranged order
	 */
	public void shuffle() {
		Collections.shuffle(Arrays.asList(reel));
	}

}
