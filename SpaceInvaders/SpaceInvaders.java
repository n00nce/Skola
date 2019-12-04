import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class SpaceInvaders extends JPanel
implements ActionListener, Runnable, KeyListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	Thread t = new Thread(this);
	JButton startKnapp;
	boolean pilLeft = false, pilRight = false, shoot = false;
	Alien[][] alien = new Alien[8][5];
	Shot shot = new Shot();
	int posX=380;
	int posY=100;
	int vx=10;
	int plyrX = 340; 
	int plyrY = 650;
	int slutX, slutY;
	int hits = 0;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public SpaceInvaders(){
// Här dras bearbetningen igång
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
		
		for (int i=0; i<8; i=i+1) {
			for (int j=0; j<5; j=j+1) {
				alien[i][j] = new Alien();
			}//for j
		}//for i 
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
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
				try{Thread.sleep(25);}
				catch(InterruptedException ie){}
				
				for (int i=0; i<8; i=i+1) {
					for (int j=0; j<5; j=j+1) {
						alien[i][j].move();
					}//for j
				}//for i 
				
				shot.move();
				hit();
				if (pilLeft) {
					plyrX = plyrX - vx;
				}
				if (pilRight) {
					plyrX = plyrX + vx;
				}
				endGame();
				repaint();
			}//while 
		}//end run()
//--------------------------------------------------------------------------------------------------
// Knapptryckningar
//---------------------------------------------------------------------------------------------------	

//keyPressed
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) 	pilLeft 	= true;
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) 	pilRight 	= true;
		//if(ke.getKeyCode() == KeyEvent.VK_SPACE)	shoot		= true;
	}//end keyPressed
//keyReleased
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) 	pilLeft 	= false;
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) 	pilRight 	= false;
		//if(ke.getKeyCode() == KeyEvent.VK_SPACE)	shoot		= false;
	}//end keyReleased
//keyTyped
	public void keyTyped(KeyEvent ke){}
//---------------------------------------------------------------------------------------------

// Counter
//---------------------------------------------------------------------------------------------
		public void endGame(){		
//			System.out.println("move();");
			if (hits==40) {
				JOptionPane.showMessageDialog(null,"Du vann!");
				for (int i=0; i<8; i=i+1) {
					for (int j=0; j<5; j=j+1) {
						alien[i][j].destroyed = false;
						hits=0;
					}//for j
				}//for i 
			}
		}// end move()
//---------------------------------------------------------------------------------------------

// Hit detection
//---------------------------------------------------------------------------------------------
		public void hit(){		
//					System.out.println("move();");
			for (int i=0; i<8; i=i+1) {
				for (int j=0; j<5; j=j+1) {
					if (shot.posX <= alien[i][j].x+20 	&&
						shot.posX+10 >= alien[i][j].x	&&
						shot.posY >= alien[i][j].y		&&
						shot.posY <= alien[i][j].y+20) {
						alien[i][j].destroyed = true;
						shot.posY = plyrY;
						shot.posX = plyrX;
						hits ++;
						}	
				}//for j
			}//for i 
		}// end move()
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void paintComponent (Graphics g){
//System.out.println("Paint()");
		g.setColor(Color.black);
		g.fillRect(0,0,700,700);
		for (int i=0; i<8; i=i+1) {
			for (int j=0; j<5; j=j+1) {
					slutX = posX+40*i;
					slutY = posY+40*j;
				if (!alien[i][j].destroyed &&
					alien[i][j].x>700) {
					
				}
				alien[i][j].draw(g, slutX, slutY);
				
			}//for j
		}//for i 
		
		g.setColor(Color.white);
		g.fillRect(plyrX,plyrY, 20, 20);

		shot.draw(g, plyrX, plyrY);
		//System.out.println("shot.draw");

	}//end paint
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(700,700);
		f.setLocation(100,100);
		f.setTitle("Space Invaders");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpaceInvaders p = new SpaceInvaders();
		f.add(p);
		f.setVisible(true);
	}//end main()

}//end class


