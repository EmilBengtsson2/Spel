import java.awt.Graphics;
import java.awt.geom.Arc2D.Double;
import java.util.Random;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SpriteEntity extends Entity{

	protected Image image;
	protected Random rdm;
	protected int movementCounter, xDirection, yDirection;
	protected double speed;

	public SpriteEntity(double speed, int x, int y, ImageIcon icon) {
		super(x, y);
		this.speed = speed;
		rdm = new Random();
		movementCounter = 0;
		image = icon.getImage();
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

	
	public AnimateEntity checkArcIntersection(Double arc) {
		// TODO Auto-generated method stub
		return null;
	}

}
