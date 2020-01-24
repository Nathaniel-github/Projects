/*
	This class handles the display graphics for Jeopardy
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class JeopardyDisplayPanel extends JPanel implements ActionListener {
	Image boxes;
	int xCenter, yCenter;
	JeopardyImage drawer;
	static JButton buttons[] = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),};
	JPanel mypanel = new JPanel();
	static boolean goToQuestion = false;
	static Timer clock;
	boolean first = true;
	SoundPlayer CorrectAnswer, BackgroundMusic, ThinkingMusic, TimeUp;
	static ReadWrite myaccess;
	static int column, row;
	static boolean useButtons = true;
	int keyPress;
	static UserInput myobj;
	static boolean run = false;
	Color [] mycolors = {Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK};
	boolean firstRun = true;
	
	public JeopardyDisplayPanel () {
		boxes = (new ImageIcon("JeopardyBoxes.png")).getImage();
		mypanel.setLayout(null);
		clock = new Timer(15000, this);
		try {
			CorrectAnswer = new SoundPlayer("JeopardyCorrectAnswer.wav");
			BackgroundMusic = new SoundPlayer("JeopardyThemeSong.wav");
			ThinkingMusic = new SoundPlayer("JeopardyThinkingMusic.wav");
			TimeUp = new SoundPlayer("JeopardyTimeUp.wav");
			
			BackgroundMusic.loop();
			BackgroundMusic.play();
		} catch (Exception ex) {
			System.out.println("Error with playing sound");
		}
		myaccess = new ReadWrite("Questions.txt");
		myobj = new UserInput(4);
	}
	
	public void paintComponent (Graphics g) {
		if (!goToQuestion) {
			useButtons = true;
			xCenter = getWidth() / 2;
			yCenter = getHeight() / 2;
			drawer = new JeopardyImage(xCenter, yCenter - 39, boxes);
			drawer.draw(g);
			for (int i = 0; i < 30; i++) {
				buttons[i].setBounds(234*(i/5), 133*(i % 5 + 1), 234, 134);
				buttons[i].setOpaque(false);
				buttons[i].setContentAreaFilled(false);
				buttons[i].setBorderPainted(false);
				add(buttons[i]);
			}
			g.setColor(Color.WHITE);
	        g.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        FontMetrics myfont = g.getFontMetrics(new Font("Tahoma", Font.PLAIN, 20));
			
			for(int i = 0; i < 6; i++) {
                g.drawString(myaccess.getCategories(i), i*getWidth()/6 + 110 - myfont.stringWidth(myaccess.getCategories(i))/2, 80);
            }
			
			g.setColor(Color.YELLOW);
	        g.setFont(new Font("Optima", Font.PLAIN, 45));
	        FontMetrics moneyFont = g.getFontMetrics(new Font("Optima", Font.PLAIN, 45));
	        String [] moneys = {"$100", "$200", "$300", "$400", "$500"};
	        for (int k = 0; k < 5; k++) {
	 			for(int i = 0; i < 6; i++) {
	                g.drawString(moneys[k], i*getWidth()/6 + 110 - moneyFont.stringWidth(moneys[k])/2, (k + 1) * 135 + 82);
	            }
	        }
			firstRun = true;
		} 
		else {
			 	String partOne = "";
			 	String partTwo = "";

		        g.setColor(Color.BLUE);
		        g.fillRect(0, 0, 1400, 800);
		        
		        String[] temp = myaccess.getQuestion(column, row).split(" ");
		        
		        for(int i = 0; i < temp.length / 2; i++) {
		        	partOne = partOne + " " + temp[i];
		        } for(int i = temp.length/2; i < temp.length; i++) {
		        	partTwo = partTwo + " " + temp[i];
		        }
		        
		        g.setColor(Color.WHITE);
		        g.setFont(new Font("Tahoma", Font.PLAIN, 60));
		        FontMetrics fm = g.getFontMetrics(new Font("Tahoma", Font.PLAIN, 60));
		        
		        //g.setAlignmentX(0.5f);
		        g.drawString(partOne, xCenter - fm.stringWidth(partOne)/2, yCenter - 69/2);
		        g.drawString(partTwo, xCenter - fm.stringWidth(partTwo)/2, yCenter + 69/2);
		        
		        String [] answers = {""};
		        if (firstRun) {
		        answers = myaccess.getAllAnswers(column, row);
		        
		        g.setFont(new Font("Tahoma", Font.PLAIN, 35));
		        
			        answers = myaccess.getAllAnswers(column, row);
			        answers[3] = myaccess.getCorrectAnswer(column, row); // begin swap
			        int randIndex = (int)Math.floor(Math.random()*3.99);
			        String moving = answers[randIndex];
			        answers[randIndex] = answers[3];
			        answers[3] = moving; // end swap
					firstRun = false;
		        }
			        
			    for(int i = 0; i < 4; i++) {
			        g.setColor(Color.YELLOW);
			        g.fillRect(30 + i*getWidth()/4, 620, 300, 40);
			        g.setColor(Color.BLACK);
			        g.drawString(answers[i], 35 + i*getWidth()/4, 650);
			    }
		        int textsize = 69;
		        
		        g.setFont(new Font("Tahona", Font.PLAIN, textsize)); 
		        
		        g.setColor(Color.WHITE);
		        
		        clock.start();
		        try {
					BackgroundMusic.stop();
					ThinkingMusic.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
		        
		}
		for(int i = 0; i < 4; i++) {
			g.setColor(mycolors[i]);
			g.setFont(new Font("Tahoma", Font.PLAIN, 35)); 
			g.drawString("P" + (i + 1) + " Score: " + myobj.getScore(i+1), (10 + (i)*(900/3 + 69 + 20)) + 10, 850);
		}
	}
	
	public void actionPerformed (ActionEvent e) {
			try {
		        JButton button = (JButton) e.getSource();
			} catch(Exception ex) {
				try {
					goToQuestion = false;
					ThinkingMusic.stop();
					ThinkingMusic.restart();
					TimeUp.restart();
					TimeUp.play();
					BackgroundMusic.restart();
					BackgroundMusic.play();
					repaint();
					clock.stop();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
//		String tempString = (String)e.getSource();
//		int keypress = Integer.parseInt(tempString);
//		if (keypress == KeyEvent.VK_TAB) {
//			mycolors[0] = Color.YELLOW;
//		}
//		else if (keypress == KeyEvent.VK_CONTROL) {
//			mycolors[1] = Color.YELLOW;
//		}
//		else if (keypress == KeyEvent.VK_SPACE) {
//			System.out.println("Registered");
//		}
//		else if (keypress == KeyEvent.VK_ENTER) {
//			mycolors[3] = Color.YELLOW;
//		}
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Jeopardy");
		window.setSize(1400,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setBackground(Color.LIGHT_GRAY);
		window.setLocationRelativeTo(null);
		
		JeopardyDisplayPanel panel = new JeopardyDisplayPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		Container c = window.getContentPane();
		c.add(panel);
		
		window.setVisible(true);
		
		while(true) {
			for (int i = 0; i < 30; i++) {
				if (buttons[i].getModel().isPressed() && useButtons) {
					column = i / 5;
					row = i % 5;
					goToQuestion = true;
					panel.repaint();
					useButtons = false;
					run = true;
				}
			}
		}
   	}

}