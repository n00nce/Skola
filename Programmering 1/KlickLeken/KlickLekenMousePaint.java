import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
// Knapp som byter färg på etikett
//---------------------------------------------------------------------------------------------
public class KlickLekenMousePaint extends JPanel
implements Runnable,MouseListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	int sida = 40;
	Thread t = new Thread(this);
	int poang = 0;
	int x=100,y=100;
	int rod=50,gron=50,bla=50;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public KlickLekenMousePaint(){
// Här dras bearbetningen igång
		addMouseListener(this);
		slumpa();
		t.start();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void run() {
// System.out.println("run()");
	requestFocus();
	while(true){
			try{Thread.sleep(500);}
			catch(InterruptedException ie){}
			slumpa();
			repaint();
		}//end while
	}//end run
	
//---------------------------------------------------------------------------------------------
// mouseClicked
//---------------------------------------------------------------------------------------------
	
	public void mouseClicked(MouseEvent e){
// System.out.println("mouseClicked()");
	if (e.getX()>= x &&
		e.getX()<= x+50 &&
		e.getY()>= y &&
		e.getY()<= y+50) {
		poang = poang + 1;	
	}//end if
	}//end mouseClicked
//---------------------------------------------------------------------------------------------
// KlickLekenMousePaint knappen
//---------------------------------------------------------------------------------------------
	public void slumpa(){
	x = (int)(Math.random() * 500);
	y = (int)(Math.random() * 400 + 75);
	
	rod = (int)(Math.random() * 255);
	gron = (int)(Math.random() * 255);
	bla = (int)(Math.random() * 255);
	}//end slumpa
	
//---------------------------------------------------------------------------------------------
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
//---------------------------------------------------------------------------------------------
// Rita
//---------------------------------------------------------------------------------------------
	public void paint(Graphics g){
// System.out.println("paint()");
		g.clearRect(0,0,600,600);
		g.setColor(Color.blue);
		g.fillRect(0,0,600,600);
// Instruktion och poängruta
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.white);
		g.drawString("Tryck på knappen",0,50);
		g.drawString("Du har "+poang+" poäng",0,550);
// Rutan
		g.setColor(new Color(rod,gron,bla,255));
		g.fillOval(x,y,sida,sida);
	}//end paint()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (600,600);
		f.setLocation(1000,100);
		f.setTitle("KlickLekenMousePaint");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KlickLekenMousePaint p = new KlickLekenMousePaint();
		f.add(p);
		f.setVisible(true);
		
	}//end bearbeta()
}//end class


