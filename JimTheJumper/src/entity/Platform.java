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
	int midHoleIndex;
	
	public Platform(Point location, int width)
	{
		for( int i=width; i>0; i--)
		{
			Block block= new Block(location);
			location.x+=block.getSize();
			blockList.add(block);
		}
	}
	
	public void makeHole()
	{
	Random Rand= new Random();
	int i=Rand.nextInt(blockList.size()-2);
	blockList.remove(i+2);
	blockList.remove(i+1);
	blockList.remove(i);
	midHoleIndex=i+1;
	}
	
	public int getHoleIndex()
	{
		return midHoleIndex;
	}
	
	public void drawBlocks(Graphics2D myGraphics, JPanel myPanel)
	{
		for(Block i : blockList)
		{
			i.draw(myGraphics, myPanel);
		}
	}
	
	public void applyUpwardForce(int force)
	{
		for(Block i : blockList)
		{
			i.applyForce(0,force);
		}
	}
	
	public void move()
	{
		for(Block i : blockList)
		{
			i.move();
		}
	}
	
	public int getHeight()
	{
		int i= blockList.get(0).dy;
		return i;
	}
	
	public int getVelocity()
	{
		return blockList.get(0).getVelocity();
	}


}
