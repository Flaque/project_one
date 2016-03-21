package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	public static void main (String[] args) {
		GamePanel panel = new GamePanel();
	}
	
	
	/**
	 * The GamePanel exists inside of the GameWindow and is where
	 * we draw everything. 
	 */
	GamePanel() {
		
	}
	
	
	/**
	 * paintComponent is called Swing. All you need to know
	 * is this is where to put all things you want to draw. 
	 */
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}