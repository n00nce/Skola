import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Studs0AppV6 extends JPanel implements Runnable {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	Thread t = new Thread(this);
	StudsOvalV1[] oval = new StudsOvalV1[10];
	StudsBoxV1[] box = new StudsBoxV1[10];
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Studs0AppV6(){
// Här dras bearbetningen igång
		for (int i=0; i<10; i=i+1) {
			oval[i] = new StudsOvalV1();
			box[i] = new StudsBoxV1();
		}
		t.start();
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
				oval[i].move();
				box[i].move();
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
			oval[i].draw(g);
			box[i].draw(g);
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
		Studs0AppV6 p = new Studs0AppV6();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class