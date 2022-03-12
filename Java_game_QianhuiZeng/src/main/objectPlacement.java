package main;

import object.Boot;
import object.Chest;
import object.Door;
import object.Key;
import object.superObject;
import object.Unicorn;

public class objectPlacement {
	GamePanel gp;
	
	public objectPlacement(GamePanel gp) {
		this.gp = gp;
		
		
	}
	
	public void setObject() {
		//place one key
		gp.object[0] = new Key();
		gp.object[0].worldX = 23 * gp.tileSize;
		gp.object[0].worldY = 7 * gp.tileSize;
		
		//place one key
		gp.object[1] = new Key();
		gp.object[1].worldX = 23 * gp.tileSize;
		gp.object[1].worldY = 40 * gp.tileSize;
		
		//place one key
	    gp.object[2] = new Key();
		gp.object[2].worldX = 38 * gp.tileSize;
		gp.object[2].worldY = 8 * gp.tileSize;
		
		
		gp.object[3] = new Door();
		gp.object[3].worldX = 10 * gp.tileSize;
		gp.object[3].worldY = 11 * gp.tileSize;
		
		gp.object[4] = new Door();
		gp.object[4].worldX = 8 * gp.tileSize;
		gp.object[4].worldY = 28 * gp.tileSize;
		
		gp.object[5] = new Door();
		gp.object[5].worldX = 12 * gp.tileSize;
		gp.object[5].worldY = 22 * gp.tileSize;
		
		gp.object[5] = new Chest();
		gp.object[5].worldX = 10 * gp.tileSize;
		gp.object[5].worldY = 7 * gp.tileSize;
		
		
		gp.object[6] = new Boot();
		gp.object[6].worldX = 37 * gp.tileSize;
		gp.object[6].worldY = 42 * gp.tileSize;
		
		gp.object[7] = new Unicorn();
		gp.object[7].worldX = 35 * gp.tileSize;
		gp.object[7].worldY = 42 * gp.tileSize;
		
		
		
	}
	

}
