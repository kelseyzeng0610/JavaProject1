package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import character.Player;
import object.superObject;
import tiles.TileManager;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
	
	//Screen setting
	final int oringinalTileSize = 16;
    final int scale = 3;
    
    public final int tileSize = oringinalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    
    //World map parameter
    
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth =  maxWorldCol * tileSize;
    public final int worldHeight = maxWorldRow * tileSize;
    
    //create a key handler for the game
    KeyHandle key_handle = new KeyHandle();
    Thread gameThread;
   
    
    int FPS = 60;
    //create a tile drawing machine for the game
    TileManager tile1 = new TileManager(this);
    
    //create an collision checker machine for the game
    public Collision_detection cDetection = new Collision_detection(this);
    //create player
    public Player player = new Player(this,key_handle);
    
    //create at max 10 object for the game
    public superObject object[] = new superObject[15];
    
    //create an object called that place objects on the map
    objectPlacement obj_placer = new objectPlacement(this);
    //sound class
    sound sound1 = new sound();
    //Uese Interface class
    public UI ui = new UI(this);
    
    
    public GamePanel() {
    	this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    	this.setBackground(Color.black);
    	this.setDoubleBuffered(true);
    	this.addKeyListener(key_handle);
    	this.setFocusable(true);
    	
    }
    
    
    public void startGameThread() {
    	gameThread = new Thread(this);
    	gameThread.start();
    	
    }

	@Override
	public void run() {
		
		// draw once every 0.0166 secs
		double interval = 1000000000/FPS;
		double next_draw_time = System.nanoTime() + interval;
		
		 
		while(gameThread != null) {
			
	
			//update character position
			
			update();
			
			//draw updated information
			repaint();
			
			
			try {
				double remaining_time = next_draw_time - System.nanoTime();
				//convert nanoseconds to milliseconds for the sleep method			
				remaining_time = remaining_time / 1000000;
				
				//test for corner case, that if there's no time remain
				if(remaining_time < 0) {
					remaining_time = 0;
				}
				Thread.sleep((long) remaining_time);
				
				next_draw_time += interval;
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		
		
	}
	
	//call object placer
	
	public  void SetGame() {
		obj_placer.setObject();
		playSound(0);
	}
	//change player position
	public void update() {
		player.update();
	}
		
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//draw tile
		tile1.draw(g2);
		
		//call object draw function, need to use a for loop to iterate
		//through the object list
			
		for( int i = 0; i < object.length; i++) {
			if(object[i] != null) {
				object[i].draw(g2,this);
			}
		}
		//draw player
		player.draw(g2);
		
		//draw UI
		ui.draw(g2);
		
		
		g2.dispose();
		
			
		
	}
	public void playSound(int i ) {
		
		sound1.setFile(i);
		sound1.play();
		sound1.loop();
		
	}
	public void stopMusic() {
		sound1.stop();
		
	}
	//sound effect
	public void playSE(int i) {
		sound1.setFile(i);
		sound1.play();
		
	}
	

}
