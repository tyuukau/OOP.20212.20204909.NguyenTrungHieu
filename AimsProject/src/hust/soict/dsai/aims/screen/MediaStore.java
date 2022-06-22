package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;

// import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class MediaStore extends JPanel {

	private Media media;
	// private Cart cart;
	
	public MediaStore(Media media) {
		this.media = media;
		// this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(this.media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + this.media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if (this.media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(e -> {
				JPanel p = new JPanel();
				JLabel j1 = new JLabel();
				JLabel j2 = new JLabel();
				
				if (((Playable)this.media).play()) {
					j1 = new JLabel(this.media.getTitle() + " is playing");
				} else {
					j1 = new JLabel(this.media.getTitle() + " cannot be played");
					j2 = new JLabel("Media length is non-positive");
				}
				j1.setAlignmentX(Component.CENTER_ALIGNMENT);
				j2.setAlignmentX(Component.CENTER_ALIGNMENT);
	
				p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
				p.add(Box.createVerticalGlue());
				p.add(j1);
				p.add(j2);
				p.add(Box.createVerticalGlue());
	
				JDialog d = new JDialog();
				d.add(p);
				d.setSize(250,100);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				int w = d.getSize().width;
				int h = d.getSize().height;
				int x = (dim.width - w) / 2;
				int y = (dim.height - h) / 2;
				d.setLocation(x,y);
				d.setVisible(true);	
			});
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}

