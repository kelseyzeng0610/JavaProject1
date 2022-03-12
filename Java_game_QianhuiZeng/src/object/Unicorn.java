
package object;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Unicorn extends superObject {
	
	public Unicorn() {
		
		name = "Unicorn";
		
		try {
			
			image = ImageIO.read( getClass().getResourceAsStream("/object/unicorn.png"));
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
				
			}
			
		}
	}
