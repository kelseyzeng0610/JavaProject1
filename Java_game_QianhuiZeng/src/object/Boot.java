package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Boot extends superObject {
	
	public Boot() {
		
		name = "Boot";
		
		try {
			
			image = ImageIO.read( getClass().getResourceAsStream("/object/boots.png"));
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
				
			}
		collision = true;
			
		}
	}