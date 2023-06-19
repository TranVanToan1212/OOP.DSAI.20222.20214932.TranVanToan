package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCDToStoreScreen extends JFrame{
	
	private Store store;
	
	public AddCDToStoreScreen (Store store) {
		super();
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add CD to Store");
		this.setVisible(true);
		this.setSize(525,350);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					URL url = getClass().getResource("/hust/soict/dsai/aims/screen/addCDToStoreScreen.fxml");
					FXMLLoader loader = new FXMLLoader(url);
					
					AddCDToStoreScreenController controller =
							new AddCDToStoreScreenController(store);
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

class AddCDToStoreScreenController extends AddItemToStoreScreenController{
		   
    @FXML
    private TextField artistTextField;
    
    @FXML
    private TextField directorTextField;
    
	public AddCDToStoreScreenController(Store store) {
		super();
		this.store = store;
	}
	
	public void reset() {
		titleTextField.setText("");
		categoryTextField.setText("");
		costTextField.setText("");
		directorTextField.setText("");
		artistTextField.setText("");
	}

    @FXML
    void btnAddToStoreClicked(ActionEvent event) {
    	String title = titleTextField.getText();
    	String category = categoryTextField.getText();
    	String director = directorTextField.getText();
    	String artist = artistTextField.getText();
    	float cost = (float) Double.parseDouble(costTextField.getText());
    	
    	addMedia(new CompactDisc(title, category, director, cost, artist));
    	reset();
    }

}