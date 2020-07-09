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
import com.hotfood.models.DishInCart;

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

public class ItemInCartView extends JPanel implements ActionListener {
	private int index;
	JLabel nameLabel;
	JLabel priceLabel;
	private JButton removeButton;
	CartView cartView;
	private JLabel selectedOptionLabel;
	private JLabel optionValueLabel;
	private JSeparator separator;
	
	public ItemInCartView(int index,DishInCart dish,CartView cartView) {
		this.cartView = cartView;
//		this.setBounds(0, 0, 546, 498);
		this.index = index;
		JPanel panel = this;
    	panel.setBackground(Color.white);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{22, 47, 131, 0, 74, 12};
		gbl_panel.rowHeights = new int[]{14, 19, 38, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
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
		
		
		
		removeButton = new JButton("Remove");
		GridBagConstraints gbc_removeButton = new GridBagConstraints();
		gbc_removeButton.anchor = GridBagConstraints.WEST;
		gbc_removeButton.insets = new Insets(0, 0, 5, 0);
		gbc_removeButton.gridx = 4;
		gbc_removeButton.gridy = 2;
		removeButton.addActionListener(this);
		
		selectedOptionLabel = new JLabel("Extra:");
		selectedOptionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectedOptionLabel.setVerticalAlignment(SwingConstants.TOP);
		selectedOptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_selectedOptionLabel = new GridBagConstraints();
		gbc_selectedOptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selectedOptionLabel.anchor = GridBagConstraints.WEST;
		gbc_selectedOptionLabel.gridx = 1;
		gbc_selectedOptionLabel.gridy = 2;
		add(selectedOptionLabel, gbc_selectedOptionLabel);
		
		optionValueLabel = new JLabel("");
		optionValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		optionValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		optionValueLabel.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_optionValueLabel = new GridBagConstraints();
		gbc_optionValueLabel.anchor = GridBagConstraints.WEST;
		gbc_optionValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_optionValueLabel.gridx = 2;
		gbc_optionValueLabel.gridy = 2;
		add(optionValueLabel, gbc_optionValueLabel);
		panel.add(removeButton, gbc_removeButton);
		
    	nameLabel.setText(dish.getName());
    	priceLabel.setText(String.valueOf(dish.getPrice()) + "$");
    	optionValueLabel.setText(dish.getSelectedOptionText());
    	
    	separator = new JSeparator();
    	GridBagConstraints gbc_separator = new GridBagConstraints();
    	gbc_separator.fill = GridBagConstraints.BOTH;
    	gbc_separator.gridwidth = 4;
    	gbc_separator.insets = new Insets(0, 0, 0, 5);
    	gbc_separator.gridx = 1;
    	gbc_separator.gridy = 3;
    	add(separator, gbc_separator);
//    	resturantNamelabel.setText(dish.get);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		cartView.removeItem(this.index);
	}
	 
 
     
}
