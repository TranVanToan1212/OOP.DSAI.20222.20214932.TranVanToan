package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.scene.control.Label;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public MediaStore (Media media, Cart cart) {
		
		this.media = media;
		this.cart = cart;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ButtonListener btnListener = new ButtonListener();
		
		JLabel title = new JLabel (media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 20));
		title.setAlignmentX (CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX (CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout (FlowLayout. CENTER));
		
		JButton btnAddToCart = new JButton("Add to cart");
		container.add(btnAddToCart);
		btnAddToCart.addActionListener(btnListener);
		
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			container.add(btnPlay);
			btnPlay.addActionListener(btnListener);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder (BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			String button = e.getActionCommand();
			if (button.equals("Add to cart")) {
				try {
					String notification;
					notification = cart.addMedia(media);
					JDialog Dialog = new JDialog(new JFrame(), "Notification");
					JLabel Label = new JLabel(notification, SwingConstants.CENTER);
					
					Dialog.add(Label);
					Dialog.setLocation(200,200);
					Dialog.pack();
					Dialog.setVisible(true);
				}
				catch (LimitExceededException | IllegalArgumentException el) {
					el.printStackTrace();
				}
			}
			else if (button.equals("Play")) {
		    	if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					try {
						dvd.play();
					}
					catch(PlayerException ep) {
						ep.printStackTrace();
					}
		    	}
		    	else if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					try {
						cd.play();
					}
					catch(PlayerException ep) {
						ep.printStackTrace();
					}
		    	}
			}
		}
	}
}

