import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Sword implements Weapon {
	
	private Position p, mP;
	private double x, y, mX, mY;
	private final int RANGE = 100, DAMAGE = 20;
	private Player player;
	
	public Sword(Player player) {
		this.player = player;
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}
	
	@Override
	public int getRange() {
		return RANGE;
	}
	
	@Override
	public void Animation(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g) {
		p = player.getPosition();
		mP = player.getMousePosition();
		x = p.getX();
		y = p.getY();
		mX = mP.getX();
		mY = mP.getY();
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setColor(Color.GRAY);
		if(mY < y)
			if(mX > x+20)
				g2d.rotate(-Math.acos((Math.abs(mX-(x+20)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x+20), 2))), x+20, y);
			else
				g2d.rotate(Math.PI + Math.acos((Math.abs(mX-(x+20)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x+20), 2))), x+20, y);
		else
			if(mX > x+20)
				g2d.rotate(Math.acos((Math.abs(mX-(x+20)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x+20), 2))), x+20, y);
			else
				g2d.rotate(Math.PI-Math.acos((Math.abs(mX-(x+20)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x+20), 2))), x+20, y);
		g2d.fillRect((int)x+20, (int)y, RANGE, 10);
		
		g2d.dispose();
	}
}
