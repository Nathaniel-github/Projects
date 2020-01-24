/*
 Author: Nathaniel Thomas
 Date: 12/13/19
 Rev: 01
 */
import java.awt.*;
import javax.swing.*;
public class GoodStyle extends JPanel {
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(120, 20, 17, 40);
		
		g.setColor(Color.RED);                         
		g.fillRect(30, 40, 130, 45);  
		
		g.setColor(Color.YELLOW);
		g.fillRect(30, 40, 65, 45);
		
		g.setColor(Color.BLUE);
		Polygon thisisapolygon = new Polygon();
		thisisapolygon.addPoint(30, 40);
		thisisapolygon.addPoint(160, 40);
        thisisapolygon.addPoint(95, 20);
    	g.fillPolygon(thisisapolygon);
	}
	
	public static void main(String[] args) { 
		JFrame window = new JFrame("Graphics Demo");
		window.setBounds(300, 300, 200, 150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GoodStyle panel = new GoodStyle();               
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
        
    }
}
