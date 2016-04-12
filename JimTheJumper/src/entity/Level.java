package entity;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics2D;

import entity.Platform;

public class Level {
	int levelLength;
	ArrayList<Platform> platformList= new ArrayList();
	int progress=-5;
	int height=600;
	int jumpProgress=0;
	int dy=0;
	int currentPlatform=0;
	
	public Level(int size)
	{
		levelLength=size;
		for(int i=0; i<levelLength; i++)
		{
			height-=100;
			Platform myPlatform= new Platform(new Point(0,height), 20);
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
	
	
	public void move(Player myPlayer)
	{
			for(Platform i : platformList)
			{
				i.move();
				
			}
			jumpProgress+=dy;
			if(jumpProgress>=100)
			{
				this.applyUpwardForce(-1*dy);
				dy=0;
				jumpProgress=0;
				if(myPlayer.getX()<(platformList.get(currentPlatform+1).getHoleIndex())*10)
				{
					System.out.println("right");
					myPlayer.moveRight();
				}
				
				if(myPlayer.getX()>(platformList.get(currentPlatform+1).getHoleIndex())*10)
				{
					System.out.println("left");
					myPlayer.moveLeft();
				}
				
			}

	}
	
	public void jump()
	{
		
		if(jumpProgress==0)
		{
			currentPlatform++;
			this.applyUpwardForce(5);
			dy= platformList.get(0).getVelocity();
			progress++;
			if(progress==10)
			{
				progress=0;
				for(int i=0; i<10;i++)
				{
					platformList.remove(0);
					height-=100;
					Platform myPlatform=new Platform(new Point(0,height), 20);
					myPlatform.makeHole();
					platformList.add(myPlatform);
				}
			}
		}
		
	}

}
