package hust.soict.dsai.aims.screen;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddItemToStoreScreenController {
	
	protected Store store;
	
    @FXML
    protected Button btnAddToStore;

    @FXML
    protected TextField categoryTextField;

    @FXML
    protected TextField costTextField;

    @FXML
    protected TextField titleTextField;
	
	public void reset() {
		titleTextField.setText("");
		categoryTextField.setText("");
		costTextField.setText("");
	}
	
	public void addMedia(Media media) {
		String notification = store.addMedia(media);
    	
		JDialog Dialog = new JDialog(new JFrame(), "Notification");
		JLabel Label = new JLabel(notification, SwingConstants.CENTER);
		
		Dialog.add(Label);
		Dialog.setLocation(200,200);
		Dialog.pack();
		Dialog.setVisible(true);
	}
}

