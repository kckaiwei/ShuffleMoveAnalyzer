import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameGui extends JFrame {
	JPanel mainPanel;
	JLabel currentSettingLabel;
	JFrame frame;
	ArrayList<JButton> buttonList;
	boolean somethingWasRemoved;
	int highestSuccesses;
	int successes;
	int buttonChangeColor1;
	int buttonChangeColor2;
	int tempButtonChangeColor1;
	int tempButtonChangeColor2;

	// holds the pokeValue before swap
	int[] holderPokeValue = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	// checks prior to drop
	int[] pokeMatchCheck = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	int[] pokeValue = { 1, 2, 3, 2, 1, 2, 3, 1, 2, 1, 2, 2, 1, 3, 3, 2, 2, 1,
			1, 3, 2, 3, 3, 2, 2, 1, 3, 2, 1, 2, 3, 1, 2, 1, 2, 1 };
	
	int[] compareValues = { 1, 2, 3, 2, 1, 2, 3, 1, 2, 1, 2, 2, 1, 3, 3, 2, 2, 1,
			1, 3, 2, 3, 3, 2, 2, 1, 3, 2, 1, 2, 3, 1, 2, 1, 2, 1 };
	// 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1, 2, 1, 2, 1, 2, 2,
	// 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2
	// 1,2,3,2,1,2,3,1,2,1,2,2,1,3,2,2,3,1, 1,3,2,3,3,1, 2,1,3,2,1,2,
	// 3,1,2,1,2,2
	int[] matchMark = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	int[] placeHolder = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	int[] newHolderValue = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int selectionNumber = 0;

	public void go() {
		somethingWasRemoved = true;
		frame = new JFrame("Pokemon ShuffleMove");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonList = new ArrayList<JButton>();

		GridLayout pokemonGrid = new GridLayout(6, 6);

		pokemonGrid.setVgap(2);
		pokemonGrid.setHgap(2);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		mainPanel = new JPanel(pokemonGrid);
		frame.getContentPane().add(background);
		background.add(BorderLayout.CENTER, mainPanel);

		frame.setSize(800, 800);
		frame.setVisible(true);

		// settings button box
		Box settingBox = new Box(BoxLayout.Y_AXIS);
		JButton set0 = new JButton("Set 0");
		set0.addActionListener(new set0ActionListener());
		settingBox.add(set0);
		JButton set1 = new JButton("Set 1");
		set1.addActionListener(new set1ActionListener());
		settingBox.add(set1);
		JButton set2 = new JButton("Set 2");
		set2.addActionListener(new set2ActionListener());
		settingBox.add(set2);
		JButton set3 = new JButton("Set 3");
		set3.addActionListener(new set3ActionListener());
		settingBox.add(set3);
		JButton set4 = new JButton("Set 4");
		set4.addActionListener(new set4ActionListener());
		settingBox.add(set4);

		background.add(BorderLayout.EAST, settingBox);

		currentSettingLabel = new JLabel("Currently set to: " + selectionNumber);
		background.add(BorderLayout.NORTH, currentSettingLabel);

		JButton shuffle = new JButton("Shuffle!");
		shuffle.addActionListener(new shuffleListener());
		background.add(BorderLayout.SOUTH, shuffle);

		for (int i = 0; i < 36; i++) {
			JButton clicky = new JButton();
			clicky.setText(String.valueOf(pokeValue[i]));
			clicky.addActionListener(new gridActionListener());
			clicky.setBackground(Color.gray);

			buttonList.add(clicky);
			mainPanel.add(clicky);
		}
		frame.setVisible(true);

	}

	// public void setRemovable() {
	// somethingWasRemoved = true;
	// }

	public class set0ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			selectionNumber = 0;
			currentSettingLabel.setText("Currently set to: " + selectionNumber);
		}
	}

	public class set1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			selectionNumber = 1;
			currentSettingLabel.setText("Currently set to: " + selectionNumber);
		}
	}

	public class set2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			selectionNumber = 2;
			currentSettingLabel.setText("Currently set to: " + selectionNumber);
		}
	}

	public class set3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			selectionNumber = 3;
			currentSettingLabel.setText("Currently set to: " + selectionNumber);
		}
	}
	public class set4ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			selectionNumber = 4;
			currentSettingLabel.setText("Currently set to: " + selectionNumber);
		}
	}

	public class gridActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).setText(String.valueOf(selectionNumber));
			pokeValue[buttonList.indexOf((JButton) e.getSource())] = selectionNumber;
		}
	}

	public class shuffleListener implements ActionListener {
		int highestSuccesses = 0;

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < pokeValue.length; i++) {

				// save values prior to swap
				for (int values = 0; values < pokeValue.length; values++) {
					// original value
					holderPokeValue[values] = pokeValue[values];
				}
				// test the swaps
				swapTest(i);

			}
			// displays
			setFinal();

		}
	}

	public void swapTest(int i) {

		for (int number = 0; number < 36; number++) {
			// swaps the two values i and generated value
			if (i != number) {
				int holder = pokeValue[number];
				pokeValue[number] = pokeValue[i];
				pokeValue[i] = holder;
				tempButtonChangeColor1 = i;
				tempButtonChangeColor2 = number;

				// remember changed values
				for (int values = 0; values < pokeValue.length; values++) {
					newHolderValue[values] = pokeValue[values];
				}
				
				for (int comparisonNumber = 0; comparisonNumber < newHolderValue.length; comparisonNumber++){
					compareValues[comparisonNumber] = newHolderValue[comparisonNumber];
				}
				// resets value for next run
				holder = pokeValue[number];
				pokeValue[number] = pokeValue[i];
				pokeValue[i] = holder;
				// drop and check for best value
				somethingWasRemoved = true;
				dropAndRemove();
				checkValue();

			}
		}
	}

	// checks value of match
	public void checkValue() {
		// if highest, save swap positions
		if (successes > highestSuccesses) {
			buttonChangeColor1 = tempButtonChangeColor1;
			buttonChangeColor2 = tempButtonChangeColor2;
			// copies over
			for (int i = 0; i < placeHolder.length; i++) {
				placeHolder[i] = newHolderValue[i];
			}
			highestSuccesses = successes;
		}
	}

	public void dropAndRemove() {
		successes = 0;
		// loop to keep dropping and removing
		// removal of blocks and cloning of array
		for (int values = 0; values < compareValues.length; values++) {
			pokeMatchCheck[values] = compareValues[values];
		}
		while (somethingWasRemoved) {
			somethingWasRemoved = false;

			// Mark for removal
			// check rows
			for (int i = 0; i < 6; i++) {
				// check columns
				for (int j = 0; j < 6; j++) {
					if (j < 4) {
						if (pokeMatchCheck[i + j] != 0) {
							if (pokeMatchCheck[i + j] == pokeMatchCheck[i + j + 1]
									&& pokeMatchCheck[i + j] == pokeMatchCheck[i + j + 2]) {
								matchMark[i + j] = 1;
								matchMark[i + j + 1] = 1;
								matchMark[i + j + 2] = 1;
								// this.setRemovable();
								somethingWasRemoved = true;
								if (j < 3) {
									if (pokeMatchCheck[i + j] == pokeMatchCheck[i + j + 3]) {
										matchMark[i + j + 3] = 1;
										if (j < 2) {
											if (pokeMatchCheck[i + j] == pokeMatchCheck[i
													+ j + 4]) {
												matchMark[i + j + 4] = 1;
												if (j < 1) {
													if (pokeMatchCheck[i + j] == pokeMatchCheck[i
															+ j + 5]) {
														matchMark[i + j + 5] = 1;
													}
												}
											}
										}
									}
								}
							}
						}
					}

				}
				for (int k = 0; k < 6; k++) {
					if (k < 4) {
						if (pokeMatchCheck[i + (k * 6)] != 0) {
							if ((pokeMatchCheck[i + (k * 6)] == pokeMatchCheck[i
									+ ((k + 1) * 6)])
									&& (pokeMatchCheck[i + (k * 6)] == pokeMatchCheck[i
											+ ((k + 2) * 6)])) {
								matchMark[i + (k * 6)] = 1;
								matchMark[i + ((k + 1) * 6)] = 1;
								matchMark[i + ((k + 2) * 6)] = 1;
								// this.setRemovable();
								somethingWasRemoved = true;
								if (k < 3) {
									if (pokeMatchCheck[i + (k * 6)] == pokeMatchCheck[i
											+ ((k + 3) * 6)]) {
										matchMark[i + ((k + 3) * 6)] = 1;
										if (k < 2) {
											if (pokeMatchCheck[i + (k * 6)] == pokeMatchCheck[i
													+ ((k + 4) * 6)]) {
												matchMark[i + ((k + 4) * 6)] = 1;
												if (k < 1) {
													if (pokeMatchCheck[i + (k * 6)] == pokeMatchCheck[i
															+ ((k + 5) * 6)]) {
														matchMark[i
																+ ((k + 5) * 6)] = 1;
													}
												}

											}
										}
									}
								}
							}
						}

					}
				}

			}

			// remove marked blocks
			for (int i = 0; i < 36; i++) {
				if (matchMark[i] == 1) {
					pokeMatchCheck[i] = 0;
					successes++;
					matchMark[i] = 0;
				}
			}

			// dropping of blocks
			for (int i = 35; i > 5; i--) {
				if (pokeMatchCheck[i] == 0) {
					pokeMatchCheck[i] = pokeMatchCheck[i - 6];
					pokeMatchCheck[i - 6] = 0;
				}
			}

			// for (int i = 0; i < 36; i++) {
			// JButton clicky = new JButton();
			// clicky.setText(String.valueOf(pokeValue[i]));
			//
			// buttonList.add(clicky);
			// }
			System.out.println(successes);
			for (int i = 0; i < 36; i++) {

				System.out.print(pokeValue[i]);
			}
		}
	}

	// redraw buttons
	public void setFinal() {
		int buttonCount = -1;
		for (JButton B1 : buttonList) {
			buttonCount++;
			B1.setText(String.valueOf(placeHolder[buttonCount]));
			B1.setBackground(Color.gray);
			if (buttonCount == buttonChangeColor1
					|| buttonCount == buttonChangeColor2) {
				B1.setBackground(Color.RED);
			}
		}
		repaint();
		System.out.println(tempButtonChangeColor1);
		System.out.println(tempButtonChangeColor2);
		for (int i = 0; i < pokeValue.length; i++){
			pokeValue[i] = placeHolder[i];
		}

	}
}
