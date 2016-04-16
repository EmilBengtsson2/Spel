import java.awt.Graphics;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class EntityController {

	private ArrayList<AnimateEntity> allEntities;
	private ArrayList<Entity> inanimateEntities;

	public EntityController(PlayerListener listener) {
		allEntities = new ArrayList<AnimateEntity>();
		inanimateEntities = new ArrayList<Entity>();		
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
		for (Entity i : inanimateEntities) {
			i.paint(g);

		}
	}

	// Returns all enemies who got hit by the weapon (intersected the arc)
	public ArrayList<AnimateEntity> getMeleeHits(Arc2D.Double arc) {
		ArrayList<AnimateEntity> temp = new ArrayList<AnimateEntity>();
		for (Entity e : allEntities) {
			if (e instanceof HostileEntity) {
				AnimateEntity ae = ((HostileEntity) e).checkArcIntersection(arc);
				if (ae != null)
					temp.add(ae);
			}
		}
		return temp;
	}

	// AnimateEntities skapas härifrån i nuvarande implementation. Skapa Entity
	// och lägg i listan.
	private void createEntities(PlayerListener listener) {
		// Player
		Player player = new Player(1.5, 600, 450, listener);
		player.setWeapon(new Spear(player, this)); //Här byter man vapen
		allEntities.add(player);

		// Enemy 1
		HatEnemy enemy1 = new HatEnemy(0.5, 600, 300, player);
		allEntities.add(enemy1);

		// Enemy 2
		HatEnemy enemy2 = new HatEnemy(0.5, 100, 300, player);
		allEntities.add(enemy2);

		// SpriteEnemy
		RedSkull rs = new RedSkull(2, 150, 150);
		allEntities.add(rs);

		// Block, 63 pixels wide atm.
		int startX = 63;		
		int startY = 59;
		for (int i = 0; i < 30; i++) {
			inanimateEntities.add(new Block(startX*i, 0));		
			inanimateEntities.add(new Block(0, startY*i));
		}

	}
}
