package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class Background extends Sprite {
	
	private static final int SIZE = 700;

	/**
	 * A Block is what the map is made of. 
	 * Why a subclass? Object detection.
	 * @param location
	 * @param image
	 */
	public Background(Point location) {
		super(location, new Dimension(Background.SIZE, Background.SIZE), null);
		this.setImage("res/backroundBase.png");
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

