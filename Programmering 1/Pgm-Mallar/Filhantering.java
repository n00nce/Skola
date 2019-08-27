import java.io.*;
import java.util.*;
import javax.swing.*;
//--------------------------------------------------------------------
// Mall för läsning av / skrivning till filer
//--------------------------------------------------------------------
public class Filhantering{
//--------------------------------------------------------------------
// Deklaratioiner 
//--------------------------------------------------------------------
	String infil;
	String utfil = "utfil.txt";
	String rad;
	
	BufferedReader lasfil;	
	PrintWriter skrivfil;
	
	JFileChooser fileChooser = new JFileChooser();
	
	int resultat;
//--------------------------------------------------------------------
// Konstruktor 
//--------------------------------------------------------------------
	public Filhantering() throws IOException{
//System.out.println("konstruktor");

		oppnaInFil();
		oppnaUtFil();
		bearbeta();
		skrivfil.close();				

	}//end konstruktor 
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void oppnaInFil() throws IOException{
//System.out.println("oppnaInFil()");

//Variant där man väljer fil från fildialogruta
/*
		resultat = fileChooser.showOpenDialog(null);
		if (resultat != JFileChooser.APPROVE_OPTION){
			System.out.println("Ingen fil valdes.");
			System.exit(0);
		}//end indata
		infil = fileChooser.getSelectedFile().getAbsolutePath();
*/		
		
//Variant där filnamnet är hårdkodat
		infil = "infil.txt";		
		
			
		lasfil = 	new BufferedReader(
					new FileReader(infil));		
		
	}//oppnaInFil  ()
//--------------------------------------------------------------------
// Öppna utfilen (på två sätt). 
// Finns inte filen skapas den.
//--------------------------------------------------------------------
	public void oppnaUtFil() throws IOException{
//System.out.println("oppnaUtfil()");	

		skrivfil = 	new PrintWriter(
					new BufferedWriter(
					
//Skriver över det som redan finns-om det finns					
					new FileWriter (utfil)));

//Lägg till det som redan finns om det finns 	
//					new FileWriter (utfil,true)));	
		
	}//oppnaUtFil 
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void bearbeta() throws IOException{
//System.out.println("bearbeta()");	

		lasRad();
		while(rad!= null){
			skrivRad();
			lasRad();
		}//end while		

	}//bearbeta()
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void lasRad() throws IOException{
//System.out.println("lasRad()");

		rad = lasfil.readLine();
		
	}//lasRad()
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void skrivRad() throws IOException{
//System.out.println("skrivRad()");				

		skrivfil.println(rad);		

	}//skrivRad()
//--------------------------------------------------------------------
// Drar igång programet
//--------------------------------------------------------------------
	public static void main(String[]args)throws IOException{
		Filhantering p = new Filhantering();
	}//end main 
//--------------------------------------------------------------------	
}//end class
//--------------------------------------------------------------------
//--------------------------------------------------------------------