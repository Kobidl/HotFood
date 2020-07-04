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
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

public class ResturantsView extends JPanel {
	private JTable table;
	private JButton enterResturantButton;

	public ResturantsView() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setBackground(Color.WHITE);

		JLabel lblNewLabel_6 = new JLabel("Choose Resturant");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_6);
		
		table = new JTable();
		table.setRowMargin(5);
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setGridColor(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setForeground(Color.BLACK);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(table);
		table.setBackground(Color.white);
	    
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableScrollPane.setPreferredSize(new Dimension(500, 300));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Resturants",
				TitledBorder.CENTER, TitledBorder.TOP,new Font("times new roman",Font.PLAIN,12),Color.white));
		tableScrollPane.setBackground(Color.WHITE);
		
		add(tableScrollPane);
		
		enterResturantButton = new JButton("Enter resturant");
		enterResturantButton.setEnabled(false);
		this.add(enterResturantButton);
		
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
	
	public int getTableSelectedRow() {
		return table.getSelectedRow();
	}
}
