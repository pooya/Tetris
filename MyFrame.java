import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;



public class MyFrame {
	public static JFrame jFrame;
	public static void main(String args[]){
		jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(true);
		MyPainter mPainter = new MyPainter(); 
		jFrame.add(mPainter);
		//jFrame.setIconImage();
		jFrame.setSize(1280,800);
		jFrame.setVisible(true);
		jFrame.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'p' || e.getKeyChar()=='P'){
					// pause  
				}
				if( e.getKeyCode() == 37) { // left key
					if( ! Data.currentObject.isLocked() )
						Data.currentObject.move(-1, 0);
				}
				if( e.getKeyCode() == 39 ){// right key
					if( !Data.currentObject.isLocked() )
						Data.currentObject.move(1, 0);
				}
				if( e.getKeyCode()==38 ){ // up key
					if( !Data.currentObject.isLocked() )
						Data.currentObject.changeDirection();
				}
				if( e.getKeyCode()== 40){ // down key
					if( !Data.currentObject.reachBottom())
						Data.currentObject.move(0, 1);
//						Data.currentObject.addY(); // increase the falling speed 
//					System.err.println("down");
				}
//				System.err.println(e.getKeyChar() + " : "+ e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {}

			public void keyTyped(KeyEvent e) {}
			
		});
		
		
//		System.err.println(jFrame.getSize().width ) ;
//		System.err.println(jFrame.getSize().height);
		Play p = new Play();
		p.mainLoop();
	}
	
}
