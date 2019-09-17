import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class StudsOvalV1 extends JPanel {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	double bollX=180;
	double bollY=180;
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
		bollX = bollX - vx;
		bollY = bollY - vy;
		
		//Studs Tak
		if(bollY <= 0) {
		vy = -vy;
		}//END IF
		
		//Studs Botten
		else if(bollY >= 350) {
		vy = -vy;
		}//END ELSE IF
		
		//Studs Vänster
		else if(bollX <= 0) {
		vx = -vx;
		}//END ELSE IF
		
		//Studs Höger
		else if(bollX >= 370) {
		vx = -vx;
		}//END ELSE IF
	}// end move()
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void draw (Graphics g){
//System.out.println("Paint()");
		g.setColor(Color.black);
		g.fillRect(0,0,400,400);
		
		g.setColor(Color.white);
		g.fillOval((int)bollX,(int)bollY, 20, 20);
	}//end draw()
}//end class