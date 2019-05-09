import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
//---------------------------------------------------------------------------------------------
public class Webadress {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String indata, 	adress;
	String start 	= "www";
	String se 		= ".se";
	String fr 		= ".fr";
	String com 		= ".com";
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Webadress(){
		bearbeta();
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// L�ser in adress genom dialogruta
// Kollar om adress börjar med "WWW"
// Kollar om adress slutar med ".se", ".fr" eller ".com"
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
// System.out.println("bearbeta()");
		indata 	= JOptionPane.showInputDialog("Webadress?");
		adress 	= indata.toLowerCase();
		
		System.out.println("Adress: "+adress+"");
		
		if (adress.startsWith(start) 	== true){
			System.out.println(""+adress+" börjar med 'WWW'");
		}
		else {
			System.out.println(""+adress+" börjar INTE med 'WWW'");
		}
		if (adress.endsWith(se) 		== true) {
			System.out.println(""+adress+" kommer från Sverige");
		}
		else if (adress.endsWith(fr) 	== true) {
			System.out.println(""+adress+" kommer från Frankrike");
		}
		else if (adress.endsWith(com) 	== true) {
			System.out.println(""+adress+" är en kommersiell adress");
		}
	}//end bearbeta()
//---------------------------------------------------------------------------------------------
// Drar ig�ng programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Webadress p = new Webadress();
	}// end bearbeta()
}//end class