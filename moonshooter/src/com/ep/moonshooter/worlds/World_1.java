package com.ep.moonshooter.worlds;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ep.moonshooter.actors.SpaceShip;
/**
 * A prototype game level
 *
 */
public class World_1 {

	private SpaceShip spaceShip;
	private Array<PlanetBlock> blocks = new Array<PlanetBlock>();

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public World_1() {
		createDemoWorld();
	}

	private void createDemoWorld() {
		spaceShip = new SpaceShip(new Vector2(7, 2));
		
		// tow bottom lines represent for now the planet on which the ship is flying
		for (int i = 0; i < 10; i++) {
			getBlocks().add(new PlanetBlock(new Vector2(i, 0)));
			if(i % 3 == 0) getBlocks().add(new PlanetBlock(new Vector2(i, 1)));
		}
	}

	public Array<PlanetBlock> getBlocks() {
		return blocks;
	}

	public void setBlocks(Array<PlanetBlock> blocks) {
		this.blocks = blocks;
	}
}
