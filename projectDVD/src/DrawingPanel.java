/*
 Author: Nathaniel Thomas
 Date: 11/3/19
 Rev: 01
 */

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class DrawingPanel extends JPanel implements ActionListener
{
  //Fields
  private DVD myDVD;
  private int xMove;
  private int yMove;
  private int x;
  private int y;
  private int cornerCount;
  private int edgeCount;
  
  //Constructor
  public DrawingPanel()
  {
    Timer clock = new Timer(30, this); 
    clock.start();
    Image DVD = (new ImageIcon("DVD.png")).getImage();
    myDVD = new DVD(700, 400, DVD);
    
    xMove = ThreadLocalRandom.current().nextInt(-3, 4);
    yMove = ThreadLocalRandom.current().nextInt(-3,4);
    
    while ((Math.abs(xMove) + Math.abs(yMove)) <= 8) {
    	int i = 0;
    	if ((i % 2) == 0) {
    		if (xMove < 0) {
    			xMove --;
    		}
    		else {
    			xMove ++;
    		}
    	}
    	else {
    		if (yMove < 0) {
    			yMove --;
    		}
    		else {
    			yMove ++;
    		}
    	}
    }
    
    if (Math.abs(xMove) <= 2) {
    	xMove += 2;
    }
    
    if (Math.abs(yMove) <= 2) {
    	yMove += 2;
    }
  }

  public void paintComponent(Graphics g)
  {
    Color sky = Color.WHITE;
    setBackground(sky); 
    super.paintComponent(g);
    
    myDVD.draw(g);
    myDVD.moveForward(xMove);
    myDVD.moveSideways(yMove);
    
    x = myDVD.getxCord();
    y = myDVD.getyCord();
    if ((x >= 1225 && x <= 1275) && ((y >= 55 && y <= 65) || (y >= 705 && y <= 715))) {
    	cornerCount++;
    	xMove *= -1;
    	yMove *= -1;
    }
    else if ((145 <= x && x <= 155) && ((y >= 55 && y <= 65) || (y >= 705 && y <= 715))) {
    	cornerCount++;
    	xMove *= -1;
    	yMove *= -1;
    }
    else if (x >= 1250 || x <= 150) {
    	xMove *= -1;
    	edgeCount++;
    }
    else if (y <= 60 || y >= 710) {
    	yMove *= -1;
    	edgeCount++;
    }
    
    g.drawString("Number of times edge has been touched: " + String.valueOf(edgeCount), 10 , 20);
    g.drawString("Number of times corner has been touched: " + String.valueOf(cornerCount), 10 , 40);
  }

  public void actionPerformed(ActionEvent e)
  {
    repaint();
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Moving Disk");
    window.setSize(1400,800);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = window.getContentPane();
    DrawingPanel panel = new DrawingPanel();
    c.add(panel);
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    window.setVisible(true);
  }
}
