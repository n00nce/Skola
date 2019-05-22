import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class LekMedSiffror {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String 	indata, tal;
	int fran, till, digRot, antal, n, siffror, length, multRot;
	//int multRot = 1;
	char kar[];
	boolean run = true;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public LekMedSiffror(){
// Här dras bearbetningen igång
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Läser in spannet av tal
// Kör for-loop med start i talet "fran" för varje tal i spannet
// multRot sätts till 1 för enkel multiplicering
// Kollar om multRot>=10 och därför om loopen behöver köras igen eller om loopen är färdig
// Annars kör loopen, tar ut karaktär för karaktär och multiplicerar med multRot
// Räknar ut digital rot med mod 9 (%-tecken)
// Jämför om lika, isåfall lägger till antal
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
		
		indata 	= JOptionPane.showInputDialog("Från tal?");
		fran = Integer.parseInt(indata);
		indata 	= JOptionPane.showInputDialog("Till tal?");
		till = Integer.parseInt(indata);
		
		// RÄKNAR UT MULTIPLIKATIV DIGITAL ROT
        for (int n=fran; n<=till; n=n+1) {
        	siffror 	= n;
        	tal 		= Integer.toString(siffror);
        	run 		= true;
        	
        	multRot = 1;
        	length 	= tal.length();
        	
        	for (int i=0; i<=length; i=i+1) {	
		        if(i == length && multRot >= 10) {
		        	i		= 0;
		        	siffror = multRot;
		        	multRot = 1;
		        	tal 	= Integer.toString(siffror);
		        	length 	= tal.length();
		        }//end if
		        else if(i 	== length) {
		        	break;
		        }//end else if
	        		
		        kar 	= new char[10];
		        kar[i] 	= tal.charAt(i);
		        
		        multRot = multRot * Character.getNumericValue(kar[i]);
        	}//end for

        	digRot = (1 + (n - 1) % 9);
         
        	if(digRot == multRot) {
        		antal = antal+1;
        	}//end if

        }//end for n
        System.out.println("Antal samma: "+antal+"");
	}//end bearbeta()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		LekMedSiffror p = new LekMedSiffror();
	}//end bearbeta()
}//end class


