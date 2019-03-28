import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
// Kanpp som byter färg på etikett
//---------------------------------------------------------------------------------------------
public class KlickLekenMouseAnim extends JPanel
implements Runnable,MouseListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	JLabel instr;
	JLabel poangRuta;
	JLabel ruta;
	Thread t = new Thread(this);
	int poang = 0;
	int x=100,y=100;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public KlickLekenMouseAnim(){
// Här dras bearbetningen igång
		this.setLayout(null);
		addMouseListener(this);
		this.setBackground(Color.white);
				
		//Etiketten
		instr = new JLabel("Klicka på knappen");
		instr.setHorizontalAlignment(SwingConstants.LEFT);
		instr.setSize(400,50);
		instr.setLocation(0,0);
		instr.setFont(new Font("Arial",Font.BOLD,20));
		instr.setForeground(Color.black);
		instr.setOpaque(true);
		instr.setBackground(Color.white);
		this.add(instr);
		
		//Ruta
		ruta = new JLabel("");
		ruta.setSize(50,50);
		ruta.setLocation(x,y);
		ruta.setOpaque(true);
		ruta.setBackground(Color.red);
		this.add(ruta);
		
		//PoängRuta
		poangRuta = new JLabel("Du har "+poang+" poäng");
		poangRuta.setHorizontalAlignment(SwingConstants.LEFT);
		poangRuta.setSize(400,50);
		poangRuta.setLocation(0,510);
		poangRuta.setFont(new Font("Arial",Font.ITALIC,20));
		poangRuta.setForeground(Color.black);
		poangRuta.setOpaque(true);
		poangRuta.setBackground(Color.white);
		this.add(poangRuta);
		
		
		t.start();
	}//end konstraktor
//---------------------------------------------------------------------------------------------
// Metoder som bearbetar -motor
//---------------------------------------------------------------------------------------------
	public void run() {
// System.out.println("run()");
	requestFocus();
	while(true){
			try{Thread.sleep(1000);}
			catch(InterruptedException ie){}
			slumpa();
			ruta.setLocation(x,y);
		}//end while
	}//end run
	
//---------------------------------------------------------------------------------------------
// mouseClicked
//---------------------------------------------------------------------------------------------
	
	public void mouseClicked(MouseEvent e){
// System.out.println("mouseClicked()");
	if (e.getX()>= x &&
		e.getX()<= x+50 &&
		e.getY()>= y &&
		e.getY()<= y+50) {
		poang = poang + 1;	
	}//end if
	poangRuta.setText("Du har "+poang+" poäng");
	}//end mouseClicked
//---------------------------------------------------------------------------------------------
// KlickLekenMouseAnim knappen
//---------------------------------------------------------------------------------------------
	public void slumpa(){
	x = (int)(Math.random() * 500);
	y = (int)(Math.random() * 400 + 75);
	}//end slumpa
	
//---------------------------------------------------------------------------------------------
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (600,600);
		f.setLocation(1000,100);
		f.setTitle("KlickLekenMouseAnim");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KlickLekenMouseAnim p = new KlickLekenMouseAnim();
		f.add(p);
		f.setVisible(true);
		
	}//end bearbeta()
}//end class


