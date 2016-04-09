package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

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
		setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
		addKeyListener();
	}
	
	
	/**
	 * I can't figure out how to make this it's own class
	 * so addKeyListener just adds our specific key listener here.
	 * This makes no sense.
	 */
	private void addKeyListener() {
		this.addKeyListener(new KeyListener(){ 

		    public void keyPressed(KeyEvent ke){ 
		         if (ke.getKeyCode() == 32) { //Is SpaceBar
		        	 System.out.println("space bar");
		         }
		    }

			@Override
			public void keyTyped(KeyEvent e) {} //Not used

			@Override
			public void keyReleased(KeyEvent e) {} //Not used
		});
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
			Platform myPlatform= new Platform(new Point(0,i*100), 20);
	        myPlatform.makeHole();
	        myPlatform.drawAll(g2d, this);
		}
	}

}
