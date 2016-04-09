package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class Block extends Sprite {
	
	private static final int SIZE = 16;

	/**
	 * A Block is what the map is made of. 
	 * Why a subclass? Object detection.
	 * @param location
	 * @param image
	 */
	Block(Point location) {
		super(location, new Dimension(Block.SIZE, Block.SIZE), null);
		this.setImage("res/p1_jump.png");
	}
}
