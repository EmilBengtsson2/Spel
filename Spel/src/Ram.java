

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ram extends JFrame{
	//Kom g�rna p� ett b�ttre namn
	//JFrame �r typ som stage i javafx (tror jag)
	
	private Display display;
	private Engine engine;
	
	private final int WIDTH = 1200, HEIGHT = 900;
	private String title;
	
	public Ram () {
		
		title = "F�nstrets namn";
		
		//"M�larduken"
		display = new Display(WIDTH, HEIGHT);
		
		//I denna klassen finns "gameloopen"
		engine = new Engine(display, this);
		
		this.setTitle(title);
		// !!VIKTIGT!! Detta g�r s� att programmet inte forts�tter k�ra i bakgrunden n�r man st�nger ner det
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//l�gger in "m�larduken"
		this.add(display);
		//pack() "packar" "ramen" runt det som ligger i den
		this.pack();
		//G�r ramen synlig
		this.setVisible(true);
		this.setResizable(false);
		//G�r s� att f�nstret hamnar i mitten p� sk�rmen n�r man startar programmet
		this.setLocationRelativeTo(null);
		
		display.setup();
		engine.start();
	}
	
	//Fullsk�rm (typ)
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
