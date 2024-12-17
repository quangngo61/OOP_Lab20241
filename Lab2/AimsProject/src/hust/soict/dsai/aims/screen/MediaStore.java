package hust.soict.dsai.aims.screen;

import javax.swing.BoxLayout;
import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new AddToCartListener());
        container.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayButtonListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (media instanceof Playable) {
                try {
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Playing Media");
                    playDialog.setSize(300, 150);
                    playDialog.setLocationRelativeTo(null);
                    JLabel message = new JLabel("Now playing: " + media.getTitle(), JLabel.CENTER);
                    playDialog.add(message);
                    playDialog.setVisible(true);
                    
                    // Play the media, this can throw a PlayerException
                    ((Playable) media).play();
                } catch (PlayerException ex) {
                    // Handle the exception if play() throws a PlayerException
                    String errorMessage = "Error occurred while playing the media: " + ex.getMessage();
                    System.err.println(errorMessage);
                    ex.printStackTrace(); // Optionally print stack trace
                    // Show the error in a dialog
                    JOptionPane.showMessageDialog(null, errorMessage, "Play Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class AddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cart.addMedia(media);
            JDialog cartDialog = new JDialog();
            cartDialog.setTitle("Add to Cart");
            cartDialog.setSize(300, 150);
            cartDialog.setLocationRelativeTo(null);
            JLabel message = new JLabel(media.getTitle() + " has been added to the cart.", JLabel.CENTER);
            cartDialog.add(message);
            cartDialog.setVisible(true);
        }
    }
}
