package framework;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import entity.Level;
import entity.Player;

public class Controller {
	
	Level myLevel;
	Player myPlayer;
	
	public Controller() {
		newGame();
	}
	
	public void newGame() {
		myLevel = new Level(50);
		myPlayer= new Player(new Point(0,500));
	}

	public void update(long gameTime) {
		myLevel.move();
		myPlayer.move();
	}
	
	public void draw(Graphics2D g2d, JPanel panel) {
		myLevel.drawLevel(g2d, panel);
		myPlayer.draw(g2d, panel);
	}
	
	public void onKey(KeyEvent e) 
	{
		if(e.getKeyCode()==32)
		{
			myLevel.jump();
		}
		
		if(e.getKeyCode()==68)
		{
			myPlayer.applyForce(2, 0);
		}
		
		if(e.getKeyCode()==65)
		{
			myPlayer.applyForce(-2, 0);
		}
		
		//System.out.println(e);
	}
}
