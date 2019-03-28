import javax.swing.*;
import java.awt.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class PanelMall extends JPanel {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public PanelMall(){
// Här dras bearbetningen igång
		this.setBackground(Color.magenta);
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
// System.out.println("bearbeta()");

	}//end bearbeta()

//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (400,300);
		f.setLocation(900,100);
		f.setTitle("TTTIntro");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelMall p = new PanelMall();
		f.add(p);
		f.setVisible(true);
	}//end bearbeta()
}//end class


