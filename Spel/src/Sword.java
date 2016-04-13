import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Sword implements Weapon {
	
	private Position p;
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
	public void paint(Graphics2D g2d) {
		p = player.getPosition();
		
		g2d.setColor(Color.GRAY);
		g2d.rotate(-Math.PI/3, p.getX()-5, p.getY()-15);
		g2d.fillRect((int)p.getX()-5, (int)p.getY()-15-RANGE, 10, RANGE);
		g2d.rotate(Math.PI/3, p.getX()-5, p.getY()-15);
	}
}
