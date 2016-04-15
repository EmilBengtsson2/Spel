import java.awt.Graphics;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class EntityController {
	
	private ArrayList <AnimateEntity> allEntities;
	
	
	public EntityController(PlayerListener listener) {
		allEntities = new ArrayList<AnimateEntity>();
		createEntities(listener);
	}
	
	public void update() {
		for (AnimateEntity e : allEntities) {
			e.action();
		}		
	}
	
	public void paintEntity(Graphics g) {
		for (AnimateEntity e : allEntities) {
			e.paint(g);
		}
	}
	
	//Returns all enemies who got hit by the weapon (intersected the arc)
	public ArrayList<AnimateEntity> getMeleeHits(Arc2D.Double arc) {
		ArrayList<AnimateEntity> temp = new ArrayList<AnimateEntity>();
		for(AnimateEntity e : allEntities) {
			if(e instanceof HostileEntity) {
				AnimateEntity ae = ((HostileEntity) e).checkArcIntersection(arc);
				if(ae != null)
					temp.add(ae);
			}
		}
		return temp;
	}
	
	// AnimateEntities skapas härifrån i nuvarande implementation. Skapa Entity och lägg i listan.	
	private void createEntities(PlayerListener listener) {
		//Player
		Player player = new Player(1.5, 600, 450, listener);
		player.setWeapon(new Sword(player, this));
		allEntities.add(player);
		
		//Enemy 1
		HatEnemy enemy1 = new HatEnemy (0.5, 600, 300, player);		
		allEntities.add(enemy1);
		
		//Enemy 2
		HatEnemy enemy2 = new HatEnemy (0.5, 100, 300, player);
		allEntities.add(enemy2);		
	}
}
