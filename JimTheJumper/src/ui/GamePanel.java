package ui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import entity.Level;
import framework.Controller;
import framework.GameCanvas;

public class GamePanel extends GameCanvas {

	//To Be Removed
	Level myLevel;
	
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
	public static GameState gameState = GameState.PLAYING;
	
	//Controller
	Controller controller = new Controller();
	
	/**
	 * The GamePanel exists inside of the GameWindow and is where
	 * we draw everything. 
	 */
	GamePanel() {
		super();
		
		controller.newGame();
		
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
			
			//Changes state
			switch(gameState)  {
				case STARTING: 
					// Do something in the start?
				case PLAYING: 
					//Update stuff
					controller.update(gameTime);
					gameTime += System.nanoTime() - lastTime;
			}
				
			//Render
			repaint();
			
			
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
	}
	


	@Override
	public void keyReleasedFramework(KeyEvent e) {
		controller.onKey(e);
	}

}
