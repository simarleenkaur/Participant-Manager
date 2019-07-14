package login;

//importing packages or classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//event handler class
@SuppressWarnings("serial")//this is added to avoid warning about serialization won't affect the code
//this the action listener to submit the login details. 
class Login extends JFrame implements ActionListener
{
	JButton submit;
	JPanel usernamePanel,passwordPanel,submitPanel,loginPanel;
	JLabel userName,passWord;
	final JTextField  enterUsername,enterPassword;
	Login()
	{
		userName = new JLabel();
		userName.setText("Username:");
		enterUsername = new JTextField(15);
	
		passWord = new JLabel();
		passWord.setText("Password:");
		enterPassword = new JPasswordField(15);
	 
		submit=new JButton("SUBMIT");
		
		loginPanel=new JPanel();
		
		//setting Layout for the frame 
		GridBagLayout loginLayout=new GridBagLayout();
		GridBagConstraints layoutConstraints=new GridBagConstraints();
		loginPanel.setLayout(loginLayout);
	  
		//to display user name and its text box in same line
		usernamePanel=new JPanel();
		usernamePanel.add(userName);
		usernamePanel.add(enterUsername);
		usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		usernamePanel.setVisible(true);
				
		//to display user s and its text box in same line
		passwordPanel=new JPanel();
		passwordPanel.add(passWord);
		passwordPanel.add(enterPassword);
		passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		passwordPanel.setVisible(true);
		
		layoutConstraints.fill=GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridx=0;
		layoutConstraints.gridy=0;
		loginPanel.add(usernamePanel,layoutConstraints);
		
		layoutConstraints.gridx=0;
		layoutConstraints.gridy=1;
		loginPanel.add(passwordPanel,layoutConstraints);
		
		layoutConstraints.gridx=0;
		layoutConstraints.gridy=2;
		loginPanel.add(submit,layoutConstraints);
				
		add(loginPanel,BorderLayout.CENTER);
		//this.add(submit)
		submit.addActionListener(this);
		setTitle("LOGIN FORM");
	}
	public void actionPerformed(ActionEvent ae)
	{
		String value1=enterUsername.getText();
		String value2=enterPassword.getText();
		if (value1.equals("roseindia") && value2.equals("roseindia")) {
			NextPage page=new NextPage();
			page.setVisible(true);
			JLabel label = new JLabel("Welcome:"+value1);
			page.getContentPane().add(label);
		}
		else{
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this,"Incorrect login or password",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}

public class LoginID {
	
	public static void main(String[] args) {
		try{
			Login frame=new Login();
			frame.setSize(1000,1000);
			frame.setVisible(true);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
