package oop.project2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import oop.project2.DataObjects.Item;
/**
 * getting null pointer exceptions for my paint and I am even checking for nulls
 * I don't know what is happening
 * @author jshaak
 *
 */
public class Pallette extends JLabel {
	private Image image;
	private Item item;
	private Graphics g;
	
	Pallette(ImageIcon icon){
		super(icon);
	}
	//I am trying to use this paint method to repaint
	//the pallete that holds the other images. 
	public void setDotProperties(Image image, Item item, Graphics g){
		this.image = image;
		this.item = item;
		this.g = g;	
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{
			if(image != null){
				g.drawImage(image, item.getX(), item.getY(), null);
			}
		}
		catch(NullPointerException e){
			
		}
	}
}
