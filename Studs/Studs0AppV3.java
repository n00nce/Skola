import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Studs0AppV3 extends JPanel implements Runnable {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	double bollX=180;
	double bollY=180;
	double vx, vy;
	Thread t = new Thread(this);
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Studs0AppV3(){
// Här dras bearbetningen igång
		vx = 2*Math.random()-1;
		vy = 2*Math.random()-1;
		t.start();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
//Run
	public void run(){
	requestFocus();
		while(true){
			try{Thread.sleep(5);}
			catch(InterruptedException ie){}
			repaint();
			move();
			bollX = bollX - vx;
			bollY = bollY - vy;
			
		}//end while
	}//end run()
//Move
	public void move(){
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
	}
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void paintComponent (Graphics g){
//System.out.println("Paint()");
		g.setColor(Color.black);
		g.fillRect(0,0,400,400);
		
		g.setColor(Color.white);
		g.fillOval((int)bollX,(int)bollY, 20, 20);
	}//end paint
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (400,400);
		f.setLocation(900,100);
		f.setTitle("PanelMall");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Studs0AppV3 p = new Studs0AppV3();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class