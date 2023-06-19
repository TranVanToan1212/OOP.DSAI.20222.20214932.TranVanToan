package hust.soict.dsai.aims.screen;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private Store store;
	
    @FXML
    private MenuItem addBookMenuItem;

    @FXML
    private MenuItem addCDMenuItem;

    @FXML
    private MenuItem addDVDMenuItem;
    
    @FXML
    private MenuItem viewStoreMenuItem;
	
    @FXML
    private Button btnPlaceOrder;
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
    @FXML
    private Label totalCostLabel = new Label("0 $");
	
	public CartScreenController (Cart cart, Store store) {
		super();
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		DoubleBinding totalCostDoubleBinding = Bindings.createDoubleBinding(() -> {
		    return cart.totalCost(); 
		}, tblMedia.getItems());
		
		totalCostLabel.textProperty().bind(totalCostDoubleBinding.asString("%.2f $"));
				
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
				@Override
				public void changed(ObservableValue<? extends Media> observable, Media oldValue,
							Media newValue) {
					if(newValue!= null) {
						updateButtonBar(newValue);
					}
				}
			});
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	void placeOrderDialog(boolean input) {
		if (input == true) {
			JDialog orderDialog1 = new JDialog(new JFrame(), "Notification");
			
			String orderLabelText1 = "Order has been created.";
			
			JLabel orderLabel1 = new JLabel(orderLabelText1, SwingConstants.CENTER);
			orderDialog1.add(orderLabel1);
			orderDialog1.setLocation(200,200);
			orderDialog1.pack();
			orderDialog1.setVisible(true);
		}
		else {
			JDialog orderDialog0 = new JDialog(new JFrame(), "Notification");
			
			String orderLabelText0 = "Cart is empty.";
			
			JLabel orderLabel0 = new JLabel(orderLabelText0, SwingConstants.CENTER);
			orderDialog0.add(orderLabel0);
			orderDialog0.setLocation(200,200);
			orderDialog0.pack();
			orderDialog0.setVisible(true);
		}

	}
	
    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
    	if (cart.getItemsOrdered().size() == 0) {
    		placeOrderDialog(false);
    	}
    	else {
	    	cart.reset();
	    	initialize();
	    	placeOrderDialog(true);
    	}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if (media instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) media;
			try {
				dvd.play();
			}
			catch(PlayerException e) {
				throw e;
			}
    	}
    	else if (media instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) media;
			try {
				cd.play();
			}
			catch(PlayerException e) {
				throw e;
			}
    	}
    }
	
    @FXML
    void btnRemoveClicked(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    @FXML
    void addBookMenuItemChosen(ActionEvent event) {
    	new AddBookToStoreScreen(store);
    }

    @FXML
    void addCDMenuItemChosen(ActionEvent event) {
    	new AddCDToStoreScreen(store);
    }

    @FXML
    void addDVDMenuItemChosen(ActionEvent event) {
    	new AddDVDToStoreScreen(store);
    }
    
    @FXML
    void viewStoreMenuItemChosen(ActionEvent event) {
    	new StoreScreen(store, cart);
    }

}
