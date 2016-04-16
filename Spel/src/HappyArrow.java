import javax.swing.ImageIcon;

public class HappyArrow extends SpriteEntity{
	private static ImageIcon icon = new ImageIcon(SpriteEntity.class.getResource("/PicResource/HappyArrow.png"));
	
	public HappyArrow(double speed, int x, int y) {
		super(speed, x, y, icon);
		
	}
	
	public void action(){
		if (movementCounter == 0) {
			xDirection = rdm.nextInt(3) - 1;
			movementCounter = 100;
		}
		position.setX(position.getX() + xDirection * speed);
		
		movementCounter--;
	}

}
