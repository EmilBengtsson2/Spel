package others;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.AnimateEntity;
import entities.Entity;
import framework.PlayerListener;

public class World {

	private EntityController entityController;

	public World(PlayerListener listener) {
		entityController = new EntityController(this);
		createWorld(listener);
	}

	public void updateWorld() {
		entityController.updateEntity();
	}

	public void createWorld(PlayerListener listener) {
		LevelGenerator.generateLevel(this, listener, 1);

	}

	public void paintWorld(Graphics g) {
		entityController.paintEntity(g);
	}
	

	public EntityController getEntityController() {
		return entityController;
	}

	public ArrayList<Entity> getObjects() {
		return entityController.getObjects();
	}

	public ArrayList<AnimateEntity> getAnimateEntities() {
		return entityController.getAnimateEntities();
	}

}
