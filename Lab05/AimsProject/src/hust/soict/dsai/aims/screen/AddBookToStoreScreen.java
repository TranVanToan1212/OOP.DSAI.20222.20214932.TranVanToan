package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.Book;
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

public class AddBookToStoreScreen extends JFrame{
	
	private Store store;
	
	public AddBookToStoreScreen (Store store) {
		super();
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add Book to Store");
		this.setVisible(true);
		this.setSize(525,250);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					URL url = getClass().getResource("/hust/soict/dsai/aims/screen/addBookToStoreScreen.fxml");
					FXMLLoader loader = new FXMLLoader(url);
					
					AddBookToStoreScreenController controller =
							new AddBookToStoreScreenController(store);
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

class AddBookToStoreScreenController extends AddItemToStoreScreenController{
    
	public AddBookToStoreScreenController(Store store) {
		super();
		this.store = store;
	}

    @FXML
    void btnAddToStoreClicked(ActionEvent event) {
    	String title = titleTextField.getText();
    	String category = categoryTextField.getText();
    	float cost = (float) Double.parseDouble(costTextField.getText());
    	
    	addMedia(new Book(title, category, cost));
    	reset();
    }

}