
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class UserInput extends JFrame implements KeyListener {
	private String keysPressed = "";
	private int playerCount;
	Color [] mycolors;
	
    public UserInput(int playerNum) {
    	playerCount = playerNum;
        addKeyListener(this);
        setSize(10, 10);
        setVisible(true);
    }

	private int[] scores = new int[4];
	private int[] players = new int[4];
	public void init() { // initializer that must be called on startup
		for(int i = 0; i < scores.length; i++) {
			scores[i] = 0;
			players[i] = i;
		}
	}
	
	public int getWinnerAndReset() {
		try {
			int winner = Integer.parseInt(keysPressed.substring(0, 1));
			System.out.println("Player " + winner);
			return winner;
		} catch(NumberFormatException e) {
			System.out.println("Invalid Answer, try again");
			getWinnerAndReset(); // recurse to beginning of loop
		}
		
		keysPressed = ""; // flush keysPressed
		return 0;
	}
    
	public void addScore(int p, int score) {
		System.out.println(score + " points was added to " + p);
	}
	
	public int getScore(int p) {
		return scores[p - 1];
	}
	
	public Color[] getColors() {
		Color[] temp = {mycolors[0], mycolors[1]};
		return temp;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			mycolors[0] = Color.YELLOW;
		}
		else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			mycolors[1] = Color.YELLOW;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Registered");
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			mycolors[3] = Color.YELLOW;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			mycolors[0] = Color.YELLOW;
		}
		else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			mycolors[1] = Color.YELLOW;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Registered");
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			mycolors[3] = Color.YELLOW;
		}
	}
    @Override
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_TAB) {
			mycolors[0] = Color.YELLOW;
		}
		else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			mycolors[1] = Color.YELLOW;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Registered");
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			mycolors[3] = Color.YELLOW;
		}
    }
}
