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

public class ResturantOwnerView extends JPanel {


	public ResturantOwnerView() {
		setLayout(null);
	
		JLabel lblNewLabel_6 = new JLabel("Menu Managment");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 11, 473, 14);
		add(lblNewLabel_6);
		
		
		
	}
	
	
	
}
