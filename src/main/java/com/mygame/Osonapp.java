package com.mygame;


import  com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;

import com.components.PlayerComponent;
import javafx.scene.input.KeyCode;
import static com.almasb.fxgl.dsl.FXGL.*;
import com.mygame.OsonFactory;

public class Osonapp extends GameApplication{

	public static final int TILE_SIZE = 20;
	private Entity player;
	private enum Type {
        PLAYER, ENEMY
    }
	private PlayerComponent playerComponent;
	
	public static void main(String[] args) {
		launch(args);

	}
	
	protected void initSettings(GameSettings gameSettings) {
	    gameSettings.setWidth(600);
	    gameSettings.setHeight(600);
	    gameSettings.setTitle("Oson Game");
	    gameSettings.setVersion("0.1");
	}

	@Override
	protected void initGame() {
	    /*
		player = FXGL.entityBuilder()
	    		.type(Type.PLAYER)
	            .at(300, 300).view(new Rectangle(25,25, Color.BLUEVIOLET))
	            .buildAndAttach();
	    */
		
	    getGameWorld().addEntityFactory(new OsonFactory());
	    getGameWorld().spawn("BG");
	    player = getGameWorld().spawn("Player");
	    playerComponent = player.getComponent(PlayerComponent.class);
	    
	}
	
	@Override
    protected void initInput() {
		
        
        Input input = FXGL.getInput();
        
        getInput().addAction(new UserAction("Up") {
            @Override
            protected void onActionBegin() {
                System.out.println("Action Begin  Up");
                playerComponent.moveUp();
            }

        }, KeyCode.W);

        getInput().addAction(new UserAction("Down") {
            @Override
            protected void onActionBegin() {
                System.out.println("Action Begin Down");
                playerComponent.moveDown();
            }

        }, KeyCode.S);
        
       
        
        getInput().addAction(new UserAction("Left") {
       	 @Override
            protected void onActionBegin() {
                System.out.println("Action Begin Left");
                playerComponent.moveLeft();
            }

       }, KeyCode.A);
       
        getInput().addAction(new UserAction("Right") {
       	 @Override
            protected void onActionBegin() {
                System.out.println("Action Begin Right");
                playerComponent.moveRight();
            }

       }, KeyCode.D);
        
       
        
    }

}
