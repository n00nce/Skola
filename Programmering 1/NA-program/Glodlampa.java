import javax.swing.*;
import java.awt.*;
//--------------------------------------------------------------------------------
//Grundmall för Java-program
//--------------------------------------------------------------------------------
public class Glodlampa {
//--------------------------------------------------------------------------------
//Deklarationer 
//--------------------------------------------------------------------------------
	String indata;
	double effektG = 60.0;
	double effektL = 11.0;
	double inkopsprisG = 5.0; 
	double inkopsprisL = 60.0;
	double timmar;
	double elpris; 
	int dagar = 0;
	double kostnadG;
	double kostnadL;
	double kostnadGDag;
	double kostnadLDag;
	int livslangdG = 1000;
	int livslangdL = 8000;
	double antalG;
	
//--------------------------------------------------------------------------------
//Konstruktor 
//--------------------------------------------------------------------------------
	public Glodlampa(){
		indata = JOptionPane.showInputDialog("timmar tänd per dag?");
		timmar = Double.parseDouble(indata);
		indata = JOptionPane.showInputDialog("elpris?");
		elpris = Double.parseDouble(indata);

		bearbeta();
		
	}//end konstruktor 
//--------------------------------------------------------------------------------
//Metoder som bearbetar -motor 
//--------------------------------------------------------------------------------
	public void bearbeta() {
//System.out.println("bearbeta()");

		kostnadGDag = effektG * timmar * elpris;
		kostnadGDag = kostnadGDag / 100000.0;
		kostnadLDag = effektL * timmar * elpris;
		kostnadLDag = kostnadLDag / 100000.0;
		kostnadG = inkopsprisG;
		kostnadL = inkopsprisL;
		antalG = antalG + 1;
		
		for (int i=0; i<dagar; i=i+1) {
			kostnadG = kostnadG + kostnadGDag;
			kostnadL = kostnadL + kostnadLDag;
			if ( (dagar*timmar) > livslangdG) { 
				kostnadG = kostnadG + inkopsprisG;
				
					 
			}//end if
			if ( (dagar*timmar) > livslangdL) {
				kostnadL = kostnadL + inkopsprisL;
			}//end if
		}
		/*
 		while(kostnadG <= kostnadL) {
			dagar = dagar + 1;
			kostnadG = kostnadG + kostnadGDag;
			kostnadL = kostnadL + kostnadLDag;
			if ( (dagar*timmar) > livslangdG) { 
				kostnadG = kostnadG + inkopsprisG;
				
					 
			}//end if
			if ( (dagar*timmar) > livslangdL) {
				kostnadL = kostnadL + inkopsprisL;
			}//end if
				
		}//end while
	*/
		
		JOptionPane.showMessageDialog(null,"Lågenergi billigst efter " +
											dagar + " dagar.");
	}//end bearbeta()
//--------------------------------------------------------------------------------
//Drar igång programet
//--------------------------------------------------------------------------------
	public static void main(String[]args){
		Glodlampa p = new Glodlampa();
	}//end main 
}//end class
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//kommentar while loop, while glödlampa<lögenergi ngt i den stilen