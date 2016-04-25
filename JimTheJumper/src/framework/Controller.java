package framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import entity.Level;
import entity.Player;

public class Controller {
	Level myLevel;
	Player myPlayer;
	private int score;
	private boolean paused;
	private boolean inMenu;
	
	public Controller() {
		myLevel = new Level(9);
		myLevel.setMenu();
		myPlayer= new Player(new Point(0,540));
		myPlayer.moveRight();
		inMenu = true;
	}
	public void newGame() {
		inMenu = false;
		myLevel = new Level(9);
		myPlayer= new Player(new Point(0,540));
		myPlayer.moveRight();
		paused = false;
		score = 0;
	}

	public boolean update(long gameTime){
		if (!paused){
			if(!inMenu)myPlayer.move();					 //update player location
			return myLevel.move(myPlayer);//update platforms location
		}
		return false;
	}
	
	public void draw(Graphics2D g2d, JPanel panel) {
		myLevel.drawLevel(g2d, panel);
		if(!inMenu){
			myPlayer.draw(g2d, panel);
			showScore(g2d);
		}
	}
	private void showScore(Graphics2D g2d){
		Font font = new Font("Copperplate Gothic Bold", Font.PLAIN, 26);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(font);
		g2d.drawString("Score: " + score, 10, 50);
	}
	public int getScore(){
		return score;
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
	}
}
