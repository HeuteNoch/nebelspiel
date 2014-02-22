package com.ep.moonshooter.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.ep.moonshooter.actors.Foreground;
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
	
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	
	private World_1 world;
	private OrthographicCamera cam;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();
	private Texture shipTexture;
	private Texture foregroundTexture;
	
	private SpriteBatch spriteBatch;

	private boolean debug;

	// TODO: consider interface for Worlds, so different worlds / levels are easy to handle.
	public WorldRenderer(World_1 world, boolean debug) {
		this.world = world;
		
		// Create the camera with a view-port of 10 units wide and 7 units tall.
		// This means that filling up the screen with unit blocks (width = height = 1)
		// will result in showing 10 boxes on the X axis and 7 on the Y.
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		loadTextures();
	}
	
	private void loadTextures() {
		shipTexture = new  Texture(Gdx.files.internal("images/spaceship.png"));
		foregroundTexture = new Texture(Gdx.files.internal("images/foreground-moon.jpg"));
	}

	public void render() {
		spriteBatch.begin();
		spriteBatch.setProjectionMatrix(cam.combined);
		drawForeground();
		drawSpaceship();
		spriteBatch.end();
		if (debug)
			drawDebug();
	}
	
	private void drawSpaceship() {
		SpaceShip s = world.getSpaceShip();
		spriteBatch.draw(shipTexture, s.getPosition().x, s.getPosition().y, s.getBounds().width, s.getBounds().height);
		
	}

	private void drawForeground() {
		for (Foreground b : world.getForeground()) {
			spriteBatch.draw(foregroundTexture, b.getPosition().x, b.getPosition().y, b.getBounds().width, b.getBounds().height);
		}
	}
	
	/**
	 * only called when in debug mode. To see the actual rectangles
	 */
	public void drawDebug() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Line);
		
		// render games foreground
		for (Foreground block : world.getForeground()) {
			Rectangle rect = block.getBounds();
			float x1 = block.getPosition().x + rect.x;
			float y1 = block.getPosition().y + rect.y;
			debugRenderer.setColor(Color.LIGHT_GRAY);
			debugRenderer.rect(x1, y1, rect.width, rect.height);
		}

		// render Spaceship
		SpaceShip ship = world.getSpaceShip();
		Rectangle rectShip = ship.getBounds();
		float x1 = ship.getPosition().x + rectShip.x;
		float y1 = ship.getPosition().y + rectShip.y;
		debugRenderer.setColor(Color.GREEN);
		debugRenderer.rect(x1, y1, rectShip.width, rectShip.height);
		debugRenderer.end();
	}
}
