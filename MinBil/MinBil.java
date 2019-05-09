import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class MinBil extends JPanel
implements Runnable{
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	int x=700,y=275;
	int vx=1;
	Thread t = new Thread(this);
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public MinBil(){
// Här dras bearbetningen igång
		t.start();
		start();
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void run(){
	requestFocus();
	while(true){
		try{Thread.sleep(5);}
		catch(InterruptedException ie){}
		repaint();
		start();
		x=x-vx;
	}//end while
}//end run()
	public void start(){
		x = (int) (x-1);
		y = (int) (y);
		if (x < -150) {
		x = 850;
		run();
	}//end if
}//end start()
//---------------------------------------------------------------------------------------------
// Rita
//---------------------------------------------------------------------------------------------
	public void paint(Graphics g){
// System.out.println("paint()");
		
		g.clearRect(0,0,800,400);
		
		//Himmel
		g.setColor(Color.blue);
		g.fillRect(0,0,800,150);
		//Gräs
		g.setColor(Color.green);
		g.fillRect(0,150,800,100);
		//Väg
		g.setColor(Color.gray);
		g.fillRect(0,250,800,150);
		//Mittlinje
		g.setColor(Color.white);
		for(int i=0;i<800;i=i+100){
		g.drawLine(i,300,i+50,300);
	}//end for i
		//Kaross
		g.setColor(Color.darkGray);
		g.fillRect(x,y,150,50);
		//Tak
		g.fillRect(x+40,y-40,110,40);
		g.setColor(Color.black);
		//Hjul
		g.fillOval(x+5,y+25,50,50);
		g.fillOval(x+95,y+25,50,50);
}//end paint()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (800,400);
		f.setLocation(900,100);
		f.setTitle("MinBil");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MinBil p = new MinBil();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class