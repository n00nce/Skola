import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//---------------------------------------------------------------------------------------------
// TicTacToe
//---------------------------------------------------------------------------------------------
public class TicTacToe extends JPanel
implements ActionListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	JButton[][] spelplan = new JButton[3][3];
	JButton nyttSpel;
	JLabel wnr;
	String spelare = "X";
	boolean gameOver=false;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public TicTacToe(){
		this.setLayout(null);
		this.setBackground(Color.gray);
	//Spelplan Knappar
		for (int rad=0; rad<3; rad=rad+1) {
			for (int kol=0; kol<3; kol=kol+1) {
				spelplan[rad][kol] = new JButton();
				spelplan[rad][kol].setSize(100,100);
				spelplan[rad][kol].addActionListener(this);
				spelplan[rad][kol].setLocation(100+kol*100,100+rad*100);
				spelplan[rad][kol].setBackground(Color.black);
				spelplan[rad][kol].setForeground(Color.white);
				spelplan[rad][kol].setFont(new Font("Arial", Font.BOLD, 40));
				this.add(spelplan[rad][kol]);
			}//END FOR kol
		}//END FOR rad
	//Nytt Spel Knapp
		nyttSpel = new JButton("Nytt Spel");
		nyttSpel.setSize(200,50);
		nyttSpel.setLocation(150,25);
		nyttSpel.setFont(new Font("Arial", Font.BOLD, 20));
		nyttSpel.setForeground(Color.white);
		nyttSpel.setOpaque(true);
		nyttSpel.setBackground(Color.black);
		nyttSpel.addActionListener(this);
		this.add(nyttSpel);
	//Vinnare Label
		wnr = new JLabel("Vinnare:");
		wnr.setHorizontalAlignment(SwingConstants.CENTER);
		wnr.setSize(200,50);
		wnr.setLocation(150,410);
		wnr.setFont(new Font("Arial",Font.BOLD,30));
		wnr.setForeground(Color.white);
		wnr.setBackground(Color.black);
		wnr.setOpaque(true);
		this.add(wnr);
	}//END konstruktor
//---------------------------------------------------------------------------------------------
//  Motor
//---------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
//System.out.println("actionPerformed()");
		if (e.getSource().equals(nyttSpel)) {
			nyttSpel();
		}//END if
		else {
			if (gameOver==false) { 
				markeraVal(e);
				kollaRad();
				kollaKol();
				kollaDiag();
			}//END IF
			if (gameOver) {
				visaVinnare();
			}//END if
			else {
				bytSpelare();
			}//END ELSE
		}//END ELSE
	}//END actionPerformed
//---------------------------------------------------------------------------------------------
//  Nytt Spel
//---------------------------------------------------------------------------------------------
	public void nyttSpel() {
//System.out.println("nyttSpel()");
		for (int rad=0; rad<3; rad=rad+1) {
			for (int kol=0; kol<3; kol=kol+1) {
					spelplan[rad][kol].setText("");
			}//END FOR kol
		}//END FOR rad
		wnr.setText("Vinnare:");
		gameOver = false;
	}//END nyttSpel
//---------------------------------------------------------------------------------------------
// Markera Val
//---------------------------------------------------------------------------------------------
	public void markeraVal(ActionEvent e) {
//System.out.println("markeraVal()");
		for (int rad=0; rad<3; rad=rad+1) {
			for (int kol=0; kol<3; kol=kol+1) {
				if (e.getSource().equals(spelplan[rad][kol])) {
						//System.out.println("funnen");
						spelplan[rad][kol].setText(spelare);
				}//END if
			}//END FOR kol
		}//END FOR rad
	}//END markeraVal
//---------------------------------------------------------------------------------------------
// Byt Spelare
//---------------------------------------------------------------------------------------------
	public void bytSpelare(){
//System.out.println("bytSpelare()");
		if (spelare.equals("X")) {
			spelare = "O";
		}//END if
		else if (spelare.equals("O")) {
			spelare = "X";
		}//END else if
	}//END bytSpelare
//---------------------------------------------------------------------------------------------
// Kolla Rad
//---------------------------------------------------------------------------------------------
	public void kollaRad() {
//System.out.println("kollaRad()");
		
		for (int rad=0; rad<3; rad=rad+1) {
			for (int kol=0; kol<3; kol=kol+1) {
				if (spelplan[rad][0].getText().equals("")) {
					//System.out.println("skippad_RAD()");
				}//END if blank
				else if (spelplan[rad][0].getText().equals(spelplan[rad][1].getText()) &&
						spelplan[rad][1].getText().equals(spelplan[rad][2].getText())) {
					//System.out.println("vinnareFunnen_RAD");
					gameOver=true;
				}//END ELSE IF
			}//END FOR kol
		}//END FOR rad
	}//END kollaRad
//---------------------------------------------------------------------------------------------
// Kolla Diagonal
//---------------------------------------------------------------------------------------------
	public void kollaDiag() {
//System.out.println("kollaDiag()");
	//KOLLA DIAGONAL 1
		if (spelplan[0][0].getText().equals("")) {
			//System.out.println("skippad_DIAGONAL1()");
		}//END if blank
		else if (spelplan[0][0].getText().equals(spelplan[1][1].getText()) &&
			spelplan[0][0].getText().equals(spelplan[2][2].getText())) {
			//System.out.println("vinnareFunnen_DIAGONAL1");
			gameOver=true;
			}//END else if
	//KOLLA DIAGONAL 2
		if (spelplan[0][2].getText().equals("")) {
			//System.out.println("skippad_DIAGONAL2()");
		}//END if blank
		else if (spelplan[0][2].getText().equals(spelplan[1][1].getText()) &&
				spelplan[0][2].getText().equals(spelplan[2][0].getText())) {
				//System.out.println("vinnareFunnen_DIAGONAL2");
				gameOver=true;
				}//END else if
	}//END kollaDiag
//---------------------------------------------------------------------------------------------
// Kolla Kolumn
//---------------------------------------------------------------------------------------------
	public void kollaKol() {
//System.out.println("kollaKol()");
		for (int rad=0; rad<3; rad=rad+1) {
			for (int kol=0; kol<3; kol=kol+1) {
				if (spelplan[0][kol].getText().equals("")) {
					//System.out.println("skippad_KOLUMN()");
				}//END if blank
				else if (spelplan[0][kol].getText().equals(spelplan[1][kol].getText()) &&
						spelplan[1][kol].getText().equals(spelplan[2][kol].getText())) {
					//System.out.println("vinnareFunnen_KOLUMN");
					gameOver=true;
				}//END else if
			}//END FOR kol
		}//END FOR rad
	}//END kollaKol
//---------------------------------------------------------------------------------------------
// Visa Vinnare
//---------------------------------------------------------------------------------------------
	public void visaVinnare() {
//System.out.println("visaVinnare()");
		wnr.setText("Vinnare: "+spelare+"");
	}//END visaVinnare
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (500,500);
		f.setLocation(900,100);
		f.setTitle("TicTacToe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TicTacToe p = new TicTacToe();
		f.add(p);
		f.setVisible(true);
	}//END main
}//END class


