import java.awt.Color;
import java.awt.Graphics;

public class Player extends AnimateEntity {
	
	PlayerListener listener;
	
	public Player(double speed, int x, int y, PlayerListener listener) {
		super(speed, x, y);
		this.listener = listener;
	}
	
	public void action() {
		position.setX(position.getX() + speed * listener.getHorizontalMult());
		position.setY(position.getY() + speed * listener.getVerticalMult());
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)position.getX()-20, (int)position.getY()-20, 40, 40);
	}
}
