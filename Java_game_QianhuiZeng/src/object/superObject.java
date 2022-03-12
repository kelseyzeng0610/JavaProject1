package object;

import java.awt.*;
import java.awt.image.*;

import main.GamePanel;
public class superObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	//create a rectangle for collision 
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	
	
	//draw the image to the map
	public void draw(Graphics2D g2, GamePanel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY  - gp.tileSize< gp.player.worldY + gp.player.screenY) {
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
		}
		
		
	}
	
	

}
