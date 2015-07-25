import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class shuffleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			FrameGui.drop();
		}
	}