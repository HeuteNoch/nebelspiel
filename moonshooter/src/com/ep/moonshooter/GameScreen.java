package com.ep.moonshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
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

	private World_1 world_1;
	private WorldRenderer renderer;
	private WorldController	controller;
	private int width;
	private int height;
	
	
	/**
	 * Called when the screen should render itself.
	 * @param delta The time in seconds since the last render.
	 * */
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		controller.update(delta);
		renderer.render();
	}
	
	@Override
	public void show() {
		world_1 = new World_1();
		renderer = new WorldRenderer(world_1, true);
		controller = new WorldController(world_1);
		Gdx.input.setInputProcessor(this);
	}

	/**
	 * Called every time the drawable surface is resized.
	 * This gives us the chance to rearrange the bits before we go on to start the play. 
	 * It happens when the window (if the game runs in one) is resized for example.
	 */
	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;

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
			controller.leftPressed();
		if (keycode == Keys.RIGHT)
			controller.rightPressed();
		if (keycode == Keys.UP)
			controller.upPressed();
		if (keycode == Keys.DOWN)
			controller.downPressed();
		if (keycode == Keys.A)
			controller.firePressed();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftReleased();
		if (keycode == Keys.RIGHT)
			controller.rightReleased();
		if (keycode == Keys.UP)
			controller.upReleased();
		if (keycode == Keys.DOWN)
			controller.downReleased();
		if (keycode == Keys.A)
			controller.fireReleased();
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
