package com.hotfood.views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

public class MenuForCustomerView extends Observable{
	private JPanel menu;
	private JPanel innerPanel;
	private JLabel menuHeaderLabel;
	private JScrollPane scroller;
	
	public MenuForCustomerView() {
		menu = new JPanel();
		menu.setBounds(0, 0, 546, 498);;
		menu.setBackground(Color.WHITE);
		innerPanel = new JPanel();
//		innerPanel.setBounds(0, 0, 546, 498);
		innerPanel.setVisible(true);
	    
		menu.setLayout(null);

		scroller = new JScrollPane( innerPanel );
		GridBagLayout gbl_innerPanel = new GridBagLayout();
		gbl_innerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_innerPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_innerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_innerPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		innerPanel.setLayout(gbl_innerPanel);
		
		scroller.setBounds(10, 5, 512, 430);
		scroller.getViewport().setViewPosition(new Point(0,0));

		menu.add(scroller);
		menu.setVisible(true);
		
	}
	
	public JPanel getMenu() {
		return this.menu;
	}

	public void addDishes(List<Dish> dishes) {
		this.scroller.setVisible(false);
		this.innerPanel.removeAll();
		for(int i=0;i<dishes.size();i++) {
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = i+1;
			this.innerPanel.add(new DishRender(i,dishes.get(i),this),gbc_panel);
		}
		
		this.innerPanel.repaint();
		this.innerPanel.revalidate();

		Thread scrollTop=new Thread(){
	          public void run() {
	              try{
	                  Thread.sleep(200);
	                  scroller.setVisible(true);
	                  scroller.getViewport().setViewPosition( new Point(0, 0) );
	              } catch(InterruptedException v){System.out.println(v);}
	          }
	      };
	      scrollTop.start();
	}

	
	public void addDish(int index, int selectedOption) {
		setChanged();
		int[] selected = new int[] {index,selectedOption};
		notifyObservers(selected);
	}
	
}
	
	
