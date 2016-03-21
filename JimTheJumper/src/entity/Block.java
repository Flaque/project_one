package entity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class Block extends Sprite {
	
	private static final int SIZE = 16;

	Block(Point location, Image image) {
		super(location, new Dimension(Block.SIZE, Block.SIZE), image);
	}
}
