package others;
import java.awt.geom.Arc2D.Double;
import java.util.Random;

import entities.AnimateEntity;
import entities.HostileEntity;

public abstract class RandomMover extends HostileEntity{
	
	protected Random rdm;
	protected int movementCounter, xDirection, yDirection;	
	

	public RandomMover(double speed, int x, int y, World world, int width, int height) {
		super(speed, x, y, world, width, height);		
		rdm = new Random();
		movementCounter = 0;			
	}	
	
	public AnimateEntity checkArcIntersection(Double arc) {
		// TODO Auto-generated method stub
		return null;
	}

}
