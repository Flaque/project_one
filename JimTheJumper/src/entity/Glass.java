package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class Glass extends Sprite {
	
	private static final int SIZE = 200;

	/**
	 * A Block is what the map is made of. 
	 * Why a subclass? Object detection.
	 * @param location
	 * @param image
	 */
	public Glass(Point location) {
		super(location, new Dimension(Glass.SIZE, Glass.SIZE), null);
		this.setImage("res/glass.png");
	}
	
	public int getSize()
	{
		return SIZE;
	}
	
	public int getVelocity()
	{
		return dy;
	}
	
	public void stop(){
		dx=0;
		dy=0;
	}
	
	
}
