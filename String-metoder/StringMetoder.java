import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
//---------------------------------------------------------------------------------------------
public class StringMetoder {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String inText, text, pos, nyText, indata;
	String utText = "";
	int length, posNr;

//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public StringMetoder() {
// H�r dras bearbetningen ig�ng
		inText = JOptionPane.showInputDialog("Intext?");
		bearbeta();
	}// end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------

	public void bearbeta() {
// System.out.println("bearbeta()");
		// Uppgift 1
		text = inText.trim();
		utText = utText + "Text: " + text + "\n";

		// Uppgift 2
		length = text.length();
		utText = utText + "Antal: " + length + "\n";
		// Uppgift 3
		pos = JOptionPane.showInputDialog("Position f�r karakt�r??");
		posNr = Integer.parseInt(pos);
		char indataC = text.charAt(posNr - 1);
		utText = utText + "Karakt�r: " + indataC + "\n";
		// Uppgift 4
		pos = JOptionPane.showInputDialog("Position f�r deltext?");
		posNr = Integer.parseInt(pos);
		indata = text.substring(posNr - 1);
		utText = utText + "Deltext: " + indata + "\n";
		// Uppgift 5
		pos = JOptionPane.showInputDialog("Fr�n position?");
		posNr = Integer.parseInt(pos);
		String pos2 = JOptionPane.showInputDialog("Till position?");
		int posNr2 = Integer.parseInt(pos2);
		indata = text.substring(posNr - 1, posNr2 - 1);
		utText = utText + indata + "\n";
		// UPPGIFT 6
		nyText = JOptionPane.showInputDialog("Intext 2?");

		if (text.equals(nyText) == true) {
			utText = utText + "Lika" + "\n";
		} // END IF
		else if (text.equalsIgnoreCase(nyText) == true) {
			utText = utText + "Lika, bortsett fr�n gemener/versaler" + "\n";
		} // END ELSE IF
		else {
			if (text.compareTo(nyText) < 0) {
				utText = utText + "Text 1 kommer f�re text 2" + "\n";
			} // END IF
			if (inText.compareTo(nyText) > 0) {
				utText = utText + "Text 2 kommer f�re text 1" + "\n";
			} // END IF
		} // END ELSE
			// UPPGIFT 7
		if (text.startsWith(nyText)) {
			utText = utText + "Text 1 b�rjar med text 2" + "\n";
		} else {
			utText = utText + "Text 1 b�rjar INTE med text 2" + "\n";
		}
		// UPPGIFT 8
		// UPPGIFT 9
		if (text.endsWith(nyText)) {
			utText = utText + "Text 1 slutar med text 2" + "\n";
		} else {
			utText = utText + "Text 1 slutar INTE med text 2" + "\n";
		}
		// UPPGIFT 10
		indata = JOptionPane.showInputDialog("Karakt�r?");
		if ((text.indexOf(indata)) > -1) {
			if ((nyText.indexOf(indata)) > -1) {
				utText = utText + indata + " Finns i text 1 och 2" + "\n";
			} else {
				utText = utText + indata + " Finns endast i text 1" + "\n";
			}
		} else if ((nyText.indexOf(indata)) > -1) {
			utText = utText + indata + " Finns endast i text 2" + "\n";
		} else {
			utText = utText + indata + " Finns INTE i n�gon text" + "\n";
		}
		// UPPGIFT 11

		JOptionPane.showMessageDialog(null, utText);
	}// end bearbeta()

//---------------------------------------------------------------------------------------------
// Drar ig�ng programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		StringMetoder p = new StringMetoder();
	}// end bearbeta()

}// end class
