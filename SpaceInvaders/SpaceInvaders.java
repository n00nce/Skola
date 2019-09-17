import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	boolean pilLeft = false, pilRight = false;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public SpaceInvaders(){
// Här dras bearbetningen ig�ng
		this.setLayout(null);
		addKeyListener(this);
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
			
		}//end run()
//--------------------------------------------------------------------------------------------------
// Knapptryckningar
//---------------------------------------------------------------------------------------------------	
//keyPressed
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) 	pilLeft 	= true;
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) 	pilRight 	= true;
	}//end keyPressed
//keyReleased
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) 	pilLeft 	= false;
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) 	pilRight 	= false;
	}//end keyReleased
//keyTyped
	public void keyTyped(KeyEvent ke){}
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(700,700);
		f.setLocation(1000,100);
		f.setTitle("Space Invaders");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpaceInvaders p = new SpaceInvaders();
		f.add(p);
		f.setVisible(true);
	}//end main()

}//end class


