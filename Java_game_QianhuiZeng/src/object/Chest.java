package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Chest extends superObject {
	
	public Chest() {
		
		name = "Chest";
		
		try {
			
			image = ImageIO.read( getClass().getResourceAsStream("/object/chest.png"));
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
				
			}
			
		}
	}
