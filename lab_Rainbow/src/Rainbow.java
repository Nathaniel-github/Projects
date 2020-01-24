/*
 Author: Nathaniel Thomas
 Date: 11/3/19
 Rev: 01
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Rainbow extends JPanel implements ActionListener
{
	
  static Color skyColor = Color.GRAY;
  Image rain;
  Rain [] myRain;
  int moveLength = 5;
  boolean reset = false;
  Queue<Integer> qx = new LinkedList<Integer>();
  Queue<Integer> qy = new LinkedList<Integer>();
  Queue<Color> qc = new LinkedList<Color>();
  private final int NUMBEROFRAINDROPS = 1000;
  private final int NUMBEROFRINGS = 8;
  float r;
  float G;
  float b;
  boolean first = true;
  Color randomColor;
  final Color VIOLET = new Color(128, 0, 128);
  final Color INDIGO = new Color(75, 0, 130);
  static SoundPlayer rainSound, thunderSound;
  
  public Rainbow()
  {
    Timer clock = new Timer(30, this); 
    clock.start();
    myRain = new Rain[NUMBEROFRAINDROPS]; 
	rain = (new ImageIcon("RainDrop.png")).getImage();
	
	for (int i = 0; i < NUMBEROFRAINDROPS; i++) {
		qx.add(ThreadLocalRandom.current().nextInt(5, 1395));
	}
	
	for (int i = 0; i < NUMBEROFRAINDROPS; i++) {
		qy.add(ThreadLocalRandom.current().nextInt(5, 795));
	}
	
	for (int i = 0; i < NUMBEROFRAINDROPS; i++) {
		int x = qx.remove();
		int y = qy.remove();
		myRain[i] = new Rain(x, y, rain);
	}
	
	qc.add(Color.RED);
	qc.add(Color.ORANGE);
	qc.add(Color.YELLOW);
	qc.add(Color.GREEN);
	qc.add(Color.BLUE);
	qc.add(INDIGO);
	qc.add(VIOLET);
  }

  public void paintComponent(Graphics g)
  {
	  	setBackground(skyColor);
	  	int width = getWidth();    
		int height = getHeight();
	   	for (int i = 0; i < NUMBEROFRAINDROPS; i++) {
	   		qx.add(myRain[i].getxCord());
	   		int x = ThreadLocalRandom.current().nextInt(5, width);
	   		qy.add(myRain[i].getyCord());
	   		int y = ThreadLocalRandom.current().nextInt(5, height);
	   		int range = ThreadLocalRandom.current().nextInt(10, 1100);
	   		while ((x + y) > range) {
	   			x--;
	   			y--;
	   		}
	   		qx.add(x);
	   		qy.add(y);
	   	}
	   	
		super.paintComponent(g);
		
		int xCenter = width / 2;
		int yCenter = (height * 3) / 4;
  
		int radius = (width + height) / 8;
		
		for (int i = 0; i < (NUMBEROFRINGS - 1); i++) {
			randomColor = qc.remove();
			qc.add(randomColor);
			int currentRadius = (radius * (NUMBEROFRINGS - i)) / NUMBEROFRINGS;
  
			g.setColor(randomColor);
			g.fillArc(xCenter - currentRadius, yCenter - currentRadius, currentRadius * 2, currentRadius * 2, 0, 180);
		}
		
		int innerRadius = radius / NUMBEROFRINGS;
		
		g.setColor(skyColor);
		g.fillArc(xCenter - innerRadius, yCenter - innerRadius, innerRadius * 2, innerRadius * 2, 0, 180);
		

		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(xCenter - (int)(width/4.6), yCenter - (int)(height/21.51), (int)(width/6.91), (int)(height/10.04));
		g.fillOval(xCenter - (int)(width/6.91), yCenter - (int)(height/75.3), (int)(width/6.91), (int)(height/10.04));
		g.fillOval(xCenter - (int)(width/4.85), yCenter - (int)(height/150.6), (int)(width/6.91), (int)(height/10.04));
		
		g.fillOval(xCenter + (int)(height/15.06), yCenter - (int)(height/21.49), (int)(width/6.91), (int)(height/10.04));
		g.fillOval(xCenter + (int)(height/75.3), yCenter - (int)(height/37.6), (int)(width/6.91), (int)(height/10.04));
		g.fillOval(xCenter + (int)(width/11.52), yCenter - (int)(height/75.3), (int)(width/6.91), (int)(height/10.04));
		
		for (int i = 0; i < NUMBEROFRAINDROPS; i++) {
			int x = qx.remove();
			int startx = qx.remove();
			int y = qy.remove();
			int starty = qy.remove();
			
			if (x >= (width - 5) || x <= 5) {
	    		myRain[i].moveForward(-1 * (x - startx));
	    		myRain[i].moveSideways(-1 * (y - starty));
			}
			else if (y <= 5 || y >= (height - 5)) {
	    		myRain[i].moveForward(-1 * (x - startx));
	    		myRain[i].moveSideways(-1 * (y - starty));
	    	}
			myRain[i].draw(g);
			myRain[i].moveForward(moveLength);
			myRain[i].moveSideways(moveLength);
		}
		
		g.setColor(Color.YELLOW);
		g.fillOval((int)(width/1.2), (int)(height/-3.012), (int)(width/2.764), (int)(width/2.764));
  }

  public void actionPerformed(ActionEvent e)
  {
    repaint();
  }

  public static void main(String[] args)
  {
	boolean thunder = false;
	String check;
	Scanner myobj = new Scanner(System.in);
	System.out.println("Would you like thunder? (y/n)");
	check = myobj.nextLine();
	myobj.close();
	if (check.equals("y") || check.equals("yes") || check.equals("Yes")) { 
		thunder = true;
	}
    JFrame window = new JFrame("Rainbow");
	window.setSize(1400, 800);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = window.getContentPane();
    try {
    	rainSound = new SoundPlayer("RainSound.wav");
    	thunderSound = new SoundPlayer("ThunderSound.wav");
    	
    	rainSound.loop();
    	rainSound.play();
    }
    catch(Exception ex) {
    	System.out.println("Error with playing sound");
    	ex.printStackTrace(); 
    }
    Rainbow panel = new Rainbow();
    window.setLocationRelativeTo(null);
    c.add(panel);
    window.setVisible(true);
    while (thunder) {
    	try {
    		Thread.sleep(10000);
    	}
    	catch(InterruptedException ie) {
    		System.out.println("Error 404");
    	}
    	
    	try {
    		thunderSound.restart();
    	}
    	catch(Exception ex) {
    		System.out.println("Error 404");
    	}
    	
    	try {
    		thunderSound.play();
    		
    		for (int i = 0; i < 5; i++) {
    			skyColor = Color.BLACK;
    			
    			try {
    				Thread.sleep(50);
    			}
    			catch(InterruptedException ie) {
    				System.out.println("Error 404");
    			}
    			
    			skyColor = Color.GRAY;
    			
    			try {
    				Thread.sleep(500);
    			}
    			catch(InterruptedException ie) {
    				System.out.println("Error 404");
    			}
    		}
        }
        catch(Exception ex) {
        	System.out.println("Error with playing sound");
        	ex.printStackTrace(); 
        }
    }
  }
}