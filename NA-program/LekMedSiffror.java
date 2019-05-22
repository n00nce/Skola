import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class LekMedSiffror {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String 	indata, tal;
	int fran, till, digRot, antal, n;
	int multRot = 1;
	char karaktar;
	boolean run;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public LekMedSiffror(){
// Här dras bearbetningen igång
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Läser in 3 första tal
// Räknar ut differens (konstant) = diff
// Räknar ut ökningen i differens = inc
// Skriver ut sista 7 talen (4-10)
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
		
		indata 	= JOptionPane.showInputDialog("Från tal?");
		fran = Integer.parseInt(indata);
		indata 	= JOptionPane.showInputDialog("Till tal?");
		till = Integer.parseInt(indata);
		
		
        for (int n=fran; n<=till; n=n+1) {
        	int length = String.valueOf(n).length();
        	tal = Integer.toString(n);
        	digRot = (1 + (n - 1) % 9);
        	//System.out.println(digRot);
        	while (run=true) {
	        	for (int i=0; i<length; i=i+1) {
	        		karaktar = tal.charAt(i);
	        		multRot = multRot * Character.getNumericValue(karaktar);
	        		
	        	}//end for
	        	
        	}
        	System.out.println("Tal "+n+": Digitalrot "+digRot+" Multirot; "+multRot+"");
        	
        	if(digRot == multRot) {
        		antal = antal+1;
        	}
        	multRot = 1;
        }
        System.out.println("Antal samma: "+antal+"");
	}//end bearbeta()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		LekMedSiffror p = new LekMedSiffror();
	}//end bearbeta()
}//end class


