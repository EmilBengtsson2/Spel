import java.awt.Color;
import java.awt.Graphics;

public class Player extends AnimateEntity {
	
	private PlayerListener listener;
	private Position mousePos;
	private Weapon w;
	
	public Player(double speed, int x, int y, PlayerListener listener) {
		super(speed, x, y);
		this.listener = listener;
		mousePos = listener.getMousePos();
	}

	public void setWeapon(Weapon w) {
		this.w = w;
	}
	
	public Position getMousePosition() {
		return mousePos;
	}
	
	public void action() {
		position.setX(position.getX() + speed * listener.getHorizontalMult());
		position.setY(position.getY() + speed * listener.getVerticalMult());
		mousePos = listener.getMousePos();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)position.getX()-20, (int)position.getY()-20, 40, 40);
		if(w != null)
			w.paint(g);
	}
}
