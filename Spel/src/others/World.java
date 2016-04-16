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
	//letar block
	public Entity getIntersectingObject(Entity entity) {
		ArrayList<Entity> objects = entityController.getObjects();
		for (Entity object : objects) {
			if (intersects(entity, object)) {
				return object;
			}
		}
		return null;
	}
	//letar "levande" objekt
	public Entity getIntersectingEntity(Entity entity) {
		ArrayList<AnimateEntity> entities = entityController.getAnimateEntities();
		for (AnimateEntity ae : entities) {
			if (intersects(entity, ae) && entity!=ae) {
				return ae;
			}
		}
		return null;
	}
	//kollar korsande rektanglar mellan Entity1 och Entity2, returnerar true vid intersection.
	private boolean intersects(Entity e1, Entity e2) {
		boolean intersection = false;
		Position e1UpperLeft = e1.getPosition();
		Position e1LowerRight = new Position(e1.getPosition().getX() + e1.getWidth(),
				e1.getPosition().getY() + e1.getHeight());

		Position e2UpperLeft = e2.getPosition();
		Position e2LowerRight = new Position(e2.getPosition().getX() + e2.getWidth(),
				e2.getPosition().getY() + e2.getHeight());

		if (e1UpperLeft.getX() > e2LowerRight.getX() || e1LowerRight.getX() < e2UpperLeft.getX()
				|| e1UpperLeft.getY() > e2LowerRight.getY() || e1LowerRight.getY() < e2UpperLeft.getY()) {
			return false;
		}
		return true;
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
