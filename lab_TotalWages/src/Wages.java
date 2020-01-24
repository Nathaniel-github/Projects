/*
 Author: Nathaniel Thomas
 Date: 12/13/19
 Rev: 01
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Wages extends JFrame
    implements ActionListener
{
  private JTextField inputHours, inputRate, location, display;
  private String countries[] = {"US", "Britain", "China", "Japan", "Canada"};
  private DecimalFormat moneyCountry[] = {new DecimalFormat("$0.00"), new DecimalFormat("€0.00"), new DecimalFormat("¥0.00"), new DecimalFormat("円0.00"), new DecimalFormat("$0.00")};
  private double wagez[] = {1.0, 0.9, 7.04, 108.32, 1.33};
  private CheckInput myobj;
  private JButton reset = new JButton("Reset");
  private JButton calc = new JButton("Calculate wages");

  public Wages()
  {
    super("Wages Calculator");

    myobj = new CheckInput();
    
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4,2));

    panel.add(new JLabel("   Hours worked:"));
    inputHours = new JTextField(5);
    inputHours.setHorizontalAlignment(JTextField.RIGHT);
    panel.add(inputHours);

    panel.add(new JLabel("   Hourly rate($):"));
    inputRate = new JTextField(5);
    inputRate.setHorizontalAlignment(JTextField.RIGHT);
    panel.add(inputRate);
    
    panel.add(new JLabel("   Which country's currency do you want the answer in?"));
    location = new JTextField(5);
    location.setHorizontalAlignment(JTextField.RIGHT);
    panel.add(location);

    panel.add(new JLabel("   Total wages:"));
    display = new JTextField(20);
    display.setHorizontalAlignment(JTextField.RIGHT);
    display.setEditable(false);
    display.setBackground(Color.yellow);
    panel.add(display);

    calc.addActionListener(this);

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
    c.add(calc, BorderLayout.SOUTH);
    
    reset.addActionListener(this);

    Container r = getContentPane();
    r.add(panel, BorderLayout.CENTER);
    r.add(reset, BorderLayout.NORTH);
  }

  public double totalWages(double hours, double rate)
  {
    double wages = 0;

    if (hours <= 40 && hours >= 0) {
    	wages = hours * rate;
    }
    else if (hours >= 40) {
    	int overtime = (int)hours - 40;
    	wages = overtime * rate * 1.5;
    	wages += (hours - overtime) * rate;
    }
    else {
    	display.setText("You're bad");
    }
    return wages;
  }

  public void actionPerformed(ActionEvent e)
  {
	JButton temp = (JButton)(e.getSource());
	
	if(temp.equals(calc)) {
	    boolean check;
	    boolean run = false;
		String s = inputHours.getText();
	    check = myobj.checkInt(s);
	    double hours = 0;
	    if (check) {
	    	hours = Double.parseDouble(s);
	    	run = true;
	    }
	    s = inputRate.getText();
	    check = myobj.checkInt(s);
	    double rate = 0;
	    if (check) {
	    	rate = Double.parseDouble(s);
	    	run = true;
	    }
	    s = location.getText();
	    String country = s;
	    boolean test = myobj.checkMessage(country, "Britain US Canada China Japan");
	    double wages = 0;
	    String output = "That wasn't a valid input";
	    if (test && run) {
	    	wages = totalWages(hours, rate);
	    	for(int i = 0; i < countries.length; i++) {
	    		if (country.equals(countries[i])) {
	    			wages *= wagez[i];
	            	display.setText(moneyCountry[i].format(wages));
	            }
	    	}
	  	}
	    else if (country.equals("") && run) {
	    	wages = totalWages(hours, rate);
	    	display.setText(moneyCountry[0].format(wages));
	    }
	    else {
	    	display.setText(output);
	    }
	}
	else if (temp.equals(reset)) {
		inputHours.setText("");
		inputRate.setText("");
		location.setText("");
		display.setText("");
	}
  }

  public static void main(String[] args)
  {
    Wages window = new Wages();
    window.setBounds(300, 300, 700, 500);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

