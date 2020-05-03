package com.mygame;

import com.almasb.fxgl.entity.EntityFactory;


import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.mygame.OsonType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import com.components.PlayerComponent;
import com.mygame.Osonapp;

public class OsonFactory implements EntityFactory{
	
	@Spawns("Player")
	public Entity newPlayer(SpawnData data) {
		return FXGL.entityBuilder()
				.type(OsonType.PLAYER)
				.from(data)
				.viewWithBBox(new Rectangle(Osonapp.TILE_SIZE, Osonapp.TILE_SIZE, Color.BLUE))
				.with(new PlayerComponent())
				.build();
	}
	
	@Spawns("BG")
	public Entity newBackground(SpawnData data) {
		return FXGL.entityBuilder()
				.at(0,0)
				.view(new Rectangle(600, 600, Color.LIGHTGREEN))
				.zIndex(-1)
				.build();
	}
}
