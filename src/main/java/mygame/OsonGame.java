package mygame;

import  com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class OsonGame extends GameApplication{

	public static void main(String[] args) {
		launch(args);

	}
	
	protected void initSettings(GameSettings gameSettings) {
	    gameSettings.setWidth(800);
	    gameSettings.setHeight(600);
	    gameSettings.setTitle("Basic Game App");
	}

}
