package com.ep.moonshooter.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Background {

	private Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();
	private Rectangle bounds   = new Rectangle();
	
	private float speed = 0.5f; 

	public Background(Vector2 pos) {
		this.position      = pos;
		this.bounds.height = 10;
		this.bounds.width  = 100;
	}

	public void update(float delta) {
		Vector2 distance = velocity.cpy().scl(delta);
		position.add(distance);
	}

	public Vector2 getVelocity() {
		return this.velocity;
	}

	public float getSpeed() {
		return this.speed;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
	
}
