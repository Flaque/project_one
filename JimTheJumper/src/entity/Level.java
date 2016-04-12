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
	int currentPlatform=1;
	Platform mostRecent;
	
	public Level(int size)
	{
		levelLength=size;
		Platform startPlatform= new Platform(new Point(0,height), 20);
		platformList.add(startPlatform);
		for(int i=0; i<levelLength; i++)
		{
			height-=100;
			Platform myPlatform= new Platform(new Point(0,height), 20);
	        myPlatform.makeHole();
	        platformList.add(myPlatform);
	        mostRecent=myPlatform;
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
			System.out.println(currentPlatform);
			this.applyUpwardForce(-1*dy);
			dy=0;
			platformList.get(currentPlatform-1).fillHole();
			jumpProgress=0;
			//System.out.println("Player:"+ myPlayer.getX());
			//System.out.println("Hole:"+ (platformList.get(currentPlatform).getHoleIndex()));
			if(myPlayer.getX()<(platformList.get(currentPlatform).getHoleLocation()))
			{
				//System.out.println("right");
				myPlayer.moveRight();
			}
			
			if(myPlayer.getX()>(platformList.get(currentPlatform).getHoleLocation()))
			{
				//System.out.println("left");
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
				System.out.println("Ping");
				progress=0;
				currentPlatform-=10;
				for(int i=0; i<10;i++)
				{
					platformList.remove(0);
					Platform myPlatform= new Platform(new Point(0,platformList.get(23).getHeight()-100),20);
					myPlatform.makeHole();
					platformList.add(myPlatform);
					mostRecent=myPlatform;
					System.out.println(platformList.indexOf(myPlatform));
					
				}
				
			}
		}
	}

}
