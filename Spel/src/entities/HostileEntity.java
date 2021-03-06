package entities;
import java.awt.Graphics;
import java.awt.geom.Arc2D.Double;

import others.World;

public abstract class HostileEntity extends AnimateEntity{

	public HostileEntity(double speed, int x, int y, World world, int width, int height) {
		super(speed, x, y, world, width, height);
	}


	@Override
	public abstract void paint(Graphics g);

	public abstract AnimateEntity checkArcIntersection(Double arc);
}
