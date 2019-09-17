import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Studs0AppV2 extends JPanel implements Runnable {
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
	public Studs0AppV2(){
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
				bollX = bollX - vx;
				bollY = bollY - vy;
			
			}//end while
		}//end run()
		
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
		Studs0AppV2 p = new Studs0AppV2();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class