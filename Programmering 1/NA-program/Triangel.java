import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Triangel {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String indata, utdata;
	Double a, b;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Triangel(){
// Här dras bearbetningen igång
		bearbeta();
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Läser in sidor, gör om från String till Double (pga decimaltal)
// Kollar om förhållandet mellan a och b = 1.6
// Skriver ut resultat i dialogruta
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
		
		while(true){
			indata	= JOptionPane.showInputDialog("Längd på kort sida? (Använd punkt)");
			a 		= Double.parseDouble(indata);
			utdata	= "Längd på kort sida: " + indata + "\n";
			
			indata 	= JOptionPane.showInputDialog("Längd på lång sida?");
			b 		= Double.parseDouble(indata);
			utdata 	= utdata + "Längd på lång sida: " + indata + "\n";
			
			if (a 	== b*1.6 || b == a*1.6) {
				utdata	= utdata + "Gyllene Triangel: Ja";
			}//end if
			else {
				utdata	= utdata + "Gyllene Triangel: Nej";
			}//end else			
			JOptionPane.showMessageDialog(null, utdata);
		}//end while
	}//end bearbeta()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Triangel p = new Triangel();
	}//end bearbeta()
}//end class