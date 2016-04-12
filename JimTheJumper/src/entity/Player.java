package entity;

import java.awt.Dimension;
import java.awt.Point;

public class Player extends Sprite {
	
	private static final int WIDTH  = 16;
	private static final int HEIGHT = 16;

	/**
	 * Player is the main Player. (Duh)
	 * Its width and height are static as far as I know,
	 * so they do not need to be in the constructor and we'll
	 * define them via static final ints.
	 * @param location
	 */
	public Player(Point location) {
		super(location, new Dimension(Player.WIDTH, Player.HEIGHT), null);
		this.setImage("res/p2_jump_right.png"); //TODO add transparency, make 40x60
	}
	
	public void move()
	{
		super.move();
		if(this.getX()<=0)
		{
			this.setXY(0, this.getY());
			this.stop();
			
		}
		
		if(this.getX()>= 360) //TODO factor in player width correctly
		{
			this.setXY(360, this.getY());
			this.stop();
			
		}
	}
	
	public void applyForce(int dx, int dy) 
	{
		super.applyForce(dx, dy);
		if(this.getdx()>0)
		{
			this.setImage("res/p2_jump_right.png");
		}
		
		if(this.getdx()<0)
		{
			this.setImage("res/p2_jump_left.png");
		}
	
	}
	
	public void moveLeft()
	{
		this.stop();
		this.applyForce(1, 0);
		
	}
	
	
	public void moveRight()
	{
		this.stop();
		this.applyForce(-1, 0);
	}
}
