package com.ep.moonshooter.worlds;

import com.badlogic.gdx.math.Vector2;
import com.ep.moonshooter.actors.SpaceShip;
/**
 * A prototype game level
 *
 */
public class World_1 {

	private SpaceShip spaceShip;

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public World_1() {
		createDemoWorld();
	}

	private void createDemoWorld() {
		spaceShip = new SpaceShip(new Vector2(7, 2));		
	}
}
