import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Studs0AppV5 extends JPanel implements Runnable {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	Thread t = new Thread(this);
	StudsOvalV1[] studs = new StudsOvalV1[10];
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Studs0AppV5(){
// Här dras bearbetningen igång
		t.start();
		for (int i=0; i<10; i=i+1) {
			studs[i] = new StudsOvalV1();
		}
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void run(){
	requestFocus();
		while(true){
			try{Thread.sleep(1);}
			catch(InterruptedException ie){}
			repaint();
			for (int i=0; i<10; i=i+1) {
				studs[i].move();
			}
			
		}//end while
	}//end run()
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void paintComponent (Graphics g){
//System.out.println("Paint()");
		g.setColor(Color.black);
		g.fillRect(0,0,400,400);
		
		for (int i=0; i<10; i=i+1) {
			studs[i].draw(g);
		}

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
		Studs0AppV5 p = new Studs0AppV5();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class