package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

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
import java.awt.Font;

public class DishRender extends JLabel implements ListCellRenderer<Dish> {
	private JPanel panel;
	JLabel nameLabel;
	JLabel priceLabel;
	JLabel descriptionLabel;
	private JSeparator separator;
	
	public DishRender() {
		
	}
	 
    @Override
    public Component getListCellRendererComponent(JList<? extends Dish> list, Dish dish, int index,
        boolean isSelected, boolean cellHasFocus) {
    	panel = new JPanel();
    	panel.setBackground(Color.white);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{46, 243, 0, 0, 72, 0};
		gbl_panel.rowHeights = new int[]{14, 19, 32, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel nameLabel = new JLabel("name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
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
		
		descriptionLabel = new JLabel("description");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.fill = GridBagConstraints.BOTH;
		gbc_descriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionLabel.gridx = 1;
		gbc_descriptionLabel.gridy = 2;
		panel.add(descriptionLabel, gbc_descriptionLabel);
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 4;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 3;
		panel.add(separator, gbc_separator);
    	nameLabel.setText(dish.getName());
    	priceLabel.setText(String.valueOf(dish.getPrice()) + "$");
    	descriptionLabel.setText(dish.getDescription());
        
        return panel;
         
//        return this;
    }
     
}
