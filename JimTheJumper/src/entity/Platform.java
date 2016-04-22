package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import entity.Block;
import ui.GamePanel;

import java.util.*;

import javax.swing.JPanel;

public class Platform {
	ArrayList<Block> blockList= new ArrayList<Block>();
	int midHoleIndex;
	int midHoleLocation;
	int height;
	int blockSize;
	
	public Platform(Point location, int width)
	{
		for(int i=width; i>0; i--)
		{
			Block block= new Block(location);
			location.x+=block.getSize();
			blockList.add(block);
			height=location.y;
			blockSize=block.getSize();
		}
	}
	
	public void makeHole(int avoid)
	{
		Random Rand= new Random();
		int i=Rand.nextInt(blockList.size()-2);
		while(!((i+1)-avoid < -2 || (i+1)-avoid > 2))
			i=Rand.nextInt(blockList.size()-2);
		midHoleLocation=(i+1)*blockSize;
		blockList.remove(i+2);
		blockList.remove(i+1);
		blockList.remove(i);
		midHoleIndex=i+1;
	}
	
	public int getHoleIndex()
	{
		return midHoleIndex;
	}
	
	public int getHoleLocation()
	{
		return midHoleLocation;
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
	
	public void fillHole()
	{
		blockList.add(new Block(new Point((midHoleIndex-1)*blockSize,600)));
		blockList.add(new Block(new Point((midHoleIndex)*blockSize,600)));
		blockList.add(new Block(new Point((midHoleIndex+1)*blockSize,600)));
	}
	//returns true is the player has collided with one of the blocks
	public boolean checkCollision(Player p){
		for(Block b : blockList)
		{
			//checks whether left side of player is within a block
			boolean leftSide = b.getX() < p.getX() && b.getX()+b.getSize() >= p.getX();
			//checks whether right side of player is within a block
			boolean rightSide = b.getX()+b.getSize() > p.getX()+40 && b.getX() <= p.getX()+40;
			if(leftSide || rightSide){
				return true;
			}
		}
		return false;
	}
	public void stop(){
		
		for(Block i : blockList)
		{
			i.stop();
		}
		
	}
}
