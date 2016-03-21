package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Sprite extends Entity{
	
	// TODO: Cry over concurrency problems with Sprites and images.
	
	Image image;
	
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
	 * @param image (Note: if you don't know the image, this can be null. 
	 * 				 Which is probably bad. But doing an image factory seems 
	 *               like overkill at the moment).
	 */
	Sprite(Point location, Dimension size, Image image) {
		super(location, size);
		this.image = image;
	}
	
	/**
	 * Will attempt to set the image based on the file path.
	 * @return true on success, else false
	 * @param filePath
	 */
	protected boolean setImage(String filePath) {
		try {
		    this.image = ImageIO.read(new File("res/p1_jump.png"));
		    return true;
		} catch (IOException e) { return false; }
	}
}
