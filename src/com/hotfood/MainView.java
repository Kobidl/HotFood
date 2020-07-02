package com.hotfood;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class MainView {

	public MainView() {
		JFrame frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.activeCaptionText);
		frame.getContentPane().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		frame.setBounds(100, 100, 546, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JTextField loginUsernameInput = new JTextField();
		JPasswordField loginPasswordInput = new JPasswordField();
		JTextField registerUsernameInput = new JTextField();
		JPasswordField registerPasswordInput = new JPasswordField();
		JTextPane txtpnUserType = new JTextPane();

		LoginController loginController = new LoginController(loginUsernameInput,loginPasswordInput,registerUsernameInput,registerPasswordInput,txtpnUserType);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(loginController);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(147, 177, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setToolTipText("click here to register as a new user");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You registred  in successfully!");

			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(147, 378, 115, 29);
		frame.getContentPane().add(btnRegister);
		
		JTextField txtHotFoodOnline = new JTextField();
		txtHotFoodOnline.setForeground(SystemColor.desktop);
		txtHotFoodOnline.setBackground(SystemColor.menu);
		txtHotFoodOnline.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtHotFoodOnline.setText("Hot Food Online");
		txtHotFoodOnline.setBounds(108, 16, 156, 29);
		frame.getContentPane().add(txtHotFoodOnline);
		txtHotFoodOnline.setColumns(10);
		txtHotFoodOnline.setEditable(false);
		
		JTextPane txtpnUserName = new JTextPane();
		txtpnUserName.setToolTipText("Enter your email address");
		txtpnUserName.setText("User name");
		txtpnUserName.setBounds(38, 255, 138, 26);
		txtpnUserName.setEditable(false);
		frame.getContentPane().add(txtpnUserName);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setToolTipText("Enter your password at least 8 characters");
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(38, 294, 138, 26);
		txtpnPassword.setEditable(false);
		frame.getContentPane().add(txtpnPassword);
		
		registerPasswordInput.setToolTipText("Enter your passwrd");
		registerPasswordInput.setBounds(191, 294, 153, 26);
		frame.getContentPane().add(registerPasswordInput);
		
		registerUsernameInput.setBounds(191, 255, 153, 26);
		frame.getContentPane().add(registerUsernameInput);
		registerUsernameInput.setColumns(10);
		
		txtpnUserType.setToolTipText("choose your user type");
		txtpnUserType.setText("User type");
		txtpnUserType.setBounds(38, 330, 138, 26);
		txtpnUserType.setEditable(false);
		frame.getContentPane().add(txtpnUserType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Resturant Owner", "Customer"}));
		comboBox.setBounds(194, 336, 150, 26);
		frame.getContentPane().add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Enter your email address");
		textPane.setText("User name");
		textPane.setBounds(38, 100, 138, 26);
		textPane.setEditable(false);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setToolTipText("Enter your password at least 8 characters");
		textPane_1.setText("Password");
		textPane_1.setBounds(38, 135, 138, 26);
		textPane_1.setEditable(false);
		frame.getContentPane().add(textPane_1);
		
		loginUsernameInput.setColumns(10);
		loginUsernameInput.setBounds(191, 100, 153, 26);
		frame.getContentPane().add(loginUsernameInput);
		
		loginPasswordInput.setToolTipText("Enter your passwrd");
		loginPasswordInput.setBounds(191, 135, 153, 26);
		frame.getContentPane().add(loginPasswordInput);
		
		JLabel lblNewLabel = new JLabel("Are you existed user?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(108, 64, 201, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRegisterHereFor = new JLabel("Register here for creating user new user");
		lblRegisterHereFor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegisterHereFor.setBounds(108, 224, 269, 20);
		frame.getContentPane().add(lblRegisterHereFor);
	}
}
