package com.ep.moonshooter.worlds;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ep.moonshooter.actors.Foreground;
import com.ep.moonshooter.actors.SpaceShip;
/**
 * A prototype game level
 * TODO: consider this architecture: World has levels. And the level holds
 * all actors.
 */
public class World_1 {

	private SpaceShip spaceShip;
	private Array<Foreground> foreground = new Array<Foreground>();


	public World_1() {
		createDemoWorld();
	}

	private void createDemoWorld() {
		spaceShip = new SpaceShip(new Vector2(0.4f, 4));
		
		// two bottom lines represent for now the planet on which the ship is flying
		for (int i = 0; i < 10; i++) {
			foreground.add(new Foreground(new Vector2(i, 0)));
			if(i % 3 == 0) 
				foreground.add(new Foreground(new Vector2(i, 1)));
		}
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}
	
	public Array<Foreground> getForeground() {
		return foreground;
	}

}
