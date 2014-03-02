package com.ep.moonshooter.worlds;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import com.ep.moonshooter.actors.Background;
import com.ep.moonshooter.actors.Enemy;
import com.ep.moonshooter.actors.Enemy.SIZE;
import com.ep.moonshooter.actors.Enemy.SPEED;
import com.ep.moonshooter.actors.Enemy.MOVEMENT;

import com.ep.moonshooter.actors.Foreground;
import com.ep.moonshooter.actors.SpaceShip;
/**
 * A prototype game level
 * TODO: consider this architecture: Game has worlds. Worlds has levels.
 * And the level holds all actors.
 */
public class World_1 {

	private SpaceShip spaceShip;
	private HashMap<String, ArrayList<Enemy>> enemies = new HashMap<String, ArrayList<Enemy>>();
	private Array<Foreground> foreground = new Array<Foreground>();
	private Background background;

	private String currentSquad = "SQUAD1";
	private boolean worldIsOver = false;

	public World_1() {
		createDemoWorld();
	}

	private void createDemoWorld() {
		spaceShip = new SpaceShip(new Vector2(0.4f, 4));
		background = new Background(new Vector2(0, 0));
		
		// two bottom lines represent for now the planet on which the ship is flying
		// TODO: only visible blocks should be considered in game
		for (int i = 0; i < 1000; i++) {
			foreground.add(new Foreground(new Vector2(i, 0)));
			if(i % 3 == 0) 
				foreground.add(new Foreground(new Vector2(i, (float) (Math.random() * 1)  )));
		}
		
		// TODO only visible enemies should be considered in game. This means
		// only update position for enemies actually in game.
		ArrayList<Enemy> enemySquad1 = new ArrayList<Enemy>();
		for(int i = 0; i < 10; i++) { // 11 means out of screen.
			Vector2 position = new Vector2(11 + (float) Math.random() * 10, (float) Math.random() * 6 + 0.2f);
			enemySquad1.add(new Enemy(position, MOVEMENT.STRAIGHT, SIZE.SMALL, SPEED.NORMAL));
		}
		enemies.put("SQUAD1", enemySquad1);
		
		ArrayList<Enemy> enemySquad2 = new ArrayList<Enemy>();
		for(int i = 0; i < 10; i++) { // 11 means out of screen.
			Vector2 position = new Vector2(11, (float) Math.random() * 6);/*Math.random() * 5 + 1)*/
			enemySquad2.add(new Enemy(position, MOVEMENT.STRAIGHT, SIZE.SMALL, SPEED.NORMAL));
		}
		enemies.put("SQUAD2", enemySquad2);
		
		ArrayList<Enemy> enemySquad3 = new ArrayList<Enemy>();
		for(int i = 0; i < 10; i++) { // 11 means out of screen.
			Vector2 position = new Vector2(11 + (float) Math.random() * 10, (float) Math.random() * 6 + 0.2f);
			enemySquad3.add(new Enemy(position, MOVEMENT.STRAIGHT, SIZE.SMALL, SPEED.NORMAL));
		}
		enemies.put("SQUAD3", enemySquad3);
	}

	public ArrayList<Enemy> getEnemies(boolean changeEnemies) {
		if (changeEnemies) { 
			if(enemies.size() > 1) {
				enemies.remove(currentSquad);
				currentSquad = enemies.keySet().iterator().next();
			}
			else {
				this.worldIsOver = true;
			};
		}
		return enemies.get(currentSquad);
	}
	
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}
	
	public Array<Foreground> getForeground() {
		return foreground;
	}

	public Background getBackground() {
		return background;
	}

	public boolean isOver() {
		return this.worldIsOver;
	}
}
