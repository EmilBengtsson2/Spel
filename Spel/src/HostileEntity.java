import java.awt.Graphics;
import java.awt.geom.Arc2D.Double;

public abstract class HostileEntity extends AnimateEntity{

	public HostileEntity(double speed, int x, int y) {
		super(speed, x, y);
	}

	@Override
	public abstract void action();

	@Override
	public abstract void paint(Graphics g);

	public abstract AnimateEntity checkArcIntersection(Double arc);
}
