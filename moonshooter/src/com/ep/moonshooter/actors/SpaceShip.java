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

	private final float SPEED   = 2f;
	private final float SIZE_X  = 1.f;
	private final float SIZE_Y  = 0.5f;
	
	// define the attributes of Spaceship. The values of these attributes define
	// Spaceship’s state at any given time.
	private Vector2 position 	 = new Vector2();
	private Vector2 acceleration = new Vector2();
	private Vector2 velocity     = new Vector2();
	private Rectangle bounds     = new Rectangle(); // for collision
	private State state          = State.FYLING;

	public SpaceShip(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE_Y;
		this.bounds.width = SIZE_X;
	}
	
	public Rectangle getBounds(){
		return this.bounds;
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
}
