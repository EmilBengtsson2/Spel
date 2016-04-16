import java.awt.Graphics;

public abstract class AnimateEntity extends Entity{
	
	protected double speed;
	protected int health;
	
	public AnimateEntity(double speed, int x, int y) {
		super(x, y);
		this.speed = speed;
	}
	
	
	public abstract void action();
	
	public abstract void paint(Graphics g);
}
