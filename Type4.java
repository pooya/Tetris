import java.awt.Color;
import java.util.Random;


/**
 * object
 * 
 * case 0:
 * 		   **
 * 		  **
 * 	case 1:
 * 		*
 * 		**
 * 		 *
 * 			
 * @author shayan
 *
 */
public class Type4 extends DrawObject {

	private Color TYPE4_COLOR = Color.MAGENTA; 
	public Type4(){
		this(new Random().nextInt(2));
	}
	public Type4(int direction){		
		this.direction=direction;
		DIRECTION_NUMBER=2;		
	}
	
	public void draw() {
		switch(direction){
		case 0:
			Data.color[x][y]=TYPE4_COLOR;
			Data.color[x+1][y]=TYPE4_COLOR;
			Data.color[x][y+1]=TYPE4_COLOR;
			Data.color[x-1][y+1]=TYPE4_COLOR;			
			break;
		case 1:
			Data.color[x][y]=TYPE4_COLOR;
			Data.color[x][y+1]=TYPE4_COLOR;
			Data.color[x+1][y+1]=TYPE4_COLOR;
			Data.color[x+1][y+2]=TYPE4_COLOR;
			break;
		}
		

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
		int tempX = x + xChange;
		int tempY = y + yChange;
		nullMe();
		boolean flag= false;
		switch(direction){
		case 0:
			if( tempX-1 >= 0 
					&& tempX+1 < Attribute.COL_NUM 
					&& tempY >= 0 
					&& tempY+1 < Attribute.ROW_NUM)
				if(Data.color[tempX][tempY] == null 
						&&Data.color[tempX+1][tempY] == null
						&&Data.color[tempX][tempY+1] == null
						&&Data.color[tempX-1][tempY+1] == null){
					flag =true;
					setX(tempX);
					setY(tempY);					
				}
			break;
		case 1:
			if(tempX >=0 
					&& tempX+1 < Attribute.COL_NUM
					&& tempY >= 0 
					&& tempY +2 <= Attribute.ROW_NUM)
				if(	Data.color[tempX][tempY]==null
						&&Data.color[tempX][tempY+1]== null
						&& Data.color[tempX+1][tempY+1]==null
						&&Data.color[tempX+1][tempY+2]==null){
					flag = true;
					setX(tempX);
					setY(tempY);
				}
			break;
		}
		draw();
		return flag; 
	}

	@Override
	protected void nullMe() {
		switch(direction){
		case 0:
			Data.color[x][y]=null;
			Data.color[x+1][y]=null;
			Data.color[x][y+1]=null;
			Data.color[x-1][y+1]=null;			
			break;
		case 1:
			Data.color[x][y]=null;
			Data.color[x][y+1]=null;
			Data.color[x+1][y+1]=null;
			Data.color[x+1][y+2]=null;
			break;
		}


	}

	@Override
	public boolean reachBottom() {
		switch( direction){
		case 0:
			if( y+1+ 1 >= Attribute.ROW_NUM 
					||Data.color[x-1][y+2]!= null 
					|| Data.color[x][y+2] != null 
					|| Data.color[x+1][y+1] != null)
				return true;
			break;
		case 1:
			if(y+2 +1 >= Attribute.ROW_NUM 
					|| Data.color[x][y+2] != null 
					|| Data.color[x+1][y+3] !=null )
				return true;
			break;
		}
		return false;
	}

	@Override
	public void setDirection() {
		switch(direction){
		case 0:
			if( y+ 2 < Attribute.ROW_NUM 
					&& Data.color[x+1][y+1]== null
					&& Data.color[x+1][y+2]== null){
				direction = 1;
			}
			break;
		case 1:
			if( x-1 >= 0  
					&& Data.color[x+1][y]== null
					&& Data.color[x-1][y+1]== null){
				direction = 0;
			}
			break;
		}
	}

	@Override
	public void setX(int x) {
		switch( direction){
		case 0:
			if(x-1 >= 0 && x+1 < Attribute.COL_NUM )
				this.x= x;
			break;
		case 1:
			if(x >= 0 && x+1 < Attribute.COL_NUM )
				this.x = x; 
			break;
		}
	}

	@Override
	public void setY(int y) {
		switch(direction){
		case 0:
			if( y >= 0 && y+1 < Attribute.ROW_NUM )
				this.y = y;
			break;
		case 1:
			if( y >=0  && y+2 < Attribute.ROW_NUM)
				this.y = y;
			break;
		}

	}

}
