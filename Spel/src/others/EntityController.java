package others;
import java.awt.Graphics;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import entities.AnimateEntity;
import entities.Entity;
import entities.HostileEntity;
import framework.PlayerListener;

public class EntityController {

	private PlayerListener listener;
	private ArrayList<AnimateEntity> allEntities;
	private ArrayList<Entity> objects;

	public EntityController(PlayerListener listener) {
		this.listener = listener;
		allEntities = new ArrayList<AnimateEntity>();		
		objects = new ArrayList<Entity>();			
	}

	public void updateEntity() {
		for (AnimateEntity e : allEntities) {
			Position oldPosition = new Position(e.getPosition().getX(), e.getPosition().getY());
			e.action();
			e.handleObjectCollision(oldPosition);
			e.handleEntityCollision(oldPosition);
		}
	}

	public void paintEntity(Graphics g) {
		double playerPosX, playerPosY;
		for (AnimateEntity e : allEntities) {
			if(e instanceof Player) {
				int tX = 0, tY = 0;
				playerPosX = e.getPosition().getX();
				playerPosY = e.getPosition().getY();
				if(playerPosX > 600 && playerPosX < 1800) {
					tX = (int) -(playerPosX - 600);
				}
				if(playerPosY > 450 && playerPosY < 1350) {
					tY = (int) -(playerPosY - 450);
				}
				g.translate(tX, tY);
				listener.setTranslatedXY(tX, tY);
				break;
			}
		}
		for (AnimateEntity e : allEntities) {
			e.paint(g);
		}
		for (Entity i : getObjects()) {
			i.paint(g);

		}
	}

	// Returns all enemies who got hit by the weapon (intersected the arc)
	public ArrayList<AnimateEntity> getMeleeHits(Arc2D.Double arc) {
		ArrayList<AnimateEntity> temp = new ArrayList<AnimateEntity>();
		for (Entity e : allEntities) {
			if (e instanceof HostileEntity) {
				AnimateEntity ae = ((HostileEntity) e).checkArcIntersection(arc);
				if (ae != null)
					temp.add(ae);
			}
		}
		return temp;
	}

	public ArrayList<Entity> getObjects() {
		return objects;
	}
	
	public ArrayList<AnimateEntity> getAnimateEntities() {
		return allEntities;
	}

	
}
