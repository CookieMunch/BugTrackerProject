import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class RegisterScreen{
	private JFrame parentFrame;
	private ScreenManager manager;
	private JPanel registerPanel;
	private JLabel title;
	private JPanel accountInfo;
	private JPanel accountLabels;
	private JPanel accountFields;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel retypePasswordLabel;
	private JLabel emailLabel;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField retypePassword;
	private JTextField email;
	private JLabel errorLabel;
	private JButton registerButton;
	private JButton cancelButton;

	public RegisterScreen(JFrame parent, ScreenManager man){
		parentFrame = parent;
		manager = man;
		setupGUI();
	}

	private class buttonListener implements ActionListener{
		private RegisterScreen parent;

		public buttonListener(RegisterScreen p){
			super();
			parent = p;
		}	

		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("register")){
				parent.registerClicked();
			}
			if(command.equals("cancel")){
				parent.cancelClicked();
			}
		}
	}

	private void setupGUI(){
		//create components
		registerPanel = new JPanel();
		accountInfo = new JPanel();
		accountLabels = new JPanel();
		accountFields = new JPanel();
	
		title = new JLabel("Register",JLabel.CENTER);
		title.setFont(title.getFont().deriveFont(32f));
	
		usernameLabel = new JLabel("Username: ",JLabel.RIGHT);
		passwordLabel = new JLabel("Password: ",JLabel.RIGHT);
		retypePasswordLabel = new JLabel("Re-type Password: ",JLabel.RIGHT);
		emailLabel = new JLabel("E-mail: ",JLabel.RIGHT);
	
		username = new JTextField(20);
		password = new JPasswordField(20);
		retypePassword = new JPasswordField(20);
		email = new JTextField(20);
	
		registerButton = new JButton("Register");
		cancelButton = new JButton("Cancel");
		registerButton.addActionListener(new buttonListener(this));
		cancelButton.addActionListener(new buttonListener(this));

		registerPanel.setLayout(new BoxLayout(registerPanel,BoxLayout.Y_AXIS));
		accountInfo.setLayout(new FlowLayout());
		accountLabels.setLayout(new GridLayout(6,1,0,10));
		accountFields.setLayout(new GridLayout(6,1));
		
		registerPanel.add(Box.createGlue());
		registerPanel.add(title,BorderLayout.PAGE_START);
	
		accountLabels.add(usernameLabel);
		accountLabels.add(passwordLabel);
		accountLabels.add(retypePasswordLabel);
		accountLabels.add(emailLabel);
	
		accountFields.add(username);
		accountFields.add(password);
		accountFields.add(retypePassword);
		accountFields.add(email);
		accountFields.add(registerButton);
		accountFields.add(cancelButton);
	
		accountInfo.add(accountLabels,BorderLayout.WEST);
		accountInfo.add(accountFields,BorderLayout.CENTER);
		
		registerPanel.add(accountInfo);
		registerPanel.add(Box.createGlue());
	}
	public void registerClicked(){
		//check if username is okay
		//check if password is valid
		//check if passwords match
		//check if email is okay
	}

	public void cancelClicked(){
		manager.changeScreen("login");
	}

	public void loadScreen(){
		username.setText("");
		password.setText("");
		retypePassword.setText("");
		parentFrame.add(registerPanel);
	}
}
