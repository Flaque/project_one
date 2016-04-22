package entity;

import java.awt.Dimension;
import java.awt.Point;

public class Player extends Sprite {
	
	private static final int WIDTH  = 40;
	private static final int HEIGHT = 56;

	/**
	 * Player is the main Player. (Duh)
	 * Its width and height are static as far as I know,
	 * so they do not need to be in the constructor and we'll
	 * define them via static final ints.
	 * @param location
	 */
	public Player(Point location) {
		super(location, new Dimension(Player.WIDTH, Player.HEIGHT), null);
		this.setImage("res/p2 _jump_right.png"); //TODO add transparency, make 40x60
	}
	
	public void move()
	{
		super.move();
		if(this.getX()<=0)
		{
			this.setXY(0, this.getY());
			this.moveRight();
		}
		
		if(this.getX()>= 360) //TODO factor in player width correctly
		{
			this.setXY(360, this.getY());
			this.moveLeft();
		}
	}
	
	public void applyForce(int dx, int dy) 
	{
		super.applyForce(dx, dy);
		if(this.getdx()>0)
		{
			this.setImage("res/p1_jump_right.png");
		}
		
		if(this.getdx()<0)
		{
			this.setImage("res/p1_jump_left.png");
		}
	
	}
	
	public void moveLeft()	//sets the movement facing left
	{
		this.stop();
		this.applyForce(-2, 0);
		
	}
	
	
	public void moveRight()	//sets the movement facing right
	{
		this.stop();
		this.applyForce(2, 0);
	}
	
	public void pickDirection(int holeLocation){
		if(this.getX()<holeLocation)
		{
			this.moveRight();
		}
		
		if(this.getX()>holeLocation)
		{
			this.moveLeft();
		}	
	}
}
