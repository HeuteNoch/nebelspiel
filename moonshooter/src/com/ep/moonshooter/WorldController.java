package com.ep.moonshooter;

import java.util.HashMap;
import java.util.Map;

import com.ep.moonshooter.actors.SpaceShip;
import com.ep.moonshooter.actors.SpaceShip.State;
import com.ep.moonshooter.worlds.World_1;

public class WorldController {

	enum Keys {
		LEFT, RIGHT, UP, DOWN, FIRE
	}

	private World_1 world;
	private SpaceShip ship;

	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.FIRE, false);
	};

	public WorldController(World_1 world) {
		this.world = world;
		this.ship = world.getSpaceShip();
	}

	// ** Key presses and touches **************** //
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}

	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}

	public void upPressed() {
		keys.get(keys.put(Keys.UP, true));
	}

	public void downPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}

	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}

	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}

	public void upReleased() {
		keys.get(keys.put(Keys.UP, false));
	}

	public void downReleased() {
		keys.get(keys.put(Keys.DOWN, false));
	}

	public void fireReleased() {
		keys.get(keys.put(Keys.FIRE, false));
	}

	/** The main update method **/
	public void update(float delta) {
		processInput();
		ship.update(delta);
	}

	/** Change Ships's state and parameters based on input controls **/
	// TODO: input processing is buggy when pressing up and right for example 
	private void processInput() {
		
		if (keys.get(Keys.LEFT)) {
			// left is pressed
			ship.setState(State.FYLING);
			ship.getVelocity().x = -ship.getSpeed();
		}
		if (keys.get(Keys.RIGHT)) {
			// right is pressed
			ship.setState(State.FYLING);
			ship.getVelocity().x = ship.getSpeed();
		}
		if (keys.get(Keys.UP)) {
			ship.setState(State.FYLING);
			ship.getVelocity().y = ship.getSpeed();
		}
		if (keys.get(Keys.DOWN)) {
			ship.setState(State.FYLING);
			ship.getVelocity().y = -ship.getSpeed();
		}
		// need to check if both or none direction are pressed, then ship is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT))
				|| ( !keys.get(Keys.LEFT) && !keys.get(Keys.RIGHT) 
						&& !keys.get(Keys.UP) && !keys.get(Keys.DOWN) )) {
			ship.setState(State.IDLING);
			// acceleration is 0 on the x
			ship.getAcceleration().x = 0;
			ship.getAcceleration().y = 0;
			// horizontal speed is 0
			ship.getVelocity().x = 0;
			ship.getVelocity().y = 0;
		}
	}
}
