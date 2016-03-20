package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public abstract class Sprite extends Entity{
	
	/**
	 * A Sprite is just an entity with an image.
	 * We make this distinction so we can define
	 * an Entity without an image. (Often this is 
	 * used to specify a "region" or something 
	 * that the player doesn't see, but we the devs,
	 * know is happening).
	 * 
	 * Sprites can also handle the animation.
	 * @param location
	 * @param size
	 */
	Sprite(Point location, Dimension size, Image image) {
		super(location, size);
	}
}
