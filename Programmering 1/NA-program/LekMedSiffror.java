import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class LekMedSiffror {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String 	indata, tal;
	int fran, till, dRot, antal, n, siffror, length, mRot;
	char kar;
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
// mRot sätts till 1 för enkel multiplicering / reset för varje nytt tal
// Kollar om mRot>=10 och därför om loopen behöver köras igen eller om loopen är färdig
// Annars kör loopen, tar ut värdet för karaktär och multiplicerar med mRot
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
        	
        	mRot = 1;
        	length 	= tal.length();
        	
        	for (int i=0; i<=length; i=i+1) {
		        if(i == length && mRot >= 10) {
		        	i		= 0;
		        	siffror = mRot;
		        	mRot = 1;
		        	tal 	= Integer.toString(siffror);
		        	length 	= tal.length();
		        }//end if
		        else if(i 	== length) {
		        	break;
		        }//end else if
	        		
		        kar 	= tal.charAt(i);
		        mRot = mRot * Character.getNumericValue(kar);
        	}//end for

        	dRot = (1 + (n - 1) % 9);
         
        	if(dRot == mRot) {
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


