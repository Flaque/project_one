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
	boolean paused = false;
	
	public Controller() {
		newGame();
	}
	
	public void newGame() {
		myLevel = new Level(25);
		myPlayer= new Player(new Point(0,540));
		myPlayer.moveRight();
	}

	public void update(long gameTime) {
		if (!paused){
			myLevel.move(myPlayer);	//update platforms location
			myPlayer.move();		//update player location
		}
	}
	
	public void draw(Graphics2D g2d, JPanel panel) {
		myLevel.drawLevel(g2d, panel);
		myPlayer.draw(g2d, panel);
	}
	
	public void onKey(KeyEvent e) 
	{
		if(e.getKeyCode()==32)	//spacebar called
		{
			if(!paused){
				// create new platforms and delete old platforms
				myLevel.jump();
			}
		}
		if(e.getKeyCode()==80){	//'p' called
			paused = !paused;
		}
		
<<<<<<< HEAD
		if(e.getKeyCode()==65)	//'a' called
=======
		if(e.getKeyCode()==65)
>>>>>>> c4c274dfa25dcb67b0a96f32fbaf02922494830c
		{
			myPlayer.moveLeft();
		}
		
		if(e.getKeyCode()==68)	//'d' called
		{
			myPlayer.moveRight();
		}
		if(e.getKeyCode()==83)	//'s' called
		{
			myPlayer.stop();
		}
	}
}
