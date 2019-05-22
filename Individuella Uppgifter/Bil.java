import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import java.io.*;
import java.io.File;
import java.io.IOException;
//---------------------------------------------------------------------------------------------
// 
//---------------------------------------------------------------------------------------------
public class Bil { 
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	double x 		= 200;
	double y 		= 200;
	double vx 		= 0;
	double vy		= 0;
	double vinkel 	= 0;
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public Bil(){

	}//end konstruktor

//---------------------------------------------------------------------------------------------
// 
//---------------------------------------------------------------------------------------------
	public void move(){
		x = x + vx;
		y = y + vy;
	}//end move()
//---------------------------------------------------------------------------------------------
// Draw
//---------------------------------------------------------------------------------------------
	public void draw(Graphics g){
// System.out.println("draw()");
		
		BufferedImage bil = LoadImage("bil.png");
		//AffineTransform at = AffineTransform.getTranslateInstance(300,200);
		AffineTransform at = AffineTransform.getTranslateInstance(x,y);
		at.rotate(Math.toRadians((int)vinkel),
				//x+bil.getWidth(),
				//y+bil.getHeight());
				x+bil.getWidth()/2,
				y+bil.getHeight()/2);
		//at.scale(2,2);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bil, at, null);
		//repaint();
		
		
	}//end draw()
//---------------------------------------------------------------------------------------------
// 
//---------------------------------------------------------------------------------------------
	BufferedImage LoadImage(String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileName));
		}
		catch(IOException ie) {}
		return img;
	}
}//end class