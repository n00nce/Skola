import javax.swing.JOptionPane;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet g�r
//---------------------------------------------------------------------------------------------
public class Moms {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String pris, moms; 
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Moms(){

		pris = JOptionPane.showInputDialog("Pris?");
		moms = JOptionPane.showInputDialog("Moms i %?");
		bearbeta();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void bearbeta(){
// System.out.println("bearbeta()");
		double kostnad = Double.parseDouble(pris) * (1 + (Double.parseDouble(moms)/100));
		JOptionPane.showMessageDialog(null,"Pris inklusive moms " + kostnad);
	}//end bearbeta()

//---------------------------------------------------------------------------------------------
// Drar ig�ng programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Moms p = new Moms();
	}
}//end class


