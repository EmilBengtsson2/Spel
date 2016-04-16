package others;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import entities.Entity;

public class Block extends Entity {
	
	private static Image image = new ImageIcon(Block.class.getResource("/PicResource/Block.png")).getImage();
	
	public Block(int x, int y, World world) {
		super (x, y, world,image.getWidth(null), image.getHeight(null));		
		
	}	

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, (int)position.getX(), (int)position.getY(), null);		
	}

}
