import javax.swing.JFrame;

public class Ram extends JFrame{
	//Kom gärna på ett bättre namn
	//JFrame är typ som stage i javafx (tror jag)
	
	private Display display;
	private Engine engine;
	
	private final int WIDTH = 1200, HEIGHT = 900;
	
	public Ram () {
		
		//"Målarduken"
		display = new Display(WIDTH, HEIGHT);
		
		//I denna klassen finns "gameloopen"
		engine = new Engine(display);
		
		this.setTitle("Fönstrets namn");
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

	public static void main(String[] args) {
		new Ram();
	}

}
