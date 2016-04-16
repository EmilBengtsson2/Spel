import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Block extends Entity {
	
	private Image image;
	
	public Block(int x, int y) {
		super (x, y);		
		initializeImage();
	}
	
	private void initializeImage() {
		ImageIcon icon = new ImageIcon(Block.class.getResource("/PicResource/Block.png"));
		image = icon.getImage();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int)position.getX(), (int)position.getY(), null);
		
	}

	@Override
	public void action() {
	}

}
