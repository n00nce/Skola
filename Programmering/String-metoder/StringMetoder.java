import javax.swing.JOptionPane;
import java.io.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class StringMetoder {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String 	inText, text, pos, nyText; 
	int 	length, posNr;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public StringMetoder(){
// Här dras bearbetningen igång
		inText = JOptionPane.showInputDialog("Intext?");
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
// System.out.println("bearbeta()");
		// Uppgift 1
		text = inText.trim(); 
		JOptionPane.showMessageDialog(null, text);
		/*
		//Uppgift 2
		length = text.length(); 
		JOptionPane.showMessageDialog(null, length);
		//Uppgift 3
		pos = JOptionPane.showInputDialog("Position?");
		posNr = Integer.parseInt(pos);
		JOptionPane.showMessageDialog(null, text.charAt(posNr-1)); 
		//Uppgift 4
		pos = JOptionPane.showInputDialog("Position?");
		posNr = Integer.parseInt(pos);
		JOptionPane.showMessageDialog(null, text.substring(posNr-1)); 
		// Uppgift 5
		pos = JOptionPane.showInputDialog("Från position?");
		posNr = Integer.parseInt(pos);
		String pos2 = JOptionPane.showInputDialog("Till position?");
		int posNr2 = Integer.parseInt(pos2);
		JOptionPane.showMessageDialog(null, text.substring(posNr-1, posNr2-1)); 
		*/
		// UPPGIFT 6
		nyText = JOptionPane.showInputDialog("Intext 2?");
		if (inText.equals(nyText)==true) {
			JOptionPane.showMessageDialog(null, "Lika");
		} //END IF
		else if (inText.equalsIgnoreCase(nyText)==true) {
			JOptionPane.showMessageDialog(null, "Lika, bortsett från gemener/versaler");
		} //END ELSE IF
		else {
			if (inText.compareTo(nyText)<0) {
				JOptionPane.showMessageDialog(null, "Text 1 kommer före text 2");
			} //END IF
			if (inText.compareTo(nyText)>0) {
				JOptionPane.showMessageDialog(null, "Text 2 kommer före text 1");
			}//END IF
		} //END ELSE
		//UPPGIFT 7
		if (inText.startsWith(nyText)) {
			JOptionPane.showMessageDialog(null, "Text 1 börjar med text 2");
		}
		else {
			JOptionPane.showMessageDialog(null, "Text 1 börjar INTE med text 2");
		}
	}//end bearbeta()

//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		StringMetoder p = new StringMetoder();
	}//end bearbeta()
	
}//end class


