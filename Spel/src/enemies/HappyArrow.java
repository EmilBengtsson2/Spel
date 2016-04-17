package enemies;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import others.Position;
import others.RandomMover;
import others.World;

public class HappyArrow extends RandomMover{
	private static Image image = new ImageIcon(RandomMover.class.getResource("/PicResource/HappyArrow.gif")).getImage();
	private final static double SPEED = 1.0;
	
	public HappyArrow(int x, int y, World world) {
		super(SPEED, x, y, world, image.getWidth(null), image.getHeight(null));
		
	}
	@Override
	public void action(){
		Position oldPosition = new Position(position.getX(), position.getY());
		if (movementCounter == 0) {
			xDirection = rdm.nextInt(3) - 1;
			movementCounter = 100;
		}
		position.setX(position.getX() + xDirection * speed);		
		movementCounter--;
		handleObjectCollision(oldPosition);
		handleEntityCollision(oldPosition);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int) position.getX(), (int) position.getY(), null);
	}
}
