package oop.project2;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * getting null pointer exceptions for my paint and I am even checking for nulls
 * I don't know what is happening
 * @author jshaak
 *
 */
public class Pallette extends JLabel {
	private LendingLibraryGUI gui;
	
	Pallette(ImageIcon icon){
		super(icon);
	}
	//I am trying to use this paint method to repaint
	//the pallete that holds the other images. 
	@Override
	public void paint(Graphics g){
		super.paint(g);
		System.out.println(gui.getImageHolder());
		if(gui.getImageHolder() == null){
		}else{
			g.drawImage(gui.getImageHolder(), gui.getCurrentItem().getX(), gui.getCurrentItem().getY(), null);
		}
	}
}
