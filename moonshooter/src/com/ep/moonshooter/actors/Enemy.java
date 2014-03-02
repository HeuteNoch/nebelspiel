package com.ep.moonshooter.actors;

import org.omg.CORBA.Bounds;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {

	private Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();

	private Rectangle bounds = new Rectangle();
	private float speed;

	private MOVEMENT movement;
	private SIZE size;

	public enum MOVEMENT {
		STRAIGHT, CIRCLE, UP_DOWM, DOWN_UP
	}

	public enum SIZE {
		TINY, SMALL, NORMAL, HUGE;
		
		public static Rectangle getSizeValue(SIZE size) {
			switch (size) {
			case TINY: // TODO change sizes
				return new Rectangle(0, 0, 0.5f, 0.5f);
			case SMALL:
				return new Rectangle(0, 0, 0.5f, 0.5f);
			case NORMAL:
				return new Rectangle(0, 0, 0.5f, 0.5f);
			case HUGE:
				return new Rectangle(0, 0, 0.5f, 0.5f);
			default:
				return new Rectangle(0, 0, 0.5f, 0.5f);
			}
		}
	}

	public enum SPEED {
		SLOW, NORMAL, FAST, CRAZY;

		public static int getSpeedValue(SPEED speed) {
			switch (speed) {
			case SLOW:
				return 1;
			case NORMAL:
				return 2;
			case FAST:
				return 3;
			case CRAZY:
				return 4;
			default:
				return 2;
			}
		}
	}

	// TODO also add possibility to set a formation 
	public Enemy(Vector2 position, MOVEMENT movement, SIZE size, SPEED speed ) {
		this.position = position;
		this.movement = movement;
		this.bounds = SIZE.getSizeValue(size);
		this.speed = SPEED.getSpeedValue(speed);
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

	public void setMovement(MOVEMENT movement) {

	}

	public void setSize(SIZE size) {
		this.size = size;
	}

}
