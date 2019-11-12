import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
//---------------------------------------------------------------------------------------------
// Skriv in vad programmet gör
//---------------------------------------------------------------------------------------------
public class StudsTriangel extends Studs {
//---------------------------------------------------------------------------------------------
// Deklarationer
//---------------------------------------------------------------------------------------------
	Point p[] = new Point[3];
//---------------------------------------------------------------------------------------------
// Konstruktor
//---------------------------------------------------------------------------------------------
	public StudsTriangel(){
// Här dras bearbetningen igång
		super();
		p[0] = new Point(0		, 	size/2);
		p[1] = new Point(size	, 	size/2);
		p[2] = new Point(size/2	, 	0);
	}//end konstruktor
//--------------------------------------------------------------------------------------------------
// Rita	
//--------------------------------------------------------------------------------------------------
	public void draw (Graphics g){
//System.out.println("Paint()");
		g.setColor(Color.white);
		
		Polygon poly = new Polygon();
		for (int i = 0; i < p.length; i=i+1) {
			poly.addPoint((int)x + p[i].x, (int)y + p[i].y);
		}
		g.fillPolygon(poly);
	}//end draw()
}//end class