package ui;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import entity.Glass;
import framework.Controller;
import framework.GameCanvas;

public class GamePanel extends GameCanvas {
	//Utility
	private final long secInNanosecond = 1000000000L;
	private final long milisecInNanosec = 1000000L;
	
	//Used for managing FPS
	private final int GAME_FPS = 60;
	private final long GAME_UPDATE_PERIOD = secInNanosecond/GAME_FPS;
	
	//Used to keep track of time
	private long gameTime;
	private long lastTime;
	
	//State
	public static enum GameState{PLAYING, STARTING, GAME_OVER, MAIN_MENU}
	public static GameState gameState;
	
	//Controller
	Controller controller = new Controller();
	
	//over slide
	private int Ycor = -50;
	private int Xcor = -300;
	private int score = 0;
	
	/**
	 * The GamePanel exists inside of the GameWindow and is where
	 * we draw everything. 
	 */
	GamePanel() {
		super();
		
		gameState = GameState.MAIN_MENU;
		
		gameTime = 0;
		lastTime = System.nanoTime();
		
		/**
		 * Starts the game in a new thread
		 */
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				loop();
			}
		};
		
		gameThread.start();
	}
	
	
	/**
	 * MAIN GAME LOOP
	 */
	private void loop() {
		
		//Used for calculating wait time during the FPS
		long beginTime, timeTaken, timeLeft;
		
		while(true) {
			beginTime = System.nanoTime();
			
			//Render
			repaint();
			
			//Changes state
			switch(gameState)  {
				case MAIN_MENU:
					controller.update(gameTime);
					break;
				case STARTING: 
					//create a new game and begin
					controller.newGame();
					gameState = GameState.PLAYING;
					break;
				case PLAYING: 
					//Update stuff
					if(controller.update(gameTime))
						gameState = GameState.GAME_OVER;
					score = controller.getScore();
					gameTime += System.nanoTime() - lastTime;
					break;
				case GAME_OVER:
					if(Ycor <= 230)
						Ycor+=10;
					else if(Xcor <= 110)
						Xcor+=10;
					break;
			}
			
			// Here we calculate the time that defines for how long we should put threat to sleep to meet the GAME_FPS.
            timeTaken = System.nanoTime() - beginTime;
            timeLeft = (GAME_UPDATE_PERIOD - timeTaken) / milisecInNanosec; // In milliseconds
            // If the time is less than 10 milliseconds, then we will put thread to sleep for 10 millisecond so that some other thread can do some work.
            if (timeLeft < 10) 
                timeLeft = 10; //set a minimum
            try {
                 //Provides the necessary delay and also yields control so that other thread can do work.
                 Thread.sleep(timeLeft);
            } catch (InterruptedException ex) { }
		}
	}


	@Override
	public void canvasDraw(Graphics2D g2d) {
		controller.draw(g2d, this);
		if(gameState == GameState.MAIN_MENU)
			this.mainMenu(g2d);
		if(gameState == GameState.GAME_OVER)
			this.overMenu(g2d);
	}
	private void mainMenu(Graphics2D g2d){
		Font font = new Font("Copperplate Gothic Bold", Font.ITALIC, 50);
		g2d.setColor(Color.WHITE);
		g2d.setFont(font);
		g2d.drawString("Jim the", 40, 60);
		g2d.drawString("Jumper", 140, 110);
		
		font = new Font("Copperplate Gothic Bold", Font.PLAIN, 22);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(font);
		g2d.drawString("Press any key", 140, 260);
		g2d.drawString("to begin.", 140, 290);
	}
	private void overMenu(Graphics2D g2d){
		Glass glass = new Glass(new Point(0,0));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.5));
		glass.draw(g2d,this);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.85));
		Glass cover = new Glass(new Point(100,210));
		cover.setImage("res/cover.png");
		cover.draw(g2d,this);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1.0));
		Font font = new Font("Copperplate Gothic Bold", Font.ITALIC, 32);
		g2d.setColor(Color.RED);
		g2d.setFont(font);
		g2d.drawString("Game Over", 100, Ycor);
		
		font = new Font("Copperplate Gothic Bold", Font.PLAIN, 22);
		g2d.setColor(Color.BLUE);
		g2d.setFont(font);
		g2d.drawString("Press 's' to", Xcor, 300);
		g2d.drawString("    start over.", Xcor, 330);
		
		g2d.setFont(font);
		g2d.drawString("HighScore: " + score, Xcor-15, 385);
	}
	@Override
	public void keyReleasedFramework(KeyEvent e) {
		//checks game is over and that space is released
		if(gameState == GameState.GAME_OVER && e.getKeyCode()==83){
			Ycor = -50; Xcor = -300;
			gameState = GameState.STARTING;
		}
		if(gameState == GameState.MAIN_MENU)
			gameState = GameState.STARTING;
		if(gameState == GameState.PLAYING)
			controller.onKey(e);
	}
}