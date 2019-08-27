import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Schack extends JPanel {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Schack(){
// Här dras bearbetningen igång
		
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Rita
//---------------------------------------------------------------------------------------------
	public void paint(Graphics g){
// System.out.println("paint()");
		
		g.setColor(Color.blue);
		g.fillRect(0,0,600,600);
		
		//g.clearRect(100,100,400,400);
		
		for (int rad=0;rad<4;rad=rad+1){
			for (int kol=0;kol<4;kol=kol+1) {
				g.setColor(Color.black);
				g.fillRect(100+rad*100,100+kol*100,50,50);
				g.fillRect(150+rad*100,150+kol*100,50,50);
				
				g.setColor(Color.white);
				g.fillRect(150+rad*100,100+kol*100,50,50);
				g.fillRect(100+rad*100,150+kol*100,50,50);
			}
		}//end for i

	}//end paint()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (600,600);
		f.setLocation(900,100);
		f.setTitle("Kvadrater");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Schack p = new Schack();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class


