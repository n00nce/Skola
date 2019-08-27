import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//--------------------------------------------------------------------------------------------------
// Pong
//--------------------------------------------------------------------------------------------------
public class Pong extends JPanel
implements ActionListener, Runnable, KeyListener {
//--------------------------------------------------------------------------------------------------
// Deklarationer
//--------------------------------------------------------------------------------------------------
	int vRacketX = 90, vRacketY = 290;
	int hRacketX = 590, hRacketY = 290;
	int racketBredd = 10;
	double bollX = 345, bollY = 323;
	double vx = 1.5, vy = 0.5;
	int RacketY = 2;
	int vPoang = 0, hPoang = 0;
	JButton startKnapp;
	Thread t = new Thread(this);
	boolean sDown = false, wUp = false;
	boolean pilDown = false, pilUp = false;
//--------------------------------------------------------------------------------------------------
// Konstruktor
//--------------------------------------------------------------------------------------------------
	public Pong (){
//Här dras bearbetningen igång
		this.setLayout(null);
		addKeyListener(this);
//Knapp
		startKnapp = new JButton("PLAY");
		startKnapp.setSize(700,50);
		startKnapp.setLocation(0,0);
		startKnapp.setFont(new Font("Arial", Font.BOLD, 20));
		startKnapp.setForeground(Color.black);
		startKnapp.setOpaque(true);
		startKnapp.setBackground(Color.lightGray);
		startKnapp.addActionListener(this);
		this.add(startKnapp);
	}//end konstruktor
//--------------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//--------------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
//actionPerformed
	startKnapp.setVisible(false);
	startKnapp.removeActionListener(this);
	t.start();
	}//end actionPerformed
//Run
	public void run(){
	requestFocus();
		while(true){
			try{Thread.sleep(5);}
			catch(InterruptedException ie){}
			repaint();
			bollX = bollX - vx;
			bollY = bollY - vy;
		//Knappar
			if(wUp) vRacketY = vRacketY - RacketY;
			if(sDown) vRacketY = vRacketY + RacketY;
			if(pilUp) hRacketY = hRacketY - RacketY;
			if(pilDown) hRacketY = hRacketY + RacketY;
		//Racket limit
			if(vRacketY<0) vRacketY = 0; 
			if(vRacketY>600) vRacketY = 600; 
			if(hRacketY<0) hRacketY = 0; 
			if(hRacketY>600) hRacketY = 600;
		//Studs Racket
			if(bollX <= vRacketX+racketBredd &&
				bollX >= vRacketX &&
				bollY >= vRacketY &&
				bollY <= vRacketY+60) {
				vy = (int)(Math.random()*4)-2;
				vx = -vx;
			}//END IF
			else if(bollX <= hRacketX + racketBredd &&
					bollX >= hRacketX &&
					bollY >= hRacketY &&
					bollY <= hRacketY+60) {
					vy = (int)(Math.random()*4)-2;
					vx = -vx;
			}//END ELSE IF
		//Studs Vägg
			if((int)bollY <= 0) {
			vy = -vy;
			}//END IF
			else if((int)bollY >= 650) {
			vy = -vy;
			}//END ELSE IF
		//Poäng
			if(bollX <= 0) {
			bollX = 345;
			bollY = 323;
			hPoang = hPoang + 1;
			vx = -vx;
			vRacketY = 290;
			hRacketY = 290;
			}
			else if(bollX >= 700) {
			bollX = 345;
			bollY = 323;
			vPoang = vPoang + 1;
			vx = -vx;
			vRacketY = 290;
			hRacketY = 290;
			}
		}//end while
	}//end run()
//--------------------------------------------------------------------------------------------------
// Knapptryckningar
//---------------------------------------------------------------------------------------------------	
//keyPressed
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode() == KeyEvent.VK_W) wUp = true;
		if(ke.getKeyCode() == KeyEvent.VK_S) sDown = true;
		if(ke.getKeyCode() == KeyEvent.VK_UP) pilUp = true;
		if(ke.getKeyCode() == KeyEvent.VK_DOWN) pilDown = true;
	}//end keyPressed
//keyReleased
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_W) wUp = false;
		if(ke.getKeyCode() == KeyEvent.VK_S) sDown = false;
		if(ke.getKeyCode() == KeyEvent.VK_UP) pilUp = false;
		if(ke.getKeyCode() == KeyEvent.VK_DOWN) pilDown = false;
	}//end keyReleased
//keyTyped
	public void keyTyped(KeyEvent ke){}
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void paint (Graphics g){
//System.out.println("Paint()");
//Bakgrund
		g.setColor(Color.black);
		g.fillRect(0,0,700,700);
//Mittenlinjen
		g.setColor(Color.gray);
		for(int i = 0; i < 700; i = i + 2){
			g.fillRect(345,i*10,10,10);
		}//end for i
//Poängtavla
		g.setFont(new Font("Arial", Font.BOLD, 90));
		g.drawString(""+vPoang+"", 150, 150);
		g.drawString(""+hPoang+"", 500, 150);
//Vänster Racket
		g.setColor(Color.white);
		g.fillRect(vRacketX,vRacketY,racketBredd,60);
//Höger Racket
		g.setColor(Color.white);
		g.fillRect(hRacketX,hRacketY,racketBredd,60);
//runda bollen
		g.setColor(Color.white);
		g.fillOval((int)bollX,(int)bollY,10,10);
	}//end paint
//--------------------------------------------------------------------------------------------------
// Drar igång programet
//--------------------------------------------------------------------------------------------------
	public static void main(String[]args) {
		JFrame f = new JFrame();
		f.setSize(700,700);
		f.setLocation(1000,100);
		f.setTitle("Pong");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pong p = new Pong();
		f.add(p);
		f.setVisible(true);
	}//end main()
}//end class
//--------------------------------------------------------------------------------------------------