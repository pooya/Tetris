
public class Play {
	public Play(){
		Data.sleepTime = 10 ;
		Data.endGame = false;
		Data.nextObject = Data.getObject();
		Data.currentObject = Data.getObject();
	}
	public void mainLoop(){
		int removeLines ;
		boolean remove ;
		int counter=0 ; 
		while(!Data.endGame){
			try {
				Thread.sleep(Data.sleepTime);
			} catch (InterruptedException e) {}
			MyFrame.jFrame.repaint();			
			counter++;
			if( counter == Data.CYCLE_NUMBER ){				
				counter = 0;
				if ( Data.currentObject.reachBottom() ){
					Data.currentObject.lock();
					for(int i = 0 ; i < Attribute.COL_NUM ; i++)
						if( Data.color[i][0]!= null )
							Data.endGame = true;
					//removing the completed lines 
					removeLines= 0 ;
					remove=true;
					for(int i = Attribute.ROW_NUM-1 ; i >=0 ; i-- ){				
						remove = true;
						for(int j= 0 ; j < Attribute.COL_NUM ; j++ ){
							if(Data.color[j][i] == null ){
								remove = false; 
								break ; 
							}					
						}
						for(int j = 0 ; j < Attribute.COL_NUM ; j++ )
							Data.color[j][i+removeLines] = Data.color[j][i];
						if( remove )
							removeLines++;

					}
					for(int i = removeLines-1 ; i >= 0 ; i--)
						for(int j = 0 ; j < Attribute.COL_NUM ; j++ )
							Data.color[j][i] = null;

					Data.score += removeLines * removeLines * 10 ;
					Data.removedLines += removeLines;				
					try {
						Thread.sleep(Data.sleepInterval);
					} catch (InterruptedException e) {
						//e.printStackTrace();
						//ignore
					}
					Data.currentObject = Data.nextObject;
					Data.nextObject=Data.getObject();
				}
				else 
					Data.currentObject.move(0, 1);
			}
		}
	}
}


/*
for(int t = 0 ;t < Attribute.ROW_NUM  ;t ++){
	for(int j=0 ; j < Attribute.COL_NUM;j++){
		if( Data.color[j][t]== null )
			System.out.print("0 ");
		else
			System.out.print("1 ");
	}
	System.out.println();					
}
 */
//coming a new object
//	Data.currentObject.draw();

