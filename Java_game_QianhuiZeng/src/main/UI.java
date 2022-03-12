package main;

import java.awt.*;
import java.awt.image.*;
import java.text.DecimalFormat;

import object.Key;

//user interface
public class UI {
	GamePanel gp;
	Font arial_40;
	Font arial_80;
	BufferedImage keyImage;
	public boolean message = false;
	public String message_notif = ""; 
	public int message_counter = 0;
	public boolean game_end = false;
	public double playTime;
	DecimalFormat dformat = new DecimalFormat("#0.00");
	

	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial",Font.PLAIN,40);
		arial_80 = new Font("Arial",Font.BOLD,80);
		Key key = new Key();
		keyImage = key.image;
	}
	
	public void showMessage(String text) {
		message_notif = text;
		message = true;
		
	}
	public void draw(Graphics2D g2) {
		if(game_end == true) {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		String text;
		int textlength;
		int x;
		int y;
		text =" You found the treasure in "+dformat.format(playTime) + "!";
		textlength = (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();	
			//display coordinate
			x = gp.screenWidth/2 - textlength/2;
		    y = gp.screenHeight/2 - gp.tileSize * 3;
		    g2.drawString(text, x, y);
			
		    
		    g2.setFont(arial_80);
		    g2.setColor(Color.yellow);
		    text = "Congratulations!";
			textlength = (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();	
			//display coordinate
			x = gp.screenWidth/2- textlength/2;
		    y = gp.screenHeight/2 + gp.tileSize * 2;
		    g2.drawString(text, x, y);
		    
		    //stop the gamethread
		    gp.gameThread = null;
			
		}
		else {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
		g2.drawString("=" + gp.player.hasKey,74,65);
		
		//show time 
		playTime += (double)1/60;
		g2.drawString("Time:" + dformat.format(playTime),gp.tileSize*11,65);
		
		//draw message
		if(message == true) {
			
			g2.setFont(g2.getFont().deriveFont(30F));
			g2.drawString(message_notif,gp.tileSize/2,gp.tileSize *5);
			message_counter ++;
			if(message_counter > 120) {
				message_counter = 0;
				message = false;	
			}
		}
		 
		}
	}

	
}
