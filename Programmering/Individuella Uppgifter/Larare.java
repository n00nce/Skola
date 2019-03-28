import java.io.*;
import java.util.*;
import javax.swing.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class Larare {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	String 	indata;
	int 	antalVeckor;		//antal veckor totalt
	int[] 	antalLektioner;  	//antal lektioner per vecka

//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Larare() {
// Här dras bearbetningen igång
		veckor();
		lektioner();
		
		tomma();
		missade();
	}//end konstruktor
//---------------------------------------------------------------------------------------------
// Läser in total antal veckor
//---------------------------------------------------------------------------------------------
	public void veckor() {
//System.out.println("veckor()");
		indata 			= JOptionPane.showInputDialog("Antal Veckor?");
		antalVeckor		= Integer.parseInt(indata);
		antalLektioner 	= new int[antalVeckor+1];
		
System.out.println("Antal veckor? "+antalVeckor+"");
	}//END veckor()
//---------------------------------------------------------------------------------------------
// Läser in antal lektioner (per vecka)
//---------------------------------------------------------------------------------------------
	public void lektioner() {
//System.out.println("lektioner()");
		for (int vecka=1; vecka<antalVeckor+1; vecka=vecka+1) {
			indata 					= JOptionPane.showInputDialog("Antal Lektioner Vecka "+vecka+"?");
			antalLektioner[vecka] 	= Integer.parseInt(indata);
			
System.out.println("Antal lektioner vecka "+vecka+"? "+antalLektioner[vecka]+"");
		}//END for int vecka
	}//END lektioner()
	
//---------------------------------------------------------------------------------------------
// Räknar totalt antal tomma lektioner
// Om tidigare vecka hade fler lektioner läggs skillnaden till i tomma
// Börjar räkna på vecka=1 för lättare sammankoppling med veckonummer
//---------------------------------------------------------------------------------------------
	public void tomma() {
//System.out.println("tomma()");
		int tomma = 0;
		for (int vecka=1; vecka<antalVeckor+1; vecka=vecka+1) {
					
				if (antalLektioner[vecka-1] > antalLektioner[vecka]) {
						
					int count = antalLektioner[vecka-1] - antalLektioner[vecka];
					tomma = tomma+count;
					
				}//END if vecka-1 > vecka
		}//END for int vecka
System.out.println("Tomma: "+tomma+"");
	}//END tomma()
//---------------------------------------------------------------------------------------------
// Räknar totalt antal missade lektioner
// Om nuvarande vecka har fler lektioner läggs skillnaden till i missade
// Börjar räkna på vecka=1 för lättare sammankoppling med veckonummer
//---------------------------------------------------------------------------------------------
	public void missade() {
//System.out.println("missade()");
		int missade = 0;
		for (int vecka=1; vecka<antalVeckor+1; vecka=vecka+1) {
				
				if (vecka>1) {
					
					if (antalLektioner[vecka] > antalLektioner[vecka-1]) {
						
						int count 	= antalLektioner[vecka] - antalLektioner[vecka-1];
						missade 	= missade+count;
						
					}//END if vecka > vecka-1
				}//END if vecka > 1
		}//END for int vecka
System.out.println("Missade: "+missade+"");
	}//END missade()
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		Larare p = new Larare();
	}//END main
}//end class