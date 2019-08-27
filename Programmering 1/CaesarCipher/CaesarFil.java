import java.io.*;
import java.util.*;
import javax.swing.*;
//--------------------------------------------------------------------
// Mall för läsning av / skrivning till filer
//--------------------------------------------------------------------
public class CaesarFil{
//--------------------------------------------------------------------
// Deklaratioiner 
//--------------------------------------------------------------------
	String infil;
	String utfil = "utfil.txt";
	String rad;
	
	String intext;
	String uttext = "";
	String bokstav;
	String kryptoNyckel = "0";
	String kryptoBokstav;
	
	int nyttIndex;
	int nyckel;
	
	String[] alfabet = {"a","b","c","d","e","f","g","h","i","j",
						"k","l","m","n","o","p","q","r","s","t",
						"u","v","w","x","y","z","å","ä","ö"};
	
	BufferedReader lasfil;	
	PrintWriter skrivfil;
	
	JFileChooser fileChooser = new JFileChooser();
	
	int resultat;
//--------------------------------------------------------------------
// Konstruktor 
//--------------------------------------------------------------------
	public CaesarFil() throws IOException{
//System.out.println("konstruktor");

		lasIn();
		
		oppnaInFil();
		oppnaUtFil();
		bearbeta();
		skrivfil.close();		
		
	}//end konstruktor 
//--------------------------------------------------------------------
// Kryptera 
//--------------------------------------------------------------------
	public void kryptera() throws IOException{
		for (int i=0; i<rad.length(); i=i+1) {
			bokstav = rad.substring(i,i+1);
			
			for (int j=0; j<alfabet.length; j=j+1) {
				if (alfabet[j].equals(bokstav)) {
					nyttIndex = j+nyckel;
					
					if (nyttIndex >= 29) {
						kryptoBokstav = alfabet[nyttIndex-29];
						uttext = uttext+kryptoBokstav;
					}//END if
					
					else {
						kryptoBokstav = alfabet[nyttIndex];
						uttext = uttext+kryptoBokstav;
					}//END else
				}//END if 
			}//END for j
		}//END for i
		//System.out.println("Krypterad");
		
	}//end kryptera() 
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void lasIn() {
//System.out.println("lasRad()");
		
		kryptoNyckel = JOptionPane.showInputDialog("Kryptonyckel?");
		nyckel = Integer.parseInt(kryptoNyckel);
		//System.out.println(nyckel);
		
	}//lasIn()
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void oppnaInFil() throws IOException{
//System.out.println("oppnaInFil()");
		
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
		
	}//oppnaUtFil 
//--------------------------------------------------------------------
//
//--------------------------------------------------------------------
	public void bearbeta() throws IOException{
//System.out.println("bearbeta()");	

		lasRad();
		while(rad!= null){
			kryptera();
			skrivRad();
			uttext = "";
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

		skrivfil.println(uttext);		

	}//skrivRad()
//--------------------------------------------------------------------
// Drar igång programet
//--------------------------------------------------------------------
	public static void main(String[]args)throws IOException{
		CaesarFil p = new CaesarFil();
	}//end main 
//--------------------------------------------------------------------	
}//end class
//--------------------------------------------------------------------
//--------------------------------------------------------------------