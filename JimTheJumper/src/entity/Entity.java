package entity;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Entity {
	
	Rectangle box;
	
	protected int dx = 0;
	protected int dy = 0;

	/**
	 * Entity is a class that is meant to be extended.
	 * It takes a location and size and will make
	 * a rectangular hit box.
	 * @param point
	 */
	Entity(Point location, Dimension size) {
		this.box = new Rectangle(location.x, location.y, size.width, size.height);
	}
	
	/**
	 * Gets X
	 * @return
	 */
	public int getX() {
		return box.x;
	}
	
	/**
	 * Gets Y
	 * @return
	 */
	public int getY() {
		return box.y;
	}
	
	/**
	 * Sets the XY
	 * @param x
	 * @param y
	 */
	public void setXY(int x, int y) {
		this.box.x = x;
		this.box.y = y;
	}
	
	/**
	 * Utility function for appling gravity to an object.
	 * @param dy
	 */
	public void applyGravity(int dy) {
		this.applyForce(0, dy);
	}
	
	/**
	 * Applys a force to the object.
	 * @param dx
	 * @param dy
	 */
	public void applyForce(int dx, int dy) {
		this.dx += dx;
		this.dy += dy;
	}
	
	/**
	 * Applies the velocity to the position of the object
	 */
	public void move() {
		this.setXY(box.x + dx, box.y + dy);
	}

}

