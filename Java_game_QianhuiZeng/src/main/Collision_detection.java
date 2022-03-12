package main;

import character.Entity;

public class Collision_detection {

	GamePanel gp;
	
	public Collision_detection ( GamePanel gp) {
	
		this.gp= gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX / gp.tileSize;
	    int entityRightCol = entityRightWorldX / gp.tileSize;
	    
	    int entityTopRow = entityTopWorldY/gp.tileSize;
	    int entityBottomRow = entityBottomWorldY/gp.tileSize;
	    
	    int testNum1, testNum2;
	    
	    //predict where the player will be, and check if that posiiton is 
	    //collide with a solid Area
	    switch(entity.direction) {
	    	case "up" :
	    		entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
	    		testNum1 = gp.tile1.mapTileNum[entityLeftCol][entityTopRow];
	    		testNum2 = gp.tile1.mapTileNum[entityRightCol][entityTopRow];
	    		if(gp.tile1.tile[testNum1].collision == true|| gp.tile1.tile[testNum2].collision == true ) {
	    			entity.collision1 =true;    			
	    			
	    		}
	    		break;
	    	case "down" :
	    		entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
	    		testNum1 = gp.tile1.mapTileNum[entityLeftCol][entityBottomRow];
	    		testNum2 = gp.tile1.mapTileNum[entityRightCol][entityBottomRow];
	    		if(gp.tile1.tile[testNum1].collision == true || gp.tile1.tile[testNum2].collision == true ) {
	    			entity.collision1 =true; 
	    		}
	    		break;
	    	case "left" :
	    		entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
	    		testNum1 = gp.tile1.mapTileNum[entityLeftCol][entityTopRow];
	    		testNum2 = gp.tile1.mapTileNum[entityLeftCol][entityBottomRow];
	    		if(gp.tile1.tile[testNum1].collision == true|| gp.tile1.tile[testNum2].collision == true) {
	    			entity.collision1 =true; 
	    		}
		    	break;
	    	case "right" :
	    		entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
	    		testNum1 = gp.tile1.mapTileNum[entityRightCol][entityTopRow];
	    		testNum2 = gp.tile1.mapTileNum[entityRightCol][entityBottomRow];
	    		if(gp.tile1.tile[testNum1].collision || gp.tile1.tile[testNum2].collision ) {
	    			entity.collision1 =true; 
	    		}
		    	break;
	    }
	}
	
	//check for object collision
	public int checkObject ( Entity entity,  boolean player) {
		//check if player is collided with a specific object( marked by index)
		//and return the index to its according effect
		int index = 999;
		
		for( int i = 0; i < gp.object.length;  i++) {
			if(gp.object[i] != null) {
				//get entity's solid Area position(player)
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				//get the object's solid area position
				gp.object[i].solidArea.x = gp.object[i].worldX + gp.object[i].solidArea.x;
				gp.object[i].solidArea.y = gp.object[i].worldY + gp.object[i].solidArea.y;
				
				switch(entity.direction) {
					case "up":
						entity.solidArea.y -= entity.speed;
						if(entity.solidArea.intersects(gp.object[i].solidArea)) {
							if(gp.object[i].collision == true) {
							entity.collision1 = true;
						}
						if(player == true) {
							index = i;
						}
						}
						break;
						
					case "down":
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(gp.object[i].solidArea)) {
							if(gp.object[i].collision == true) {
						
							entity.collision1 = true;
						}
						if(player == true) {
							index = i;
						}
						}
						break;
					case "left":
						entity.solidArea.x -= entity.speed;
						if(entity.solidArea.intersects(gp.object[i].solidArea)) {
							if(gp.object[i].collision == true) {
							entity.collision1 = true;
						}
						if(player == true) {
							index = i;
						}
						}
						break;
					case "right":
						entity.solidArea.x += entity.speed;
						if(entity.solidArea.intersects(gp.object[i].solidArea)) {
							if(gp.object[i].collision == true) {
							entity.collision1 = true;
						}
						if(player == true) {
							index = i;
						}
						}
						break;					
					
				}
				//set it back to the original
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.object[i].solidArea.x = gp.object[i].solidAreaDefaultX;
				gp.object[i].solidArea.y = gp.object[i].solidAreaDefaultY;
				
				
			}
		}
		
		return index;
		
	}

}
