package com.ep.moonshooter.actors;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
/**
 * @author Patrick
 *
 */
public class Foreground {
	
	static final float SIZE = 1.18f;
	
	private Vector2 	position = new Vector2();
	private Rectangle 	bounds   = new Rectangle();
	private Vector2 	velocity = new Vector2();
	
	private float speed = 2; 
	
	/**
	 * @param pos is the position where the block takes place in the world
	 */
	public Foreground(Vector2 pos) {
		this.setPosition(pos);
		this.getBounds().width = SIZE;
		this.getBounds().height = SIZE;
	}
	
	public void update(float delta) {
		Vector2 distance = velocity.cpy().scl(delta);
		position.add(distance);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
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
