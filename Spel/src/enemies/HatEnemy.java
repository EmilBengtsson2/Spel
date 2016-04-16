package enemies;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import entities.AnimateEntity;
import entities.HostileEntity;
import others.Player;
import others.Position;
import others.World;

public class HatEnemy extends HostileEntity {	

	private Player player;
	private Random rdm;
	private final static double SPEED = 0.7;
	

	public HatEnemy(int x, int y, Player player, World world) {
		super(SPEED, x, y, world, 30, 90);
		this.player = player;
		rdm = new Random();
		health = 2;		
	}

	@Override
	public void action() {
		Position oldPosition = new Position(position.getX(), position.getY());
		double dx = position.getX()-player.getPosition().getX();
		double dy = position.getY()-player.getPosition().getY();
		
		int teleport = rdm.nextInt(1000);
		if(teleport == 999) {
			position.setX(rdm.nextInt(1500));
			position.setY(rdm.nextInt(1000));
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
		handleEntityCollision(oldPosition);
	}
	
	//Kollar om en kon skär gubbens hitbox
	@Override
	public AnimateEntity checkArcIntersection(Arc2D.Double arc) {
		if(arc.intersects(new Rectangle2D.Double(position.getX()-15, position.getY()+10, 30, 90)))
			return this;
		return null;
	}

	@Override
	public void paint(Graphics g) {
		double x = position.getX();
		double y = position.getY();
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.YELLOW);
		g2d.fillOval((int)x-20, (int)y+35, 40, 70);
		
		g2d.setColor(Color.RED);
		g2d.fillOval((int)x +8-20, (int)y+20+35, 8, 8);
		g2d.fillOval((int)x +25-20, (int)y+20+35, 8, 8);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect((int)x - 5-20, (int)y+35, 50, 10);
		g2d.fillRect((int)x +5-20, (int)y-30+35, 30, 40);
		
		g2d.drawRect((int)position.getX()-15, (int)position.getY()+10, 30, 90);
	}
	
	
	

}
