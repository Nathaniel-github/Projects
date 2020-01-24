/*
 Author: Nathaniel Thomas
 Date: 11/3/19
 Rev: 01
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MovingDisk extends JPanel implements ActionListener
{
  private int time;

  public MovingDisk()
  {
    time = 0;
    Timer clock = new Timer(30, this); 
    clock.start();;
  }

  public void paintComponent(Graphics g)
  {
	//Calculates coordinates of the sun and moon to be opposite from each other
    int x = 150 - (int)(100 * Math.cos(0.005 * Math.PI * time));
    int y = 150 - (int)(75 * Math.sin(0.005 * Math.PI * time));
    int x2 = 150 + (int)(100 * Math.cos(0.005 * Math.PI * time));
    int y2 = 150 + (int)(75 * Math.sin(0.005 * Math.PI * time));
        
    int r = 20;

    //Depending on whether the sun or moon is up the sky color is set
    Color sky;
    if (y > 150) {
    	sky = Color.BLACK;
    }
    else {
    	sky = Color.CYAN;
    }
    
    setBackground(sky); 
    super.paintComponent(g);

    //Draws the sun and moon
    g.setColor(Color.ORANGE);
    g.fillOval(x - r, y - r, 2*r, 2*r); 
    
    g.setColor(Color.WHITE);
    g.fillOval(x2 - r, y2 - r, 2 * r, 2 * r);
    
  }

  public void actionPerformed(ActionEvent e)
  {
    time++;
    repaint();
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Moving Disk");
    window.setSize(300, 150);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = window.getContentPane();
    MovingDisk panel = new MovingDisk();
    c.add(panel);
    window.setResizable(false);
    window.setVisible(true);
  }
}