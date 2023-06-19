package hust.soict.dsai.aims.screen;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ExceptionDialog {
	Exception exception;
	public ExceptionDialog(Exception exception) {
		this.exception = exception;
	}
	
	public void getDialog() {
		String message = exception.getMessage();
		JDialog Dialog = new JDialog(new JFrame(), "ERROR");
		JLabel Label = new JLabel(message, SwingConstants.CENTER);
		
		Dialog.add(Label);
		Dialog.setLocation(200,200);
		Dialog.pack();
		Dialog.setVisible(true);
	}
}
