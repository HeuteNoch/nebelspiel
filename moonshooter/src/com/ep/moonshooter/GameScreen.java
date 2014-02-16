package com.ep.moonshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.ep.moonshooter.worlds.World_1;

/**
 * For the different game screen states. GameScreen implements the Screen
 * interface which is very much like an ApplicationListener but it has 2
 * important methods added. show() – this is called when the main game makes
 * this screen active hide() – this is called when the main game makes another
 * screen active
 * 
 */
public class GameScreen implements Screen {

	private World_1 world_1;
	private WorldRenderer renderer;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		renderer.render();

	}
	
	@Override
	public void show() {
		world_1 = new World_1();
		renderer = new WorldRenderer(world_1);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
