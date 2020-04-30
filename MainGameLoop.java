package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {
	

	public static void main(String[] args) {
		
		DisplayManager.createDysplay();
		
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		  float[] vertices = {
				  // first triangle :
				    -0.5f, 0.5f, 0,  //v0
				    -0.5f, -0.5f, 0, //v1
				    0.5f, -0.5f, 0,  //v2
				    0.5f, 0.5f, 0,  //v3
				  };
		  
		  int[] indices = {
			0,1,3,   // Top left triangle (V0,V1,V3)
			3,1,2,   // Bottom right triangle (V3,V1,V2)
		  };
		  
		  RawModel model = loader.loadToVAO(vertices,indices);
		
		while (!Display.isCloseRequested()) {
			renderer.prepare();
			//game logic
			renderer.render(model);
			DisplayManager.updateDysplay();
			
		}
		
		loader.cleanUp();
		DisplayManager.closeDysplay();

	}

}
