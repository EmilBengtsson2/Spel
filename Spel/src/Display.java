import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Display extends Canvas{
	
	private BufferStrategy bs;

	public Display(int width, int height) {
		this.setSize(width, height);
		this.setBackground(Color.GREEN);
	}
	
	public void setup() {
		this.createBufferStrategy(2);
		bs = this.getBufferStrategy();
	}
	
	public void paint(int fpsCounter, EntityController entity) {
		do {
			do {
				Graphics g = bs.getDrawGraphics();
				
				//Bakgrund
				//////////////////////////////////////////////////////////////////////////////
				g.setColor(Color.GREEN);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				//////////////////////////////////////////////////////////////////////////////
				
				//Ritar allt som inte är bakgrunden (spelare, så småning om npcs kanske, osv.)
				entity.paintEntity(g);
				
				g.setColor(Color.BLACK);
				g.drawString("" + fpsCounter, 2, 12);
				g.dispose();
			} while(bs.contentsRestored());
		} while(bs.contentsLost());
		bs.show();
	}
}
