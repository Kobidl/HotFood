package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.hotfood.models.Dish;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.Color;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DishRender extends JPanel implements ActionListener {
	private int index;
	JLabel nameLabel;
	JLabel priceLabel;
	private JTextArea textArea;
	private JButton btnNewButton;
	MenuForCustomerView dishesView;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	
	public DishRender(int index,Dish dish,MenuForCustomerView dishesView) {
		this.dishesView = dishesView;
//		this.setBounds(0, 0, 546, 498);
		this.index = index;
		JPanel panel = this;
    	panel.setBackground(Color.white);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{46, 126, 131, 0, 72, 0};
		gbl_panel.rowHeights = new int[]{14, 19, 32, 30, 47};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel nameLabel = new JLabel("name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.gridwidth = 2;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 1;
		panel.add(nameLabel, gbc_nameLabel);
		
		
		priceLabel = new JLabel("price");
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.insets = new Insets(0, 0, 5, 0);
		gbc_priceLabel.gridx = 4;
		gbc_priceLabel.gridy = 1;
		panel.add(priceLabel, gbc_priceLabel);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setRows(3);
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		panel.add(textArea, gbc_textArea);
		
		
		
		btnNewButton = new JButton("Add to cart");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		btnNewButton.addActionListener(this);
		
		lblNewLabel = new JLabel("Choose option");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(dish.getOptions()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);
		panel.add(btnNewButton, gbc_btnNewButton);
		
    	nameLabel.setText(dish.getName());
    	priceLabel.setText(String.valueOf(dish.getPrice()) + "$");
    	textArea.setText(dish.getDescription());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedOption = comboBox.getSelectedIndex();
		dishesView.addDish(this.index,selectedOption);
	}
	 
 
     
}
