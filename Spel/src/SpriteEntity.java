import java.awt.Graphics;
import java.awt.geom.Arc2D.Double;
import java.awt.image.ImageObserver;
import java.util.Random;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SpriteEntity extends HostileEntity {

	private Image image;
	private Random rdm;
	private int movementCounter, xDirection, yDirection;

	public SpriteEntity(double speed, int x, int y) {
		super(speed, x, y);
		rdm = new Random();
		movementCounter = 0;
		ImageIcon icon = new ImageIcon(SpriteEntity.class.getResource("/PicResource/RedSkull.png"));
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

	@Override
	public AnimateEntity checkArcIntersection(Double arc) {
		// TODO Auto-generated method stub
		return null;
	}

}
