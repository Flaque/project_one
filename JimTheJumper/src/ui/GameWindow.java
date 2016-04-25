// David was here

package ui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	public static final int WIDTH  = 400;
	public static final int HEIGHT = 660;

	/**
	 * The GameWindow is the window that the game runs in. Woo.
	 * However, you can't easily draw things on a JFrame, so instead
	 * we draw things on the GamePanel (Just a custom JPanel)
	 */
	public GameWindow() {
		this.initWindow();
	}
	
	/**
	 * Starts window
	 */
	private void initWindow() {
		this.setContentPane(new GamePanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Jim the Jumper");
		this.setLocationRelativeTo(null);
		this.setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
		this.setVisible(true); //Common Java, just make this the default.
		this.setResizable(false);
	}

}
