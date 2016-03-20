package entity;

import java.awt.Dimension;
import java.awt.Point;

public class Player extends Entity {
	
	private static final int WIDTH  = 16;
	private static final int HEIGHT = 16;

	/**
	 * Player is the main Player. (Duh)
	 * Its width and height are static as far as I know,
	 * so they do not need to be in the constructor and we'll
	 * define them via static final ints.
	 * @param location
	 */
	Player(Point location) {
		super(location, new Dimension(Player.WIDTH, Player.HEIGHT));
	}

}
