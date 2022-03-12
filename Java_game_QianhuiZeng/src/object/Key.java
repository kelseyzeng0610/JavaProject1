package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Key extends superObject {
	
	public Key() {
		
		name = "Key";
		
		try {
			
			image = ImageIO.read( getClass().getResourceAsStream("/object/key.png"));
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
				
			}
			
		}
	}
	 

