package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class AddDVDToStoreScreen extends JFrame{
	
	private Store store;
	
	public AddDVDToStoreScreen (Store store) {
		super();
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add DVD to Store");
		this.setVisible(true);
		this.setSize(525,250);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					URL url = getClass().getResource("/hust/soict/dsai/aims/screen/addDVDToStoreScreen.fxml");
					FXMLLoader loader = new FXMLLoader(url);
					
					AddDVDToStoreScreenController controller =
							new AddDVDToStoreScreenController(store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene (new Scene(root));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class AddDVDToStoreScreenController extends AddItemToStoreScreenController {
    
	public AddDVDToStoreScreenController(Store store) {
		super();
		this.store = store;
	}

    @FXML
    void btnAddToStoreClicked(ActionEvent event) {
    	String title = titleTextField.getText();
    	String category = categoryTextField.getText();
    	float cost = (float) Double.parseDouble(costTextField.getText());
    	
    	addMedia(new DigitalVideoDisc(title, category, cost));
    	reset();
    }

}