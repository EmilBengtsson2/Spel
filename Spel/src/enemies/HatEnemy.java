package enemies;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

import entities.AnimateEntity;
import entities.HostileEntity;
import others.Player;
import others.Position;
import others.RandomMover;
import others.World;

public class HatEnemy extends HostileEntity {	
	
	private Image image = new ImageIcon(RandomMover.class.getResource("/PicResource/HatEnemy.gif")).getImage();

	private Player player;
	private Random rdm;
	private final static double SPEED = 0.7;
	

	public HatEnemy(int x, int y, Player player, World world) {
		super(SPEED, x, y, world, 100, 120);
		this.player = player;
		rdm = new Random();
		health = 2;		
	}

	@Override
	public void action() {
		
		double dx = position.getX()-player.getPosition().getX();
		double dy = position.getY()-player.getPosition().getY();

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
	
	//Kollar om en kon skär gubbens hitbox
	@Override
	public AnimateEntity checkArcIntersection(Arc2D.Double arc) {
		if(arc.intersects(new Rectangle2D.Double(position.getX()-15, position.getY()+10, 30, 90)))
			return this;
		return null;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int)position.getX(), (int)position.getY(), null);
	}
	
	
	

}
