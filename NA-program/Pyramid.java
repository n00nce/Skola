import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Pyramid {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String indata;
	int block, hojd, area;
	int sida = 1;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Pyramid(){
// Här dras bearbetningen igång
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Läser in antal block från dialogruta, gör om till Int
// Räknar ut area, kollar om area är större än antal block kvar
// Avslutar loopen om arean är större
// Annars subtraherar arean, ökar höjd med 1 och längd på sida med 2
//---------------------------------------------------------------------------------------------
	public void bearbeta(){

		indata = JOptionPane.showInputDialog("Antal block?");
		block = Integer.parseInt(indata);
		
		for(int i=1; i>0; i++) {
			area = sida*sida;
			
			if(area>block) {
				i=-1;
				System.out.println("slut");
			}//end if
			
			else {
				block = block - area;
				hojd = hojd+1;
				sida = sida+2;
			}//end else	
		}//end for
		System.out.println("Höjd "+hojd+"");
	}//end bearbeta()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Pyramid p = new Pyramid();
	}//end bearbeta()
}//end class


