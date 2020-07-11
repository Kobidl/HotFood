package com.hotfood.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.hotfood.interfaces.View;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class ResturantsView extends Observable implements View {
	JPanel panel;
	private JTable table;
	private JButton enterResturantButton;

	public ResturantsView() {
		panel = new JPanel();
		panel.setBounds(0, 40, 546, 498);
		panel.setOpaque(false);
		panel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Choose Resturant");
		lblNewLabel_6.setBounds(192, 5, 161, 22);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		table = new JTable();
		table.setBounds(6, 16, 488, 0);
		table.setRowMargin(5);
		table.setRowHeight(25);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setGridColor(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setForeground(Color.BLACK);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(table);
		table.setBackground(Color.white);
	    
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(23, 32, 500, 355);
		tableScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableScrollPane.setPreferredSize(new Dimension(500, 300));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Resturants",
				TitledBorder.CENTER, TitledBorder.TOP,new Font("times new roman",Font.PLAIN,12),Color.white));
		tableScrollPane.setBackground(Color.WHITE);
		
		panel.add(tableScrollPane);
		
		enterResturantButton = new JButton("Enter resturant");
		enterResturantButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		enterResturantButton.setBounds(192, 410, 171, 29);
		enterResturantButton.setEnabled(false);
		panel.add(enterResturantButton);
		
	}
	
	public JPanel getView() {
		return panel;
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
