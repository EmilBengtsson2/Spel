package enemies;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


import entities.Entity;
import others.Position;
import others.RandomMover;
import others.World;

public class RedSkull extends RandomMover {
	private static Image[] images = {
			new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull1.png")).getImage(),
			new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull2.png")).getImage(),
			new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull3.png")).getImage(), 
			new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull4.png")).getImage(),
			new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull5.png")).getImage(), 
			new ImageIcon(RandomMover.class.getResource("/PicResource/RedSkull6.png")).getImage()};
	private final static double SPEED = 1.5;
	private int animationCounter;
	private int imageIndex;

	public RedSkull(int x, int y, World world) {
		super(SPEED, x, y, world, images[0].getWidth(null), images[0].getHeight(null));
		animationCounter = 0;
		imageIndex = 0;		
	}

	@Override
	public void action() {	
		Position oldPosition = new Position(position.getX(), position.getY());
		if (movementCounter == 0) {
			xDirection = rdm.nextInt(3) - 1;
			yDirection = rdm.nextInt(3) - 1;
			movementCounter = 100;
		}
		position.setX(position.getX() + xDirection * speed);
		position.setY(position.getY() + yDirection * speed);
		movementCounter--;
		handleObjectCollision(oldPosition);
		handleEntityCollision(oldPosition);
		

	}

	@Override
	public void paint(Graphics g) {
		switchImage();
		g.drawImage(images[imageIndex], (int) position.getX(), (int) position.getY(), null);
	}

	private void switchImage() {
		if (animationCounter >= 20) {
			imageIndex = (imageIndex + 1) % 6;
			animationCounter = 0;
		}
		animationCounter++;
	}
}