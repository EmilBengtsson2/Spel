import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		double x = position.getX();
		double y = position.getY();
		double mX = mousePos.getX();
		double mY = mousePos.getY();
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.rotate(Math.PI/2, x, y);
		if(mY < y)
			if(mX > x)
				g2d.rotate(-Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
			else
				g2d.rotate(Math.PI + Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
		else
			if(mX > x)
				g2d.rotate(Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
			else
				g2d.rotate(Math.PI-Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
		
		if(w != null)
			w.paint(g2d);
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect((int)position.getX()-20, (int)position.getY()-20, 40, 40);
		
		g2d.dispose();
	}
}
