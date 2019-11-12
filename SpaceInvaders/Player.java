import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Player extends JPanel implements KeyListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	int posX=340, posY=650;
	boolean pilLeft = false, pilRight = false;
	int vx=2;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Player(){
// Här dras bearbetningen igång
		addKeyListener(this);
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void move(){		
//		System.out.println("move();");
		if (pilLeft) {
			posX = posX - vx;
		}
		if (pilRight) {
			posX = posX + vx;
		}
	}// end move()
//--------------------------------------------------------------------------------------------------
// Knapptryckningar
//---------------------------------------------------------------------------------------------------	
//keyPressed
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) 	pilLeft 	= true;
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) 	pilRight 	= true;
	}//end keyPressed
//keyReleased
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) 	pilLeft 	= false;
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) 	pilRight 	= false;
	}//end keyReleased
//keyTyped
	public void keyTyped(KeyEvent ke){}

//---------------------------------------------------------------------------------------------
// Rita	
//---------------------------------------------------------------------------------------------
	public void draw(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(posX,posY, 20, 20);
	}//draw

}//end class