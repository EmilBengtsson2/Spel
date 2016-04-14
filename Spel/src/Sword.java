import java.awt.Color;
import java.awt.Graphics2D;

public class Sword implements Weapon {
	
	private Position p;
	private final int RANGE = 100, BASE_DAMAGE = 20, BASE_COOLDOWN = 500;
	private long lastAnimationTime;
	private int animation, xDislocation;
	private double theta;
	private final double dTheta = Math.PI / 3 / 10 * 2;
	private Player player;
	
	public Sword(Player player) {
		this.player = player;
		theta = -Math.PI/3;
		xDislocation = -10;
		animation = 0;
	}

	@Override
	public int getDamage() {
		return BASE_DAMAGE;
	}
	
	@Override
	public int getRange() {
		return RANGE;
	}
	
	@Override
	public void Animation() {
		if(animation != 0 || System.currentTimeMillis() - lastAnimationTime > BASE_COOLDOWN) {
			if(animation == 0) {
				lastAnimationTime = System.currentTimeMillis();
				if(xDislocation < 0)
					animation++;
				else
					animation--;
			}
			
			if(animation > 0) {
				theta += dTheta;
				xDislocation += 1;
				animation++;
			} else {
				theta -= dTheta;
				xDislocation -= 1;
				animation--;
			}
			
			if(Math.abs(animation) % 11 == 0)
				animation = 0;
		}
	}

	@Override
	public void paint(Graphics2D g2d) {
		p = player.getPosition();
		
		if(player.getMouseDown() || animation != 0)
			Animation();
		
		g2d.setColor(Color.GRAY);
		g2d.rotate(theta, p.getX()+xDislocation+5, p.getY()-20);
		g2d.fillRect((int)p.getX()+xDislocation, (int)p.getY()-20-RANGE, 10, RANGE);
		g2d.rotate(-theta, p.getX()+xDislocation+5, p.getY()-20);
	}
}
