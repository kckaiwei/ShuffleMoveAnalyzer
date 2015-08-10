import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SelectionConfirmation extends JFrame {
	JFrame popupFrame;
	JPanel confirmationPanel;
	JPanel radioButtonPanel;
	ArrayList<JRadioButton> buttons;

	public void go() {
		popupFrame = new JFrame("Icon Selection");

		popupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout radioButtonLayout = new GridLayout(7, 1);
		radioButtonLayout.setHgap(2);
		BorderLayout confirmationLayout = new BorderLayout();

		JPanel confirmationPanel = new JPanel(confirmationLayout);

		radioButtonPanel = new JPanel(radioButtonLayout);
		popupFrame.getContentPane().add(confirmationPanel);
		popupFrame.setSize(600, 300);
		popupFrame.setFocusable(false);
		confirmationPanel.add(BorderLayout.CENTER, radioButtonPanel);

		JLabel confirmationPrompt = new JLabel(
				"Select icon position for pokemon");
		confirmationPanel.add(BorderLayout.NORTH, confirmationPrompt);

		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton set1 = new JRadioButton("Set as icon 1");
		buttonGroup.add(set1);
		JRadioButton set2 = new JRadioButton("Set as icon 2");
		buttonGroup.add(set2);
		JRadioButton set3 = new JRadioButton("Set as icon 3");
		buttonGroup.add(set3);
		JRadioButton set4 = new JRadioButton("Set as icon 4");
		buttonGroup.add(set4);
		JRadioButton set5 = new JRadioButton("Set as icon 5");
		buttonGroup.add(set5);
		JRadioButton set6 = new JRadioButton("Set as icon 6");
		buttonGroup.add(set6);

		radioButtonPanel.add(set1);
		radioButtonPanel.add(set2);
		radioButtonPanel.add(set3);
		radioButtonPanel.add(set4);
		radioButtonPanel.add(set5);
		radioButtonPanel.add(set6);

		set1.addActionListener(new radioActionListener1());
		set2.addActionListener(new radioActionListener2());
		set3.addActionListener(new radioActionListener3());
		set4.addActionListener(new radioActionListener4());
		set5.addActionListener(new radioActionListener5());
		set6.addActionListener(new radioActionListener6());

		JButton close = new JButton("Close");
		close.addActionListener(new closeConfirmationActionListener());

		popupFrame.setVisible(true);

		confirmationPanel.add(BorderLayout.SOUTH, close);

	}
	
	//series of RadioButtonListeners. to be optimized

	public class radioActionListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameGui.savedSelectionInteger[1] = FrameGui.savedSelectionIntegerSelector;

		}

	}
	public class radioActionListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameGui.savedSelectionInteger[2] = FrameGui.savedSelectionIntegerSelector;

		}

	}
	public class radioActionListener3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameGui.savedSelectionInteger[3] = FrameGui.savedSelectionIntegerSelector;

		}

	}
	public class radioActionListener4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameGui.savedSelectionInteger[4] = FrameGui.savedSelectionIntegerSelector;

		}

	}
	public class radioActionListener5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameGui.savedSelectionInteger[5] = FrameGui.savedSelectionIntegerSelector;

		}

	}
	public class radioActionListener6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			FrameGui.savedSelectionInteger[6] = FrameGui.savedSelectionIntegerSelector;

		}

	}

	public class closeConfirmationActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			popupFrame.dispose();

		}

	}
}
