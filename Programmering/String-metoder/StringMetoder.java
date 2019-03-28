import javax.swing.JOptionPane;
import java.io.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
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
// H�r dras bearbetningen ig�ng
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
		pos = JOptionPane.showInputDialog("Fr�n position?");
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
			JOptionPane.showMessageDialog(null, "Lika, bortsett fr�n gemener/versaler");
		} //END ELSE IF
		else {
			if (inText.compareTo(nyText)<0) {
				JOptionPane.showMessageDialog(null, "Text 1 kommer f�re text 2");
			} //END IF
			if (inText.compareTo(nyText)>0) {
				JOptionPane.showMessageDialog(null, "Text 2 kommer f�re text 1");
			}//END IF
		} //END ELSE
		//UPPGIFT 7
		if (inText.startsWith(nyText)) {
			JOptionPane.showMessageDialog(null, "Text 1 b�rjar med text 2");
		}
		else {
			JOptionPane.showMessageDialog(null, "Text 1 b�rjar INTE med text 2");
		}
	}//end bearbeta()

//---------------------------------------------------------------------------------------------
// Drar ig�ng programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		StringMetoder p = new StringMetoder();
	}//end bearbeta()
	
}//end class


