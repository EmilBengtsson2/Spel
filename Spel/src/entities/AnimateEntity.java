package entities;
import java.awt.Graphics;

import others.Position;
import others.World;

public abstract class AnimateEntity extends Entity{
	
	protected double speed;
	protected int health;
	
	public AnimateEntity(double speed, int x, int y, World world, int width, int height) {
		super(x, y, world, width, height);
		this.speed = speed;
	}	
	
	public abstract void action();
	
	public void handleObjectCollision(Position oldPosition) {
		Entity entity =getIntersectingObject();
		if (entity!=null) {
			position.setX(oldPosition.getX());
			position.setY(oldPosition.getY());			
		}
	}
	
	public void handleEntityCollision(Position oldPosition){
		Entity entity =getIntersectingEntity();
		if (entity!=null) {
			position.setX(oldPosition.getX());
			position.setY(oldPosition.getY());			
		}
	}
	
	public abstract void paint(Graphics g);	

}
