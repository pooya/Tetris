import java.awt.Color;
import java.util.Random;


/**
 * objects of the  form: 
 * 
 * 						**
 * 						**
 * @author shayan
 *
 */
public class Type1 extends DrawObject {

	public static Color TYPE1_COLOR = Color.cyan ;
	public Type1(){
		this(new Random().nextInt(1));
	}
	public Type1(int direction){		
		this.direction=direction;
		DIRECTION_NUMBER=1;		
	}
/*	@Override
	public void changeDirection(){
		
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public void draw() {
//		System.err.println("draw " + x + " : " + y );
		Data.color[x][y]=TYPE1_COLOR;
		Data.color[x+1][y]=TYPE1_COLOR;
		Data.color[x][y+1]=TYPE1_COLOR;
		Data.color[x+1][y+1]=TYPE1_COLOR;
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public boolean move(int xChange, int yChange) {
		nullMe();
		boolean flag = false;
		if( x + xChange >= 0 && 
				x + xChange < Attribute.COL_NUM-1  &&
				y + yChange > 0 && 
				y + yChange < Attribute.ROW_NUM )
			if( Data.color[x+xChange][y+yChange]== null && 
					Data.color[x+xChange+1][y+yChange]== null && 
					Data.color[x+xChange][y+yChange+1]== null && 
					Data.color[x+xChange+1][y+yChange+1]== null ){			
				setX(getX() + xChange) ; 
				setY(getY() +yChange) ;
				flag =true;
			}
		draw();
		return flag;
	}

	//@Override
	protected void nullMe() {
		Data.color[x][y]=null;
		Data.color[x+1][y]=null;
		Data.color[x][y+1]=null;
		Data.color[x+1][y+1]=null;

	}

	@Override
	public boolean reachBottom() {
		if(this.getY() + 2 >= Attribute.ROW_NUM||				
				Data.color[this.getX()][this.getY()+2] != null ||
				Data.color[this.getX() +1 ][ this.getY()+2] != null )
			return true;
		return false;
	}

	@Override
	public void setX(int x) {
		if( x >= 0 && x < Attribute.COL_NUM-1  )
			this.x = x;	
	}

	@Override
	public void setY(int y) {
		if( y > 0 &&  y < Attribute.ROW_NUM )
			this.y = y;
	}
	@Override
	public void setDirection() {
	}
	

}
