package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import entity.Player;

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
	}
	
	
	/**
	 * paintComponent is called Swing. All you need to know
	 * is this is where to put all things you want to draw. 
	 */
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Player player = new Player(new Point(60, 100));
        
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d, this);
    }

}
