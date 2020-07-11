package com.hotfood.views;

import javax.swing.JPanel;
import java.awt.Font;
import java.util.List;
import java.util.Observable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.hotfood.interfaces.View;
import com.hotfood.models.DishInCart;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

public class CartView extends Observable implements View{
	private JPanel menu;
	private JPanel innerPanel;
	private JScrollPane scroller;
	private JLabel menuHeaderLabel;
	
	public CartView() {
		menu = new JPanel();
		menu.setBounds(0, 50, 546, 520);
		menu.setOpaque(false);
		innerPanel = new JPanel();
		innerPanel.setOpaque(false);
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
		scroller.setVisible(false);
		scroller.getVerticalScrollBar().setUnitIncrement(16);
		
		menu.add(scroller);
		
		menuHeaderLabel = new JLabel("Cart");
		menuHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuHeaderLabel.setBounds(197, 0, 148, 19);
		menu.add(menuHeaderLabel);
		
	}
	
	public JPanel getView() {
		return this.menu;
	}
	
	public void setHeader(String value) {
		menuHeaderLabel.setText(value);
	}

	public void printItems(List<DishInCart> items) {
		this.innerPanel.removeAll();
		for(int i=0;i<items.size();i++) {
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = i+1;
			this.innerPanel.add(new ItemInCartView(i,items.get(i),this),gbc_panel);
		}
		
		this.innerPanel.repaint();
		this.innerPanel.revalidate();
		if(!this.scroller.isVisible()) {
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
	}
	
	public void removeItem(int index) {
		setChanged();
		notifyObservers(index);
	}
}
	
	
