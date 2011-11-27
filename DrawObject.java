import java.util.Random;


public abstract class DrawObject {
	
	/**
	 * constructor of its children should have another parameter d
	 * @param x
	 * @param y
	 */
	
	public DrawObject(){
		x = Attribute.COL_NUM /2;
		y = 0;
		lock=false;
	}
	protected int x;
	protected int y;
	public abstract void draw();
	protected int direction;
	protected int DIRECTION_NUMBER;
	
	public abstract int getDirection();
	/**
	 * TODO implement this method using exeption
	 */
	public void changeDirection(){
		nullMe();
		setDirection();
		draw();
		
	}
	
	private boolean lock;
	public boolean isLocked(){
		return lock;
	}
	public void lock(){
		lock = true;
	}
	public void unlock(){
		lock = false;
		
	}
	
	public abstract void setDirection();
	public abstract int getX();
	public abstract int getY();
	public abstract void setX(int x);
	public abstract void setY(int y);
	

	public abstract boolean move(int xChange, int yChange);
	
	public abstract boolean reachBottom();
	
	protected abstract void nullMe();

}
