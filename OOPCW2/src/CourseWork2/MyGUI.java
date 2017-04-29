/**
 *
 * @author 2014016
 */
package CourseWork2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.beancontext.BeanContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.scene.chart.PieChart;

public class MyGUI extends JFrame {

	SlotMachineController machine = new SlotMachineController();
	String adminUsername = "admin";
	String adminPassword = "admin";

	// status of all the reels spinning
	boolean isSpinning = false;

	public MyGUI(String title) {
		// Title of the window
		super(title);

	}

	public static void main(String[] args) {
		// creating the main GUI
		MyGUI my = new MyGUI("Slot Machine");
		my.createSlotMachineGUI();

	}

	/**
	 * creates the main GUI of the Slot Machine
	 */
	public void createSlotMachineGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 800);

		// create panels

		// outer containing panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1, 50, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panel);

		// panel 1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 4));

		panel1.add(new JLabel(""));

		JPanel panel1_2 = new JPanel();
		panel1_2.setLayout(new GridLayout(2, 1));
		JLabel lblBetAreaText = new JLabel("BETTING");
		lblBetAreaText.setHorizontalAlignment(SwingConstants.CENTER);
		panel1_2.add(lblBetAreaText);
		JLabel lblBetArea = new JLabel("BET AREA");
		lblBetArea.setFont(new Font("Arial", Font.PLAIN, 50));
		lblBetArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblBetArea.setBackground(Color.DARK_GRAY);
		lblBetArea.setForeground(Color.white);
		lblBetArea.setOpaque(true);

		panel1_2.add(lblBetArea);
		panel1.add(panel1_2);

		JPanel panel1_3 = new JPanel();
		panel1_3.setLayout(new GridLayout(2, 1));
		JLabel lblCreditAreaText = new JLabel("CREDITS");
		lblCreditAreaText.setHorizontalAlignment(SwingConstants.CENTER);
		panel1_3.add(lblCreditAreaText);
		JLabel lblCreditArea = new JLabel("CREDIT AREA");
		lblCreditArea.setFont(new Font("Arial", Font.PLAIN, 50));
		lblCreditArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditArea.setBackground(Color.BLACK);
		lblCreditArea.setForeground(Color.orange);
		lblCreditArea.setOpaque(true);
		panel1_3.add(lblCreditArea);
		panel1.add(panel1_3);

		panel1.add(new JLabel(""));
		panel.add(panel1);

		// panel 2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 5, 20, 20));

		panel2.add(new JLabel(""));

		// set initial images for reels

		// REEL 1
		// ---------------------------------------------------------------
		JLabel lblReel1 = new JLabel();
		lblReel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReel1.setBackground(Color.WHITE);
		lblReel1.setOpaque(true);

		// getting a random image
		machine.reel1.loadReel();
		String reel1Image = machine.reel1.returnSymbol.getImage();

		// read the picture as a BufferedImage
		BufferedImage img1 = null;
		try {
			img1 = ImageIO.read(new File(reel1Image));
		} catch (IOException e) {
			// error message
			JOptionPane.showMessageDialog(new JFrame(), "Loading image for Reel 1 failed", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		// resize the BufferedImage
		Image dimg1 = img1.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);

		// assign to reel label
		ImageIcon imageIcon1 = new ImageIcon(dimg1);
		lblReel1.setIcon(imageIcon1);
		// panel2.add(lblReel1);
		panel2.add(lblReel1);

		// REEL 2
		// ---------------------------------------------------------------
		JLabel lblReel2 = new JLabel();
		lblReel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblReel2.setBackground(Color.WHITE);
		lblReel2.setOpaque(true);

		// getting a random image
		machine.reel2.loadReel();
		String reel2Image = machine.reel2.returnSymbol.getImage();

		// read the picture as a BufferedImage
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(new File(reel2Image));
		} catch (IOException e) {
			// error message
			JOptionPane.showMessageDialog(new JFrame(), "Loading image for Reel 2 failed", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		// resize the BufferedImage
		Image dimg2 = img2.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);

		// assign to reel label
		ImageIcon imageIcon2 = new ImageIcon(dimg2);
		lblReel2.setIcon(imageIcon2);
		// panel2.add(lblReel2);
		panel2.add(lblReel2);

		// REEL 3
		// ---------------------------------------------------------------
		JLabel lblReel3 = new JLabel();
		lblReel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblReel3.setBackground(Color.WHITE);
		lblReel3.setOpaque(true);

		// getting a random image
		machine.reel3.loadReel();
		String reel3Image = machine.reel3.returnSymbol.getImage();

		// read the picture as a BufferedImage
		BufferedImage img3 = null;
		try {
			img3 = ImageIO.read(new File(reel3Image));
		} catch (IOException e) {
			// error message
			JOptionPane.showMessageDialog(new JFrame(), "Loading image for Reel 3 failed", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		// resize the BufferedImage
		Image dimg3 = img3.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);

		// assign to reel label
		ImageIcon imageIcon3 = new ImageIcon(dimg3);
		lblReel3.setIcon(imageIcon3);
		// panel2.add(lblReel3);
		panel2.add(lblReel3);

		panel2.add(new JLabel(""));

		// -----------------------------------------------------------------------

		// panel2.add(new JLabel(""));
		panel.add(panel2);

		// panel 3
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 3, 10, 10));

		JPanel panel3_1 = new JPanel();
		panel3_1.setLayout(new GridLayout(1, 2, 10, 10));
		JButton btnBetOne = new JButton("BET ONE");
		panel3_1.add(btnBetOne);
		JButton btnBetMax = new JButton("BET MAX");
		panel3_1.add(btnBetMax);
		panel3.add(panel3_1);

		JPanel panel3_2 = new JPanel();
		panel3_2.setLayout(new GridLayout(1, 1, 10, 10));
		JButton btnSpin = new JButton("SPIN");
		panel3_2.add(btnSpin);
		panel3.add(panel3_2);

		JPanel panel3_3 = new JPanel();
		panel3_3.setLayout(new GridLayout(1, 2, 10, 10));
		JButton btnAddCoin = new JButton("ADD COIN");
		panel3_3.add(btnAddCoin);
		JButton btnReset = new JButton("RESET");
		panel3_3.add(btnReset);
		panel3.add(panel3_3);

		panel.add(panel3);

		// panel 4
		JPanel panel4 = new JPanel();
		JLabel lblStatus = new JLabel("Welcome to Slot Machine!");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(lblStatus);

		panel.add(panel4);

		// panel 5
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1, 4, 10, 10));

		panel5.add(new JLabel(""));
		JPanel panel5_2 = new JPanel();
		panel5_2.setLayout(new GridLayout(2, 1, 10, 10));
		JButton btnStats = new JButton("Statistics");
		panel5_2.add(btnStats);
		JButton btnAdminPanel = new JButton("Admin Panel");
		panel5_2.add(btnAdminPanel);
		panel5.add(panel5_2);
		panel5.add(new JLabel(""));
		panel.add(panel5);

		// assigning initial values for labels

		// initial loaded credits
		lblCreditArea.setText(machine.getCredits() + "");
		// initial bet is zero
		lblBetArea.setText(0 + "");

		// label actions --------------------------------------
		/*
		 * clicking one of the reels will stop spinning of all the reels
		 */

		// reel 1 label
		lblReel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// calling label click action
				labelClickAction(btnAddCoin, btnBetMax, btnBetOne, btnReset, lblBetArea, lblCreditArea, lblStatus);

			}

		});

		// reel 2 label
		lblReel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// calling label click action
				labelClickAction(btnAddCoin, btnBetMax, btnBetOne, btnReset, lblBetArea, lblCreditArea, lblStatus);
			}

		});

		// reel 3 label
		lblReel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// calling label click action
				labelClickAction(btnAddCoin, btnBetMax, btnBetOne, btnReset, lblBetArea, lblCreditArea, lblStatus);
			}

		});

		// button actions --------------------------------------

		// spin button
		btnSpin.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				if (!machine.isSpinning) {
					// reels are not spinning
					// spinning is allowed
					if (!machine.gameOver) {
						// game is not over. Can spin

						// additional chance is set to false
						// will be set to true if two reels match later
						machine.isAdditionalChance = false;

						if (machine.getBettingCredits() != 0) {
							// at least one credit is bet. Spinning is allowed

							// start spinning
							machine.isSpinning = true;

							// disable buttons
							btnAddCoin.setEnabled(false);
							btnBetMax.setEnabled(false);
							btnBetOne.setEnabled(false);
							btnReset.setEnabled(false);

							if (machine.isSpinning) {
								// spin all the reels until a reel is clicked
								// create Reel objects and override the run
								// methods

								// reel1
								Reel reel1 = new Reel() {
									// overriding reel 1's run method
									public void run() {
										// calling the reelsSpin method
										reelsSpin(this, lblReel1, 1);

									}
								};

								// reel2
								Reel reel2 = new Reel() {
									// overriding reel 1's run method
									public void run() {
										// calling the reelsSpin method
										reelsSpin(this, lblReel2, 2);

									}
								};

								// reel3
								Reel reel3 = new Reel() {
									// overriding reel 1's run method
									public void run() {
										// calling the reelsSpin method
										reelsSpin(this, lblReel3, 3);

									}
								};

								// starting the three threads
								reel1.start();
								reel2.start();
								reel3.start();
							}

						} else {
							// no credit is on bet. Spinning not allowed
							machine.status = "You have no credits on bet. Please bet and spin";
							lblStatus.setText(machine.status);
						}
					} else {
						// game over. Spinning not allowed
						JOptionPane.showMessageDialog(new JFrame(),
								"You can't play further ! You've reached 0 Credits !", "Game Over",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					// reels are already spinning
					JOptionPane.showMessageDialog(new JFrame(), "Reels are already spinning!", "Can't spin again",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});

		// bet one button
		btnBetOne.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				if (machine.isAdditionalChance) {
					// on an additional attempt
					JOptionPane.showMessageDialog(new JFrame(), "You are having an additional chance!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					machine.betOne();
					lblBetArea.setText(machine.getBettingCredits() + "");
					lblCreditArea.setText(machine.getCredits() + "");
				}
			}
		});

		// bet max button
		btnBetMax.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				if (machine.isAdditionalChance) {
					// on an additional attempt
					JOptionPane.showMessageDialog(new JFrame(), "You are having an additional chance!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					if (machine.isBetMaxPressed) {
						// bet max has been pressed before
						JOptionPane.showMessageDialog(new JFrame(), "You can only press this button once per spin!",
								"Error", JOptionPane.ERROR_MESSAGE);

					} else {

						// can allow bet max
						machine.betMax();
						lblBetArea.setText(machine.getBettingCredits() + "");
						lblCreditArea.setText(machine.getCredits() + "");
					}
				}

			}

		});

		// add coin button
		btnAddCoin.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				if (machine.isAdditionalChance) {
					// on an additional attempt
					JOptionPane.showMessageDialog(new JFrame(), "You are having an additional chance!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					machine.addCoin();
					lblCreditArea.setText(machine.getCredits() + "");
				}
			}
		});

		// reset button
		btnReset.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				if (machine.isAdditionalChance) {
					// on an additional attempt
					JOptionPane.showMessageDialog(new JFrame(), "You are having an additional chance!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					machine.reset();
					lblBetArea.setText(machine.getBettingCredits() + "");
					lblCreditArea.setText(machine.getCredits() + "");
				}

			}
		});

		// adminPanel button
		btnAdminPanel.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				try {
					// creating a new AdminGUI object
					MyGUI loginGUI = new MyGUI("Login");
					loginGUI.createLoginGUI();
				} catch (Exception nonSpecificException_login) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid values / actions detected", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// statistics button
		btnStats.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				// clear status
				lblStatus.setText("");

				try {
					if (machine.noOfGames == 0) {
						// no games are played
						// statistics not available
						JOptionPane.showMessageDialog(new JFrame(),
								"Statistics not available. You haven't played any game.", "Statistics Unavailable",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						machine.netCreditsPerGame = (double) machine.netCredits / (double) machine.noOfGames;
						MyGUI statisticsGUI = new MyGUI("Statistics");
						statisticsGUI.createStatisticsGUI(600, 400, machine.noOfGames, machine.wins, machine.losses,
								machine.netCreditsPerGame);

						// createStatistics().setVisible(true);
					}
				} catch (Exception nonSpecificException_statistics) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid values / actions detected", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		setVisible(true);
	}

	/**
	 * creates the statistics GUI
	 * 
	 * @param width
	 * @param height
	 * @param noOfGames
	 * @param wins
	 * @param losses
	 * @param netCreditsPerGame
	 */
	public void createStatisticsGUI(int width, int height, int noOfGames, int wins, int losses,
			double netCreditsPerGame) {

		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		setSize(width, height);

		// local variables in order to make Save Status possible through method
		int localNoOfGames = noOfGames;
		int localWins = wins;
		int localLosses = losses;
		double localNetCreditsPerGame = netCreditsPerGame;

		// main containing panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 50, 50));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panel);

		// panel1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 3));

		panel1.add(new JLabel(""));

		JLabel lblNetCreditsPerGameText = new JLabel("Net credits per game");
		lblNetCreditsPerGameText.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblNetCreditsPerGameText);

		panel1.add(new JLabel(""));
		panel1.add(new JLabel(""));

		JLabel lblNetCreditsPerGame = new JLabel(netCreditsPerGame + "");
		lblNetCreditsPerGame.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblNetCreditsPerGame);

		JButton btnSaveStatistics = new JButton("Save Statistics");
		panel1.add(new JLabel(""));
		// panel1.add(new JLabel(""));

		JLabel lblWinsText = new JLabel("Wins");
		lblWinsText.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblWinsText);

		JLabel lblGamesText = new JLabel("Games");
		lblGamesText.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblGamesText);

		JLabel lblLossesText = new JLabel("Losses");
		lblLossesText.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblLossesText);

		JLabel lblWins = new JLabel(wins + "");
		lblWins.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblWins);

		JLabel lblGames = new JLabel(noOfGames + "");
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblGames);

		JLabel lblLosses = new JLabel(losses + "");
		lblLosses.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblLosses);

		panel.add(panel1);

		// panel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 20, 20));
		// panel2.add(new JLabel(""));

		// wins = 1;
		// noOfGames = 1;

		JProgressBar progressBar = new JProgressBar();
		double winValue = ((double) wins / noOfGames) * 100;

		progressBar.setValue((int) winValue);
		// progressBar.setValue(60);
		progressBar.setBackground(new Color(26, 35, 43));
		progressBar.setForeground(new Color(110, 185, 93));
		progressBar.setBorderPainted(false);

		panel2.add(progressBar);

		JPanel panel2_2 = new JPanel();
		panel2_2.setLayout(new GridLayout(1, 3, 20, 20));
		JLabel lblWinsGraphText = new JLabel("WINS %");
		lblWinsGraphText.setForeground(new Color(110, 185, 93));
		panel2_2.add(lblWinsGraphText);
		panel2_2.add(btnSaveStatistics);

		JLabel lblLossesGraphText = new JLabel("LOSSES %");
		lblLossesGraphText.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2_2.add(lblLossesGraphText);
		panel2.add(panel2_2);

		panel.add(panel2);

		// button actions ------------------

		// save statistics
		btnSaveStatistics.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {
				try {
					saveStatistics(localNoOfGames, localWins, localLosses, localNetCreditsPerGame);
				} catch (Exception nonSpecificException_saveStatistics) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid values / actions detected", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		setVisible(true);

	}

	/**
	 * creates the Login GUI
	 */
	public void createLoginGUI() {
		// Title of the window
		// super("Login");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(500, 170);

		// create panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// add components
		add(panel);
		panel.add(new JLabel("Username"));
		JTextField txtUsername = new JTextField(10);
		panel.add(txtUsername);
		panel.add(new JLabel("Password"));
		JPasswordField txtPassword = new JPasswordField(10);
		panel.add(txtPassword);
		JLabel lblInfo = new JLabel("Username : " + adminUsername + "  Password : " + adminPassword);
		lblInfo.setForeground(Color.LIGHT_GRAY);
		panel.add(lblInfo);

		// action button
		JButton btnLogin = new JButton("Login");
		panel.add(btnLogin);

		// login
		btnLogin.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {
				try {
					String userName = adminUsername;
					String password = adminPassword;
					if (txtUsername.getText().equals(userName) && txtPassword.getText().equals(password)) {
						// creating a new AdminGUI object
						MyGUI adminGUI = new MyGUI("Admin Panel");
						adminGUI.createAdminGUI();
						setVisible(false);
					} else {
						// error message
						JOptionPane.showMessageDialog(new JFrame(), "Invalid Username and/or Password",
								"Access Denied!", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception nonSpecificException_login) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid values / actions detected", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		setVisible(true);
	}

	/**
	 * create the AdminGUI (Admin Panel)
	 */
	public void createAdminGUI() {
		// super("Admin");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		setSize(500, 400);

		// main containing panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 3, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panel);

		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		JLabel lblInitialCreditsText = new JLabel("Initial Credits");
		lblInitialCreditsText.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblInitialCreditsText);

		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		JTextField txtInitialCredits = new JTextField(SlotMachineController.initialCredits + "");
		panel.add(txtInitialCredits);
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		JLabel lblMaximumBetCreditsText = new JLabel("Maximum Bet Credits");
		lblMaximumBetCreditsText.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMaximumBetCreditsText);

		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		JTextField txtMaxBetCredits = new JTextField(SlotMachineController.maxBetCredits + "");
		panel.add(txtMaxBetCredits);
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		JButton btnUpdate = new JButton("UPDATE");
		panel.add(btnUpdate);
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		// button actions ------------------

		// update
		btnUpdate.addActionListener(new ActionListener() {
			// overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {

				try {
					// validations for fields

					// initial credits
					if (Integer.parseInt(txtInitialCredits.getText()) <= 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Initial Credits should be more than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ((Integer.parseInt(txtMaxBetCredits.getText()) < 0) || (Integer
							.parseInt(txtMaxBetCredits.getText()) > (Integer.parseInt(txtInitialCredits.getText())))) {
						// max bet credits
						JOptionPane.showMessageDialog(new JFrame(),
								"Maximum Bet Credits should be more than 0 and Less than or equal to Initial Credits",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						// static variables are overwritten
						SlotMachineController.initialCredits = Integer.parseInt(txtInitialCredits.getText());
						SlotMachineController.maxBetCredits = Integer.parseInt(txtMaxBetCredits.getText());

						// storing file
						updateDefaultValues();

						// close
						System.exit(0);

					}
				} catch (NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(new JFrame(), "Both the fields should be integers", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception nonSpecificException_Update) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid values / actions detected", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		setVisible(true);

	}

	// other methods

	/**
	 * stores statistics in a file
	 */
	public void saveStatistics(int noOfGames, int wins, int losses, double netCreditsPerGame) {
		// getting current date
		Date currentDate = new Date();

		// declaring the file name as the current date
		String fileName = currentDate.getDate() + "-" + (currentDate.getMonth() + 1) + "-"
				+ (currentDate.getYear() + 1900) + "_" + currentDate.getHours() + "-" + currentDate.getMinutes() + "-"
				+ currentDate.getSeconds();

		// creating file object
		File file = new File(fileName + ".txt");
		PrintWriter pw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
			pw = new PrintWriter(fw, true);

			// pw.println

			// write statistics
			// format : "noOfGames wins losses netCreditsPerGame"
			pw.println(noOfGames + "\t" + wins + "\t" + losses + "\t" + netCreditsPerGame);

			// success message
			JOptionPane.showMessageDialog(new JFrame(), "File is successfully saved !", "Successful",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// error message
			JOptionPane.showMessageDialog(new JFrame(), "File saving failed", "Error", JOptionPane.ERROR_MESSAGE);

		} finally {

			pw.close();

			try {
				fw.close();
			} catch (Exception e) {
				// error message
				JOptionPane.showMessageDialog(new JFrame(), "File saving failed", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/**
	 * updates admin modifyable values to the file
	 */
	public void updateDefaultValues() {

		// creating file object to overwrite the existing "admin.txt"
		File file = new File("defaultValues.txt");
		PrintWriter pw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
			pw = new PrintWriter(fw, true);

			// pw.println

			// write
			pw.println(SlotMachineController.initialCredits);
			pw.println(SlotMachineController.maxBetCredits);

			// message box
			JOptionPane.showMessageDialog(new JFrame(),
					"Successfully updated ! Restart the program to run with changes", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// error message
			JOptionPane.showMessageDialog(new JFrame(), "Updating failed", "Error", JOptionPane.ERROR_MESSAGE);

		} finally {

			pw.close();

			try {
				fw.close();
			} catch (Exception e) {
				// error message
				JOptionPane.showMessageDialog(new JFrame(), "Updating failed", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	/**
	 * executes when any label is clicked
	 * 
	 * @param btnAddCoin
	 * @param btnBetMax
	 * @param btnBetOne
	 * @param btnReset
	 * @param lblBetArea
	 * @param lblCreditArea
	 * @param lblStatus
	 */
	public void labelClickAction(JButton btnAddCoin, JButton btnBetMax, JButton btnBetOne, JButton btnReset,
			JLabel lblBetArea, JLabel lblCreditArea, JLabel lblStatus) {
		if (machine.isSpinning) {
			// reels are currently spinning

			// stop reels
			machine.isSpinning = false;

			// another game is played
			machine.noOfGames++;

			// enable buttons
			btnAddCoin.setEnabled(true);
			btnBetMax.setEnabled(true);
			btnBetOne.setEnabled(true);
			btnReset.setEnabled(true);

			// allow bet max to be pressed for the next time
			machine.isBetMaxPressed = false;

			// calculate credit awarding
			machine.calculate();

			// update labels
			lblBetArea.setText(machine.getBettingCredits() + "");
			lblCreditArea.setText(machine.getCredits() + "");
			lblStatus.setText(machine.status);

			if (machine.gameOver) {
				// credits have reached 0
				// game over
				// set status color to red
				lblStatus.setForeground(Color.RED);

				// disable buttons
				btnAddCoin.setEnabled(false);
				btnBetMax.setEnabled(false);
				btnBetOne.setEnabled(false);
				btnReset.setEnabled(false);

				// show error
				JOptionPane.showMessageDialog(new JFrame(), "You can't play further ! You've reached 0 Credits !",
						"Game Over", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * executed for repeated spin of reel
	 * 
	 * @param reel
	 *            : denotes the declared Reel object in button action method
	 * @param lblReel
	 *            : JLabel that holds the image of current reel
	 * @param n
	 *            : current reel number (1,2 or 3)
	 */
	public void reelsSpin(Reel reel, JLabel lblReel, int n) {

		// storing the returned random array
		Symbol[] reelArray = reel.spin();

		while (machine.isSpinning) {
			// spin button have been pressed
			// traverse through array
			for (int i = 0; i < reelArray.length; i++) {
				if (machine.isSpinning) {
					final int count = i;

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {

							// read the picture
							// as a
							// BufferedImage
							BufferedImage imgReel = null;
							try {
								// assign symbol
								// for
								// calculation

								switch (n) {
								case 1:
									machine.reel1Symbol = reelArray[count];
									imgReel = ImageIO.read(new File(machine.reel1Symbol.getImage()));
									break;
								case 2:
									machine.reel2Symbol = reelArray[count];
									imgReel = ImageIO.read(new File(machine.reel2Symbol.getImage()));
									break;
								case 3:
									machine.reel3Symbol = reelArray[count];
									imgReel = ImageIO.read(new File(machine.reel3Symbol.getImage()));
									break;
								}

								// resize the
								// BufferedImage
								Image scaledImgReel = imgReel.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);

								// assign to
								// reel
								// label
								ImageIcon imageIconReel = new ImageIcon(scaledImgReel);
								lblReel.setIcon(imageIconReel);

							} catch (IOException e) {
								// error message
								JOptionPane.showMessageDialog(new JFrame(), "Loading image for reel " + n + " failed",
										"Error", JOptionPane.ERROR_MESSAGE);
							}

						}
					});

					try {
						Reel.sleep(100);
					} catch (InterruptedException e) {
						// error message
						JOptionPane.showMessageDialog(new JFrame(), "Spin of reel" + n + "is interrupted", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

			}

		});
	}

}
