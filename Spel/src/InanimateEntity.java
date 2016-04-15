import java.awt.Graphics;

public abstract class InanimateEntity {	
		
		protected Position position;
		
		public InanimateEntity(int x, int y) {			
			position = new Position(x, y);
		}
		
		public Position getPosition() {
			return position;
		}
		
		public abstract void paint(Graphics g);
	}


