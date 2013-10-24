import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import net.matt.entity.Map;
import net.matt.entity.SpriteManager;
import net.matt.mapdrawer.RoomStack;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class MainDisplay {
	
	public static int fillSize = 45;
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(800, 800));
			Display.setTitle("Matts Map Generator Demo");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		 
		SpriteManager manager = new SpriteManager(new Map(40, 40, fillSize));
		
		
		// init OpenGL here
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();glOrtho(0, 800, 800, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		System.out.println(RoomStack.rooms.size());
		
		while(!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			manager.draw();		
			pollInput(manager);
			
			Display.update();
			Display.sync(60);
		}
	
	}
	
	public static void main(String[] args) {
		MainDisplay mainDisplay = new MainDisplay();
		mainDisplay.start();
	}
	
	public void pollInput(SpriteManager manager){
		while(Keyboard.next())
			if(Keyboard.getEventKeyState()){
				if(Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) { System.exit(0); } 
				if(Keyboard.getEventKey() == Keyboard.KEY_Q) { System.exit(0); } }
			else if (Keyboard.getEventKey() == Keyboard.KEY_SPACE)
				manager.getNewMap(fillSize);
	}

}
