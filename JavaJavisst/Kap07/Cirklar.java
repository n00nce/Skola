import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
//---------------------------------------------------------------------------------------------
public class Cirklar extends JPanel {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Cirklar(){
// H�r dras bearbetningen ig�ng
		
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Rita
//---------------------------------------------------------------------------------------------
	public void paint(Graphics g){
// System.out.println("paint()");
		
		g.clearRect(0,0,600,600);
		
		g.setColor(Color.red);
		for(int i=0;i<400;i=i+10){
			g.drawOval(25,25,50+i,50+i);
		}//end for i

	}//end paint()
//---------------------------------------------------------------------------------------------
// Drar ig�ng programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (600,600);
		f.setLocation(900,100);
		f.setTitle("Cirklar");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cirklar p = new Cirklar();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class


