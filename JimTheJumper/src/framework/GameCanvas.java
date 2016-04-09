package framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public abstract class GameCanvas extends JPanel implements KeyListener{
	
	/**
	 * The Canvas is an abstraction of both the JPanel and the Keylistener
	 * so we don't have to deal with it and it can be in its own little
	 * thing.
	 */
	public GameCanvas() {
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.setBackground(Color.white);
		this.addKeyListener(this);
	}
	
	/**
	 * ============ DRAWING ============
	 */
	
	/**
	 * Implemented in the GamePanel
	 * @param g2d
	 */
	public abstract void canvasDraw(Graphics2D g2d);
	
	
	@Override
	/**
	 * Draws everything 
	 */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;        
        super.paintComponent(g2d);        
        this.canvasDraw(g2d);
    }
	
	
	/**
	 * ============ KEYS ============ 
	 */
	
	//Stores the states for keyboard keys
	private static boolean[] keyboardState = new boolean[525];
	
	/**
	 * Gets the keyboard state
	 * @param key
	 * @return
	 */
	public static boolean keyboardKeyState(int key) {
        return keyboardState[key];
    }
    
    /** KeyListener Contractual relationship **/
	
    @Override
    public void keyPressed(KeyEvent e) {
        keyboardState[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        keyboardState[e.getKeyCode()] = false;
        keyReleasedFramework(e);
    }
    
    @Override
    public void keyTyped(KeyEvent e) { }
    
    /**
     * To be implemented later
     * @param e
     */
    public abstract void keyReleasedFramework(KeyEvent e);

	
}
 