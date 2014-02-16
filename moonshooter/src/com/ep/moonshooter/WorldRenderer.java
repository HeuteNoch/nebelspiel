package com.ep.moonshooter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.ep.moonshooter.actors.SpaceShip;
import com.ep.moonshooter.worlds.World_1;

/**
 * The WorldRenderer has only one purpose. To take the current state of the world
 * and render it to the screen. It has a single public render() method which gets 
 * called by the main loop (GameScreen). 
 * The renderer needs to have access to the world so we will pass it in when we 
 * instantiate the renderer. 
 *
 */
public class WorldRenderer {
	private World_1 world;
	private OrthographicCamera cam;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	// TODO: consider interface for Worlds, so different worlds / levels are easy to handle.
	public WorldRenderer(World_1 world) {
		this.world = world;
		this.cam = new OrthographicCamera(10, 7);
		this.cam.position.set(5, 3.5f, 0);
		this.cam.update();
	}

	public void render() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Line);

		// render Spaceship
		SpaceShip ship = world.getSpaceShip();
		Rectangle rectShip = ship.getBounds();
		float x1 = ship.getPosition().x + rectShip.x;
		float y1 = ship.getPosition().y + rectShip.y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rectShip.width, rectShip.height);
		debugRenderer.end();
	}
}
