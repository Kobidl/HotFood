package com.hotfood.views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class MenuForCustomerView extends JPanel {
	private JTable table;
	private JButton enterResturantButton;
	JLabel menuHeaderLabel;
	
	public MenuForCustomerView() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		menuHeaderLabel = new JLabel("Menu");
		menuHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(menuHeaderLabel);
		
		table = new JTable();
		add(table);
		
	    
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(500, 300));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Menu",
				TitledBorder.CENTER, TitledBorder.TOP));
		add(tableScrollPane);
		
		enterResturantButton = new JButton("Enter resturant");
		enterResturantButton.setEnabled(false);
		this.add(enterResturantButton);
		
	}
	
	public void setMenuHeaderLabel(String value) {
		this.menuHeaderLabel.setText(value);
	}
	
	public void addListSectionListener(ListSelectionListener listner) {
		table.getSelectionModel().addListSelectionListener(listner);
	}
	
	public void setEnterResturantsEnable(boolean enable) {
		enterResturantButton.setEnabled(enable);
	}
	
	public void addEnterResturantListener(ActionListener listner) {
		enterResturantButton.addActionListener(listner);
	}
	
	public void addTableModel(TableModel tableModel) {
		table.setModel(tableModel);
	}
}
