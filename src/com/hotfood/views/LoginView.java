package com.hotfood.views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginView extends JPanel {

	private JTextField loginEmailInput = new JTextField(50);
	private JPasswordField loginPasswordInput = new JPasswordField();
	private JTextField registerEmailInput = new JTextField(50);
	private JPasswordField registerPasswordInput = new JPasswordField();
	private JComboBox userTypeSelectBox = new JComboBox();
	private JButton loginButton = new JButton("Login");
	private JButton registerButton = new JButton("Register");
	private JTextField registerName = new JTextField(40);
	
	public LoginView() {
		setLayout(null);
		

		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setBounds(173, 164, 112, 25);
		this.add(loginButton);
		
		registerButton.setToolTipText("click here to register as a new user");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerButton.setBounds(173, 374, 133, 25);
		this.add(registerButton);
		
		registerPasswordInput.setToolTipText("Enter your passwrd");
		registerPasswordInput.setBounds(163, 269, 211, 20);
		this.add(registerPasswordInput);
		
		registerEmailInput.setBounds(163, 238, 211, 20);
		this.add(registerEmailInput);
		registerEmailInput.setColumns(10);
		
		
		userTypeSelectBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		userTypeSelectBox.setModel(new DefaultComboBoxModel(new String[] {"Resturant Owner", "Customer"}));
		userTypeSelectBox.setBounds(163, 331, 139, 22);
		this.add(userTypeSelectBox);
		
		loginEmailInput.setColumns(10);
		loginEmailInput.setBounds(163, 91, 211, 20);
		this.add(loginEmailInput);
		
		loginPasswordInput.setToolTipText("Enter your passwrd");
		loginPasswordInput.setBounds(163, 128, 211, 20);
		this.add(loginPasswordInput);
		
		JLabel lblNewLabel = new JLabel("Are you existed user?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(169, 65, 133, 15);
		this.add(lblNewLabel);
		
		JLabel lblRegisterHereFor = new JLabel("Register here for creating user new user");
		lblRegisterHereFor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegisterHereFor.setBounds(106, 200, 248, 15);
		this.add(lblRegisterHereFor);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(65, 94, 88, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(65, 133, 88, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(65, 241, 88, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(65, 272, 88, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("What are you");
		lblNewLabel_5.setBounds(65, 336, 88, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("HOTFOOD ONLINE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 11, 473, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setBounds(65, 303, 46, 14);
		add(lblNewLabel_7);
		
		registerName.setBounds(163, 300, 211, 20);
		add(registerName);
		
	}
	
	public String getLoginEmail() {
		return this.loginEmailInput.getText();
	}
	
	public String getLoginPassword() {
		return this.loginPasswordInput.getText();
	}
	
	public String getRegisterEmail() {
		return this.registerEmailInput.getText();
	}
	
	public String getRegisterPassword() {
		return this.registerPasswordInput.getText();
	}
	
	public int getSelectedUserType() {
		return this.userTypeSelectBox.getSelectedIndex();
	}
	
	public String getRegisterName() {
		return this.registerName.getText();
	}
	
	public void addLoginListener(ActionListener listenerForLogin) {
		this.loginButton.addActionListener(listenerForLogin);
	}
	
	public void addRegisterListener(ActionListener listenerForRegister) {
		this.registerButton.addActionListener(listenerForRegister);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
