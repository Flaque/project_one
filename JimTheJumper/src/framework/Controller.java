package framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import entity.Background;
import entity.Block;
import entity.Level;
import entity.Player;

public class Controller {
	Level myLevel;
	Player myPlayer;
	int score;
	boolean paused = false;
	
	public Controller() {
		newGame();
	}
	
	public void newGame() {
		myLevel = new Level(17);
		myPlayer= new Player(new Point(0,540));
		myPlayer.moveRight();
	}

	public void update(long gameTime){
		if (!paused){
			myLevel.move(myPlayer, score);	//update platforms location
			myPlayer.move();		//update player location
		}
	}
	
	public void draw(Graphics2D g2d, JPanel panel) {
		myLevel.drawLevel(g2d, panel);
		myPlayer.draw(g2d, panel);
		showScore(g2d);
	}
	public void showScore(Graphics2D g2d){
		Font font = new Font("Copperplate Gothic Bold", Font.PLAIN, 26);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(font);
		g2d.drawString("Score: " + score, 10, 50);
	}
	public void onKey(KeyEvent e) 
	{
		if(e.getKeyCode()==32)	//spacebar called
		{
			if(!paused){
				// create new platforms and delete old platforms
				// also pauses the game if there is a collision
				score += myLevel.jump(myPlayer);
			}
		}
		if(e.getKeyCode()==80){	//'p' called
			paused = !paused;
		}
		if(e.getKeyCode()==65) 	//'a' called
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
