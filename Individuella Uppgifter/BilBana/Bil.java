import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
//---------------------------------------------------------------------------------------------
public class Bil { 
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	int x, y;
	ImageIcon bil = new ImageIcon("");
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Bil(){

	}//end konstruktor

//---------------------------------------------------------------------------------------------
// Rita
//---------------------------------------------------------------------------------------------
	public void draw(Graphics g){
// System.out.println("draw()");
		g.clearRect(0,0,400,300);
		//Body
		g.setColor(Color.red);
		g.fillRect(x,y,65,150);
		//Ruta fram
		g.setColor(Color.darkGray);
		g.fillRect(x+10,y+40,45,20);
		//Ruta bak
		g.setColor(Color.darkGray);
		g.fillRect(x+10,y+110,45,20);
		//Tak
		g.setColor(Color.darkGray);
		g.drawRect(x+10,y+60,44,50);
		//Huv
		g.setColor(Color.darkGray);
		g.drawRect(x+10,y,44,34);
		//Skuff
		g.setColor(Color.darkGray);
		g.drawRect(x+10,y+132,44,17);
		
		super.paintComponent(g);
		bil.paintIcon(this,g,0,0);
	}//end paint()
}//end class