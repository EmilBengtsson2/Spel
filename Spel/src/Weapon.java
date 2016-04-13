import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Weapon {
	
	public int getDamage();
	
	public int getRange();
	
	public void Animation(Graphics g);
	
	public void paint(Graphics2D g2d);
}
