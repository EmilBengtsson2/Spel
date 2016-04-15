import java.awt.Graphics;

public abstract class AnimateEntity {
	
	protected double speed;
	protected Position position;
	protected int health;
	
	public AnimateEntity(double speed, int x, int y) {
		this.speed = speed;
		position = new Position(x, y);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public abstract void action();
	
	public abstract void paint(Graphics g);
}
