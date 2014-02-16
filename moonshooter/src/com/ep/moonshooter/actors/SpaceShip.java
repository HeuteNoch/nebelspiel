package com.ep.moonshooter.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Then main space ship ;)
 */
public class SpaceShip {

	public enum State {
		FYLING, SHOOTING, DYING
	}

	static final float SPEED         = 2f;
	static final float SIZE          = 0.5f;

	// define the attributes of Spaceship. The values of these attributes define
	// Spaceship’s state at any given time.
	// TODO: getters and setters?
	Vector2 position 	 = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity     = new Vector2();
	Rectangle bounds     = new Rectangle(); // for collision
	State state          = State.FYLING;

	public SpaceShip(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}
	
	public Rectangle getBounds(){
		return this.bounds;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
}
