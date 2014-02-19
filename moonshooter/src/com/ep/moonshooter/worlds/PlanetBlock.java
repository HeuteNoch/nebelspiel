/**
 * 
 */
package com.ep.moonshooter.worlds;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
/**
 * @author Patrick
 *
 */


public class PlanetBlock {
	
	/**
	 * 
	 * @param pos is the position where the block takes place in the world
	 */
	public PlanetBlock(Vector2 pos) {
		this.setPosition(pos);
		this.getBounds().width = SIZE;
		this.getBounds().height = SIZE;
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

	static final float SIZE = 1.18f;

	private Vector2 	position = new Vector2();
	private Rectangle 	bounds = new Rectangle();



}
