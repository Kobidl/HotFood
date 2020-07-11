package com.hotfood.views;

import javax.swing.JPanel;
import java.awt.Font;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.hotfood.interfaces.View;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView extends Observable implements View{
	private JPanel panel;
	private JTextField fistNameField;
	private JTextField lastNameField;
	private JTextField cityField;
	private JTextField streetField;
	private JTextField floorField;
	private JTextField apartmentField;
	private JRadioButton  takeawayRadio;
	private JRadioButton deliveryRadio;
	private JButton finishBtn;
	private JLabel itemsLabel;
	
	public OrderView() {
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 30, 500, 498);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Order");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 24, 480, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(58, 62, 98, 14);
		panel.add(lblNewLabel_1);
		
		itemsLabel = new JLabel("Items:");
		itemsLabel.setBounds(68, 87, 263, 14);
		panel.add(itemsLabel);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 128, 480, 2);
		panel.add(separator_1);
		
		ButtonGroup group = new ButtonGroup();
		
		takeawayRadio = new JRadioButton("TakeAway");
		takeawayRadio.setBounds(58, 173, 109, 23);
		takeawayRadio.setSelected(true);
		takeawayRadio.setOpaque(false);
		panel.add(takeawayRadio);
		
		deliveryRadio = new JRadioButton("Delivery");
		deliveryRadio.setBounds(169, 173, 109, 23);
		deliveryRadio.setOpaque(false);
		panel.add(deliveryRadio);
		
		group.add(takeawayRadio);
		group.add(deliveryRadio);
		
		JLabel lblNewLabel_4 = new JLabel("Delivery Option");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(58, 152, 130, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Your Details");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(58, 216, 98, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("First Name");
		lblNewLabel_6.setBounds(68, 250, 88, 14);
		panel.add(lblNewLabel_6);
		
		fistNameField = new JTextField();
		fistNameField.setBounds(176, 247, 248, 20);
		panel.add(fistNameField);
		fistNameField.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Last Name");
		lblNewLabel_6_1.setBounds(68, 278, 88, 14);
		panel.add(lblNewLabel_6_1);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(176, 275, 248, 20);
		panel.add(lastNameField);
		
		JLabel lblNewLabel_6_2 = new JLabel("City");
		lblNewLabel_6_2.setBounds(68, 306, 88, 14);
		panel.add(lblNewLabel_6_2);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(176, 303, 248, 20);
		panel.add(cityField);
		
		JLabel lblNewLabel_6_3 = new JLabel("Street");
		lblNewLabel_6_3.setBounds(68, 334, 88, 14);
		panel.add(lblNewLabel_6_3);
		
		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(176, 331, 248, 20);
		panel.add(streetField);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("Floor");
		lblNewLabel_6_3_1.setBounds(68, 362, 88, 14);
		panel.add(lblNewLabel_6_3_1);
		
		floorField = new JTextField();
		floorField.setColumns(10);
		floorField.setBounds(176, 359, 248, 20);
		panel.add(floorField);
		
		JLabel lblNewLabel_6_3_2 = new JLabel("Apartment");
		lblNewLabel_6_3_2.setBounds(68, 390, 88, 14);
		panel.add(lblNewLabel_6_3_2);
		
		apartmentField = new JTextField();
		apartmentField.setColumns(10);
		apartmentField.setBounds(176, 387, 248, 20);
		panel.add(apartmentField);
		
		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishBtn.setEnabled(false);
				setChanged();
				notifyObservers();
			}
		});
		finishBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		finishBtn.setBounds(176, 435, 211, 34);
		panel.add(finishBtn);

		
	}
	
	public JPanel getView() {
		return this.panel;
	}
	
	public String getName() {
		return this.fistNameField.getText();
	}
	
	public String getLastName() {
		return this.lastNameField.getText();
	}
	public String getCity() {
		return this.cityField.getText();
	}
	public String getStreet() {
		return this.streetField.getText();
	}
	public String getFloor() {
		return this.floorField.getText();
	}
	public String getApartment() {
		return this.apartmentField.getText();
	}
	
	public boolean takeAwaySelected() {
		return takeawayRadio.isSelected();
	}
	
	public boolean deliverySelected() {
		return deliveryRadio.isSelected();
	}
	
	public void setButtonEnable(boolean enable) {
		this.finishBtn.setEnabled(enable);
	}

	public void setItemsCount(int itemsCount) {
		this.itemsLabel.setText("Items: " + Integer.toString(itemsCount));
	}
}
	
	
