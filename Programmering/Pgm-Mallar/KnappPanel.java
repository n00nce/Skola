import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
// Kanpp som byter färg på etikett
//---------------------------------------------------------------------------------------------
public class KnappPanel extends JPanel implements ActionListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	JLabel lbl;
	JButton btn;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public KnappPanel(){
// Här dras bearbetningen igång
		this.setLayout(null);
		this.setBackground(Color.red);		//Etikettens utseende
		
		lbl = new JLabel("Detta är en JLabel");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setSize(300,50);
		lbl.setLocation(50,20);
		lbl.setFont(new Font("Arial",Font.ITALIC,20));
		lbl.setForeground(Color.yellow);
		lbl.setOpaque(true);
		lbl.setBackground(Color.blue);
		this.add(lbl);
		
		//Knappen
		btn = new JButton("Tryck");
		btn.setSize(300,50);
		btn.setLocation(50,150);
		btn.setFont(new Font("Arial", Font.BOLD, 20));
		btn.setForeground(Color.blue);
		btn.setOpaque(true);
		btn.setBackground(Color.yellow);
		btn.addActionListener(this);
		this.add(btn);
		
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
//System.out.println("actionPerformed()");
	if (lbl.getForeground().equals(Color.red)){
		lbl.setForeground(Color.yellow);
	}//end if
	else{
		lbl.setForeground(Color.red);
	}//end else
	}//end actionPerformed

//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (400,300);
		f.setLocation(900,100);
		f.setTitle("KnappPanel");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KnappPanel p = new KnappPanel();
		f.add(p);
		f.setVisible(true);
		
	}//end bearbeta()
}//end class


