import java.awt.Graphics;

public class AnimateEntity {
	
	protected double speed;
	protected Position position;
	
	public AnimateEntity(double speed, int x, int y) {
		this.speed = speed;
		position = new Position(x, y);
	}
	
	public void paint(Graphics g) {}
}
