package weapons;
import java.awt.Graphics2D;

public interface Weapon {
	
	//Tänkte att alla "vapen" spelaren kan använda implementerar denna, metoderna borde funka till allt tror jag
	
	public int getDamage();
	
	public int getRange();
	
	public void hit();
	
	public void Animation();
	
	public void paint(Graphics2D g2d);
}
