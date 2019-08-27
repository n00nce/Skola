import java.io.*;
import java.util.*;
import javax.swing.*;
//--------------------------------------------------------------------
// Mall f�r l�sning av / skrivning till filer
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

//Variant d�r man v�ljer fil fr�n fildialogruta
/*
		resultat = fileChooser.showOpenDialog(null);
		if (resultat != JFileChooser.APPROVE_OPTION){
			System.out.println("Ingen fil valdes.");
			System.exit(0);
		}//end indata
		infil = fileChooser.getSelectedFile().getAbsolutePath();
*/		
		
//Variant d�r filnamnet �r h�rdkodat
		infil = "infil.txt";		
		
			
		lasfil = 	new BufferedReader(
					new FileReader(infil));		
		
	}//oppnaInFil  ()
//--------------------------------------------------------------------
// �ppna utfilen (p� tv� s�tt). 
// Finns inte filen skapas den.
//--------------------------------------------------------------------
	public void oppnaUtFil() throws IOException{
//System.out.println("oppnaUtfil()");	

		skrivfil = 	new PrintWriter(
					new BufferedWriter(
					
//Skriver �ver det som redan finns-om det finns					
					new FileWriter (utfil)));

//L�gg till det som redan finns om det finns 	
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
// Drar ig�ng programet
//--------------------------------------------------------------------
	public static void main(String[]args)throws IOException{
		Filhantering p = new Filhantering();
	}//end main 
//--------------------------------------------------------------------	
}//end class
//--------------------------------------------------------------------
//--------------------------------------------------------------------