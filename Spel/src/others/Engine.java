package others;


import java.awt.Toolkit;

public class Engine implements Runnable {
	
	//Runnable har med trådhantering att göra, här används dock bara en tråd
	
	private Thread t;
	private Ram ram;
	private Display display;
	private World world;

	private PlayerListener listener;
	private boolean running;
	private final int FPS_CAP = 150;
	private int fps;
	
	public Engine (Display display, Ram ram) {
		this.display = display;
		this.ram = ram;
		t = new Thread(this);
		listener = new PlayerListener(this);		
		world = new World(listener);
	}

	public void start() {
		display.addKeyListener(listener);
		display.addMouseMotionListener(listener);
		display.addMouseListener(listener);
		display.requestFocus();
		fps = 0;
		running = true;
		t.start();
	}
	
	//Fullskärm (typ)
	public void setFullscreen(boolean fullscreen) {
		ram.setFullscreen(fullscreen);
		display.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	@Override
	public void run() {
		long time = 0, cycleTime, fpsTime = System.currentTimeMillis();
		double minCycleTime = Math.pow(10, 9) / FPS_CAP;
		int fpsCounter = 0;
		while(running) {
			if(System.currentTimeMillis() - fpsTime > 500) {
				fpsTime = System.currentTimeMillis();
				fps = fpsCounter * 2;
				fpsCounter = 0;
			}
			fpsCounter++;
			
			cycleTime = System.nanoTime() - time;
			if(cycleTime < minCycleTime) {
				try {
					Thread.sleep((int)((minCycleTime - cycleTime) / Math.pow(10, 6)));
				} catch (InterruptedException e) {
					System.out.println("Thread Interrupted");
				}
			}
			time = System.nanoTime();
			
			//Efter denna kommentaren skrivs allt spelrelaterat som ska hända i varje "frame/cykel"
			///////////////////////////////////////////////////////////////////////////////////////
			world.updateWorld();
			repaint();
			///////////////////////////////////////////////////////////////////////////////////////
		}
	}

	private void repaint() {
		display.paint(fps, world);
	}
}
