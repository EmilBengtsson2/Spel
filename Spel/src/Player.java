import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Player extends AnimateEntity {
	
	private PlayerListener listener;
	private Position mousePos;
	private Weapon weapon;
	
	public Player(double speed, int x, int y, PlayerListener listener) {
		super(speed, x, y);
		this.listener = listener;
		mousePos = listener.getMousePos();
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Position getMousePosition() {
		return mousePos;
	}
	
	public boolean getMouseDown() {
		return listener.getMouseDown();
	}
	@Override
	public void action() {
		position.setX(position.getX() + speed * listener.getHorizontalMult());
		position.setY(position.getY() + speed * listener.getVerticalMult());
		mousePos = listener.getMousePos();		
	}
	@Override
	public void paint(Graphics g) {
		double x = position.getX();
		double y = position.getY();
		double mX = mousePos.getX();
		double mY = mousePos.getY();
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
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
		
		if(weapon != null)
			weapon.paint(g2d);
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect((int)position.getX()-20, (int)position.getY()-20, 40, 40);
		
		g2d.dispose();
	}	
}
