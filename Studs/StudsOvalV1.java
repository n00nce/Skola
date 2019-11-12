import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class StudsOvalV1 extends JPanel {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	double posX=180;
	double posY=180;
	int size = 20;
	double vx, vy;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public StudsOvalV1(){
// Här dras bearbetningen igång
		vx = 2*Math.random()-1;
		vy = 2*Math.random()-1;
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void move(){
		posX = posX - vx;
		posY = posY - vy;
		
		//Studs Tak
		if(posY <= 0) {
		vy = -vy;
		}//END IF
		
		//Studs Botten
		else if(posY >= 350) {
		vy = -vy;
		}//END ELSE IF
		
		//Studs Vänster
		else if(posX <= 0) {
		vx = -vx;
		}//END ELSE IF
		
		//Studs Höger
		else if(posX >= 370) {
		vx = -vx;
		}//END ELSE IF
	}// end move()
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void draw (Graphics g){
//System.out.println("Paint()");
		g.setColor(Color.white);
		g.fillOval((int)posX,(int)posY, size, size);
	}//end draw()
}//end class