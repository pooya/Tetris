import java.awt.Color;
import java.util.Random;


public class Data {
	
	public  static Color color[][] = new Color[Attribute.ROW_NUM][Attribute.COL_NUM];
	
	public static boolean endGame;
	
	public static int CYCLE_NUMBER = 30;
	
	public static int sleepInterval =300;
	
	public static DrawObject currentObject ;
	
	public static int sleepTime ;
	
	public static DrawObject nextObject;
	
	public static int score;
	
	public static int removedLines;
	
	public static DrawObject getObject(){
		int r=(new Random()).nextInt(6) +1;
		DrawObject dob=null;		
		switch (r) {
		case 1:
			dob= new Type1();
			break;
		case 2:
			dob = new Type2();
			break;
		case 3:
			dob = new Type3();
			break;
		case 4:
			dob = new Type4();
			break;
		case 5:
			dob = new Type5();
			break;
		case 6:
			dob = new Type6();
			break;
		}
		return dob;
	}

}
