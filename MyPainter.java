import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPainter extends JPanel{
	
	private Graphics graph; 
	public MyPainter(){
	}
	public void paintComponent(Graphics graph){
		this.graph = graph ; 
		super.paintComponent(graph);

		Attribute.MAX_X = this.getSize().width;
		Attribute.MAX_Y = this.getSize().height;
		Attribute.X_BOX_BEGIN= Attribute.MAX_X/4; 
		Attribute.Y_BOX_BEGIN= Attribute.MAX_Y/10; 
		Attribute.PLAY_WIDTH = Attribute.MAX_X/3; 
		Attribute.PLAY_HEIGHT = 3 * Attribute.MAX_Y/4; 
		
		Attribute.XBOX_SIZE = Attribute.PLAY_WIDTH / Attribute.ROW_NUM;
		Attribute.YBOX_SIZE = Attribute.PLAY_HEIGHT / Attribute.COL_NUM;
		
		Attribute.X_SHOW_NEXT = 3* Attribute.MAX_X / 5 ;
		Attribute.Y_SHOW_NEXT =  Attribute.MAX_Y/ 5 ;
		Attribute.WIDTH_SHOW_NEXT =  Attribute.MAX_X / 5 ;
		Attribute.HEIGHT_SHOW_NEXT=  Attribute.MAX_Y / 5 ;
		
		Attribute.X_SCORE_PLACE = 5 * Attribute.MAX_X / 6 ; 
		Attribute.Y_SCORE_PLACE = 5 * Attribute.MAX_Y / 6 ;
		
		Attribute.Y_SMALL_DIFF = Attribute.MAX_Y/40 ; 
		Attribute.X_SMALL_DIFF = Attribute.MAX_Y/40 ;
		
		
//		System.err.println(Attribute.X_SHOW_NEXT + " : " + Attribute.Y_SHOW_NEXT);
//		System.err.println(Attribute.HEIGHT_SHOW_NEXT+ " : " + Attribute.WIDTH_SHOW_NEXT);

//		Data.color[5][4]=Color.black;
		paintBackGround();
		
	}
	//first
	private void paintBackGround(){
		
		//  drawing background
		graph.setColor(Color.yellow);
		graph.fillRect(0, 0, Attribute.MAX_X, Attribute.MAX_Y);
		
		//setting the icond
		
		// drawing play area
		graph.setColor(Color.blue);
		graph.fillRoundRect(Attribute.X_BOX_BEGIN, Attribute.Y_BOX_BEGIN,
				Attribute.PLAY_WIDTH, Attribute.PLAY_HEIGHT , 30, 30);		
		graph.drawRoundRect(Attribute.X_BOX_BEGIN, Attribute.Y_BOX_BEGIN,
				Attribute.PLAY_WIDTH, Attribute.PLAY_HEIGHT , 30, 30);
		
		// drawing next instruction 
		graph.setColor(Color.black);
		graph.drawRoundRect(Attribute.X_SHOW_NEXT, Attribute.Y_SHOW_NEXT, Attribute.WIDTH_SHOW_NEXT, Attribute.HEIGHT_SHOW_NEXT	,30,30);
		graph.fillRoundRect(Attribute.X_SHOW_NEXT, Attribute.Y_SHOW_NEXT, Attribute.WIDTH_SHOW_NEXT, Attribute.HEIGHT_SHOW_NEXT	,30,30);
		
		//drawBox(Attribute.X_SHOW_NEXT, Attribute.Y_SHOW_NEXT, Color.yellow);
		
		
		// drawing Strings
		graph.setFont(new Font(Font.SERIF,Font.BOLD,15));
		
		graph.drawString("Score: ", Attribute.X_SCORE_PLACE-50, Attribute.Y_SCORE_PLACE);
		graph.drawString(Data.score+""	, Attribute.X_SCORE_PLACE+100 , Attribute.Y_SCORE_PLACE );
		
		graph.drawString("Lines Removed: " , Attribute.X_SCORE_PLACE-50 , Attribute.Y_SCORE_PLACE + Attribute.Y_SMALL_DIFF);
		graph.drawString(Data.removedLines+""	, Attribute.X_SCORE_PLACE+100 , Attribute.Y_SCORE_PLACE + Attribute.Y_SMALL_DIFF );
		
		graph.drawString("Level: ", Attribute.X_SCORE_PLACE-50 , Attribute.Y_SCORE_PLACE + 2 * Attribute.Y_SMALL_DIFF);
		graph.drawString("1"	, Attribute.X_SCORE_PLACE+100 , Attribute.Y_SCORE_PLACE + 2 * Attribute.Y_SMALL_DIFF);
		
		
		
		for(int i = 0 ; i< Attribute.ROW_NUM ; i++){
			for(int j = 0 ; j < Attribute.COL_NUM ; j++){
				if( Data.color[i][j] != null )
					drawBox(getXofIndex(i), getYofIndex(j), Data.color[i][j]); 
			}
		}
		if( Data.endGame){
			graph.setColor(Color.black);
			graph.setFont(new Font(Font.SERIF,Font.BOLD,20));
			graph.drawString("You lost!", Attribute.X_BOX_BEGIN, Attribute.Y_BOX_BEGIN);
			System.err.println("ending");
			try {
				Thread.sleep(4* Data.sleepTime);
				System.exit(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	
	private int getXofIndex(int j) {
		//return Attribute.X_BOX_BEGIN + j * Attribute.PLAY_WIDTH / Attribute.ROW_NUM ;
		return Attribute.X_BOX_BEGIN + j * Attribute.XBOX_SIZE ;
	}
	private int getYofIndex(int i) {
//		return Attribute.Y_BOX_BEGIN + i * Attribute.PLAY_HEIGHT / Attribute.COL_NUM ;
		return Attribute.Y_BOX_BEGIN + i * Attribute.YBOX_SIZE ;
	}
	private void drawBox(int x_begin, int y_begin,Color c ){
		graph.setColor(c );
		graph.fillRoundRect(x_begin, y_begin,
				Attribute.XBOX_SIZE, Attribute.YBOX_SIZE, 10, 10);

		graph.setColor(Color.black);
		graph.drawRoundRect(x_begin, y_begin,
				Attribute.XBOX_SIZE, Attribute.YBOX_SIZE, 10, 10);	
	}


}
