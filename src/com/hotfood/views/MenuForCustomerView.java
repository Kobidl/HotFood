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
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.hotfood.models.Dish;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.Scrollable;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MenuForCustomerView extends JPanel {
	private JButton enterResturantButton;
	JLabel menuHeaderLabel;
	JList list;
	
	public MenuForCustomerView() {
		this.setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{451, 72, 0};
		gridBagLayout.rowHeights = new int[]{14, 17, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_menuLabel = new GridBagConstraints();
		gbc_menuLabel.gridwidth = 2;
		gbc_menuLabel.insets = new Insets(0, 0, 5, 5);
		gbc_menuLabel.gridx = 0;
		gbc_menuLabel.gridy = 0;
		add(menuLabel, gbc_menuLabel);
		
	
//		DefaultListModel<Dish> listModel = new DefaultListModel<Dish>();
		
		list = new JList();
		list.setCellRenderer(new DishRender());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		JScrollPane scrollPane = new JScrollPane(list);
		add(scrollPane, gbc);
		
	}
	
	public void setMenuHeaderLabel(String value) {
		this.menuHeaderLabel.setText(value);
	}
	
	public void setEnterResturantsEnable(boolean enable) {
		enterResturantButton.setEnabled(enable);
	}
	
	public void addEnterResturantListener(ActionListener listner) {
		enterResturantButton.addActionListener(listner);
	}
	
	public void addListModel(ListModel model) {
		list.setModel(model);
	}
}
	
	
