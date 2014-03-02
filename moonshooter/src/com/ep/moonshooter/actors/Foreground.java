package com.ep.moonshooter.actors;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
/**
 * @author Patrick
 *
 */
public class Foreground {
	
	static final float SIZE = 1f;
	private float speed = 2; 
	
	private Rectangle bounds   = new Rectangle();
	private Vector2   position = new Vector2();
	private Vector2   velocity = new Vector2();
	
	
	/**
	 * @param pos is the position where the block takes place in the world
	 */
	public Foreground(Vector2 pos) {
		this.position = pos;
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	
	public void update(float delta) {
		Vector2 distance = velocity.cpy().scl(delta);
		position.add(distance);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}

	public Vector2 getVelocity() {
		return velocity;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
