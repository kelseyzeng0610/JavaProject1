package character;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandle;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandle key_handle;
	
	public final int screenX;
	public final int screenY;
	public int hasKey;
	


	public Player (GamePanel gp, KeyHandle key_handle) {
		
		this.gp = gp;
		this.key_handle = key_handle;
		//need to subtract a value bc the figure is not in centre
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle(8,16,32,32);
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		//set default value
		setDefault(); 
		getPlayerImage();
		
		
		
	} 
	//set default values for players
	public void setDefault() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "up";
		
	}
	
	public void getPlayerImage() {
		//read the image 
		try  {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		
		
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(key_handle.upPressed == true || key_handle.downPressed == true || key_handle.leftPressed == true || key_handle.rightPressed == true) {
		if(key_handle.upPressed == true) {
			direction = "up";
		}
		else if(key_handle.downPressed == true) {
			direction = "down";
		}
		else if(key_handle.leftPressed == true) {
			direction = "left";
		}
		else if(key_handle.rightPressed == true) {
			direction = "right";	
		}
		collision1 = false;
		gp.cDetection.checkTile(this);
		
		
		int ObjectIndex = gp.cDetection.checkObject(this, true);
		pickUpObject(ObjectIndex);
		//if collision1 is true, user cannot move
		if(collision1 ==false) {
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY  += speed;
				break;
			case "left":
				worldX  -= speed;
				break;
			case "right":
				worldX  += speed;
				break;
			}						
		}
				
		character_counter++;
		
		if(character_counter > 13) {
			if(run_num == 1) {
				run_num = 2;
			}
			else if (run_num == 2) {
				run_num = 1;
			}
			character_counter = 0;
		}
	}
	}
	public void pickUpObject (int i ) {
		if(i != 999) {
			String objectName = gp.object[i].name;
			
			switch(objectName) {
			case "Key" :
				gp.playSE(1);
				hasKey++;
				gp.object[i] = null;
				gp.ui.showMessage("You got a key!");
				
				break;
			case "Door":		
				if(hasKey > 0) {
					gp.playSE(3);
					gp.object[i] = null;
					hasKey--;	
					gp.ui.showMessage("You open a door!");
				}
				else {
					gp.ui.showMessage("you need a key to open this door!");
				}
				
				break;
			
			case "Boot":
				gp.playSE(2);
				speed +=2;
				gp.object[i] =null;
				gp.ui.showMessage("speed up!");
				break;
			case "Chest":
				gp.ui.game_end = true;
				gp.stopMusic();
				gp.playSE(9);
				break;
				
				
			}
		}
	}
	public void draw(Graphics2D g2) {	
	
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(run_num == 1) {
				image = up1;
			}
			if(run_num == 2) {
				image = up2;
			} 
			break;
		case "down":
			if(run_num == 1) {
				image = down1;
			}
			if(run_num == 2 ) {
				image = down2;	
			}	
			break;
		case "left":
			if(run_num == 1) {
				image = left1;
			}
			if(run_num == 2) {
				image = left2; 
			}
			break;
		case "right":
			if(run_num == 1) {
				image =  right1;
			}
			if(run_num == 2) {
				image = right2;
			}
			break;		
			
		}
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
		
		
		
		
	}
}
