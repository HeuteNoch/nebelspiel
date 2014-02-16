package com.ep.moonshooter.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Then main space ship ;)
 */
public class SpaceShip {

	public enum State {
		FYLING, SHOOTING, IDLING, DYING
	}

	private float speed   = 2f;
	private float SIZE_X  = 1.f;
	private float SIZE_Y  = 0.5f;
	
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

	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
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

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	
}
