package others;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import entities.AnimateEntity;
import framework.PlayerListener;
import weapons.Weapon;

public class Player extends AnimateEntity {
	
	
	private static Image image = new ImageIcon(Player.class.getResource("/PicResource/Player.gif")).getImage();
	private PlayerListener listener;
	private Position mousePos;
	private Weapon weapon;
	private double rotation;
	
	public Player(double speed, int x, int y, PlayerListener listener, World world) {
		super(speed, x, y, world, image.getWidth(null), image.getHeight(null));
		this.listener = listener;
		mousePos = listener.getMousePos();
		health = 5;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Position getMousePosition() {
		return mousePos;
	}
	
	public boolean getMouseDown() {
		return listener.getMouseDown();
	}
	
	/**
	 * @return rotation in radians
	 */
	public double getRotation() {
		return rotation;
	}
	
	@Override
	public void action() {
		
		position.setX(position.getX() + speed * listener.getHorizontalMult());
		position.setY(position.getY() + speed * listener.getVerticalMult());
		mousePos = listener.getMousePos();
		if(listener.getMouseDown())
			weapon.Animation();

	}
	@Override
	public void paint(Graphics g) {
		double x = position.getX() + (getWidth()/2);
		double y = position.getY() + (getHeight()/2);
		double mX = mousePos.getX();
		double mY = mousePos.getY();
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.rotate(Math.PI/2, x, y);
		rotation = Math.PI/2;
		
		if(mY < y) {
			if(mX > x) {
				g2d.rotate(-Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
				rotation += -Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2)));
			} else {
				g2d.rotate(Math.PI + Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
				rotation += Math.PI + Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2)));
			}
		} else {
			if(mX > x) {
				g2d.rotate(Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
				rotation += Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2)));
			} else {
				g2d.rotate(Math.PI-Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2))), x, y);
				rotation += Math.PI-Math.acos((Math.abs(mX-(x)))/Math.sqrt(Math.pow(y-mY, 2) + Math.pow(mX-(x), 2)));
			}
		}
		
		if(weapon != null)
			weapon.paint(g2d);
		g2d.drawImage(image, (int)position.getX(), (int)position.getY(), width, height, null);
		
		//g2d.setColor(Color.BLUE);
		//g2d.fillRect((int)position.getX()-20, (int)position.getY()-20, 40, 40);
		
		g2d.dispose();
	}
}
