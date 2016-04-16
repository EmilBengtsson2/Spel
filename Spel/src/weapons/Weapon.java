package weapons;
import java.awt.Graphics2D;

public interface Weapon {
	
	//T�nkte att alla "vapen" spelaren kan anv�nda implementerar denna, metoderna borde funka till allt tror jag
	
	public int getDamage();
	
	public int getRange();
	
	public void hit();
	
	public void Animation();
	
	public void paint(Graphics2D g2d);
}
