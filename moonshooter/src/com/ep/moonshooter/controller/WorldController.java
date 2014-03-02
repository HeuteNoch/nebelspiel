package com.ep.moonshooter.controller;

import java.util.ArrayList;

import com.badlogic.gdx.utils.Array;
import com.ep.moonshooter.actors.Background;
import com.ep.moonshooter.actors.Enemy;
import com.ep.moonshooter.actors.Foreground;
import com.ep.moonshooter.worlds.World_1;

public class WorldController {

	private World_1 world;
	
	private Array<Foreground> foregrounds;
	private Background background;
	private ArrayList<Enemy> enemies;

	public WorldController(World_1 world) {
		this.world = world;
		this.foregrounds = world.getForeground();
		this.background = world.getBackground();
		this.enemies = world.getEnemies(false);
	}

	/** The main update method **/
	public void update(float delta) {
		processForeground();
		processBackground();
		processEnemies();
		
		for (Foreground f : foregrounds) {
			f.update(delta);
		}
		
		for (Enemy e : enemies) {
			e.update(delta);
		}
		
		background.update(delta);
	}
	
	private void processEnemies() {
		boolean enemySquadPassed = true;
		for (Enemy e : enemies) {
			e.getVelocity().x = -e.getSpeed();
			enemySquadPassed = (e.getPosition().x < 0) && enemySquadPassed;
		}
		if (enemySquadPassed)
			this.enemies = world.getEnemies(true);
			
	}
	
	private void processBackground() {
		background.getVelocity().x = -background.getSpeed();
	}
	
	private void processForeground() {
		for (Foreground f : foregrounds) {
			f.getVelocity().x = -f.getSpeed();	
		}
		
	}


}
