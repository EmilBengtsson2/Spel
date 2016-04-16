import java.awt.Graphics;

public abstract class Entity {	
		
		protected Position position;
		
		public Entity(int x, int y) {			
			position = new Position(x, y);
		}
		
		public Position getPosition() {
			return position;
		}
		
		public abstract void paint(Graphics g);
	}


