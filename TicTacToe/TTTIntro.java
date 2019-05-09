import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class TTTIntro extends JPanel
implements ActionListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	JButton[] btn = new JButton[3];
	Color[] clr = {Color.red, Color.green, Color.blue};
	String[] clrTxt = {"Röd", "Grön", "Blå"};
	JLabel lbl;
	int n;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public TTTIntro(){
// Här dras bearbetningen igång
		this.setLayout(null);
		this.setBackground(Color.black);;
		bearbeta();
		
		lbl = new JLabel("Tryck");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setSize(300,50);
		lbl.setLocation(100,50);
		lbl.setFont(new Font("Arial",Font.BOLD,40));
		lbl.setForeground(Color.white);
		lbl.setOpaque(false);
		this.add(lbl);
		
		
		for (int i=0; i<3; i=i+1) {
			btn[i] = new JButton();
			btn[i].setSize(100,100);
			btn[i].addActionListener(this);
			btn[i].setLocation(100+i*100,200);
			btn[i].setBackground(clr[i]);
			this.add(btn[i]);
		}//end for i

	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
// System.out.println("bearbeta()");

	}//end bearbeta()
	public void actionPerformed(ActionEvent e){
		n = (int)(Math.random() * 3);
		lbl.setText("Tryck "+clrTxt[n]+" ");
	}//end actionPerformed
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (500,500);
		f.setLocation(900,100);
		f.setTitle("TTTIntro");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TTTIntro p = new TTTIntro();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class


