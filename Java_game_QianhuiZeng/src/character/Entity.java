package character;
import java.awt.image.BufferedImage;
import java.awt.*;

public class Entity {
	
	public int worldX,worldY;
	
	
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, left1,left2,right1,right2;
	public String direction;
	
	public int character_counter = 0;
	public int run_num = 1;
	
	public Rectangle solidArea;
	
	//Use invisible rectangle to detect collision, check if collision or not
	
	public boolean collision1 = false;
	
	//new variable to check for collision with the objects
	public int solidAreaDefaultX, solidAreaDefaultY;
	
}
