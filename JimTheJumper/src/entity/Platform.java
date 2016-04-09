package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import entity.Block;
import ui.GamePanel;

import java.util.*;

import javax.swing.JPanel;

public class Platform {
	ArrayList<Block> blockList= new ArrayList();
	
	public Platform(Point location, int width)
	{
		for( int i=width; i>0; i--)
		{
			Block block= new Block(location);
			location.x+=block.getSize();
			blockList.add(block);
		}
	}
	
	public void drawAll(Graphics2D myGraphics, JPanel myPanel)
	{
		for(Block i : blockList)
		{
			i.draw(myGraphics, myPanel);
		}
	}

}
