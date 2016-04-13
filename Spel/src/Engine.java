
public class Engine implements Runnable {
	
	private Thread t;
	private Display display;
	private EntityController entity;
	private PlayerListener listener;
	private boolean running;
	private final int FPS_CAP = 150;
	private int fps;
	
	public Engine (Display display) {
		this.display = display;
		t = new Thread(this);
		listener = new PlayerListener();
		entity = new EntityController(listener);
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
			entity.update();
			repaint();
			///////////////////////////////////////////////////////////////////////////////////////
		}
	}

	private void repaint() {
		display.paint(fps, entity);
	}
}
