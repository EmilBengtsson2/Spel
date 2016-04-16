

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ram extends JFrame{
	//Kom gärna på ett bättre namn
	//JFrame är typ som stage i javafx (tror jag)
	
	private Display display;
	private Engine engine;
	
	private final int WIDTH = 1200, HEIGHT = 900;
	private String title;
	
	public Ram () {
		
		title = "Fönstrets namn";
		
		//"Målarduken"
		display = new Display(WIDTH, HEIGHT);
		
		//I denna klassen finns "gameloopen"
		engine = new Engine(display, this);
		
		this.setTitle(title);
		// !!VIKTIGT!! Detta gör så att programmet inte fortsätter köra i bakgrunden när man stänger ner det
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//lägger in "målarduken"
		this.add(display);
		//pack() "packar" "ramen" runt det som ligger i den
		this.pack();
		//Gör ramen synlig
		this.setVisible(true);
		this.setResizable(false);
		//Gör så att fönstret hamnar i mitten på skärmen när man startar programmet
		this.setLocationRelativeTo(null);
		
		display.setup();
		engine.start();
	}
	
	//Fullskärm (typ)
	public void setFullscreen(boolean fullscreen) {
		if(fullscreen) {
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		} else {
			display.setSize(WIDTH, HEIGHT);
			this.pack();
			this.setLocationRelativeTo(null);
		}
	}

	public static void main(String[] args) {
		new Ram();
	}

}
