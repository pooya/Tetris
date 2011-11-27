import java.awt.Color;
import java.util.Random;



public class Type2 extends DrawObject{
	
	
	public Type2(){
		this(new Random().nextInt(2));
	}
	public Type2(int direction){
		this.direction=direction;
		DIRECTION_NUMBER=2;		
	}
	/*public Type2(){
		super(Attribute.COL_NUM/2,0);
		direction = 0 ; 
		DIRECTION_NUMBER=2;
	}
	*/
	public static Color TYPE2_COLOR = Color.white ;
	@Override
	public void draw() {
		switch(direction){
		case 0: // * * * * 
			Data.color[x][y]=TYPE2_COLOR;
			Data.color[x+1][y]=TYPE2_COLOR;
			Data.color[x+2][y]=TYPE2_COLOR;
			Data.color[x+3][y]=TYPE2_COLOR;			
			break;
		case 1:
			Data.color[x][y]=TYPE2_COLOR;
			Data.color[x][y+1]=TYPE2_COLOR;
			Data.color[x][y+2]=TYPE2_COLOR;
			Data.color[x][y+3]=TYPE2_COLOR;
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
		boolean flag=false;
		nullMe();
		int tempX= x + xChange;
		int tempY= y + yChange;
		switch(direction){
		case 0:
			if( tempX >= 0 && tempX + 3 < Attribute.COL_NUM 
					&& tempY >=0 && tempY < Attribute.ROW_NUM )
				if(Data.color[tempX][tempY] == null &&
						Data.color[tempX+1][tempY] == null &&
						Data.color[tempX+2][tempY] == null &&
						Data.color[tempX+3][tempY] == null){
					this.setX(tempX);
					this.setY(tempY);
					flag = true;
				}
			break;
		case 1:
			if( tempX >= 0 && tempX < Attribute.COL_NUM 
					&& tempY >=0 && tempY+3 < Attribute.ROW_NUM )
				if(Data.color[tempX][tempY] == null &&
						Data.color[tempX][tempY+1] == null &&
						Data.color[tempX][tempY+2] == null &&
						Data.color[tempX][tempY+3] == null){
					this.setX(tempX);
					this.setY(tempY);
					flag = true;
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
			Data.color[x+2][y]=null;
			Data.color[x+3][y]=null;
			break;
		case 1:
			Data.color[x][y]=null;
			Data.color[x][y+1]=null;
			Data.color[x][y+2]=null;
			Data.color[x][y+3]=null;
			break;
		}
		

	}

	@Override
	public boolean reachBottom() {
		switch(direction){
		case 0:
			if( y+1 >= Attribute.ROW_NUM 
					||Data.color[x][y+1] != null					
					|| Data.color[x+1][y+1] !=null 
					|| Data.color[x+2][y+1] !=null
					|| Data.color[x+3][y+1] !=null)
				return true;			
			break;
		case 1:
			if( y+3+1 >= Attribute.ROW_NUM || Data.color[x][y+3+1] !=null)
				return true;
			break;
		}

		return false;
	}

	@Override
	public void setX(int x) {
		switch(direction){
		case 0:
			if(x>= 0 && x +3 < Attribute.COL_NUM )
				this.x= x;
			break;
		case 1:
			if( x >= 0 && x< Attribute.COL_NUM )
				this.x= x;
			break;
		}
		
	}

	@Override
	public void setY(int y) {
		switch(direction){
		case 0:
			if( y >= 0 && y< Attribute.ROW_NUM )
				this.y= y;
			break;
		case 1:
			if(y>= 0 && y +3 < Attribute.ROW_NUM )
			
				this.y= y;
			break;
		}

		
	}

	@Override
	public void setDirection(){
		switch( direction){
		case 0: // **** to vertical
			if( y+3 < Attribute.ROW_NUM
					&& Data.color[x][y+1] == null 
					&& Data.color[x][y+2] == null
					&& Data.color[x][y+3] == null)
				direction=1;
			break;
		case 1:// vertical to ****
			if( x+3 < Attribute.COL_NUM
					&& Data.color[x+1][y] == null 
					&& Data.color[x+2][y] == null
					&& Data.color[x+3][y] == null)
				direction = 0;				
			break;
		}
	}
}
