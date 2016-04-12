import java.awt.Graphics;

public class EntityController {
	
	private Player player;
	
	public EntityController(PlayerListener listener) {
		player = new Player(1.5, 600, 450, listener);
	}
	
	public void update() {
		player.action();
	}
	
	public void paintEntity(Graphics g) {
		player.paint(g);
	}
}
