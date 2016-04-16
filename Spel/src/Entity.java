import java.awt.Graphics;

public abstract class Entity {			
		
		protected World world;
		protected Position position;
		protected int width;
		protected int height;
		
		public Entity(int x, int y, World world, int width, int height) {	
			position = new Position(x, y);
			this.world = world;
			this.width = width;
			this.height = height;			
		}
		
		public Position getPosition() {
			return position;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
		
		public abstract void paint(Graphics g);

	}


