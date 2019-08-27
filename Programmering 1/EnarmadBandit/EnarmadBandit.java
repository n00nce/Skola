import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class EnarmadBandit extends JPanel
implements ActionListener{
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	JLabel[] ruta = new JLabel[3];
	JLabel credit, win;
	JButton spin;
	int credits=100;
	ImageIcon background = new ImageIcon("EnarmadBandit.gif");
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public EnarmadBandit(){
// Här dras bearbetningen igång
		this.setLayout(null);
		this.setBackground(Color.white);

		for (int i=0; i<3; i=i+1) {
			ruta[i] = new JLabel();
			ruta[i].setSize(50, 50);
			ruta[i].setLocation(85+i*67,173);
			ruta[i].setOpaque(true);
			ruta[i].setFont(new Font("Arial", Font.BOLD, 50));
			ruta[i].setBackground(Color.white);
			ruta[i].setForeground(Color.black);
			ruta[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.add(ruta[i]);
		}//end for i

		//Credits
			credit = new JLabel("Credits: "+credits+"");
			credit.setSize(150,50);
			credit.setLocation(350, 50);
			credit.setOpaque(false);
			credit.setFont(new Font("Arial", Font.BOLD, 20));
			credit.setForeground(Color.black);
			credit.setHorizontalAlignment(SwingConstants.CENTER);
			this.add(credit);
		//Spin Knapp
			spin = new JButton();
			spin.setSize(50,50);
			spin.setLocation(357,99);
			spin.setOpaque(false);
			spin.setBackground(Color.white);
			spin.addActionListener(this);
			this.add(spin);
		//Win
			win = new JLabel();
			win.setSize(250, 100);
			win.setLocation(55, 330);
			win.setOpaque(true);
			win.setFont(new Font("Arial", Font.BOLD, 20));
			win.setForeground(Color.white);
			win.setBackground(Color.black);
			win.setHorizontalAlignment(SwingConstants.CENTER);
			this.add(win);
						
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
//System.out.println("actionPerformed()");
		spin(e);
		kollaRad();
		newCredits();
		
}//end actionPerformed	
//---------------------------------------------------------------------------------------------
// Visa Vinnare
//---------------------------------------------------------------------------------------------
	public int random() {
		int x = (int)(Math.random()*(9-1)+1);
//System.out.println(x);
		
		return x;
	
	}//END 
//---------------------------------------------------------------------------------------------
// Markera Val
//---------------------------------------------------------------------------------------------
	public void spin(ActionEvent e) {
//System.out.println("markeraVal()");
		win.setText("");
		if(credits>=10) {
			credits=credits-10;
			for (int i=0; i<3; i=i+1) {
					ruta[i].setText(""+random()+"");	
			}//END FOR rad
		}//END if
		else if(credits==0) {
			win.setText("<html>Dina credits är slut.<br> Spelet är över</html>");
		}
		
	}//END spin
	
//---------------------------------------------------------------------------------------------
// Kolla Rad
//---------------------------------------------------------------------------------------------
	public void kollaRad() {
//System.out.println("kollaRad()");
		
			if (ruta[0].getText().equals(ruta[1].getText()) &&
				ruta[0].getText().equals(ruta[2].getText())) {
				credits=credits+100;
				win.setText("Du har vunnit: 100 Credits");
				
			}//END if 3 LIKA
			else if(ruta[0].getText().equals(ruta[1].getText()) ||
					ruta[1].getText().equals(ruta[2].getText())) {
					credits=credits+50;
					win.setText("Du har vunnit: 50 Credits");
			}//END else if 2 lika
	}//END kollaRad
//---------------------------------------------------------------------------------------------
// New Credits
//---------------------------------------------------------------------------------------------
	public void newCredits() {
		credit.setText("Credits: "+credits+"");
	}//END newCredits
	
//---------------------------------------------------------------------------------------------
// Rita Bakgrund
//---------------------------------------------------------------------------------------------
	public void paintComponent(Graphics g) {
//System.out.println("paintComponent()");
		super.paintComponent(g);
		background.paintIcon(this,g,0,0);
	}//END paintComponent
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (500,500);
		f.setLocation(900,100);
		f.setTitle("EnarmadBandit");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EnarmadBandit p = new EnarmadBandit();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class


