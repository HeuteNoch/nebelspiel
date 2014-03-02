package com.ep.moonshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.ep.moonshooter.controller.ShipController;
import com.ep.moonshooter.controller.WorldController;
import com.ep.moonshooter.renderer.WorldRenderer;
import com.ep.moonshooter.worlds.World_1;

/**
 * GameScreen implements the Screen interface which is very much like an 
 * ApplicationListener but it has two important methods added. show() this 
 * is called when the main games makes this screen active hide() this is
 * called when the main game makes another screen active.
 */
public class GameScreen implements Screen, InputProcessor {

	// TODO: add possibility to change world via setters
	private World_1 world_1;
	private WorldRenderer worldRenderer;
	private WorldController	worldController;
	private ShipController shipController;
	
	/**
	 * Called when the screen should render itself.
	 * @param delta The time in seconds since the last render.
	 * */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if (world_1.isOver()) {
			this.world_1 = setNextWorld(); // TODO: either world or level
		}
		worldController.update(delta);
		shipController.update(delta);
		worldRenderer.render();
	}
	
	private World_1 setNextWorld() {
		return new World_1(); // TODO add more worlds ;)
	}

	@Override
	public void show() {
		world_1 = new World_1();
		worldRenderer = new WorldRenderer(world_1, false);
		worldController = new WorldController(world_1);
		shipController = new ShipController(world_1);
		
		Gdx.input.setInputProcessor(this);
	}

	/**
	 * Called every time the drawable surface is resized.
	 */
	@Override
	public void resize(int width, int height) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}


	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	/**
	 *  method is called in the end of the game.
	 *  do some cleanup here
	 */
	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			shipController.leftPressed();
		if (keycode == Keys.RIGHT)
			shipController.rightPressed();
		if (keycode == Keys.UP)
			shipController.upPressed();
		if (keycode == Keys.DOWN)
			shipController.downPressed();
		if (keycode == Keys.A)
			shipController.firePressed();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			shipController.leftReleased();
		if (keycode == Keys.RIGHT)
			shipController.rightReleased();
		if (keycode == Keys.UP)
			shipController.upReleased();
		if (keycode == Keys.DOWN)
			shipController.downReleased();
		if (keycode == Keys.A)
			shipController.fireReleased();
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
