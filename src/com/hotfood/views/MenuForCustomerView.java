package com.hotfood.views;

import javax.swing.JPanel;
import java.awt.Font;
import java.util.List;
import java.util.Observable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.hotfood.interfaces.View;
import com.hotfood.models.Dish;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

public class MenuForCustomerView extends Observable implements View{
	private JPanel menu;
	private JPanel innerPanel;
	private JScrollPane scroller;
	private JLabel menuHeaderLabel;
	
	public MenuForCustomerView() {
		menu = new JPanel();
		menu.setBounds(0, 50, 546, 520);;
		menu.setBackground(Color.WHITE);
		innerPanel = new JPanel();
//		innerPanel.setBounds(0, 0, 546, 498);
		innerPanel.setVisible(true);
	    
		menu.setLayout(null);

		scroller = new JScrollPane( innerPanel );
		GridBagLayout gbl_innerPanel = new GridBagLayout();
		gbl_innerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_innerPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_innerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_innerPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		innerPanel.setLayout(gbl_innerPanel);
		
		scroller.setBounds(10, 22, 512, 460);
		scroller.getViewport().setViewPosition(new Point(0,0));
		scroller.getVerticalScrollBar().setUnitIncrement(16);
		
		menu.add(scroller);
		
		menuHeaderLabel = new JLabel("Menu");
		menuHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuHeaderLabel.setBounds(10, 0, 500, 22);
		menu.add(menuHeaderLabel);

		
	}
	
	public JPanel getView() {
		return this.menu;
	}
	
	public void setHeader(String value) {
		menuHeaderLabel.setText(value);
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
	
	
