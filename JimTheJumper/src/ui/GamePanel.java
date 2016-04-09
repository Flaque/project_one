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
		System.out.println("Added stuff");
		setFocusable(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
		setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
		
		this.addKeyListener(new KeyListener(){ 

		    public void keyPressed(KeyEvent ke){ 

		         if (ke.getKeyCode() == 32) {
		        	 System.out.println("space bar");
		         }
		    }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
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
       // Block block=new Block(new Point(100, 100));
        Platform myPlatform= new Platform(new Point(100,100), 10);
        Graphics2D g2d = (Graphics2D) g;
      //  block.draw(g2d, this);
        myPlatform.drawAll(g2d, this);
    }

}
