import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class RedSkull extends RandomMover{

	private static Image [] images = {	new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull1.png")).getImage(),
										new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull2.png")).getImage(),
										new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull3.png")).getImage() };
	private final static double SPEED = 1.0;
	private int animationCounter;
	private int imageIndex;	
	
	public RedSkull(int x, int y, World world) {
		super(SPEED, x, y, world, images[0].getWidth(null), images[0].getHeight(null));		
		animationCounter = 0;
		imageIndex = 0;
		Image currentImage = images[0];
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
		switchImage();
		g.drawImage(images[imageIndex], (int) position.getX(), (int) position.getY(), null);		
	}
	
	private void switchImage() {
		if (animationCounter >= 100) {
			imageIndex = (imageIndex+1)%3;
			animationCounter = 0;
		}		
		animationCounter++;		
	}
	

}
