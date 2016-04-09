package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import entity.Player;
import entity.Block;
import entity.Platform;

public class GamePanel extends JPanel {
	
	/**
	 * The GamePanel exists inside of the GameWindow and is where
	 * we draw everything. 
	 */
	GamePanel() {
		setFocusable(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
	}
	
	
	/**
	 * paintComponent is called Swing. All you need to know
	 * is this is where to put all things you want to draw. 
	 */
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Player player = new Player(new Point(1, 1));
        
        Graphics2D g2d = (Graphics2D) g;
        testLevelDesign(g2d);
      //  block.draw(g2d, this);
        
    }
	
	public void testLevelDesign(Graphics2D g2d)
	{
		for(int i=1; i<15; i++)
		{
			Platform myPlatform= new Platform(new Point(0,i*100), 10);
	        myPlatform.makeHole();
	        myPlatform.drawAll(g2d, this);
		}
	}

}
