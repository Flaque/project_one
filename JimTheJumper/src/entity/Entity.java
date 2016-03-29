package entity;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Entity {
	
	Rectangle box;

	/**
	 * Entity is a class that is meant to be extended.
	 * It takes a location and size and will make
	 * a rectangular hit box.
	 * @param point
	 */
	Entity(Point location, Dimension size) {
		this.box = new Rectangle(location.x, location.y, size.width, size.height);
	}
	
	public int getX() {
		return box.x;
	}
	
	public int getY() {
		return box.y;
	}
}

