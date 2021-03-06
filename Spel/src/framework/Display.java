package framework;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import others.World;

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
	
	public void paint(int fpsCounter, World world) {
		do {
			do {
				Graphics g = bs.getDrawGraphics();
				
				//Bakgrund
				//////////////////////////////////////////////////////////////////////////////
				g.setColor(Color.lightGray);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				//////////////////////////////////////////////////////////////////////////////
				
				//Ritar allt som inte �r bakgrunden (spelare, s� sm�ning om npcs kanske, osv.)
				world.paintWorld(g);
				
				g.setColor(Color.BLACK);
				g.drawString("" + fpsCounter, 2, 12);
				g.dispose();
			} while(bs.contentsRestored());
		} while(bs.contentsLost());
		bs.show();
	}
}
