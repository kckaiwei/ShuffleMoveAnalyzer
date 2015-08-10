import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SelectionConfirmation extends JFrame{
	JFrame popupFrame;
	JPanel confirmationPanel;
	JPanel radioButtonPanel;
	

	public void go() {
		popupFrame = new JFrame("Icon Selection");

		popupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GridLayout radioButtonLayout = new GridLayout(7,1);
		radioButtonLayout.setHgap(2);
		BorderLayout confirmationLayout = new BorderLayout();
		
		JPanel confirmationPanel = new JPanel(confirmationLayout);
		
		
		radioButtonPanel = new JPanel(radioButtonLayout);
		popupFrame.getContentPane().add(confirmationPanel);
		popupFrame.setSize(600,300);
		popupFrame.setFocusable(false);
		confirmationPanel.add(BorderLayout.CENTER,radioButtonPanel);
		
		JLabel confirmationPrompt = new JLabel("Select icon position for pokemon");
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
		
		radioButtonPanel.add(set1);
		radioButtonPanel.add(set2);
		radioButtonPanel.add(set3);
		radioButtonPanel.add(set4);
		radioButtonPanel.add(set5);
		
		JButton close = new JButton("Close");
		close.addActionListener(new closeConfirmationActionListener());
		
		
		popupFrame.setVisible(true);
		
		confirmationPanel.add(BorderLayout.SOUTH, close);
		
		
	}
	public class radioActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String buttonName = null;
			
			buttonName = (String) e.getSource();
			switch (buttonName){
			
			case "set1":
				FrameGui.savedSelectionInteger[1] = FrameGui.savedSelectionIntegerSelector;
				break;
			case "set2":
				FrameGui.savedSelectionInteger[2] = FrameGui.savedSelectionIntegerSelector;
				break;
			case "set3":
				FrameGui.savedSelectionInteger[3] = FrameGui.savedSelectionIntegerSelector;
				break;
			case "set4":
				FrameGui.savedSelectionInteger[4] = FrameGui.savedSelectionIntegerSelector;
				break;
			case "set5":
				FrameGui.savedSelectionInteger[5] = FrameGui.savedSelectionIntegerSelector;
				break;
			case "set6":
				FrameGui.savedSelectionInteger[6] = FrameGui.savedSelectionIntegerSelector;
				break;
			
			}
		}
		
	}
	
	public class closeConfirmationActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			popupFrame.dispose();
			
		}
		
	}
}
