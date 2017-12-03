package oop.project2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import oop.project2.DataObjects.Item;
/**
 * This class is designed to set the paintProperties
 * of the image that is to be painted and paint that
 * image based on an item's location. 
 * 
 * @author jshaak
 *
 */
public class Pallette extends JLabel {
	private Image image;
	private Item item;
	private Graphics g;
	
	/**
	 * Pallette(ImageIcon icon)
	 * 
	 * This constructor takes an ImageIcon and passes that icon
	 * to the JLabel constructor. This way, when the JLabel is
	 * created, the image will be loaded as a JLabel.
	 * @param icon
	 */
	Pallette(ImageIcon icon){
		super(icon);
	}
	/**
	 * void setPaintProperties(Image image, Item item, Graphics g)
	 * 
	 * This method sets the paint properties of an image that is to be
	 * painted on. g is the canvas, image is what is to be painted on the
	 * canvas, and item is to get the coordinates of where the image should
	 * be located. 
	 * @param image
	 * @param item
	 * @param g
	 */
	public void setPaintProperties(Image image, Item item, Graphics g){
		this.image = image;
		this.item = item;
		this.g = g;	
	}
	/**
	 * void paint(Graphics g)
	 * 
	 * This method takes the graphic of whatever is calling repaint. It then
	 * draws the image where the selected item's location is on the canvas.
	 * 
	 * @param g
	 */
	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{
			if(image != null){ //make sure there is never a null image.
				g.drawImage(image, item.getX(), item.getY(), null);
			}
		}
		catch(NullPointerException e){
			
		}
	}
}
