import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

public class Enemy extends AnimateEntity {	

	private Player player;
	private Random rdm;
	

	public Enemy(double speed, int x, int y, Player player) {
		super(speed, x, y);
		this.player = player;
		rdm = new Random();
		
		
	}

	@Override
	public void action() {
		double dx = position.getX()-player.getPosition().getX();
		double dy = position.getY()-player.getPosition().getY();
		
		int teleport = rdm.nextInt(1000);
		if(teleport == 999) {
			position.setX(rdm.nextInt(500));
			position.setY(rdm.nextInt(500));
		}

		if (dx > 0) {
			position.setX(position.getX() - speed);
		} else{
			position.setX(position.getX() + speed);
		}
		if (dy>0) {
			position.setY(position.getY() - speed);
		} else {
			position.setY(position.getY() + speed);
		}
		
		

		
	}

	@Override
	public void paint(Graphics g) {
		double x = position.getX();
		double y = position.getY();
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.YELLOW);
		g2d.fillOval((int)x, (int)y, 40, 70);
		
		g2d.setColor(Color.RED);
		g2d.fillOval((int)x +8, (int)y+20, 8, 8);
		g2d.fillOval((int)x +25, (int)y+20, 8, 8);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect((int)x - 5, (int)y, 50, 10);
		g2d.fillRect((int)x +5, (int)y-30, 30, 40);
		
	}
	
	
	

}
