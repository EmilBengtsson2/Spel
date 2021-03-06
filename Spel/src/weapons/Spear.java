package weapons;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import entities.AnimateEntity;
import others.EntityController;
import others.Player;
import others.Position;

public class Spear implements Weapon{
	private Position p;
	private final int RANGE = 105, BASE_DAMAGE = 20, BASE_COOLDOWN = 500;
	private long lastAnimationTime;
	private int animation, xDislocation;
	private double theta;
	private final double dTheta = Math.PI / 3 / 10 * 2;
	private Player player;
	private EntityController entity;
	
	public Spear(Player player, EntityController entity) {
		this.player = player;
		this.entity = entity;
		theta = -Math.PI/3;
		xDislocation = -10;
		animation = 0;
	}

	@Override
	public int getDamage() {
		return BASE_DAMAGE;
	}
	
	@Override
	public int getRange() {
		return RANGE;
	}
		
	@Override
	public void hit() {
		Arc2D.Double arc = new Arc2D.Double(player.getPosition().getX()-(RANGE + 15), player.getPosition().getY()-(RANGE + 15), (RANGE + 15) * 2, (RANGE + 15) * 2, Math.toDegrees(-Math.PI/3 + Math.PI/2 - player.getRotation()), Math.toDegrees(Math.PI/3 * 2), Arc2D.PIE);
		ArrayList<AnimateEntity> entities = entity.getMeleeHits(arc);
		for(AnimateEntity ae : entities) {
			System.out.println("Tr�ff p�: (" + ae.getPosition().getX() + ", " + ae.getPosition().getY() + ")");
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	@Override //M�ste �ndra, har samma animation som sv�rdet nu.
	public void Animation() {
		if(animation != 0 || System.currentTimeMillis() - lastAnimationTime > BASE_COOLDOWN) {
			if(animation == 0) {
				lastAnimationTime = System.currentTimeMillis();
				if(xDislocation < 0)
					animation++;
				else
					animation--;
				hit();
			}
			if(animation > 0) {
				theta += dTheta;
				xDislocation += 1;
				animation++;
			} else {
				theta -= dTheta;
				xDislocation -= 1;
				animation--;
			}
			
			if(Math.abs(animation) % 11 == 0)
				animation = 0;
		}
	}

	@Override
	public void paint(Graphics2D g2d) {
		p = player.getPosition();
		
		if(animation != 0)
			Animation();
		
		g2d.setColor(Color.GRAY);
		g2d.rotate(theta, p.getX()+xDislocation+5, p.getY()-20);
		g2d.fillRect((int)p.getX()+xDislocation, (int)p.getY()-20-RANGE, 10, RANGE);
		
		int[] x = new int[3];
		int[] y = new int[3];
		x[0]=(int)p.getX()+ xDislocation +12+6; x[1]=(int)p.getX()+ xDislocation+6; x[2]=(int)p.getX()+ xDislocation-12+6;
		y[0]=(int)p.getY()-20-RANGE+10; y[1]=(int)p.getY()-20-RANGE-10; y[2]=(int)p.getY()-20-RANGE+10;
		int n = 3;
		Polygon poly = new Polygon(x, y, n);  
		g2d.fillPolygon(poly);
		g2d.setColor(new Color(80, 20, 10));
		g2d.fillRect((int)p.getX()+xDislocation, (int)p.getY()-10-RANGE, 10, RANGE);
		g2d.rotate(-theta, p.getX()+xDislocation+5, p.getY()-20);
	}

}
