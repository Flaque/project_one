package entity;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics2D;

import entity.Platform;

public class Level {
	int levelLength;
	ArrayList<Platform> platformList= new ArrayList();
	int progress;
	
	
	public Level(int size)
	{
		levelLength=size;
		for(int i=0; i<levelLength; i++)
		{
			Platform myPlatform= new Platform(new Point(0,500-(i*100)), 20);
	        myPlatform.makeHole();
	        platformList.add(myPlatform);
		}
		
	}
	
	public void drawLevel(Graphics2D g2d, JPanel myPanel)
	{
		for(Platform i : platformList)
		{
			i.drawBlocks(g2d, myPanel);
		}
	}
	
	public void applyUpwardForce(int force)
	{
		for(Platform i : platformList)
		{
			i.applyUpwardForce(force);
		}
	}
	
	
	public void move()
	{
			for(Platform i : platformList)
			{
				i.move();
			}

	}
	
	public void jump()
	{
		this.applyUpwardForce(1);
		progress++;
		
		
	}

}
