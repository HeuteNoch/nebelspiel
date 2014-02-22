package com.ep.moonshooter.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Then main space ship ;)
 */
public class SpaceShip {

	/**
	 * enum of stats of the SpaceShip:
	 * FLYING --> idle
	 * FLYING_FF  = FLYING FAST FORWARD --> like, when the user hits the "right"-key
	 * FLYING_SL  = FLYING SLOW         --> "left"-key
	 * FLYING_UP  = FLYING UP           --> "up"-key
	 * FLYING_DWN = FLYING DOWN         --> "down"-key"
	 *
	 */
	public enum State {
		FLYING, FLYING_FF, FLYING_SL, FLYING_UP, FLYING_DWN,  SHOOTING, IDLING, DYING
	}

	private float speed   = 3f;
	private float size_X  = 0.8f;
	private float size_Y  = 0.4f;
	
	private Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();

	private Rectangle bounds = new Rectangle();
	
	private State     state  = State.FLYING;

	public SpaceShip(Vector2 position) {
		this.position      = position;
		this.bounds.width  = size_X;
		this.bounds.height = size_Y;
	}
	
	/**
	 * Returns the ships bounds. For rendering and collision handling.
	 * 
	 * @see getPosition()
	 * @return the actual bounds of the ship
	 */
	public Rectangle getBounds(){
		return this.bounds;
	}
	
	/**
	 * Returns the actual position of the ship. 
	 * For collision handling use the position and bounds of the ship
	 * 
	 * @return
	 */
	public Vector2 getPosition() {
		return this.position;
	}

	/**
	 * Updates the position from the space ship.
	 * 
	 * The velocity ("speed" vector) is first multiplied with the scalar delta.
	 * This extends or shortens the vector. The velocity is assigned by the direction of the ship. 
	 * Result is the "distance" the ship has moved in time delta.
	 * 
	 * The above result is added to the actual position of the space ship. 
	 * Result is the new position of the space ship.
	 * 
	 * @param delta time in seconds since last render.
	 */
	public void update(float delta) {
		Vector2 distance = velocity.cpy().scl(delta);
		position.add(distance);
	}

	public void setState(State state) {
		this.state = state;
	}

	public Vector2 getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
