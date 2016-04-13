
public abstract class AnimateEntity {
	
	protected double speed;
	protected Position position;
	
	public AnimateEntity(double speed, int x, int y) {
		this.speed = speed;
		position = new Position(x, y);
	}
	
	public Position getPosition() {
		return position;
	}
}
