import java.awt.Graphics;
import java.util.ArrayList;

public class EntityController {
	
	private ArrayList <AnimateEntity> aEntities;
	
	
	public EntityController(PlayerListener listener) {
		aEntities = new ArrayList<AnimateEntity>();
		createEntities(listener);
	}
	
	public void update() {
		for (AnimateEntity e : aEntities) {
			e.action();
		}		
	}
	
	public void paintEntity(Graphics g) {
		for (AnimateEntity e : aEntities) {
			e.paint(g);
		}
	}
	
	// AnimateEntities skapas härifrån i nuvarande implementation. Skapa Entity och lägg i listan.	
	private void createEntities(PlayerListener listener) {
		//Player
		Player player = new Player(1.5, 600, 450, listener);
		player.setWeapon(new Sword(player));
		aEntities.add(player);
		
		//Enemy 1
		Enemy enemy1 = new Enemy (0.5, 600, 300, player);		
		aEntities.add(enemy1);
		
		//Enemy 2
		Enemy enemy2 = new Enemy (0.5, 100, 300, player);
		aEntities.add(enemy2);		
	}
}
