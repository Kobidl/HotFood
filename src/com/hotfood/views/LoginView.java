package com.hotfood.views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginView extends JPanel {

	private JTextField loginEmailInput = new JTextField(50);
	private JPasswordField loginPasswordInput = new JPasswordField();
	private JTextField registerEmailInput = new JTextField(50);
	private JPasswordField registerPasswordInput = new JPasswordField();
	private JComboBox<String> userTypeSelectBox = new JComboBox<String>();
	private JButton loginButton = new JButton("Login");
	private JButton registerButton = new JButton("Register");
	private JTextField registerName = new JTextField(40);
	
	public LoginView() {
		setLayout(null);
		
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 546, 498);
		
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setBounds(197, 162, 133, 25);
		this.add(loginButton);
		
		registerButton.setToolTipText("click here to register as a new user");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerButton.setBounds(197, 379, 133, 25);
		this.add(registerButton);
		
		registerPasswordInput.setToolTipText("Enter your passwrd");
		registerPasswordInput.setBounds(171, 272, 211, 20);
		this.add(registerPasswordInput);
		
		registerEmailInput.setBounds(171, 241, 211, 20);
		this.add(registerEmailInput);
		registerEmailInput.setColumns(10);
		
		
		userTypeSelectBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		userTypeSelectBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Resturant Owner", "Customer"}));
		userTypeSelectBox.setBounds(171, 334, 139, 22);
		this.add(userTypeSelectBox);
		
		loginEmailInput.setColumns(10);
		loginEmailInput.setBounds(171, 94, 211, 20);
		this.add(loginEmailInput);
		
		loginPasswordInput.setToolTipText("Enter your passwrd");
		loginPasswordInput.setBounds(171, 131, 211, 20);
		this.add(loginPasswordInput);
		
		JLabel lblNewLabel = new JLabel("Are you existed user?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(197, 63, 133, 15);
		this.add(lblNewLabel);
		
		JLabel lblRegisterHereFor = new JLabel("Register here for creating user new user");
		lblRegisterHereFor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegisterHereFor.setBounds(114, 203, 248, 15);
		this.add(lblRegisterHereFor);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(73, 97, 88, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(73, 136, 88, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(73, 244, 88, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(73, 275, 88, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("What are you");
		lblNewLabel_5.setBounds(73, 339, 88, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("HOTFOOD ONLINE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 11, 536, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setBounds(73, 306, 46, 14);
		add(lblNewLabel_7);
		
		registerName.setBounds(171, 303, 211, 20);
		add(registerName);
		
	}
	
	public String getLoginEmail() {
		return this.loginEmailInput.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getLoginPassword() {
		return this.loginPasswordInput.getText();
	}
	
	public String getRegisterEmail() {
		return this.registerEmailInput.getText();
	}
	
	@SuppressWarnings("deprecation")
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
