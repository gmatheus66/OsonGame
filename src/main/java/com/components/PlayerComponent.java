package com.components;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import com.almasb.fxgl.core.util.LazyValue;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.almasb.fxgl.entity.components.TypeComponent;
import static com.almasb.fxgl.dsl.FXGL.*;
import com.mygame.Osonapp;



public class PlayerComponent extends Component{
	
	private TransformComponent position;
	
	public void moveRight() {
		if(canMove(new Point2D(10,0)))
			position.translateX(Osonapp.TILE_SIZE);
	}
	
	public void moveLeft() {
		if(canMove(new Point2D(-10, 0)))
			position.translateX(-Osonapp.TILE_SIZE);
	}
	public void moveUp() {
		if(canMove(new Point2D(0, -10)))
			position.translateY(-Osonapp.TILE_SIZE);
	}
	public void moveDown() {
		if(canMove(new Point2D(0, 10)))
			position.translateY(Osonapp.TILE_SIZE);
	}
	
	private boolean canMove(Point2D direction) {
		Point2D newPosition = position.getPosition().add(direction);
		return FXGL.getGameScene()
				.getViewport()
				.getVisibleArea()
				.contains(newPosition);
	}
		
	 @Override
	    public void onAdded() {
	        entity.getTransformComponent().setScaleOrigin(entity.getCenter());
	    }


	 
	
}
