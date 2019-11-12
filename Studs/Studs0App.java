import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Studs0App extends JPanel implements Runnable {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	Thread t = new Thread(this);
	Studs[] studs = new Studs[30];
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Studs0App(){
// Här dras bearbetningen igång
		for (int i=0; i<10; i=i+1) {
			studs[i] = new StudsOval();
		}
		for (int i=10; i<20; i=i+1) {
			studs[i] = new StudsBox();
		}
		for (int i=20; i<30; i=i+1) {
			studs[i] = new StudsTriangel();
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
			for (int i=0; i<studs.length; i=i+1) {
				studs[i].move();
			}
			repaint();
			
		}//end while
	}//end run()
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void paintComponent (Graphics g){
//System.out.println("Paint()");
		g.clearRect(0,0,400,400);
		g.setColor(Color.black);
		g.fillRect(0,0,400,400);
		
		for (int i=0; i<studs.length; i=i+1) {
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
		Studs0App p = new Studs0App();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class