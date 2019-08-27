import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//---------------------------------------------------------------------------------------------
// TicTacToe
//---------------------------------------------------------------------------------------------
public class GameOfLife extends JPanel
implements ActionListener {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	int radNr=10, kolNr=10;
	JButton[][] spelplan = new JButton[radNr][kolNr];
	String[][] skugga = new String[radNr][kolNr];
	JButton next = new JButton();
	int size=30;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public GameOfLife(){
		this.setLayout(null);
		this.setBackground(Color.gray);
	//Spelplan Knappar
		for (int rad=0; rad<radNr; rad=rad+1) {
			for (int kol=0; kol<kolNr; kol=kol+1) {
				spelplan[rad][kol] = new JButton();
				spelplan[rad][kol].setSize(size,size);
				spelplan[rad][kol].addActionListener(this);
				spelplan[rad][kol].setLocation(100+kol*size,100+rad*size);
				spelplan[rad][kol].setBackground(Color.black);
				spelplan[rad][kol].setForeground(Color.white);
				this.add(spelplan[rad][kol]);
			}//END FOR kol
		}//END FOR rad
	//Skugga
		for (int rad=0; rad<radNr; rad=rad+1) {
			for (int kol=0; kol<kolNr; kol=kol+1) {
				skugga[rad][kol] = new String();
			}//END FOR kol
		}//END FOR rad
		
		//Next
		next = new JButton("Nästa");
		next.setSize(200,50);
		next.setLocation(150,25);
		next.setFont(new Font("Arial", Font.BOLD, 20));
		next.setForeground(Color.white);
		next.setOpaque(true);
		next.setBackground(Color.black);
		next.addActionListener(this);
		this.add(next);
	}//END konstruktor
//---------------------------------------------------------------------------------------------
//  Motor
//---------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
//System.out.println("actionPerformed()");
		if (e.getSource().equals(next)) {
			next();
		}//END if
		else {
		markeraVal(e);
		}
	}//END actionPerformed
//---------------------------------------------------------------------------------------------
//  Next
//---------------------------------------------------------------------------------------------
	public void next() {
//System.out.println("next()");


	}//END nyttSpel
	
//---------------------------------------------------------------------------------------------
//  isAlive
//---------------------------------------------------------------------------------------------
	public boolean isAlive() {
		int count = 0;
		
		for (int rad=0; rad<radNr; rad=rad+1) {
			for (int kol=0; kol<kolNr; kol=kol+1) {
				
			}//END FOR kol
		}//END FOR rad
		
		if (count==2) {
			return true;
		}
		else if (count==3) {
			return true;
		}
		else {
			return false;
		}
	}
//---------------------------------------------------------------------------------------------
// Markera Val
//---------------------------------------------------------------------------------------------
	public void markeraVal(ActionEvent e) {
//System.out.println("markeraVal()");
		for (int rad=0; rad<radNr; rad=rad+1) {
			for (int kol=0; kol<kolNr; kol=kol+1) {
				if (e.getSource().equals(spelplan[rad][kol])) {
						//System.out.println("funnen");
					if (spelplan[rad][kol].getBackground().equals(Color.black)) {
						spelplan[rad][kol].setBackground(Color.yellow);
					}
					else {
						spelplan[rad][kol].setBackground(Color.black);
					}
				}//END if
			}//END FOR kol
		}//END FOR rad
	}//END markeraVal
//---------------------------------------------------------------------------------------------
// Drar igång programmet
//---------------------------------------------------------------------------------------------
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize (500,500);
		f.setLocation(900,100);
		f.setTitle("TicTacToe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameOfLife p = new GameOfLife();
		f.add(p);
		f.setVisible(true);
	}//END main
}//END class


