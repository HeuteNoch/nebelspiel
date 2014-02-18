package com.ep.moonshooter;

import com.badlogic.gdx.Game;

/**
 * The game "entry"
 * @see http://obviam.net/index.php/getting-started-in-android-game-development-with-libgdx-create-a-working-prototype-in-a-day-tutorial-part-1/
 *
 */
public class MoonShooter extends Game {
	
	@Override
	public void create() {		
		setScreen(new GameScreen());
	}

}
