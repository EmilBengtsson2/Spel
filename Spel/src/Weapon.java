import java.awt.Graphics;

public interface Weapon {
	
	public int getDamage();
	
	public int getRange();
	
	public void Animation(Graphics g);
	
	public void paint(Graphics g);
}
