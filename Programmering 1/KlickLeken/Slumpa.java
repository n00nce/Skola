import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
// Kanpp som byter färg på etikett
//---------------------------------------------------------------------------------------------
public class Slumpa extends JPanel implements ActionListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	JLabel instr;
	JButton knapp;
	JLabel poangRuta;
	int poang = 0;
	int x,y;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Slumpa(){
// Här dras bearbetningen igång
		this.setLayout(null);
		this.setBackground(Color.white);
				
		//Etikettens utseende
		instr = new JLabel("Klicka på knappen");
		instr.setHorizontalAlignment(SwingConstants.LEFT);
		instr.setSize(400,50);
		instr.setLocation(0,0);
		instr.setFont(new Font("Arial",Font.BOLD,20));
		instr.setForeground(Color.black);
		instr.setOpaque(true);
		instr.setBackground(Color.white);
		this.add(instr);
		
		//Knappen
		knapp = new JButton("");
		knapp.setSize(50,50);
		knapp.setLocation(250,250);
		knapp.setFont(new Font("Arial", Font.BOLD, 20));
		knapp.setForeground(Color.blue);
		knapp.setOpaque(true);
		knapp.setBackground(Color.red);
		knapp.addActionListener(this);
		this.add(knapp);
		
		poangRuta = new JLabel("Du har "+poang+" poäng");
		poangRuta.setHorizontalAlignment(SwingConstants.LEFT);
		poangRuta.setSize(400,50);
		poangRuta.setLocation(0,510);
		poangRuta.setFont(new Font("Arial",Font.ITALIC,20));
		poangRuta.setForeground(Color.black);
		poangRuta.setOpaque(true);
		poangRuta.setBackground(Color.white);
		this.add(poangRuta);
		
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
//System.out.println("actionPerformed()");
	poang = poang + 1;
	poangRuta.setText("Du har "+poang+" poäng");
	slumpa();
	}//end actionPerformed
	
//---------------------------------------------------------------------------------------------
// Slumpa knappen
//---------------------------------------------------------------------------------------------
	public void slumpa(){
	x = (int)(Math.random() * 500);
	y = (int)(Math.random() * 400 + 75);
	
	knapp.setLocation(x,y);
	}//end slumpa

//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (600,600);
		f.setLocation(1000,100);
		f.setTitle("Slumpa");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Slumpa p = new Slumpa();
		f.add(p);
		f.setVisible(true);
		
	}//end bearbeta()
}//end class


