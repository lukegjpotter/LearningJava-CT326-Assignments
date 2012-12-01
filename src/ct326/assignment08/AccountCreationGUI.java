/**
 * @Student_ID 07013418
 * @Author Luke Potter
 * @Course 3rd B.Sc. I.T.
 * @Date 13/November/2009
 */

package ct326.assignment08;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class AccountCreationGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel firstnameLabel, lastnameLabel, emailLabel,
				dobLabel, dayLabel, monthLabel, yearLabel,
				sexLabel, passLabel, confirmpassLabel;
	private JTextField firstnameField, lastnameField, emailField;
	private JComboBox dayCB, monthCB, yearCB;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup sexGroup;
	private JPasswordField passField, confirmpassField;
	private JButton createAccountButton;
	private String output = "";
	private ButtonEvent handler;
	
	private String dayArray[] = 
		{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
		"12", "13", "14", "15", "16", "17", "18", "19","20", "21",
		"22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	
	private String monthArray[] =
		{"Jan", "Feb", "Mar", "Apr", "May", "Jun",
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	private String yearArray[] =
		{"1980", "1981", "1982", "1983", "1984", "1985", "1986",
		"1987", "1988", "1989", "1990", "1991", "1992", "1993",
		"1994", "1995", "1996", "1997", "1998", "1999", "2000"};
	
	public AccountCreationGUI () {
		
		//A string that will be in the GUI frame
		super ("Creating new e-mail Account");
		
		//Declare the container and its layout style
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//Initialise and Add labels and fields for the first name
		firstnameLabel = new JLabel ("Enter First Name");
		container.add(firstnameLabel);
		firstnameField = new JTextField (15);
		container.add(firstnameField);
		
		//Initialise and Add labels and fields for the last name
		lastnameLabel = new JLabel ("Enter Last Name");
		container.add(lastnameLabel);
		lastnameField = new JTextField (15);
		container.add(lastnameField);
		
		//Initialise and Add labels and fields for the e-mail address
		emailLabel = new JLabel ("Enter E-Mail Address");
		container.add(emailLabel);
		emailField = new JTextField (15);
		container.add(emailField);
		
		//Initialise and Add labels and fields for the user's gender
		sexLabel = new JLabel ("Please Select Sex");
		container.add(sexLabel);
		maleRB = new JRadioButton ("Male", false);
		container.add(maleRB);
		femaleRB = new JRadioButton ("Female", false);
		container.add(femaleRB);
		
		//Instantiate the button Event
		handler = new ButtonEvent();
		
		//Group the radio buttons
		sexGroup = new ButtonGroup ();
		sexGroup.add(maleRB);
		sexGroup.add(femaleRB);
		
		//Add Action Listeners to the Male and Female
		//Radio Buttons
		maleRB.addActionListener(handler);
		femaleRB.addActionListener(handler);
		
		//Initialise and Add labels and fields for the
		//date of birth entry
		dobLabel = new JLabel ("Select Date of Birth");
		container.add(dobLabel);
		
		//Day of birth
		dayLabel = new JLabel ("Day");
		container.add(dayLabel);
		dayCB = new JComboBox (dayArray);
		dayCB.setMaximumRowCount(5);
		container.add(dayCB);
		
		//Month of birth
		monthLabel = new JLabel ("Month");
		container.add(monthLabel);
		monthCB = new JComboBox (monthArray);
		monthCB.setMaximumRowCount(5);
		container.add(monthCB);
		
		//Year of birth
		yearLabel = new JLabel ("Year");
		container.add(yearLabel);
		yearCB = new JComboBox (yearArray);
		yearCB.setMaximumRowCount(5);
		container.add(yearCB);
		
		//Initialise and Add labels and fields for the
		//password entry
		passLabel = new JLabel ("Enter Password");
		container.add(passLabel);
		passField = new JPasswordField (15);
		container.add(passField);
		
		//Initialise and Add labels and fields for the
		//password confirmation
		confirmpassLabel = new JLabel ("Confirm Password");
		container.add(confirmpassLabel);
		confirmpassField = new JPasswordField (15);
		container.add(confirmpassField);
		
		//Add the button along with the event that happens
		//when it gets pressed
		createAccountButton = new JButton ("Confirm");
		container.add(createAccountButton);
		
		//Add Action Listener
		createAccountButton.addActionListener(handler);
		
		//Set the GUI's size and make it visible to the user
		setSize (250, 410);
		setVisible (true);
	}
	
	public static void main (String args[]) {
		
		AccountCreationGUI test = new AccountCreationGUI();
		
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonEvent implements ActionListener {
		
		private String Sex = null;
		
		public void actionPerformed (ActionEvent e) {
			
			if(Arrays.equals(passField.getPassword(),
						confirmpassField.getPassword()) == false){
				
				JOptionPane.showMessageDialog(null,
						"Your Passwords are not the same,\n" +
						"Please re-enter details");
			}
		
			else {
				
				//Determine the user's Sex via ActionListener
				if (e.getSource() == maleRB)
					Sex = "Male";
				
				if(e.getSource() == femaleRB)
					Sex = "Female";
				
				//Printing out the results of the data entry
				//on the GUI
				if(e.getSource() ==createAccountButton){
				
					//Get rid of the GUI
					dispose();
					
					//Format the output String
					output += "Name: " +firstnameField.getText()+
					" " +lastnameField.getText()+
					"\nE-Mail Address: " +emailField.getText()+
					"\nDate of Birth: " +(dayCB.getSelectedIndex()+1)+
					"/" +(monthCB.getSelectedIndex()+1)+
					"/" +(yearCB.getSelectedIndex()+1980)+
					"\nSex: " +Sex;
				
					//Output the Required information
					JOptionPane.showMessageDialog(null, output,
							"Account Creation Successful", JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		}
	}
}

