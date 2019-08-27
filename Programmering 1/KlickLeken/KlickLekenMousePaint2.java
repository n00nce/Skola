import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
// Kanpp som byter f�rg p� etikett
//---------------------------------------------------------------------------------------------
public class KlickLekenMousePaint2 extends JPanel
implements Runnable,MouseListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	int sida = 40;
	Thread t = new Thread(this);
	int poang = 0;
	int x=100,y=100;
	int x2=50,y2=50;
	int rod=50,gron=50,bla=50;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public KlickLekenMousePaint2(){
// H�r dras bearbetningen ig�ng
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
			try{Thread.sleep(1000);}
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
	if (e.getX()>= x2 &&
		e.getX()<= x2+50 &&
		e.getY()>= y2 &&
		e.getY()<= y2+50) {
		poang = poang + 1;	
	}//end if
	}//end mouseClicked
//---------------------------------------------------------------------------------------------
// KlickLekenMousePaint2 knappen
//---------------------------------------------------------------------------------------------
	public void slumpa(){
	x = (int)(Math.random() * 500);
	y = (int)(Math.random() * 400 + 75);
	x2 = (int)(Math.random() * 500);
	y2 = (int)(Math.random() * 400 + 75);
	
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
// Instruktion och po�ngruta
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setColor(Color.white);
		g.drawString("Tryck p� knappen",0,50);
		g.drawString("Du har "+poang+" po�ng",0,550);
// Rutan
		g.setColor(new Color(rod,gron,bla,255));
		g.fillOval(x,y,sida,sida);
// Rutan 2
		g.setColor(new Color(rod,gron,bla,255));
		g.fillRect(x2,y2,sida,sida);
	}//end paint()
//---------------------------------------------------------------------------------------------
// Drar ig�ng programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (600,600);
		f.setLocation(1000,100);
		f.setTitle("KlickLekenMousePaint2");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KlickLekenMousePaint2 p = new KlickLekenMousePaint2();
		f.add(p);
		f.setVisible(true);
		
	}//end bearbeta()
}//end class


