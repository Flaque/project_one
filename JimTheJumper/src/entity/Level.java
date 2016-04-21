/**
 * An array of platforms that comprise a level
 * 
 * @Author: Max Baker
 * @LastModified: 4/14/16
 *  */
package entity;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics2D;

import entity.Platform;

public class Level {
	int levelLength;
	ArrayList<Platform> platformList= new ArrayList<Platform>();
	int progress=-5;
	int height=600;
	int jumpProgress=0;
	int dy=0;
	int currentPlatform=1;
	
	/**
	 * Add the start platform and adds platforms equal to the size
	 * parameter.
	 * 
	 * @param size: The number of platforms in the level to begin with,
	 * not counting the start platform
	 */
	public Level(int size){
		Platform startPlatform= new Platform(new Point(0,height), 20);
		platformList.add(startPlatform);
		initializePlatformList(size);
	}
	
	/**
	 * Adds platforms equal to the size parameter, makes holes in them and 
	 * adds them to the platform list.  Platforms are added every 100 pixels
	 * 
	 * @param size: the number of platforms to be added
	 */
	public void initializePlatformList(int size){
		for(int i=0; i<size; i++)
		{
			height-=100;
			Platform myPlatform= new Platform(new Point(0,height), 20);
	        myPlatform.makeHole();
	        platformList.add(myPlatform);
		}
	}
	
	/**
	 * Draws each platform
	 * 
	 * @param g2d: the graphics object
	 * @param myPanel: The game panel
	 */
	public void drawLevel(Graphics2D g2d, JPanel myPanel){
		for(Platform i : platformList)
		{
			i.drawBlocks(g2d, myPanel);
		}
	}
	
	/**
	 * Force is applied to each block in the level
	 * 
	 * @param force: the amount of force being added to
	 * each block
	 */
	public void applyUpwardForce(int force){
		for(Platform i : platformList)
		{
			i.applyUpwardForce(force);
		}
	}
	
	/**
	 * Changes the position of the level by the dx and dy variables.  If the player has 
	 * traveled up one platform since the last jump, jump end will be called.
	 * 
	 * @param myPlayer: the player
	 */
	public boolean move(Player myPlayer){
		for(Platform i : platformList)
			i.move();
		jumpProgress+=dy;
		if(jumpProgress==40){
			//gets the platform over head
			Platform p = platformList.get(currentPlatform-1);
			//returns true if player has collided; false otherwise
			return p.checkCollision(myPlayer);
		}
		if(jumpProgress==100)
			this.jumpEnd(myPlayer);
		return false;
	}
	//public boolean jump(Player myPlayer)
	//{   
	//}
	
	/**
	 * Stops the upward velocity of the player. Fills in the platform that was jumped over
	 * re-enables the jump, and makes the player move in the direction of the next hole.
	 * 
	 * @param myPlayer:the Player
	 */
	public void jumpEnd(Player myPlayer){
		this.applyUpwardForce(-1*dy);
		dy=0;
		height+=100;
		platformList.get(currentPlatform-1).fillHole();
		jumpProgress=0;
		int holeLocation=(platformList.get(currentPlatform).getHoleLocation());
		myPlayer.pickDirection(holeLocation);
		if(progress==1)
		{
			this.platformRefresh();	
		}
	}
	
	/**
	 * Only runs if the player is not currently jumping.  Makes the level travel downward
	 * every ten jumps, it adds more platforms to the top
	 */
	public void jump(Player myPlayer)
	{         
		if(jumpProgress==0)
		{
			currentPlatform++;
			this.applyUpwardForce(5);
			dy = platformList.get(0).getVelocity();
			progress++;
		}
	}
	
	/**
	 * Currently doesn't work, should add more platforms to the top and removes them from the bottom.
	 */
	public void platformRefresh(){
		progress=0;
		height-=100;
		Platform myPlatform= new Platform(new Point(0,height),20);
		myPlatform.makeHole();
		myPlatform.stop();
		platformList.add(myPlatform);
	}
}