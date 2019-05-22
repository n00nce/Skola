import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class korBil 
					extends JPanel
					implements KeyListener, Runnable{
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	Bil bil = new Bil();
	Thread t = new Thread(this);
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public korBil(){
// Här dras bearbetningen igång
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		addKeyListener((KeyListener) this);
		requestFocus();
		
		t.start();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void run(){
// System.out.println("run()");
		while(true){
			try {Thread.sleep(100);}
			catch(InterruptedException ie) {}
			bil.move();
			repaint();
			requestFocus();
		}
		
	}//end run()

	public void paintComponent(Graphics g) {
		bil.draw(g);
	}
	
		
		
	
	public void keyPressed (KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			bil.vinkel = bil.vinkel + 1.5;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			bil.vinkel = bil.vinkel - 1.5;
		}
	}
	
	public void keyReleased (KeyEvent ke) {}
	public void keyTyped (KeyEvent ke) {}
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (1200,800);
		f.setLocation(300,10);
		f.setTitle("");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		korBil p = new korBil();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class


