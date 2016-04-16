import javax.swing.ImageIcon;

public class RedSkull extends SpriteEntity{
	private static ImageIcon icon = new ImageIcon(SpriteEntity.class.getResource("/PicResource/RedSkull.png"));
	
	public RedSkull(double speed, int x, int y) {
		super(speed, x, y, icon);
		
	}

}
