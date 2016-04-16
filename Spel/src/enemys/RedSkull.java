package enemys;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import others.RandomMover;
import others.World;

public class RedSkull extends RandomMover{
	private static Image image = new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull.png")).getImage();
	private final static double SPEED = 1.0;
	
	public RedSkull(int x, int y, World world) {
		super(SPEED, x, y, world, image.getWidth(null), image.getHeight(null));		
	}
	
	@Override
	public void action() {
		if (movementCounter == 0) {
			xDirection = rdm.nextInt(3) - 1;
			yDirection = rdm.nextInt(3) - 1;
			movementCounter = 100;
		}
		position.setX(position.getX() + xDirection * speed);
		position.setY(position.getY() + yDirection * speed);
		movementCounter--;

	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int) position.getX(), (int) position.getY(), null);
	}
	
	

}
