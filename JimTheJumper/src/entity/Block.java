package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class Block extends Sprite {
	
	private static final int SIZE = 20;

	/**
	 * A Block is what the map is made of. 
	 * Why a subclass? Object detection.
	 * @param location
	 * @param image
	 */
	public Block(Point location) {
		super(location, new Dimension(Block.SIZE, Block.SIZE), null);
		this.setImage("res/jimPlatform.jpg");
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
