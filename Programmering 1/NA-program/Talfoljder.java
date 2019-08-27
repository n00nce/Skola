import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Talfoljder {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String 	indata;
	int 	diff, inc;
	int[] 	tal;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Talfoljder(){
// Här dras bearbetningen igång
		tal = new int[10];
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Läser in 3 första tal
// Räknar ut differens (konstant) = diff
// Räknar ut ökningen i differens = inc
// Skriver ut sista 7 talen (4-10)
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
		
		for (int i=0; i<3; i=i+1) {
			indata 	= JOptionPane.showInputDialog("Tal nr "+(i+1)+"?");
			tal[i] 	= Integer.parseInt(indata);
			
			System.out.println("Tal nr "+(i+1)+"? "+tal[i]+"");
		}//END for int i
		diff = tal[1] - tal[0];
		inc = tal[2]-tal[1]-diff;
		
		for (int i=3; i<10; i=i+1) {
			tal[i] = tal[i-1]+diff+(i-1)*inc;
			System.out.println("Tal nr "+(i+1)+"? "+tal[i]+"");
		}//END for int i

	}//end bearbeta()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Talfoljder p = new Talfoljder();
	}//end bearbeta()
}//end class


