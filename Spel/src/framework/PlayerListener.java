package framework;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import others.Position;

public class PlayerListener implements KeyListener, MouseListener, MouseMotionListener{
	
	private boolean mouseDown, left, right, up, down;
	private int horizontalMult, verticalMult;
	private Position mousePos;
	private Engine engine;
	private boolean fullscreen;
	
	public PlayerListener(Engine engine) {
		this.engine = engine;
		fullscreen = false;
		horizontalMult = verticalMult = 0;
		mousePos = new Position(0, 0);
	}
	
	public boolean getMouseDown() {
		return mouseDown;
	}
	
	public int getHorizontalMult() {
		return horizontalMult;
	}
	
	public int getVerticalMult() {
		return verticalMult;
	}
	
	public Position getMousePos() {
		return mousePos;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePos.setX(e.getX());
		mousePos.setY(e.getY());
		mouseDown = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos.setX(e.getX());
		mousePos.setY(e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			up = true;
			verticalMult = -1;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			down = true;
			verticalMult = 1;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			left = true;
			horizontalMult = -1;
		} else if(e.getKeyCode() == KeyEvent.VK_D) {
			right = true;
			horizontalMult = 1;
		} else if(e.getKeyCode() == KeyEvent.VK_0) {
			if(fullscreen)
				fullscreen = false;
			else
				fullscreen = true;
			engine.setFullscreen(fullscreen);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
			if(down)
				verticalMult = 1;
			else
				verticalMult = 0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
			if(up)
				verticalMult = -1;
			else
				verticalMult = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
			if(right)
				horizontalMult = 1;
			else
				horizontalMult = 0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
			if(left)
				horizontalMult = -1;
			else
				horizontalMult = 0;
		}
	}
}
