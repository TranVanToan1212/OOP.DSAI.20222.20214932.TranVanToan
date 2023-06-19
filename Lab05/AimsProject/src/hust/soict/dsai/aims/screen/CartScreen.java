package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;


public class CartScreen extends JFrame{
	
	private Cart cart;
	private Store store;
	
	public CartScreen (Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		this.setSize(1000,500);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					URL url = getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml");
					FXMLLoader loader = new FXMLLoader(url);
					
					CartScreenController controller =
							new CartScreenController(cart, store);
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