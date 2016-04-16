package entitys;
import java.awt.Graphics;

import others.World;

public abstract class AnimateEntity extends Entity{
	
	protected double speed;
	protected int health;
	
	public AnimateEntity(double speed, int x, int y, World world, int width, int height) {
		super(x, y, world, width, height);
		this.speed = speed;
	}
	
	
	public abstract void action();
	
	public abstract void paint(Graphics g);
}
